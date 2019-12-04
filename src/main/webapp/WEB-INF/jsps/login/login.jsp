<%--
  Created by IntelliJ IDEA.
  User: yilizatiabudusaimaiti
  Date: 11/19/19
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login | Cyram Flight</title>
</head>
<body>
    <h2>Login:</h2>
    <form action="login" method="POST"> <br>
    User Name: <input type="text" name="email"/><br>
    Password:  <input type="password" name="password"/><br>
    <input type="submit" value="Login"/>
    ${msg}
    </form>
</body>
</html>
