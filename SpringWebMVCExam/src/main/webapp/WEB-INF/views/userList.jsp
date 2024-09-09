<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View User</title>
</head>
<body>
  <c:set var="userObj" value="${userObj}"/>
  <table>
    <tr>
      <th>User Id</th>
      <th>USer Name</th>
      <th>User Email</th>
    </tr>
    <tr>
      <td>${userObj.userId}</td>
      <td>${userObj.userName}</td>
      <td>${userObj.userEmail}</td>
    </tr>
  </table>
</body>
</html>