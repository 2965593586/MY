package demoJDBC.service;

import demoJDBC.dao.BookDaoImpl;
import demoJDBC.entity.Book;

import java.util.List;

/**
 * Created by mycom on 2018/3/13.
 */
public class BookServiceImpl implements IBookService {
    BookDaoImpl book;

    public BookDaoImpl getBook() {
        return book;
    }

    public void setBook(BookDaoImpl book) {
        this.book = book;
    }

    public List<Book> findAll() {
        return book.findAll();
    }
}
