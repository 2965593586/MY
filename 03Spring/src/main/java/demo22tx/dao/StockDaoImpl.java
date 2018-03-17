package demo22tx.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by mycom on 2018/3/15.
 */
public class StockDaoImpl extends JdbcDaoSupport implements IStockDao {
    public boolean updateStock(int sid, int count, boolean isbuy) {
        String sql="";
        boolean flag=false;
        if(isbuy){
            //买入购票
            sql="update stock set count=count+? where sid=?";
        }else{
            sql="update stock set count=count+? where sid=?";
        }
        int update = this.getJdbcTemplate().update(sql, count, sid);
        if(update>0){
            flag=true;
        }
        return flag;
    }
}
