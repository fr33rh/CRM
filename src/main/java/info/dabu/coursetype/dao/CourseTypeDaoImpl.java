package info.dabu.coursetype.dao;

import info.dabu.coursetype.domain.CrmCourseType;
import info.dabu.page.PageHibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by AlexY on 2016/8/24.
 */
public class CourseTypeDaoImpl extends HibernateDaoSupport implements CourseTypeDao {



    @Override
    public List<CrmCourseType> findAll() {
        return this.getHibernateTemplate().find("from CrmCourseType ");
    }


    /**
     * 条件查询
     * @param condition
     * @param params
     * @return
     */
    @Override
    public List<CrmCourseType> findAll(String condition, Object[] params) {

//        加入 1=1 是因为字符串拼接的时候，得到的查询语句是以 and 开头的，这样生成的sql语法错误。所以，需要加入1=1，避免错误。
        String hql = "from CrmCourseType where 1 = 1 " +condition;

        return this.getHibernateTemplate().find(hql, params);
    }

    @Override
    public CrmCourseType findById(String courseTypeId) {


        return this.getHibernateTemplate().get(CrmCourseType.class, courseTypeId);
    }

    @Override
    public void saveOrUpdate(CrmCourseType courseType) {
        this.getHibernateTemplate().saveOrUpdate(courseType);
    }

    /**
     * 查询总条数
     * @param condition
     * @param params
     * @return
     */
    @Override
    public int getTotalRecord(String condition, Object[] params) {


        String hql = "select count(*) from CrmCourseType c where 1=1  "+ condition;

        List<Long> list =  this.getHibernateTemplate().find(hql,params);

        return list.get(0).intValue();
    }


    /**
     * 分页查询
     * @param condition
     * @param params
     * @param startIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<CrmCourseType> findAll(String condition, Object[] params, int startIndex, int pageSize) {
        String hql = "from CrmCourseType where 1=1 " + condition;
        return this.getHibernateTemplate().execute(new PageHibernateCallback<CrmCourseType>().setHql(hql).setParams(params).setPageSize(pageSize).setStartIndex(startIndex));
    }
}
