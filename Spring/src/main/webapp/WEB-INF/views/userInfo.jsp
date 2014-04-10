<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<h1>User</h1>

	<c:if test="${not empty user}">
		<TABLE>
			<THEAD>
				<TR>
					<TH>Login</TH>
					<TH>Password</TH>
					<TH>Email</TH>
					<TH>Role</TH>
				</TR>
			</THEAD>
			<TBODY>
					<TR>
						<TD>${user.login}</TD>
						<TD>${user.password}</TD>
						<TD>${user.email}</TD>
						<c:if test="${!empty user.roles}">
							<c:forEach items="${user.roles}" var="role">
								<TD>${role.role}</TD>
							</c:forEach>
						</c:if>
					</TR>
				
			</TBODY>
		</TABLE>
	</c:if>
	<p>
		<a href="/spring/index">back</a>
	</p>
</body>
</html>
