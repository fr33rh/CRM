package info.dabu.post.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import info.dabu.post.domain.CrmPost;
import info.dabu.post.servcie.PostService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;
import java.util.List;


/**
 * Created by AlexY on 2016/8/23.
 */
public class PostAction extends ActionSupport implements ModelDriven<CrmPost> {


    //    封装数据
    private CrmPost post = new CrmPost();

    private PostService postService;

    @Override
    public CrmPost getModel() {

//        注意：如果这里写成了null，则会类似错误：
//        Unexpected Exception caught setting 'xxx' on 'class xxx: Error setting expression 'xxx' with value ['x', ]
        return post;
    }


    public PostService getPostService() {
        return postService;
    }

    public void setPostService(PostService postService) {
        this.postService = postService;
    }


    ///////////////////////////////////////////////

    /**
     * ajax 通过部门 ，查询所有的职务
     *
     * @return
     * @throws IOException
     */
    public String findAllWithDepartment() throws IOException {
        //1 查询

        List<CrmPost> allPost = this.postService.findAll(post.getDepartment());
        System.out.println(allPost.size());
        //2 将java对象 转换 json数据

        //2.1 排除不需要数据，避免post查departement，departement又查post，形成死循环
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(new String[]{"department", "staffSet"});
        //2.2 转换
        String jsonData = JSONArray.fromObject(allPost, jsonConfig).toString();

        //3 将json数据发送给浏览器
        //3.1 响应中文乱码
        ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
        //3.2 发送
        ServletActionContext.getResponse().getWriter().print(jsonData);

        return "none";
    }


}
