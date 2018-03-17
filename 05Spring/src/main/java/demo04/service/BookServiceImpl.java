package demo04.service;

import demo04.dao.BookDaoImpl;
import demo04.entity.Book;

import java.util.List;

/**
 * Created by mycom on 2018/3/14.
 */
public class BookServiceImpl implements IBookService{
    //植入dao
    BookDaoImpl dao;

    public BookDaoImpl getDao() {
        return dao;
    }

    public void setDao(BookDaoImpl dao) {
        this.dao = dao;
    }

    public List<Book> findAll() {
        return dao.findAll();
    }
}
