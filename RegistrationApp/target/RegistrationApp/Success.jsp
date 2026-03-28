<%--
  Created by IntelliJ IDEA.
  User: chandra
  Date: 26-03-2026
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>

<% String name=(String) session.getAttribute("name"); %>
<h1 style="color: aquamarine">Congratulations <%=name%>. Registration Successfull...! </h1>
</body>
</html>
