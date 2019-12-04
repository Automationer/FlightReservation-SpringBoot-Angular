<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration | Cyram Flight</title>
</head>
<body>
<h1>User Registration</h1>
<form action="registerUser" method="POST">
    First Name: <input type="text" name="firstName"/> <br>
    Last Name: <input type="text" name="lastName"/> <br>
    User Name: <input type="text" name="email"/> <br>
    Password: <input type="password" name="password"/> <br>
    Confirm Password: <input type="password" name="confirmPassword"/> <br>
    <input type="submit" value="register"/>
</form>


</body>
</html>
