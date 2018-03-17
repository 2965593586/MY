package dao;

import entity.Dept;
import entity.Emp;

import java.util.List;

/**
 * Created by mycom on 2018/2/26.
 */
public interface IDeptDao {
    //根据部门编号获得部门名称  员工名称  单条sql
    public Dept getEmpByDeptNo(int deptNo);
    //根据部门编号获得部门名称  员工名称  多条sql
    public Dept getEmpByDeptNoMultiSQL(int deptNo);
    //添加部门
    public int addDept(Dept dept);
}
