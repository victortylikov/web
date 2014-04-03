<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<h1>Add user</h1>
	<form:form action="addUserPost" modelAttribute="user">
		<table>
			<tr>
				<td>Login :</td>
				<td><form:input path="login" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add"></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>
