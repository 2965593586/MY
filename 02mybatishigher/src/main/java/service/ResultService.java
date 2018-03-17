package service;

import entity.ErrorT;
import entity.Result;
import entity.StuAnswer;
import entity.TeacherAnswer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mycom on 2018/2/2.
 */
public interface ResultService {
    //向成绩表中插入数据
    public int insertResult(Result result);
    //生成成绩表
    public List<Result> getResultTable(String className) throws SQLException;
    //查询成绩最高分
    public Result getMax(String className) throws SQLException;
    //查询成绩最低分
    public Result getMin(String className) throws SQLException;
    //查询平均分
    public Result getAvg(String className) throws SQLException;
    //查询错误人数
    public ErrorT getError(String className, Integer tid) throws SQLException;
    //查询题号
    public Integer getTid(String className) throws SQLException;
    public String write();
}
