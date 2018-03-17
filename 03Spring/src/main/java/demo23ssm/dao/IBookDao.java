package demo23ssm.dao;

import demo23ssm.entity.Book;

/**
 * Created by mycom on 2018/3/17.
 */
public interface IBookDao {
    //添加图书
    public int addBook(Book book);
}
