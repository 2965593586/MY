package demoJDBC.dao;

import demoJDBC.entity.Book;

import java.util.List;

/**
 * Created by mycom on 2018/3/12.
 */
public interface IBookDao {
    public List<Book> findAll();

}
