package dao;

import entity.Student;
import entity.Teacher;

import java.util.List;

/**
 * Created by mycom on 2018/2/26.
 */
public interface ITeacherDao {
    //根据老师编号查询学生集合
    public Teacher findAllStudentsByTid(int tid);
}
