<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: namjh
  Date: 2021/11/15
  Time: 8:03 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>사원정보 리스트</title>
</head>
<body>
<h2>사원정보 리스트</h2>
<c:forEach var="emp" items="${list}">
    ${emp.empno }
    <a href="info.do?empno=${emp.empno}">${emp.ename}</a> <br>
</c:forEach>
<p>
    <a href="insert.do">사원정보 추가</a>
</body>
</html>

