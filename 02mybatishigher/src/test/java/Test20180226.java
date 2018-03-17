import dao.*;
import entity.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import util.MyBatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mycom on 2018/1/29.
 */
public class Test20180226 {
    //查询部门和员工  单条sql
    @Test
    public void oneToMany(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IDeptDao mapper = sqlSession.getMapper(IDeptDao.class);
        Dept dept = mapper.getEmpByDeptNo(1);
        System.out.println("部门名称"+dept.getDeptName());
        for (Emp emp:dept.getEmps()) {
            System.out.println(emp.getEmpName());
        }
        sqlSession.close();
    }
    //查询部门和员工  多条sql
    @Test
    public void oneToManyMulti(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IDeptDao mapper = sqlSession.getMapper(IDeptDao.class);
        Dept dept = mapper.getEmpByDeptNoMultiSQL(1);
        System.out.println("部门名称"+dept.getDeptName());
        for (Emp emp:dept.getEmps()) {
            System.out.println(emp.getEmpName());
        }
        sqlSession.close();
    }
    //多对一  单条sql
    @Test
    public void manyToOne(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IEmpDao mapper = sqlSession.getMapper(IEmpDao.class);
        Emp emp = mapper.getDeptByEmpNo(1);
        System.out.println("员工名称："+emp.getEmpName());
        System.out.println("员工所属部门："+emp.getDept().getDeptName());
        sqlSession.close();
    }
    //多对一  多条sql
    @Test
    public void manyToOneMulti(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IEmpDao mapper = sqlSession.getMapper(IEmpDao.class);
        Emp emp = mapper.getDeptByEmpNoMulti(1);
        System.out.println("员工名称："+emp.getEmpName());
        System.out.println("员工所属部门："+emp.getDept().getDeptName());
        sqlSession.close();
    }
    //多对多
    @Test
    public void manyToMany(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        ITeacherDao mapper = sqlSession.getMapper(ITeacherDao.class);
        Teacher teacher = mapper.findAllStudentsByTid(1);
        System.out.println("名老师姓："+teacher.getTname());
        for (Student student:teacher.getStus()) {
            System.out.println(student.getSname());
        }
        sqlSession.close();
    }
    //自关联
    @Test
    public void selfSelect(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        ICategoryDao mapper = sqlSession.getMapper(ICategoryDao.class);
        List<Category> list = mapper.getChildrenByPid(1);
        for (Category category:list) {
            System.out.println(category);
        }
        sqlSession.close();
    }

}
