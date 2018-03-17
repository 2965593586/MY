package service;

import entity.News;
import entity.Page;
import entity.Talk;

import java.util.List;

/**
 * Created by mycom on 2018/3/1.
 */
public interface INewsService {
    public int count();
    public Page<News> getNewsList(Integer start, Integer pageSize);
    //点击增加访问量
    public int clickCount(Integer newsId);
    //查询单条评论内容
    public News getNewsInfo(Integer newsId);
    //增加评论
    public int submitTalk(Talk talk);
}
