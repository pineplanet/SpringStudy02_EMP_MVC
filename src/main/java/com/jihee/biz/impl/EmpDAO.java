package com.jihee.biz.impl;


import com.jihee.biz.EmpRowMapper;
import com.jihee.biz.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


/**
 * 추가 / 수정 /삭제/ 검색 / 전체 목록 출력
 */
//@Repository("empDAO")

@Repository
public class EmpDAO {

    @Autowired
    private DataSource dataSource;


    /*private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;*/

    //SQL 관련 상수

    private final String EMP_INSERT = "INSERT INTO EMP VALUES(?, ?, ?, ?, to_date(?,'yyyy-mm-dd'), ?, ?, ?)";
    private final String EMP_UPDATE = "UPDATE EMP SET  ENAME=?, JOB=? , MGR=? ,HIREDATE=?,SAL=?,COMM=?,DEPTNO=? WHERE EMPNO=? ";
    private final String EMP_DELETE = "DELETE FROM EMP WHERE EMPNO=?";
    private final String EMP_GET = "SELECT * FROM EMP WHERE EMPNO=?";
    private final String EMP_GETLIST = "SELECT * FROM EMP ORDER BY EMPNO";

    public EmpDAO() {
        System.out.println(" ====== > EMPDAO 객체 생성 ");
    }

    public boolean insertEmp(EmpVO vo) {
        System.out.println("==> JDBC로 기능 처리 " + vo.toString());
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(
                EMP_INSERT,
                vo.getEmpno(), vo.getEname(), vo.getJob(), vo.getMgr(), vo.getHiredate(), vo.getSal(), vo.getComm(), vo.getDeptno()
        );
        return rows > 0 ? true : false;

        /*try {

            this.conn = JDBCutil.getConnection();
            this.pstmt = this.conn.prepareStatement(EMP_INSERT);
            this.pstmt.setInt(1, vo.getEmpno());
            this.pstmt.setString(2, vo.getEname());
            this.pstmt.setString(3, vo.getJob());
            this.pstmt.setInt(4, vo.getMgr());
            this.pstmt.setString(5, vo.getHiredate());
            this.pstmt.setInt(6, vo.getSal());
            this.pstmt.setInt(7, vo.getComm());
            this.pstmt.setInt(8, vo.getDeptno());

            this.pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutil.close(this.pstmt, this.conn);
        }*/
    }

    public boolean updateEmp(EmpVO vo) {
        System.out.println("==> JDBC로  updateEMP 기능 처리 " + vo.toString());
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(
                EMP_UPDATE, vo.getEname(), vo.getJob(), vo.getMgr(), vo.getHiredate(), vo.getSal(), vo.getComm(), vo.getDeptno(), vo.getEmpno()
        );
        return rows > 0 ? true : false;

        /*try {
            this.conn = JDBCutil.getConnection();
            this.pstmt = this.conn.prepareStatement(EMP_UPDATE);

            this.pstmt.setString(1, vo.getEname());
            this.pstmt.setString(2, vo.getJob());
            this.pstmt.setInt(3, vo.getMgr());
            this.pstmt.setString(4, vo.getHiredate());
            this.pstmt.setInt(5, vo.getSal());
            this.pstmt.setInt(6, vo.getComm());
            this.pstmt.setInt(7, vo.getDeptno());
            this.pstmt.setInt(8, vo.getEmpno());

            this.pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutil.close(this.pstmt, this.conn);
        }*/
    }

    public boolean deleteEmp(EmpVO vo) {
        System.out.println("==> JDBC로  deleteEMP 기능 처리 " + vo.toString());
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int rows = jdbcTemplate.update(EMP_DELETE, vo.getEmpno());
        return rows > 0 ? true : false;




    /*    try {
            this.conn = JDBCutil.getConnection();
            this.pstmt = this.conn.prepareStatement(EMP_DELETE);

            this.pstmt.setInt(1, vo.getEmpno());
            this.pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutil.close(this.pstmt, this.conn);
        }*/
    }

    public EmpVO getEmp(EmpVO vo) {
        System.out.println("==> JDBC로  getEmp 기능 처리 " + vo.toString());
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        EmpVO empVO = jdbcTemplate.queryForObject(EMP_GET, new Object[]{vo.getEmpno()}, new EmpRowMapper());
        return empVO;
       /* EmpVO emp = null;
        try {
            this.conn = JDBCutil.getConnection();
            this.pstmt = this.conn.prepareStatement(EMP_GET);

            this.pstmt.setInt(1, vo.getEmpno());
            this.rs = this.pstmt.executeQuery();
            if (this.rs.next()) {
                emp = new EmpVO();
                emp.setEmpno(this.rs.getInt(1));
                emp.setEname(this.rs.getString(2));
                emp.setJob(this.rs.getString(3));
                emp.setMgr(this.rs.getInt(4));
                emp.setHiredate(this.rs.getString(5));
                emp.setSal(this.rs.getInt(6));
                emp.setComm(this.rs.getInt(6));
                emp.setDeptno(this.rs.getInt(6));
            }

        } catch (Exception e) {

        } finally {
            JDBCutil.close(this.rs, this.pstmt, this.conn);

        }
        return emp;*/
    }

    public List<EmpVO> getEmpList(EmpVO vo) {
        System.out.println("==> JDBC로  getEmpList 기능 처리 ");
        List<EmpVO> empList = new ArrayList<>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        empList = jdbcTemplate.query(EMP_GETLIST, new EmpRowMapper());
        return empList;
        /*
        try {
            this.conn = JDBCutil.getConnection();
            this.pstmt = this.conn.prepareStatement(EMP_GETLIST);

            this.rs = this.pstmt.executeQuery();
            while (this.rs.next()) {
                EmpVO emp = new EmpVO();
                emp.setEmpno(this.rs.getInt(1));
                emp.setEname(this.rs.getString(2));
                emp.setJob(this.rs.getString(3));
                emp.setMgr(this.rs.getInt(4));
                emp.setHiredate(this.rs.getString(5));
                emp.setSal(this.rs.getInt(6));
                emp.setComm(this.rs.getInt(6));
                emp.setDeptno(this.rs.getInt(6));
                empList.add(emp);
            }


        } catch (Exception e) {

        } finally {
            JDBCutil.close(this.rs, this.pstmt, this.conn);
        }*/
        //return empList;
    }

}
