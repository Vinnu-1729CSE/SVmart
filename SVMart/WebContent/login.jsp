<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body style='background-color: #52b788;'>

	<div class='login-tn'>
		<div class="login-form" align="center">

			<form action="LoginServlet" method="post" id="loginSubmit">
				<table style="width: 50%">
					<h2>Welcome Back</h2>
					<tr>
						<td><input type="text" name="username" id="username"
							placeholder='UserName' /></td>
					</tr>
					<tr>

						<td><input type="password" name="password" id="password"
							placeholder='Password' /></td>
					</tr>

				</table>
				<button type="submit">Login</button>
				<p>
					Don't have an account?<a href="register.html"
						style="color: #4c958c">Register</a>
				</p>
			</form>

		</div>
		<div class='login-pic'>
			<img
				src="https://preview.colorlib.com/theme/bootstrap/login-form-08/images/undraw_file_sync_ot38.svg" />
		</div>
	</div>

	<script>
		$('#loginSubmit').submit(function(e) {
			e.preventDefault();
			$.ajax({
				url : 'LoginServlet',
				method : 'POST',
				data : {
					username : $('#username').val(),
					password : $('#password').val()
				},
				success : function(res) {
					if (res.includes('Success')) {
						window.location.href = 'onlinestore.jsp';
					} else {
						$("#username").css('border', '1px solid red');
						$("#password").css('border', '1px solid red');
					}
				}
			})
		})
	</script>
</body>
</html>