<%--
  Created by IntelliJ IDEA.
  User: Luiz Filipy
  Date: 26/07/2020
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    First Name: <form:input path="firstName"/>

    <br><br>

    Last Name: <form:input path="lastName"/>

    <br><br>

    Country:
    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
        <%-- <form:option value="Brazil" label="Brazil"/> --%>
        <%-- <form:option value="France" label="France"/> --%>
        <%-- <form:option value="Germany" label="Germany"/> --%>
        <%-- <form:option value="India" label="India"/> --%>
    </form:select>

    <br><br>

    Favorite Language:
    Java <form:radiobutton id="fl1" path="favoriteLanguage" value="java"/>
    Python <form:radiobutton path="favoriteLanguage" value="python"/>
    Go <form:radiobutton path="favoriteLanguage" value="go"/>
    TypeScript <form:radiobutton path="favoriteLanguage" value="typescript"/>

    <br><br>

    Operating Systems:
    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
    MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>

    <br><br>

    <button type="submit">Send</button>
</form:form>
</body>
</html>
