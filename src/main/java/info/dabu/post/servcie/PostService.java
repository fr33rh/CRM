package info.dabu.post.servcie;

import info.dabu.department.domain.CrmDepartment;
import info.dabu.post.domain.CrmPost;

import java.util.List;

/**
 * Created by AlexY on 2016/8/23.
 */
public interface PostService {

    /**
     * 查询指定部门的所有职务
     * @param department
     * @return
     */
    public List<CrmPost> findAll(CrmDepartment department);
}
