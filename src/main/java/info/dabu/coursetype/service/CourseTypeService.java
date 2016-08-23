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

}
