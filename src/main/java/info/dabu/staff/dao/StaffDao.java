package info.dabu.staff.dao;

import info.dabu.staff.domain.CrmStaff;

import java.util.List;

/**
 * Created by AlexY on 2016/8/21.
 */

public interface StaffDao {




    /**
     * 通过用户名和密码查找员工
     * @param loginName
     * @param loginPwd
     * @return
     */
    public CrmStaff find(String loginName,String loginPwd);


    /**
     * 查询所有员工
     * @return
     */
    List<CrmStaff> findAll();


    /**
     * 根据id查找员工
     * @param starffId
     * @return
     */
     CrmStaff findById(String starffId);

}
