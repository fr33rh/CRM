package info.dabu.coursetype.dao;

import info.dabu.coursetype.domain.CrmCourseType;

import java.util.List;

/**
 * Created by AlexY on 2016/8/24.
 */
public interface CourseTypeDao {


    /**
     * 查询所有
     * @return
     */
    List<CrmCourseType> findAll();

    /**
     * 条件查询
     * @param condition
     * @param params
     * @return
     */
    List<CrmCourseType> findAll(String condition,Object[] params);

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
    public void saveOrUpdate(CrmCourseType courseType);

    int getTotalRecord(String condition, Object[] params);

    List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize);
}
