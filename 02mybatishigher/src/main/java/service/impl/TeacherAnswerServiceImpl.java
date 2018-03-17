package service.impl;

import dao.TeacherAnswerDao;
import dao.impl.TeacherAnswerDaoImpl;
import entity.TeacherAnswer;
import service.TeacherAnswerService;

/**
 * Created by mycom on 2018/2/1.
 */
public class TeacherAnswerServiceImpl implements TeacherAnswerService {
    //创建Dao层的对象
    TeacherAnswerDao dao=new TeacherAnswerDaoImpl();
    public int insertTeacherAnswer(TeacherAnswer answer) {
        return dao.insertTeacherAnswer(answer);
    }

    public int deleteTeacherAnswer(String className) {
        return dao.deleteTeacherAnswer(className);
    }
}
