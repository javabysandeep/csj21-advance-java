<%--
  Created by IntelliJ IDEA.
  User: sandeepbhingle
  Date: 25/06/22
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>javaCodeInsideHtml</title>
</head>
<body>
  <%
      for (int i = 1; i<=10 ; i++) {
          out.println(i*20+"\t");
      }
  %>

</body>
</html>
