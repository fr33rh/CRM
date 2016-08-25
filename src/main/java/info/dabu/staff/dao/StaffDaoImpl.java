package info.dabu.staff.dao;

import info.dabu.base.BaseDaoImpl;
import info.dabu.staff.domain.CrmStaff;

import java.util.List;

/**
 * Created by AlexY on 2016/8/21.
 */
public class StaffDaoImpl extends BaseDaoImpl<CrmStaff> implements StaffDao {


    public StaffDaoImpl() {

        System.out.println("StaffDaoImpl Create");
    }

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




}
