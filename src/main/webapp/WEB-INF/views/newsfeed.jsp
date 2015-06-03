<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>


<!DOCTYPE html>
<html>
<head>
<title>IU Times</title>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0">

<link href="${pageContext.request.contextPath}/resources/css/demo.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/sky-forms.css"
	rel="stylesheet">

</head>
<body class="bg-cyan">
	<div class="body ">

		<form action="" class="sky-form">
			<fieldset>
				<table style="width: 100%">
					<tr>
						<td><a href="newsfeed"> News Feed</a></td>
						<td><a href="internetfeed"> Internet Feed</a></td>
						<td><a href="twitterfeed"> Twitter Feed</a></td>
						<td><h2><a style="color:#666;" href="logout">Logout</a></h2></td>
					</tr>
				</table>
			</fieldset>

			<h1>Welcome, ${sessionUser.name}</h1>

			<fieldset>
				<table style="width: 100%">
					<tr>
						<td>Name</td>
						<td>Description</td>

					</tr>
					<c:forEach items="${newsfeeds}" var="nfeed">
						<tr>
							<td>${nfeed.name}</td>
							<td>${nfeed.description}</td>

						</tr>

					</c:forEach>
				</table>
				</br>

			</fieldset>
		</form>

	</div>
</body>
</html>