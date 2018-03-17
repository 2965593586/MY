package demoTransaction.service;

import demoTransaction.dao.IAccountDao;
import demoTransaction.dao.IStockDao;

/**
 * Created by mycom on 2018/3/16.
 */
public class StockServiceImpl implements IStockService {
    //植入dao
    private IAccountDao accountDao;
    private IStockDao stockDao;

    public IStockDao getStockDao() {
        return stockDao;
    }

    public void setStockDao(IStockDao stockDao) {
        this.stockDao = stockDao;
    }

    public IAccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public void buyStock(int aid, int abalance, int sid, int count) {
        boolean isbuy=true;//购买股票
        accountDao.updateAccount(aid,abalance,isbuy);
        stockDao.updateStock(sid,count,isbuy);
    }
}
