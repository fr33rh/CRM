package info.dabu.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import info.dabu.staff.domain.CrmStaff;
import info.dabu.staff.service.StaffService;

/**
 * Created by AlexY on 2016/8/21.
 */


//模型驱动
public class StaffAction extends ActionSupport implements ModelDriven<CrmStaff> {

    private StaffService staffService;

    private CrmStaff staff = new CrmStaff();

    @Override
    public CrmStaff getModel() {

        return staff;

    }

//    默认按照名称注入 


    public CrmStaff getStaff() {
        return staff;
    }

    public void setStaff(CrmStaff staff) {
        this.staff = staff;
    }

    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }

    ///////////////////////////


    /**
     * 员工登录
     *
     * @return
     */
    public String login() {


        if ( staffService == null){

            System.out.println( "staffService is null");
        }else {
            System.out.println( "staffService not null");

        }

//        查询员工
        CrmStaff findStaff = staffService.login(staff);

//        是否成功
        if (null != findStaff) {

//            将查询到的数据保存到session作用域
            ActionContext.getContext().getSession().put("loginStaff", findStaff);

            return SUCCESS;
        }

//        登录不成功
        this.addFieldError("", "用户名与密码不匹配");
//        请求转发
        return "login";


    }


    /**
     * 显示首页
     * @return
     */
    public String home(){
        return "home";
    }


}
