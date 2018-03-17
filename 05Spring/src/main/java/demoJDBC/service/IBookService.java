package demoJDBC.service;

import demoJDBC.entity.Book;

import java.util.List;

/**
 * Created by mycom on 2018/3/13.
 */
public interface IBookService {
    public List<Book> findAll();
}
