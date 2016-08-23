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
}
