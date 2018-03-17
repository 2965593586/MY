package demo04.service;

import demo04.dao.IHelloDao;

/**
 * Created by mycom on 2018/3/5.
 */
public class HelloServiceImpl implements IHelloService {
    //创建一个Dao的对象
    IHelloDao dao;

    public IHelloDao getDao() {
        return dao;
    }

    public void setDao(IHelloDao dao) {
        this.dao = dao;
    }

    public void doSome() {
        dao.doSome();
    }
}
