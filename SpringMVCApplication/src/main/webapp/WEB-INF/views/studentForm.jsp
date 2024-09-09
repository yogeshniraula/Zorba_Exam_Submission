<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <div class="container">
        <h2>Student Information Form</h2>
        <form action="submitStudent" method="POST">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>

             <label for="mobile">Mobile</label>
             <input type="tel" id="mobile" name="mobile" required pattern="[0-9]{10}" title="Please enter a valid 10-digit mobile number">

            <form:form action="validateEmail" modelAttribute="student">
                    <table>
                        <tr>
                            <td>Email:</td>
                            <td>
                                <form:input path="email" />
                                <form:errors path="email" cssClass="error" />
                            </td>
                        </tr>
                        <tr>
                            <td>Password:</td>
                            <td>
                                <form:password path="password" />
                                <form:errors path="password" cssClass="error" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit" value="Submit" />
                            </td>
                        </tr>
                    </table>
                </form:form>

                <style>
                    .error {
                        color: red;
                    }
                </style>







            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>


