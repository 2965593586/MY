package dao.impl;

import dao.BaseDao;
import dao.TeacherAnswerDao;
import entity.TeacherAnswer;

/**
 * Created by mycom on 2018/2/1.
 */
public class TeacherAnswerDaoImpl extends BaseDao implements TeacherAnswerDao {
    public int insertTeacherAnswer(TeacherAnswer answer) {
        String sql="INSERT INTO `teacheranswer`(className,tid,tresult) VALUES(?,?,?)";
        int rs = exeUpDate(sql, answer.getClassName(), answer.getTid(), answer.getTresult());
        if(rs>0){
            return rs;
        }
        return 0;
    }

    public int deleteTeacherAnswer(String className) {
        String sql="DELETE FROM `teacheranswer` WHERE className=?";
        int i = exeUpDate(sql, className);
        if(i>0){
            return i;
        }
        return 0;
    }
}
