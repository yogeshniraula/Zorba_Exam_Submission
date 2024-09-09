<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Validation Form</title>
    <script type="text/javascript">
        function validateEmail() {
            var email = document.getElementById("email").value;
            var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

            if (!emailPattern.test(email)) {
                document.getElementById("error-message").innerHTML = "Invalid email format.";
                return false; // Prevent form submission
            }

            return true; // Allow form submission if email is valid
        }

            function validatePassword() {
                    var password = document.getElementById("password").value;

                    // Check if password length is at least 8 characters
                    if (password.length < 8) {
                        document.getElementById("error-message").innerHTML = "Password must be at least 8 characters long.";
                        return false; // Prevent form submission
                    }

                    // Clear any error message if validation passes
                    document.getElementById("error-message").innerHTML = "";
                    return true; // Allow form submission
                }
                function validatePhoneNumber() {
                            var phoneNumber = document.getElementById("phone").value;
                            var phonePattern = /^[0-9]{10}$/;

                            // Check if the phone number is exactly 10 digits
                            if (!phonePattern.test(phoneNumber)) {
                                document.getElementById("phone-error-message").innerHTML = "Phone number must be exactly 10 digits.";
                                return false; // Prevent form submission
                            }

                            // Clear error message if validation passes
                            document.getElementById("phone-error-message").innerHTML = "";
                            return true; // Allow form submission
                        }
                        function validateForm() {
                                    return validateEmail%% validatePassword() && validatePhoneNumber();
                                }




    </script>
</head>
<body>

        <h2>User validation Form</h2>
        <form action="userForm" method="POST">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>

            <label for="mobile">Mobile</label>
            <input type="text" id="mobile" name="mobile" required pattern="[0-9]{10}" title="Please enter a valid 10-digit mobile number">

            <label for="email">Email</label>
            <input type="text" id="email" name="email" required>

            <label for="password">Password</label>
            <input type="text" id="password" name="password" required>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
