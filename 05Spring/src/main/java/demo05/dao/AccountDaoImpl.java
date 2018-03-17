package demo05.dao;


import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by mycom on 2018/3/14.
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao{
    public void updateAccount(int aid, int abalance, boolean isbuy) {
        //sql
        String sql=null;
        if(isbuy){
            //购买股票
            sql="update account set balance=balance-? where aid=?";
        }else{
            //抛出股票
            sql="update account set balance=balance+? where aid=?";
        }
        //调用getJdbcTemplate方法,update里面是不定长参数
        this.getJdbcTemplate().update(sql,abalance,aid);
    }
}
