package info.dabu.classes.web.action;

import info.dabu.base.BaseAction;
import info.dabu.classes.domain.CrmClass;

import java.util.List;

/**
 * Created by AlexY on 2016/8/26.
 */
public class ClassesAction extends BaseAction<CrmClass> {


    /**
     * 查询所有
     * @return
     */
     public String findAll(){

         List<CrmClass> allClasses  =  this.getClassesService().findAll();

         System.out.println("allClasses size="+ allClasses.size());
         this.set("allClasses",allClasses);

         return "findAll";
     }



}
