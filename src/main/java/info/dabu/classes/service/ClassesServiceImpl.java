package info.dabu.classes.service;

import info.dabu.classes.dao.ClassesDao;
import info.dabu.classes.domain.CrmClass;

import java.util.List;

/**
 * Created by AlexY on 2016/8/26.
 */
public class ClassesServiceImpl implements   ClassesService {


    private ClassesDao classesDao;


    public ClassesDao getClassesDao() {
        return classesDao;
    }

    public void setClassesDao(ClassesDao classesDao) {
        this.classesDao = classesDao;
    }

    @Override
    public List<CrmClass> findAll() {
        return classesDao.findAll();
    }
}
