<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>


<!DOCTYPE html> 
<html>
	<head>
		<title>Sky Forms</title>
		
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0">
		
		<link href="${pageContext.request.contextPath}/resources/css/demo.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/resources/css/sky-forms.css" rel="stylesheet">
		
	</head>
	<body class="bg-cyan">
		<div class="body body-s">
		
			<form action="" class="sky-form">
				<header>Registration form</header>
				
				<fieldset>					
					<section>
						<label class="input">
							<i class="icon-append icon-user"></i>
							<input type="text" placeholder="Username">
							<b class="tooltip tooltip-bottom-right">Only latin characters and numbers</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append icon-envelope-alt"></i>
							<input type="text" placeholder="Email address">
							<b class="tooltip tooltip-bottom-right">Needed to verify your account</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append icon-lock"></i>
							<input type="password" placeholder="Password">
							<b class="tooltip tooltip-bottom-right">Only latin characters and numbers</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append icon-lock"></i>
							<input type="password" placeholder="Confirm password">
							<b class="tooltip tooltip-bottom-right">Only latin characters and numbers</b>
						</label>
					</section>
				</fieldset>
					
				<fieldset>
					<div class="row">
						<section class="col col-6">
							<label class="input">
								<input type="text" placeholder="First name">
							</label>
						</section>
						<section class="col col-6">
							<label class="input">
								<input type="text" placeholder="Last name">
							</label>
						</section>
					</div>
					
					<section>
						<label class="select">
							<select>
								<option value="0" selected disabled>Gender</option>
								<option value="1">Male</option>
								<option value="2">Female</option>
								<option value="3">Other</option>
							</select>
							<i></i>
						</label>
					</section>
					
					<section>
						<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>I agree to the Terms of Service</label>
						<label class="checkbox"><input type="checkbox" name="checkbox"><i></i>I want to receive news and  special offers</label>
					</section>
				</fieldset>
				<footer>
					<button type="submit" class="button">Submit</button>
				</footer>
			</form>
			
		</div>
	</body>
</html>