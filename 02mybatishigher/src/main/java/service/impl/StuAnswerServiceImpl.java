package service.impl;

import dao.StuAnswerDao;
import dao.impl.StuAnswerDaoImpl;
import entity.StuAnswer;
import service.StuAnswerService;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by mycom on 2018/1/31.
 */
public class StuAnswerServiceImpl implements StuAnswerService {
    //创建一个Dao层的对象
    StuAnswerDao dao=new StuAnswerDaoImpl();
    public int insertStuAnswer(StuAnswer stuanswer) {
        return dao.insertStuAnswer(stuanswer);
    }

    public int getScore(String studentName,String className) throws SQLException {
        return dao.getScore(studentName,className);
    }

    public String getStudent(String studentName) throws SQLException {
        return dao.getStudent(studentName);
    }
}
