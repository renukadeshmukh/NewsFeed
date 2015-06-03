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

		<form action="addHeadline" method="post" class="sky-form">

			<table>
				<tr>
					<td><h2>Hello, ${sessionUser.name}</h2></td>

				</tr>
				<tr>
					<td>
					<td width="50%"></td>
					<td><h2>
							<a style="color: #666;" href="logout">Logout</a>
						</h2></td>
					</td>
				</tr>
			</table>
			<fieldset>
				<table style="width: 100%">

					<tr>
						<td>Id</td>
						<td>Headline</td>
						<td>Department</td>

					</tr>
					<c:forEach items="${headlines}" var="headline">
						<tr>
							<td>${headline.headlineId}</td>
							<td>${headline.description}</td>
							<td>${department}</td>
							<td><a href="deletefeed?fid=${headline.headlineId}">Delete
									Headline</a></td>
						</tr>

					</c:forEach>

					<tr>


					</tr>
				</table>
				</br>
				<footer>
					<label class="input"> <i class="icon-append icon-user"></i>
						<input type="text" placeholder="Enter new headline"
						name="headline"> <b class="tooltip tooltip-bottom-right">Only
							latin characters and numbers</b>

					</label> </br>
					<button type="submit" class="button">Save</button>

				</footer>
			</fieldset>
		</form>

	</div>
</body>

</html>