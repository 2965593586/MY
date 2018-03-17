package demo23ssm.service;

import demo23ssm.dao.IBookDao;
import demo23ssm.entity.Book;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mycom on 2018/3/17.
 */
public class BookServiceImpl implements IBookService {
    private IBookDao bookDao;

    public IBookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(IBookDao bookDao) {
        this.bookDao = bookDao;
    }
    @Transactional
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }
}
