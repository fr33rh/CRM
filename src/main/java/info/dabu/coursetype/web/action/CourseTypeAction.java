package info.dabu.coursetype.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import info.dabu.coursetype.domain.CrmCourseType;
import info.dabu.coursetype.service.CourseTypeService;

import java.util.List;

/**
 * Created by AlexY on 2016/8/24.
 */
public class CourseTypeAction extends ActionSupport implements ModelDriven<CrmCourseType> {



    private CrmCourseType courseType = new CrmCourseType();

    private CourseTypeService courseTypeService;



    @Override
    public CrmCourseType getModel() {
        return courseType;
    }


    public CourseTypeService getCourseTypeService() {
        return courseTypeService;
    }

    public void setCourseTypeService(CourseTypeService courseTypeService) {
        this.courseTypeService = courseTypeService;
    }


//////////////////////////////////////////////////
    /**
     * 查询所有
     * @return
     */
    public String findAll(){

        //1简单查询
        List<CrmCourseType> allCourseType = this.courseTypeService.findAll();
        // * 查询结果存在值栈 , jsp 通过“#key”获得
        ActionContext.getContext().put("allCourseType", allCourseType);


        return "findAll";
    }





}
