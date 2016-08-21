package info.dabu.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * Created by AlexY on 2016/8/22.
 */
public class LoginInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

//        判断session作用域中是否有登录信息，如果没有就拦截
        Object obj  = ActionContext.getContext().getSession().get("loginStaff");


        if ( null == obj){


//            没有登录，需要跳转到登录页面
//            跳转后，在页面提示用户登录
            Object action =  actionInvocation.getAction();

            if ( action instanceof ActionSupport){
                 ActionSupport actionSupport = (ActionSupport) action;

                actionSupport.addFieldError("" ,  "请登录！！");
            }


            return "login";
        }


        return actionInvocation.invoke();

    }
}
