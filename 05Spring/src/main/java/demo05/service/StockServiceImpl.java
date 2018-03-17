package demo05.service;

import demo05.dao.IAccountDao;
import demo05.dao.IStockDao;

/**
 * Created by mycom on 2018/3/14.
 */
public class StockServiceImpl implements IStockService {
    //植入Dao
    private IAccountDao accountDao;
    private IStockDao stockDao;

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public IStockDao getStockDao() {
        return stockDao;
    }

    public void setStockDao(IStockDao stockDao) {
        this.stockDao = stockDao;
    }

    public void buyStock(int aid, int abalance, int sid, int scount) {
        //定义一个boolean值，判断是购买还是抛出
        boolean isbuy=true;//购买
        accountDao.updateAccount(aid,abalance,isbuy);
        stockDao.updateStock(sid,scount,isbuy);
    }
}
