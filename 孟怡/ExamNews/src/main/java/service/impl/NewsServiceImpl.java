package service.impl;


import dao.INewsDao;
import entity.News;
import entity.Page;
import entity.Talk;
import org.apache.ibatis.session.SqlSession;
import service.INewsService;
import util.MyBatisUtil;

import java.util.List;

/**
 * Created by mycom on 2018/3/1.
 */
public class NewsServiceImpl implements INewsService {

    public int count() {
        SqlSession session = MyBatisUtil.getSession();
        INewsDao mapper = session.getMapper(INewsDao.class);
        int count = mapper.count();
        return count;
    }

    public Page<News> getNewsList(Integer start, Integer pageSize) {
        SqlSession session = MyBatisUtil.getSession();
        INewsDao mapper = session.getMapper(INewsDao.class);
        List<News> newsList = mapper.getNewsList((start-1)*pageSize, pageSize);
        Page<News> page=new Page<News>();
        page.setLists(newsList);
        page.setPageIndex(start);
        page.setPageSize(pageSize);
        page.setTotalSize(count());
        page.setUrl("/NewsServlet?oper=page");
        return page;
    }

    public int clickCount(Integer newsId) {
        SqlSession session = MyBatisUtil.getSession();
        INewsDao mapper = session.getMapper(INewsDao.class);
        int i = mapper.clickCount(newsId);
        session.commit();
        return i;
    }

    public News getNewsInfo(Integer newsId) {
        SqlSession session = MyBatisUtil.getSession();
        INewsDao mapper = session.getMapper(INewsDao.class);
        News news = mapper.getNewsInfo(newsId);
        return news;
    }

    public int submitTalk(Talk talk) {
        SqlSession session = MyBatisUtil.getSession();
        INewsDao mapper = session.getMapper(INewsDao.class);
        mapper.submitTalk(talk);
        session.commit();
        return 0;
    }
}
