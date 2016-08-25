package info.dabu.base;

import java.util.List;

/**
 * Created by AlexY on 2016/8/25.
 */
public interface BaseDao<T> {

    public void save(T t);
    public void update(T t);
    public void delete(T t);
    public void saveOrUpdate(T t);

//    如果直接将参数设置为String，则以后换成int之类的，就需要修改源代码
    public T findById(java.io.Serializable id);
    public List<T> findAll();

}
