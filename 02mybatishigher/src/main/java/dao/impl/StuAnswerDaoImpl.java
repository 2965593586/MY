package dao.impl;

import dao.BaseDao;
import dao.StuAnswerDao;
import entity.StuAnswer;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mycom on 2018/1/31.
 */
public class StuAnswerDaoImpl extends BaseDao implements StuAnswerDao {
    public int insertStuAnswer(StuAnswer stuanswer) {
        String sql="INSERT INTO stuanswer(studentName,tid,tresult,`DateTime`,className) VALUES(?,?,?,?,?)";
        int rs = exeUpDate(sql, stuanswer.getStudentName(), stuanswer.getTid(), stuanswer.getTresult(), stuanswer.getDateTime(),stuanswer.getClassName());
        if(rs>0){
            return rs;
        }
        return 0;
    }

    public int getScore(String studentName,String className) throws SQLException {
        String sql="SELECT COUNT(*) as score FROM `stuanswer` AS a,`teacheranswer` AS b WHERE a.`tid`=b.`tid` AND a.`tresult`=b.`tresult` AND studentName=? AND a.className=?";
        ResultSet rs = exeQuery(sql, studentName,className);
        if(rs.next()){
            return rs.getInt("score");
        }
        return 0;
    }

    public String getStudent(String studentName) throws SQLException {
        String sql="SELECT studentName FROM `result` WHERE studentName=?";
        ResultSet rs = exeQuery(sql, studentName);
        if(rs.next()){
            return rs.getString("studentName");
        }
        return null;
    }
}
