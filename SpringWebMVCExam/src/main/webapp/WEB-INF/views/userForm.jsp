<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Information Form</title>

</head>
<body>
    <div class="container">
        <h2>User Information Form</h2>
        <form action="ProcessUserInfo.jsp" method="POST">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="mobile">Mobile</label>
            <input type="tel" id="mobile" name="mobile" required pattern="[0-9]{10}" title="Please enter a valid 10-digit mobile number">

            <label for="username">Username</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
