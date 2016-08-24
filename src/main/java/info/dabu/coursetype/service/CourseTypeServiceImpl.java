package info.dabu.coursetype.service;

import info.dabu.coursetype.dao.CourseTypeDao;
import info.dabu.coursetype.domain.CrmCourseType;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
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


    /**
     * 条件查询
     * @param courseType
     * @return
     */
    @Override
    public List<CrmCourseType> findAll(CrmCourseType courseType) {

        //1.1 拼凑查询条件
        StringBuilder builder = new StringBuilder();
        //1.2 拼凑实际参数 , 可以重复，顺序 --> List
        List<Object> paramsList = new ArrayList<Object>();

        //2 过滤条件
        // 2.1 课程类别
        if(StringUtils.isNotBlank(courseType.getCourseName())){
            builder.append(" and courseName like ?");
            paramsList.add("%"+courseType.getCourseName()+"%");
        }
        // 2.2 课程简介
        if(StringUtils.isNotBlank(courseType.getRemark())){
            builder.append(" and remark like ?");
            paramsList.add("%"+courseType.getRemark()+"%");
        }
        // TODO: 2016/8/24 缺乏输入的校验，可能输入的是英文字母之类的，无法转换为数字
        // 2.3 总学时：
        if(StringUtils.isNotBlank(courseType.getTotalStart())){
            builder.append(" and total >= ?");
            paramsList.add(Integer.parseInt(courseType.getTotalStart()));
        }
        if(StringUtils.isNotBlank(courseType.getTotalEnd())){
            builder.append(" and total <= ?");
            paramsList.add(Integer.parseInt(courseType.getTotalEnd()));
        }
        // 2.4课程费用
        if(StringUtils.isNotBlank(courseType.getLessonCostStart())){
            builder.append(" and courseCost >= ?");
            paramsList.add(Double.parseDouble(courseType.getLessonCostStart()));
        }
        if(StringUtils.isNotBlank(courseType.getLessonCostEnd())){
            builder.append(" and courseCost <= ?");
            paramsList.add(Double.parseDouble(courseType.getLessonCostEnd()));
        }



        //3 使用
        // 条件 , 格式：" and ..? and ..."
        String condition = builder.toString();
        // 实际参数
        Object[] params = paramsList.toArray();

        return courseTypeDao.findAll(condition, params);
    }




    
    @Override
    public CrmCourseType findById(String courseTypeId) {
        return this.courseTypeDao.findById(courseTypeId);
    }
    @Override
    public void addOrEdit(CrmCourseType courseType) {
        this.courseTypeDao.saveOrUpdate(courseType);
    }
}
