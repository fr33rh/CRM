package info.dabu.staff.dao;

import info.dabu.base.BaseDao;
import info.dabu.staff.domain.CrmStaff;

/**
 * Created by AlexY on 2016/8/21.
 */

public interface StaffDao extends BaseDao<CrmStaff>{




    /**
     * 通过用户名和密码查找员工
     * @param loginName
     * @param loginPwd
     * @return
     */
    public CrmStaff find(String loginName,String loginPwd);


}
