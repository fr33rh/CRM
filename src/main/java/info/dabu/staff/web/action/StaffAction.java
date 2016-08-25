package info.dabu.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import info.dabu.base.BaseAction;
import info.dabu.department.domain.CrmDepartment;
import info.dabu.staff.domain.CrmStaff;

import java.util.List;

/**
 * Created by AlexY on 2016/8/21.
 */


public class StaffAction extends BaseAction<CrmStaff> {

    /**
     * 员工登录
     * @return
     */
    public String login(){
        //1 查询员工
        CrmStaff findStaff = getStaffService().login(this.getModel());
        //2 是否成功
        if(findStaff != null){
            //成功
            // 3.1 session作用域保存数据
            putSession("loginStaff", findStaff);
            // 3.2 重定向首页 -- xml配置
            return "success";
        }

        //4 不成功
        this.addFieldError("", "用户名与密码不匹配");
        // * 请求转发显示
        return "login";
    }

    /**
     * 显示首页
     * @return
     */
    public String home(){
        return "home";
    }


    /**
     * 查询所有
     * @return
     */
    public String findAll(){
        // 1查询所有
        List<CrmStaff> allStaff = this.getStaffService().findAllStaff();
        // 2 将结果存放到值栈，方便jsp获得数据
        // * 方式1：context (map)存放 put(key ,value) ，jsp页面获得 “#key” 。
        //		ActionContext.getContext().put(key, value)
        // * 方式2：root (值栈) ，push(obj) ，一般数据为JavaBean 或 Map ，jsp页面获得“属性名” 或“key”  。
        //		ActionContext.getContext().getValueStack().push(o)
        // * 方式3：root (值栈) ，set(key ,value) ,一般数据为List ，jsp页面获得“key”
        //		set() 底层 new Map(key,value) ，将 push(map )

        // 使用 context存放数据
        put("allStaff", allStaff);



        return "findAll";
    }

    /**
     * 编辑前操作
     * @return
     */
    public String editUI(){
        //1 通过id查询员工
        CrmStaff findStaff = this.getStaffService().findById(getModel().getStaffId());
        ActionContext.getContext().getValueStack().push(findStaff);

        //2 查询所有部门
        List<CrmDepartment> allDepartment = this.getDepartmentService().findAll();
        // * jsp页面通过“key”获得
        set("allDepartment",allDepartment);

        return "editUI";
    }
    /**
     * 编辑
     * @return
     */
    public String edit(){
        this.getStaffService().updateStaff(this.getModel());
        return "edit";
    }


}
