<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Upload Excel File</title>
</head>
<body>
    <h2>Upload Excel File</h2>
    <form action="fileUpload" method="post" enctype="multipart/form-data">
        <label>Select Excel File:</label>
        <input type="file" name="file" accept=".xlsx" required />
        <br/><br/>
        <input type="submit" value="Upload and Save Data" />
    </form>
</body>
</html>
