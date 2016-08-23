package info.dabu.department.service;

import info.dabu.department.dao.DepartmentDao;
import info.dabu.department.domain.CrmDepartment;

import java.util.List;

/**
 * Created by AlexY on 2016/8/23.
 */
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentDao departmentDao;
    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public DepartmentDao getDepartmentDao() {
        return departmentDao;
    }

    @Override
    public List<CrmDepartment> findAll() {
        return departmentDao.findAll();
    }


}
