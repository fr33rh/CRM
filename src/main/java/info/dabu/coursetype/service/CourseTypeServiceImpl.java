package info.dabu.coursetype.service;

import info.dabu.coursetype.dao.CourseTypeDao;
import info.dabu.coursetype.domain.CrmCourseType;

import java.util.List;

/**
 * Created by AlexY on 2016/8/24.
 */
public class CourseTypeServiceImpl implements CourseTypeService {

     private CourseTypeDao courseTypeDao;

    public CourseTypeDao getCourseTypeDao() {
        return courseTypeDao;
    }

    public void setCourseTypeDao(CourseTypeDao courseTypeDao) {
        this.courseTypeDao = courseTypeDao;
    }

    @Override
    public List<CrmCourseType> findAll() {
        return courseTypeDao.findAll();
    }
}
