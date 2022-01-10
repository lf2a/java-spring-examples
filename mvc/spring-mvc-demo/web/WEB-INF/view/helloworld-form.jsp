<%--
  Created by IntelliJ IDEA.
  User: Luiz Filipy
  Date: 25/07/2020
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World - Input Form</title>
</head>
<body>
<form action="processForm" method="get">
    <label>Process Form</label>
    <input type="text" name="studentName" placeholder="What's your name? ">
    <button type="submit">Send</button>
</form>

<br><br>

<form action="processFormVersionTwo" method="get">
    <label>Process Form Version Two</label>
    <input type="text" name="studentName" placeholder="What's your name? ">
    <button type="submit">Send</button>
</form>

<br><br>

<form action="processFormVersionThree" method="get">
    <label>Process Form Version Three</label>
    <input type="text" name="studentName" placeholder="What's your name? ">
    <button type="submit">Send</button>
</form>
</body>
</html>
