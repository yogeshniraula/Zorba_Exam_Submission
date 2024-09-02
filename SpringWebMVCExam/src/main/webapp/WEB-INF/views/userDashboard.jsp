<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Details</title>
</head>
<body>
<table>
    <tr>
        <th>User Id</th>
        <th>User Name</th>
        <th>User Email</th>
          <th>User Mobile</th>
    </tr>
    <c:forEach var="userObj" items="${allUserInfo}">
        <tr>
            <td>
                <a href="http://localhost:8080/SpringWebMVCExam/user/getUserById/${userObj.userId}">
                    <c:out value="${userObj.userId}"/>
                </a>
            </td>
            <td><c:out value="${userObj.userName}"/></td>
            <td><c:out value="${userObj.userEmail}"/></td>
            <td><c:out value="${userObj.userMobile}"/></td>
            <td><c:out value="${userObj.userUsername}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>