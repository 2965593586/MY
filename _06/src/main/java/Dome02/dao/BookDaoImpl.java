package Dome02.dao;

import Dome02.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 浅笑 on 2018/3/13.
 */
public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

    public List<Book> find() {
        String sql="select * from book";
        List<Book> list=this.getJdbcTemplate().query(sql, new RowMapper<Book>() {
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
               Book b=new Book();
               b.setId(resultSet.getInt("bookID"));
               b.setBookName(resultSet.getString("bookName"));
                return b;
            }
        });
        return list;
    }
}
