<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
<h2>Vendors</h2>
<table>
 <thead>
        <tr>
            <th>User ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <!-- Loop through the list of vendors -->
        <c:forEach var="vendor" items="${vendorList}">
            <tr>
                <td>${vendor.userId}</td>
                <td>${vendor.name}</td>
                <td>${vendor.email}</td>
                <td>${vendor.mobile}</td>
                <td>
                    <!-- Action buttons -->
                    <form action="deleteUser" method="post">
                        <input type="hidden" name="userId" value="${vendor.userId}" />
                        <button type="submit">Remove</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<!-- Customers Table -->
<h2>Customers</h2>
<table>
    <thead>
        <tr>
            <th>User ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <!-- Loop through the list of customers -->
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.userId}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.mobile}</td>
                <td>
                    <!-- Action buttons -->
                    <form action="deleteUser" method="post">
                        <input type="hidden" name="userId" value="${customer.userId}" />
                        <button type="submit">Remove</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
    <a href="<c:url value='/viewInventory' />">View All Inventory</a>
</body>
</html>
