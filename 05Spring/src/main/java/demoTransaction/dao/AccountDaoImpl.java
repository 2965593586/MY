package demoTransaction.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by mycom on 2018/3/16.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao{
    public boolean updateAccount(int aid, int abalance, boolean isbuy) {
        //准备sql
        String sql="";
        if(isbuy){
            //购买股票
            sql="update account set balance=balance-? where aid=?";
        }else{
            sql="update account set balance=balance+? where aid=?";
        }
        int update = this.getJdbcTemplate().update(sql, abalance, aid);
        if (update>0){
            return true;
        }else{
            return false;
        }
    }
}
