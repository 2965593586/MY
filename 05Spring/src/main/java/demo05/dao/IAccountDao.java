package demo05.dao;

/**
 * Created by mycom on 2018/3/14.
 */
public interface IAccountDao {
    //改变账户的余额
    public void updateAccount(int aid,int abalance,boolean isbuy);
}
