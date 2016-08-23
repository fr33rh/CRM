package info.dabu.department.dao;

import info.dabu.department.domain.CrmDepartment;

import java.util.List;

/**
 * Created by AlexY on 2016/8/23.
 */
public interface DepartmentDao {


    /**
     * 查询所有员工
     * @return
     */
    List<CrmDepartment> findAll();
}
