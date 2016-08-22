package info.dabu.staff.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import info.dabu.staff.domain.CrmStaff;
import info.dabu.staff.service.StaffService;

import java.util.List;

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


        if (staffService == null) {

            System.out.println("staffService is null");
        } else {
            System.out.println("staffService not null");

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
     *
     * @return
     */
    public String home() {
        return "home";
    }


    /**
     * 查询所有员工
     *
     * @return
     */
    public String findAll() {


        List<CrmStaff> allStaff = staffService.findAllStaff();

        System.out.println("allStaff.size=" + allStaff.size());


//        将结果放到值栈，方便jsp取出数据
//         2 将结果存放到值栈，方便jsp获得数据
//         * 方式1：context (map)存放 put(key ,value) ，jsp页面获得 “#key” 。
//        		ActionContext.getContext().put(key, value)
//         * 方式2：root (值栈) ，push(obj) ，一般数据为JavaBean 或 Map ，jsp页面获得“属性名” 或“key”  。
//        		ActionContext.getContext().getValueStack().push(o)
//         * 方式3：root (值栈) ，set(key ,value) ,一般数据为List ，jsp页面获得“key”
//        		set() 底层 new Map(key,value) ，将 push(map )

        // 使用 context存放数据
        ActionContext.getContext().put("allStaff", allStaff);


        return "findAll";

    }


    /**
     * 编辑前操作
     *
     * @return
     */
    public String editUI() {
//        通过id查询员工


        CrmStaff findStaff = this.staffService.findById(staff.getStaffId());

        ActionContext.getContext().getValueStack().push(findStaff);

//        查询所有部门




        return "editUI";
    }


}
