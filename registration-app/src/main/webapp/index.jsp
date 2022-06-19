<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="register" method="post">
    name: <input type="text" name="name"><br><br>
    email: <input type="text" name="email"><br><br>
    phone: <input type="text" name="phone"><br><br>
    username: <input type="text" name="username"><br><br>
    password: <input type="password" name="password"><br><br>
    <input type="submit" value="Register User">
</form>
</body>
</html>
<hr/>
<a href="users">Get User Details</a><br>
<a href="redirect.html">Redirection</a>