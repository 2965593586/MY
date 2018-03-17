package demo21.service;

import demo21.dao.IBookDao;
import demo21.entity.Book;

import java.util.List;

/**
 * Created by mycom on 2018/3/13.
 */
public class BookServiceImpl implements IBookservice {
    IBookDao dao;

    public IBookDao getDao() {
        return dao;
    }

    public void setDao(IBookDao dao) {
        this.dao = dao;
    }

    public List<Book> findAll() {
        return dao.findAll();
    }
}
