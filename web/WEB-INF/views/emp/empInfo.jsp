<%--
  Created by IntelliJ IDEA.
  User: namjh
  Date: 2021/11/15
  Time: 8:07 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>사원정보 상세 페이지</title>
</head>
<body>
<h2>사원정보 상세 페이지</h2>


사번 ${empInfo.empno } <br>
이름 ${empInfo.ename } <br>
직무 ${empInfo.job } <br>
매니저 ${empInfo.mgr } <br>
입사 ${empInfo.hiredate } <br>
급여 ${empInfo.sal } <br>
성과급 ${empInfo.comm } <br>
부서  ${empInfo.deptno } <br>

<p>
  <a href="edit.do?empno=${empInfo.empno}">사원정보 수정</a>
  <a href="delete.do?empno=${empInfo.empno}">사원정보 삭제</a>
</body>
</html>
