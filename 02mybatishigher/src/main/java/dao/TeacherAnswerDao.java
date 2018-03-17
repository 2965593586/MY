package dao;

import entity.TeacherAnswer;

/**
 * Created by mycom on 2018/2/1.
 */
public interface TeacherAnswerDao {
    //老师录入答案
    public int insertTeacherAnswer(TeacherAnswer answer);
    //删除旧题
    public int deleteTeacherAnswer(String className);
}
