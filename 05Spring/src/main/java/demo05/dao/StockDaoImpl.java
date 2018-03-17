package demo05.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by mycom on 2018/3/14.
 */
public class StockDaoImpl extends JdbcDaoSupport implements IStockDao {
    public void updateStock(int sid, int scount, boolean isbuy) {
        //sql
        String sql=null;
        if(isbuy){
            //购买股票
            sql="update stock set count=count+? where sid=?";
        }else{
            //抛出股票
            sql="update stock set count=count-? where sid=?";
        }
        //调用getJdbcTemplate方法,update里面是不定长参数
        this.getJdbcTemplate().update(sql,scount,sid);
    }
}
