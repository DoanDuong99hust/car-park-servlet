<%--
  Created by IntelliJ IDEA.
  User: Shisui
  Date: 10/31/2021
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Xin chao</h1>
    <div>
        <a href="<c:url value="/employee-home"/>">Employee Management</a>
        <a href="<c:url value="/car-park"/>">Carpark Management</a>
    </div>
    <div>
        <a href="<c:url value="/login?action=login"/>">Dang nhap</a>
    </div>
</body>
</html>
