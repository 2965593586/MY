package demoTransaction.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by mycom on 2018/3/16.
 */
public class StockDaoImpl extends JdbcDaoSupport implements IStockDao {
    public boolean updateStock(int sid, int count, boolean isbuy) {
        //准备sql
        String sql="";
        if(isbuy){
            //购买股票
            sql="update stock set count=count+? where sid=?";
        }else{
            sql="update stock set count=count-? where sid=?";
        }
        int update = this.getJdbcTemplate().update(sql, count, sid);
        if (update>0){
            return true;
        }else{
            return false;
        }
    }
}
