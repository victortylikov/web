<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>login page</h1>
	<form name="f" action="<c:url value='j_spring_security_check'/>"
		method="POST">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type='text' name='j_username' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password'></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit">&nbsp;<input
					name="reset" type="reset"></td>
			</tr>
		</table>
	</form>

</body>
</html>
