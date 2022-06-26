<%--
  Created by IntelliJ IDEA.
  User: sandeepbhingle
  Date: 25/06/22
  Time: 9:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Error Handling </title>
</head>
<body>
<%
    String message = exception.getMessage();
    session.getAttribute("username");
    request.getParameter("");
    response.getWriter();

    out.println(message);

%>
<h1 style="color: red"> Invalid denominator</h1>>
</body>
</html>
