<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<!DOCTYPE html> 
<html>
	<head>
		<title>IU Times</title>
		
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		
		<link href="${pageContext.request.contextPath}/resources/css/demo.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/sky-forms.css" rel="stylesheet">
		
	</head>
	<body class="bg-cyan">
		<div class="body body-s">
		
			<form method="post" action="login" class="sky-form">
				<header>Login form</header>
				
				<fieldset>					
					<section>
						<div class="row">
							<label class="label col col-4">E-mail</label>
							<div class="col col-8">
								<label class="input">
									<i class="icon-append icon-user"></i>
									<input name="username" type="email">
								</label>
							</div>
						</div>
					</section>
					
					<section>
						<div class="row">
							<label class="label col col-4">Password</label>
							<div class="col col-8">
								<label class="input">
									<i class="icon-append icon-lock"></i>
									<input name="pwd" type="password">
								</label>
								<div class="note"><a href="#">Forgot password?</a></div>
							</div>
						</div>
					</section>
					
					<section>
						<div class="row">
							<div class="col col-4"></div>
							<div class="col col-8">
								<label class="checkbox"><input type="checkbox" name="checkbox-inline" checked><i></i>Keep me logged in</label>
							</div>
						</div>
					</section>
				</fieldset>
				<footer>
					<button type="submit" class="button">Log in</button>
					<a href="register" class="button button-secondary">Register</a>
				</footer>
			</form>
			
		</div>
	</body>
</html>