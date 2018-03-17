package dao;

import entity.Emp;

/**
 * Created by mycom on 2018/2/26.
 */
public interface IEmpDao {
    //根据员工编号查询 单条sql
    public Emp getDeptByEmpNo(int empNo);
    //根据员工编号查询 多条sql
    public Emp getDeptByEmpNoMulti(int empNo);
}
