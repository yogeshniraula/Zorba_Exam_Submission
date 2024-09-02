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
      <td>${studObj.studId}</td>
      <td>${studObj.studName}</td>
      <td>${studObj.studAddress}</td>
    </tr>
  </table>
</body>
</html>