package dao;

import entity.StuAnswer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mycom on 2018/1/31.
 */
public interface StuAnswerDao {
    //学生填写的答案写入数据库
    public int insertStuAnswer(StuAnswer stuanswer);
    //对比老师答案和学生答案
    public int getScore(String studentName,String className) throws SQLException;
    //判断学生是否提交过成绩，提交过就不能再提交
    public String getStudent(String studentName) throws SQLException;

}
