package demoTransaction.dao;

/**
 * Created by mycom on 2018/3/16.
 */
public interface IStockDao {
    //改变股票
    public boolean updateStock(int sid,int count,boolean isbuy);
}
