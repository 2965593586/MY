package demo22tx.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by mycom on 2018/3/15.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    public boolean updateAccount(int aid, int ablance, boolean isbuy) {
        String sql="";
        boolean flag=false;
        if(isbuy){
            //买入购票
            sql="update account set balance=balance-? where aid=?";
        }else{
            sql="update account set balance=balance+? where aid=?";
        }
        int update = this.getJdbcTemplate().update(sql, ablance, aid);
        if(update>0){
            flag=true;
        }
        return flag;
    }
}
