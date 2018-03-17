package dao;

import entity.Category;

import java.util.List;

/**
 * Created by mycom on 2018/2/26.
 */
public interface ICategoryDao {
    //根据pid查询分类
    public List<Category> getChildrenByPid(int pid);
}
