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
		
			<form action="registeruser" method="post" class="sky-form">
				<header>Registration form</header>
				
				<fieldset>	
					<section>
						<label class="input">
							<i class="icon-append icon-user"></i>
							<input type="text" placeholder="Name" name="name">
							<b class="tooltip tooltip-bottom-right">Only latin characters and numbers</b>
						</label>
					</section>
									
					<section>
						<label class="input">
							<i class="icon-append icon-envelope-alt"></i>
							<input type="text" placeholder="Email address" name="email">
							<b class="tooltip tooltip-bottom-right">Needed to verify your account</b>
						</label>
					</section>
					
					<section>
						<label class="input">
							<i class="icon-append icon-lock"></i>
							<input type="password" placeholder="Password" name="pwd">
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
					
					<section>
						<label class="input">
							<i class="icon-append icon-lock"></i>
							<input type="text" placeholder="Address" name="addr">
							<b class="tooltip tooltip-bottom-right">Only latin characters and numbers</b>
						</label>
					</section>
					
					<section>
					
						<label class="select">
							<select name="gender">
								<option value="0" selected disabled>Gender</option>
								<option value="1">Male</option>
								<option value="2">Female</option>
							
							</select>
							<i></i>
						</label>
					
				</section>

				</fieldset>
					
				
				<footer>
					<button type="submit" class="button">Submit</button>
				</footer>
			</form>
			
		</div>
	</body>
</html>