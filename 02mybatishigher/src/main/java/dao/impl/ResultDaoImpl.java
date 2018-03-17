package dao.impl;

import dao.BaseDao;
import dao.ResultDao;
import entity.ErrorT;
import entity.Result;
import entity.StuAnswer;
import entity.TeacherAnswer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mycom on 2018/2/2.
 */
public class ResultDaoImpl extends BaseDao implements ResultDao {

    public int insertResult(Result result) {
        String sql="INSERT INTO `result`(studentName,score,`dateTime`,className) VALUES(?,?,?,?)";
        int i = exeUpDate(sql, result.getStudentName(), result.getScore(), result.getDateTime(), result.getClassName());
        if(i>0){
            return i;
        }
        return 0;
    }

    public List<Result> getResultTable(String className) throws SQLException {
        String sql="SELECT * FROM `result` WHERE className=?";
        ResultSet rs = exeQuery(sql, className);
        List<Result> lists=new ArrayList<Result>();
        while(rs.next()){
            Result result=new Result();
            result.setStudentName(rs.getString("studentName"));
            result.setScore(rs.getInt("score"));
            result.setDateTime(rs.getDate("dateTime"));
            result.setClassName(rs.getString("className"));
            lists.add(result);
        }
        return lists;
    }

    public Result getMax(String className) throws SQLException {
        String sql="SELECT * FROM `result` WHERE score=(SELECT MAX(score) FROM `result`) AND className=?";
        ResultSet rs = exeQuery(sql,className);
        System.out.println(className);
        Result result=null;
        if(rs.next()){
            result=new Result();
            result.setStudentName(rs.getString("studentName"));
            result.setClassName(rs.getString("className"));
            result.setScore(rs.getInt("score"));
        }
        return result;
    }

    public Result getMin(String className) throws SQLException {
        String sql="SELECT * FROM `result` WHERE score=(SELECT MIN(score) FROM `result`) AND className=?";
        ResultSet rs = exeQuery(sql,className);
        System.out.println(className);
        Result result=null;
        if(rs.next()){
            result=new Result();
            result.setStudentName(rs.getString("studentName"));
            result.setClassName(rs.getString("className"));
            result.setScore(rs.getInt("score"));
        }
        return result;
    }

    public Result getAvg(String className) throws SQLException {
        String sql="SELECT AVG(score) as avgs FROM `result` WHERE className=?";
        ResultSet rs = exeQuery(sql, className);
        Result result=null;
        if(rs.next()){
            result=new Result();
            result.setScore(rs.getInt("avgs"));
        }
        return result;
    }

    public ErrorT getError(String className, Integer tid) throws SQLException {
        String sql="SELECT s.tid as t,COUNT(1) as counts FROM `stuanswer` AS s,`teacheranswer` AS t WHERE  s.tid=t.tid AND s.tid=? AND s.tresult!=t.tresult AND s.className=?";
        ResultSet rs = exeQuery(sql, tid, className);
        //List<ErrorT> list=new ArrayList<ErrorT>();
        ErrorT errorT=null;
        if(rs.next()){
            errorT=new ErrorT();
            errorT.setTid(rs.getInt("t"));
            errorT.setCounts(rs.getInt("counts"));
            //list.add(errorT);
        }
        return errorT;
    }

    public Integer getTid(String className) throws SQLException {
        String sql="SELECT COUNT(1) as counts FROM `teacheranswer` WHERE className=?";
        ResultSet rs = exeQuery(sql, className);
        if(rs.next()){
            return rs.getInt("counts");
        }
        return null;
    }


}
