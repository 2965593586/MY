package demo04.service;

import demo04.entity.Book;

import java.util.List;

/**
 * Created by mycom on 2018/3/14.
 */
public interface IBookService {
    public List<Book> findAll();
}
