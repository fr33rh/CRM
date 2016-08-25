package info.dabu.post.web.action;

import info.dabu.base.BaseAction;
import info.dabu.post.domain.CrmPost;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;


/**
 * Created by AlexY on 2016/8/23.
 */

public class PostAction extends BaseAction<CrmPost> {

    /**
     * ajax 通过部门 ，查询所有的职务
     * @return
     * @throws IOException
     */
    public String findAllWithDepartment() throws IOException{
        //1 查询
        List<CrmPost> allPost = this.getPostService().findAll(this.getModel().getDepartment());

        //2 将java对象 转换 json数据

        //2.1 排除不需要数据
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"department","staffSet"});
        //2.2 转换
        String jsonData = JSONArray.fromObject(allPost,jsonConfig).toString();

        //3 将json数据发送给浏览器
        //3.1 响应中文乱码
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        //3.2 发送
        ServletActionContext.getResponse().getWriter().print(jsonData);

        return "none";
    }

}
