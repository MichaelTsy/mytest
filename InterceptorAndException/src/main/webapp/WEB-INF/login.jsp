<%--
  Created by IntelliJ IDEA.
  User: Micha
  Date: 2019/9/20
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    email:<input type="text" name="email"><br>
    password:<input type="password" name="password">
    <input type="submit">
</form>
</body>
</html>
