<%--
  Created by IntelliJ IDEA.
  User: Luiz Filipy
  Date: 25/07/2020
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</head>
<body>
<img src="${pageContext.request.contextPath}/resources/images/logo.png" width="900" height="520">
<h2 id="title">Spring MVC</h2>
<hr>
<a href="hello/showForm">Show Form</a>
<br><br>
<a href="student/showForm">Student Form</a>
<br><br>
<a href="customer/showForm">Customer Form</a>
</body>
</html>
