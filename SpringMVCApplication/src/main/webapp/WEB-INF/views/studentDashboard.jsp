<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students Details</title>
</head>
<body>
<table>
    <tr>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Student Address</th>
    </tr>
    <c:forEach var="studObj" items="${allStudInfo}">
        <tr>
            <td>
                <a href="http://localhost:8080/SpringMVCApplication/student/getStudentById/${studObj.studId}">
                    <c:out value="${studObj.studId}"/>
                </a>
            </td>
            <td><c:out value="${studObj.studName}"/></td>
            <td><c:out value="${studObj.studAddress}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>