<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>View Employees</title>
</head>
<body>

<h2>Employee List</h2>

<c:if test="${not empty inventory}">
    <table>
        <thead>
            <tr>
                <th>Inventory_Category</th>
                <th>Inventory_Name</th>
                <th>Inventory_Quantity</th>
                <th>Inventory_Price</th>
                <th>Inventory_Description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${inventory.category}</td>
                    <td>${inventory.name}</td>
                    <td>${inventory.quantity}</td>
                    <td>${inventory.price}</td>
                    <td>${inventory.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty inventory}">
    <p>No Inventory found.</p>
</c:if>

</body>
</html>
