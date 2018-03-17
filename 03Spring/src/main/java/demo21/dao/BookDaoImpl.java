package demo21.dao;

import demo21.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mycom on 2018/3/13.
 */
public class BookDaoImpl extends JdbcDaoSupport implements IBookDao{
    public List<Book> findAll() {
        //sql
        String sql="select * from book";
        List<Book> list = this.getJdbcTemplate().query(sql, new RowMapper<Book>() {
            public Book mapRow(ResultSet rs, int index) throws SQLException {
                Book book = new Book();
                book.setBookId(rs.getInt("bookID"));
                book.setBookName(rs.getString("bookName"));
                book.setBookAuthor(rs.getString("bookAuthor"));
                book.setBookPrice(rs.getInt("bookPrice"));
                return book;
            }
        });
        return list;
    }
}
