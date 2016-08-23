package info.dabu.department.dao;

import info.dabu.department.domain.CrmDepartment;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by AlexY on 2016/8/23.
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {




    @Override
    public List<CrmDepartment> findAll() {
        return this.getHibernateTemplate().find("from  CrmDepartment ");
    }
}
