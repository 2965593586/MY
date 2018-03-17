package service.impl;

import dao.ResultDao;
import dao.impl.ResultDaoImpl;
import entity.ErrorT;
import entity.Result;
import entity.StuAnswer;
import entity.TeacherAnswer;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.ResultService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mycom on 2018/2/2.
 */
public class ResultServiceImpl implements ResultService {
    ResultDao dao=new ResultDaoImpl();
    public int insertResult(Result result) {
        return dao.insertResult(result);
    }

    public List<Result> getResultTable(String className) throws SQLException {
        return dao.getResultTable(className);
    }

    public Result getMax(String className) throws SQLException {
        return dao.getMax(className);
    }

    public Result getMin(String className) throws SQLException {
        return dao.getMin(className);
    }

    public Result getAvg(String className) throws SQLException {
        return dao.getAvg(className);
    }

    public ErrorT getError(String className, Integer tid) throws SQLException {
        return dao.getError(className,tid);
    }

    public Integer getTid(String className) throws SQLException {
        return dao.getTid(className);
    }

    public String write() {
        return null;
    }


}
