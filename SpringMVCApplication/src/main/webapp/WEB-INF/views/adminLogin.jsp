<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Vendor Login</title>
</head>
<body>
    <h2>Vendor Login</h2>
    <form action="login" method="post">
        <label for="username">User Name:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="role">Role:</label>
        <input type="text" id="role" name="role" value="Admin" readonly><br><br>

        <button type="submit">Login</button>
    </form>
</body>
</html>