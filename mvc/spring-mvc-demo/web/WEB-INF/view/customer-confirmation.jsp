<%--
  Created by IntelliJ IDEA.
  User: Luiz Filipy
  Date: 27/07/2020
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
The customer: ${customer.firstName} ${customer.lastName}
<br><br>
Free Passes: ${customer.freePasses}
<br><br>
Postal Code: ${customer.postalCode}
<br><br>
Course Code: ${customer.courseCode}
</body>
</html>
