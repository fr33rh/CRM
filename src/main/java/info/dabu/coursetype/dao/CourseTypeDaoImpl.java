package info.dabu.coursetype.dao;

import info.dabu.coursetype.domain.CrmCourseType;
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
}
