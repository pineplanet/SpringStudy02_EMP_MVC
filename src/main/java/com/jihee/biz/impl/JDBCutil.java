package com.jihee.biz.impl;

import java.sql.*;

/*
getConnection() : 접속하고 접속결과를 포함하는 Connection 객체 반환
close() : 자원 해제 메서드
 */
public class JDBCutil {
    public JDBCutil() {
    }
    /***
     param :
     return : Connection
     * **/
    public static Connection getConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@jhnam_high?TNS_ADMIN= /Users/namjh/WebJavaProject/Day8_EMP_MVC/src/main/resources/wallet_JHNAM";
            return DriverManager.getConnection(url, "admin","#Namjihee878787");


        } catch (ClassNotFoundException e) {
            System.out.println(" getConnection () ERR --->" +e.getMessage() );

        }catch ( SQLException e){
            System.out.println("  getConnection () DriverManager.getConnection ERR ---> " + e.getMessage());
        }
        return null;

    }


    /**
     * param  : PreparedStatement, Connection
     */
    public static void close(PreparedStatement pstmt){
        if(pstmt != null){
            try {
                if(!pstmt.isClosed()){
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                pstmt=null;
            }
        }

    }
    /**
     * param  : PreparedStatement, Connection
     */
    public static void close(PreparedStatement pstmt, Connection conn){
        if(pstmt != null){
            try {
                if(!pstmt.isClosed()){
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                pstmt=null;
            }
        }
        if(conn != null){
            try {
                if(!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn=null;
            }
        }

    }
    /**
     * param  : PreparedStatement, Connection
     */
    public static void close(ResultSet rs , PreparedStatement pstmt, Connection conn){
        if(rs !=null){
            try {
                if(!rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
        }
        if(pstmt != null){
            try {
                if(!pstmt.isClosed()){
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                pstmt=null;
            }
        }
        if(conn != null){
            try {
                if(!conn.isClosed()){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn=null;
            }
        }

    }
}
