package demo05.dao;

/**
 * Created by mycom on 2018/3/14.
 */
public interface IStockDao {
    //改变股票股数的方法
    public void updateStock(int sid,int scount,boolean isbuy);
}
