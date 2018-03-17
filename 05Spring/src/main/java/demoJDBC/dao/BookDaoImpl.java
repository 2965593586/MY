package demoJDBC.dao;


import demoJDBC.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mycom on 2018/3/12.
 */
public class BookDaoImpl extends JdbcDaoSupport implements IBookDao {
    public List<Book> findAll() {
        //sql
        String sql="select * from book";
        List<Book> list = this.getJdbcTemplate().query(sql, new RowMapper<Book>() {
            public Book mapRow(ResultSet rs, int i) throws SQLException {
                //创建一个Book对象
                Book book = new Book();
                book.setBookID(rs.getInt("bookID"));
                book.setBookName(rs.getString("bookName"));
/*                book.setBookAuthor(rs.getString("bookAuthor"));
                book.setBookPrice(rs.getInt("bookPrice"));*/
                return book;
            }
        });
        return list;
    }
}
