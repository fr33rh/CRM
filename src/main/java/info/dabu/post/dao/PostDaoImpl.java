package info.dabu.post.dao;

import info.dabu.department.domain.CrmDepartment;
import info.dabu.post.domain.CrmPost;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by AlexY on 2016/8/23.
 */
public class PostDaoImpl  extends HibernateDaoSupport implements PostDao {


    @Override
    public List<CrmPost> findAll(CrmDepartment department) {

        return this.getHibernateTemplate().find("from CrmPost where department = ?", department);
    }
}
