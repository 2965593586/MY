package demo21.dao;

import demo21.entity.Book;

import java.util.List;

/**
 * Created by mycom on 2018/3/13.
 */
public interface IBookDao {
    public List<Book> findAll();
}
