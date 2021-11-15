package com.jihee.biz;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpExtractor implements ResultSetExtractor<EmpVO> {
    @Override
    public EmpVO extractData(ResultSet rs) throws SQLException, DataAccessException {


     /*   private int empno;
        private String ename;
        private String job;
        private int mgr;
        private String hiredate;
        private int  sal;
        private int comm;
        private int deptno;*/


        EmpVO empVO = new EmpVO();
        empVO.setEmpno(rs.getInt("EMPNO"));
        empVO.setEname(rs.getString("ENAME"));
        empVO.setJob(rs.getString("JOB"));
        empVO.setMgr(rs.getInt("MGR"));
        empVO.setHiredate(rs.getString("HIREDATE"));
        empVO.setSal(rs.getInt("SAL"));
        empVO.setComm(rs.getInt("COMM"));
        empVO.setDeptno(rs.getInt("DEPTNO"));

        return empVO;
    }
}
