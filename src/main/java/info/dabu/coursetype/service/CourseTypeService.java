package info.dabu.coursetype.service;

import info.dabu.coursetype.domain.CrmCourseType;

import java.util.List;

/**
 * Created by AlexY on 2016/8/24.
 */
public interface CourseTypeService {
    /**
     * 查询所有
     * @return
     */
    public List<CrmCourseType> findAll();


    /**
     * 带有条件的查询所有
     * @param courseType
     * @return
     */
    List<CrmCourseType> findAll(CrmCourseType courseType);

    /**
     * 通过id查询详情
     * @param courseTypeId
     * @return
     */
    public CrmCourseType findById(String courseTypeId);

    /**
     * 保存或更新
     * @param courseType
     */
    public void addOrEdit(CrmCourseType courseType);
}
