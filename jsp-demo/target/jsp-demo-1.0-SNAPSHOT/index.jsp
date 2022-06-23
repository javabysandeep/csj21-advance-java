<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
        Welcome to the JSP file
    <form action="arithmetic.jsp" method="get">
    number1 <input type="number" name="number1"> <br>
    number2 <input type="number" name="number2"> <br>
    Operation <input type="text" name="operation"> <br>
    <input type="submit" name="Calculate"> <br>
</form>
</body>
</html>