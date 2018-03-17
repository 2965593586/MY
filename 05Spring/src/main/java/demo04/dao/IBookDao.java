package demo04.dao;


import demo04.entity.Book;

import java.util.List;

/**
 * Created by mycom on 2018/3/14.
 */
public interface IBookDao {
    public List<Book> findAll();
}
