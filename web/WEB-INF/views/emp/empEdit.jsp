<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: namjh
  Date: 2021/11/15
  Time: 8:08 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원정보 수정 페이지</title>
</head>
<body>
<h2>사원정보 수정 페이지</h2>
<form:form method="post" action="update" modelAttribute="empInfo">
<form:hidden path="empno"/>

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
사번 ${empInfo.empno } <br>
이름 ${empInfo.ename } <br>
부서 <form:input path="deptno"/> <br>
입사 ${empInfo.hiredate } <br>
직무 ${empInfo.job } <br>
급여 <form:input path="sal"/> <br>

<p>
    <input type="submit" value="변경사항 적용">
    </form:form>
</body>
</html>