package info.dabu.post.servcie;

import info.dabu.department.domain.CrmDepartment;
import info.dabu.post.dao.PostDao;
import info.dabu.post.domain.CrmPost;

import java.util.List;

/**
 * Created by AlexY on 2016/8/23.
 */
public class PostServiceImpl implements PostService {

    private PostDao postDao;
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }



    @Override
    public List<CrmPost> findAll(CrmDepartment department) {
        return postDao.findAll(department);
    }
}
