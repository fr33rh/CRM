package info.dabu.coursetype.web.action;

import info.dabu.base.BaseAction;
import info.dabu.coursetype.domain.CrmCourseType;
import info.dabu.page.PageBean;
import org.apache.commons.lang.StringUtils;

/**
 * Created by AlexY on 2016/8/24.
 */

public class CourseTypeAction extends BaseAction<CrmCourseType> {

    /**
     * 查询所有
     * @return
     */
    public String findAll(){
		/*1简单查询
		List<CrmCourseType> allCourseType = this.courseTypeService.findAll();
		// * 查询结果存在值栈 , jsp 通过“#key”获得
		ActionContext.getContext().put("allCourseType", allCourseType);
		*/

		/*2 条件查询
		List<CrmCourseType> allCourseType = this.courseTypeService.findAll(courseType);
		ActionContext.getContext().put("allCourseType", allCourseType);
		 */

        //3 分页 + 条件
        PageBean<CrmCourseType> pageBean = this.getCourseTypeService().findAll(getModel(), getPageNum(), getPageSize());
        put("pageBean", pageBean);

        return "findAll";
    }


    /**
     * 添加或编辑显示jsp页面
     * @return
     */
    public String addOrEditUI(){
        //如果有id就是编辑，编辑需要查询详情
        if(StringUtils.isNotBlank(this.getModel().getCourseTypeId())){
            //将查询的详情压入到栈顶，方便标签自动的回显
            CrmCourseType findCourseType = this.getCourseTypeService().findById(this.getModel().getCourseTypeId());
            push(findCourseType);
        }

        return "addOrEditUI";
    }

    /**
     * 添加或编辑 功能
     * @return
     */
    public String addOrEdit(){
        this.getCourseTypeService().addOrEdit(getModel());
        return "addOrEdit";
    }













}
