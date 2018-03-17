import dao.ICategoryDao;
import dao.IDeptDao;
import dao.IEmpDao;
import dao.ITeacherDao;
import entity.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.List;

/**
 * Created by mycom on 2018/1/29.
 */
public class Test20180227 {

    //延迟加载
    @Test
    public void layLoading(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IDeptDao mapper = sqlSession.getMapper(IDeptDao.class);
        Dept dept = mapper.getEmpByDeptNoMultiSQL(1);
        System.out.println("部门名称："+dept.getDeptName());
        System.out.println("分割线=======================");
        Dept dept2 = mapper.getEmpByDeptNoMultiSQL(1);
        System.out.println("部门名称："+dept2.getDeptName());
        sqlSession.close();
    }

    //证明一级缓存的存在性
    @Test
    public void firstLevelHasExist(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IDeptDao mapper = sqlSession.getMapper(IDeptDao.class);
        Dept dept = mapper.getEmpByDeptNoMultiSQL(1);
        System.out.println("部门名称："+dept.getDeptName());
        //证明一级缓存的存在性
        Dept d1=new Dept();
        d1.setDeptName("运营部");
        mapper.addDept(d1);
        System.out.println("分割线=======================");
        Dept dept2 = mapper.getEmpByDeptNoMultiSQL(1);
        System.out.println("部门名称："+dept2.getDeptName());
        sqlSession.close();
    }



    //证明二级缓存的存在性
    @Test
    public void secondLevelHasExist(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IDeptDao mapper = sqlSession.getMapper(IDeptDao.class);
        Dept dept = mapper.getEmpByDeptNoMultiSQL(1);
        System.out.println("部门名称："+dept.getDeptName());
        sqlSession.close();

        System.out.println("===========二级缓存============");
        SqlSession sqlSession2 = MyBatisUtil.getSession();
        IDeptDao mapper2 = sqlSession2.getMapper(IDeptDao.class);
        Dept dept2 = mapper2.getEmpByDeptNoMultiSQL(1);
        System.out.println("部门名称："+dept2.getDeptName());
        sqlSession2.close();
    }

}
