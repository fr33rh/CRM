package info.dabu.staff.service;

import info.dabu.staff.dao.StaffDao;
import info.dabu.staff.domain.CrmStaff;
import info.dabu.utils.MyStringUtils;

import java.util.List;

/**
 * Created by AlexY on 2016/8/21.
 */
public class StaffServiceImpl implements StaffService {


    private StaffDao staffDao;





    public StaffServiceImpl() {

        System.out.println("@StaffServiceImpl");
    }

    public StaffDao getStaffDao() {
        return staffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    /**登录
     *
     * @param staff
     * @return
     */
    @Override
    public CrmStaff login(CrmStaff staff) {


        return staffDao.find(staff.getLoginName(), MyStringUtils.getMD5Value( staff.getLoginPwd()));
    }


    /**
     * 查询所有员工
     * @return
     */
    @Override
    public List<CrmStaff> findAllStaff() {


        return staffDao.findAll();
    }

    /**
     * 根据id查找员工
     * @param staffId
     * @return
     */
    public CrmStaff findById(String staffId){


        return staffDao.findById(staffId);
    }





}
