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






    /**
     * 通过id查询详情
     * @param classesId
     * @return
     */
    public CrmClass findById(String classesId);

    /**
     * 更新上传
     * @param model
     */
    public void updateUpload(CrmClass model);



}
