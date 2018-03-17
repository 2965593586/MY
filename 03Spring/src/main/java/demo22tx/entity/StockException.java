package demo22tx.entity;

/**
 * Created by mycom on 2018/3/15.
 */
public class StockException extends ClassNotFoundException {
    public StockException() {
    }

    public StockException(String s) {
        super(s);
    }
}
