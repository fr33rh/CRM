package info.dabu.classes.web.action;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import info.dabu.base.BaseAction;
import info.dabu.classes.domain.CrmClass;
import info.dabu.utils.MyStringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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




    /**
     * 显示上传表单
     * @return
     */
    public String uploadUI(){
        CrmClass findClasses = this.getClassesService().findById(this.getModel().getClassId());
        // 将查询的数据压入到指定
        this.push(findClasses);

        return "uploadUI";
    }

    private File schedule;				//上传内容
    private String scheduleFileName;	//上传文件名
    private String scheduleContentType;	//上传类型
    public void setSchedule(File schedule) {
        this.schedule = schedule;
    }
    public void setScheduleFileName(String scheduleFileName) {
        this.scheduleFileName = scheduleFileName;
    }
    public void setScheduleContentType(String scheduleContentType) {
        this.scheduleContentType = scheduleContentType;
    }
    /**
     * 文件上传
     * @return
     * @throws IOException
     */
    @InputConfig(resultName="uploadInput")
    public String upload() throws IOException {

        //1 将课本 保存 硬盘  。
        // 1.1 位置：tomcat.../WEB-INF/upload/....
        String parentDir = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
        // 1.2 文件名 随机数，且没有扩展名
        String fileName = MyStringUtils.getUUID();
        // 1.3 保存
        FileUtils.copyFile(schedule, new File(parentDir,fileName));

        //2 更新
        this.getModel().setUploadTime(new Date());
        this.getModel().setUploadPath("/WEB-INF/upload/" + fileName);
        this.getModel().setUploadFilename(scheduleFileName);

        this.getClassesService().updateUpload(this.getModel());

        return "upload";
    }



}
