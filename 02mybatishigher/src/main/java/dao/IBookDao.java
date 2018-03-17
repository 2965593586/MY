package dao;

import entity.Book;
import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;

import java.util.List;
import java.util.Map;

/**
 * Created by mycom on 2018/1/29.
 */
public interface IBookDao {
    public List<Book> findAllBooks();
    //添加方法
    public int insert(Book book);
    //删除
    public int del(int bookId);
    //更新
    public int update(Book book);
    //模糊查询
    public List<Book> likeSelect(String bookName);
    //多条件查询Map
    public List<Book> selectMultiConditionMap(Map<String,Object> map);
    //多条件查询Index
    public List<Book> selectMultiConditionIndex(String bookName,Integer bookPrice);
    //智能标签if
    public List<Book> findByIf(Map<String,Object> map);
    //智能标签foreach array
    public List<Book> findByforEachArray(int[] bookids);
    //智能标签foreach list
    public List<Book> findByforEachList(List<Integer> list);
    //智能标签foreach list 自定义
    public List<Book> findByforEachListBook(List<Book> list);

}
