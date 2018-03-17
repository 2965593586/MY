package demo21.service;

import demo21.dao.IBookDao;
import demo21.entity.Book;

import java.util.List;

/**
 * Created by mycom on 2018/3/13.
 */
public interface IBookservice {
    public List<Book> findAll();
}
