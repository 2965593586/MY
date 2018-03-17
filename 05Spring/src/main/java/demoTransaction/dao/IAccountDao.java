package demoTransaction.dao;

/**
 * Created by mycom on 2018/3/16.
 */
public interface IAccountDao {
    //改变账户余额
    public boolean updateAccount(int aid,int abalance,boolean isbuy);
}
