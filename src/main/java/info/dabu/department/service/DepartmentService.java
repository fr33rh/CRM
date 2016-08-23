package info.dabu.department.service;

import info.dabu.department.domain.CrmDepartment;

import java.util.List;

/**
 * Created by AlexY on 2016/8/23.
 */
public interface DepartmentService {


    /**
     * 查询所有部门
     * @return
     */
    public List<CrmDepartment> findAll();

}
