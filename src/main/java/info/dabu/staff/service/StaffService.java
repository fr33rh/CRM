package info.dabu.staff.service;

import info.dabu.staff.domain.CrmStaff;

import java.util.List;

/**
 * Created by AlexY on 2016/8/21.
 */
public interface StaffService {




    CrmStaff  login(CrmStaff staff);


    List<CrmStaff> findAllStaff();
}
