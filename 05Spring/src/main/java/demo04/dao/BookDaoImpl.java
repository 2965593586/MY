package demo04.dao;

import demo04.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mycom on 2018/3/14.
 */
public class BookDaoImpl extends JdbcDaoSupport implements IBookDao {
    public List<Book> findAll() {
        //准备sql
        String sql="select * from book";
        //调用方法
        List<Book> list = this.getJdbcTemplate().query(sql, new RowMapper<Book>() {
            public Book mapRow(ResultSet rs, int index) throws SQLException {
                Book book = new Book();
                book.setBookID(rs.getInt("bookID"));
                book.setBookName(rs.getString("bookName"));
                book.setBookAuthor(rs.getString("bookAuthor"));
                book.setBookPrice(rs.getInt("bookPrice"));
                return book;
            }
        });
        return list;
    }
}
