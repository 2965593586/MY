package demo22tx.service;

import demo22tx.dao.IAccountDao;
import demo22tx.dao.IStockDao;
import demo22tx.entity.StockException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mycom on 2018/3/15.
 */
public class StockServiceImpl implements IStockService{
    private IAccountDao accountDao;
    private IStockDao stockDao;
    @Transactional
    public boolean buyStock(int aid, int abalance, int sid, int count) throws StockException {
        boolean isbuy=true;
        //异常
        if(1==1){
            throw new StockException("出错了");
        }
        boolean account = accountDao.updateAccount(aid, abalance, isbuy);
        boolean stock = stockDao.updateStock(sid, count, isbuy);
        if(account&&stock){
            return true;
        }else{
            return false;
        }
    }

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
}
