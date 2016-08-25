package info.dabu.classes.service;

import info.dabu.classes.domain.CrmClass;

import java.util.List;

/**
 * Created by AlexY on 2016/8/26.
 */
public interface ClassesService {

    /**
     * 查询所有
     * @return
     */
    List<CrmClass> findAll();
}
