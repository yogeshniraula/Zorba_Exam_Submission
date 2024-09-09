<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View Users</title>
</head>
<body>
    <h2>User List</h2>
    <table border="1" >
        <thead>
            <tr>
                <th>User ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Phone Number</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>
                        <a href="addRoles?userId=${user.userId}">${user.userId}</a>
                    </td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.phoneNumber}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
