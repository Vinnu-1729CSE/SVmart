<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>VSmart Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 300px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error-message {
            color: red;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>VSmart Registration</h2>
        <form id="registerForm" action="registerServlet" method="post">
            <input type="text" id="username" name="username" placeholder="Username">
            <div class="error-message" id="usernameError"></div>
            <input type="password" id="password" name="password" placeholder="Password">
            <div class="error-message" id="passwordError"></div>
            <input type="submit" value="Register">
        </form>
    </div>

    <script>
        document.getElementById("registerForm").addEventListener("submit", function (event) {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var usernameError = document.getElementById("usernameError");
            var passwordError = document.getElementById("passwordError");

            // Validate username
            if (username.trim() === "") {
                usernameError.textContent = "Username is required";
                event.preventDefault();
            } else {
                usernameError.textContent = "";
            }

            // Validate password
            if (password.trim() === "") {
                passwordError.textContent = "Password is required";
                event.preventDefault();
            } else {
                passwordError.textContent = "";
            }
        });
    </script>
</body>
</html>
