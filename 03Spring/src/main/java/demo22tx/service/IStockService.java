package demo22tx.service;

import demo22tx.entity.StockException;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mycom on 2018/3/15.
 */
public interface IStockService {
    public boolean buyStock(int aid,int abalance,int sid,int count) throws StockException;
}
