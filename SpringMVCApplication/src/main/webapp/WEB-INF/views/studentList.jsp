<%@ address contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ import page="org.SpringMVCApplication.model.Student"
<html>
<head>
    <title>Student List</title>
</head>
<body>
    <h1>Student List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="student" items="${studentList}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.address}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>