package info.dabu.staff.dao;

import info.dabu.staff.domain.CrmStaff;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by AlexY on 2016/8/21.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {

    /**
     * 根据用户名和密码查询员工
     * @param loginName
     * @param loginPwd
     * @return
     */
    @Override
    public CrmStaff find(String loginName, String loginPwd) {


        List<CrmStaff> allStaff = this.getHibernateTemplate().find("from CrmStaff where loginName=? and loginPwd=? ", loginName, loginPwd);

        if (allStaff.size() == 1) {


            return allStaff.get(0);
        }


        return null;
    }

    /**
     * 查询所有员工
     * @return
     */
    @Override
    public List<CrmStaff> findAll() {


        return this.getHibernateTemplate().find("from CrmStaff ");


    }


    /**
     * 根据id查找员工
     * @param starffId
     * @return
     */
    public CrmStaff findById(String starffId){


        return this.getHibernateTemplate().get(CrmStaff.class, starffId);


    }



}
