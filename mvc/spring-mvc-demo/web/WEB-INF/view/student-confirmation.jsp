<%--
  Created by IntelliJ IDEA.
  User: Luiz Filipy
  Date: 26/07/2020
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Confirmation</title>
</head>
<body>
<h2>The student is confirmed: ${student.fullName}</h2>

<br><br>

<h2>Country: ${student.country}</h2>

<br><br>

<h2>Language is: ${student.favoriteLanguage}</h2>

<br><br>

<ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
        <li>${temp}</li>
    </c:forEach>
</ul>
</body>
</html>
