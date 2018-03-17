package demo22tx.dao;

/**
 * Created by mycom on 2018/3/15.
 */
public interface IStockDao {
    public boolean updateStock(int sid,int count,boolean isbuy);
}
