<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Roles</title>
</head>
<body>
    <h2>Assign Role to User ID: ${userId}</h2>

    <form action="assignRole" method="post">
        <input type="hidden" name="userId" value="${userId}" />

        <label for="role">Select Role:</label>
        <select id="role" name="role">
            <option value="ADMIN">ADMIN</option>
            <option value="USER">USER</option>
            <option value="VENDOR">VENDOR</option>
        </select>

        <input type="submit" value="Add Role" />
    </form>
</body>
</html>