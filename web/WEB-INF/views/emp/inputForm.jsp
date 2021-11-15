<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: namjh
  Date: 2021/11/15
  Time: 8:14 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원정보 입력 폼</title>
    <style>
        body {
            font-size: 20px;
            color: teal;
        }

        td {
            font-size: 15px;
            color: black;
            width: 100px;
            height: 22px;
            text-align: left;
        }

        .heading {
            font-size: 18px;
            color: white;
            font: bold;
            background-color: orange;
            border: thick;
        }
    </style>
</head>
<body>
<h2>사원정보 입력 폼 </h2>
<%--
사번 ${empInfo.empno } <br>
이름 ${empInfo.ename } <br>
직무 ${empInfo.job } <br>
매니저 ${empInfo.mgr } <br>
입사 ${empInfo.hiredate } <br>
급여 ${empInfo.sal } <br>
성과급 ${empInfo.comm } <br>
부서  ${empInfo.deptno } <br>
--%>

<div>

    <form:form method="post" action="insert.do" modelAttribute="empVO">
        <table>
            <tr>
                <td>EMPNO :</td>
                <td><form:input path="empno"/></td>
            </tr>
            <tr>
                <td>ENAME :</td>
                <td><form:input path="ename"/></td>
            </tr>
            <tr>
                <td>JOB :</td>
                <td><form:input path="job"/></td>
            </tr>
            <tr>
                <td>Manager :</td>
                <td><form:input path="mgr"/></td>
            </tr>
            <tr>
                <td>Hire Date :</td>
                <td><form:input path="hiredate"/></td>
            </tr>
            <tr>
                <td>sal :</td>
                <td><form:input path="sal"/></td>
            </tr>
            <tr>
                <td>comm :</td>
                <td><form:input path="comm"/></td>
            </tr>
            <tr>
                <td>deptno :</td>
                <td><form:input path="deptno"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save"/></td>
            </tr>
            <tr>

                <td colspan="2"><a href="list">사원정보 리스트 보기</a></td>
            </tr>
        </table>
    </form:form>
</div>

</body>
</html>
