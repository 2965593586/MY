package dao;

import entity.News;
import entity.Talk;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by mycom on 2018/3/1.
 */
public interface INewsDao {
    public int count();
    public List<News> getNewsList(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
    //点击增加访问量
    public int clickCount(Integer newsId);
    //查询单条评论内容
    public News getNewsInfo(Integer newsId);
    //增加评论
    public int submitTalk(Talk talk);


}
