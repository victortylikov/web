<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>

	<h1>List of users</h1>

	<c:if test="${not empty listUsers}">
        <TABLE>
        	<THEAD>
        		<TR>
        			<TH>Login</TH>
        			<TH>Password</TH>
        			<TH>Email</TH>
        		</TR>
        	</THEAD>
        	<TBODY>
        		<c:forEach items="${listUsers}" var="user">
        			<TR>
        				<TD>${user.login}</TD>
        				<TD>${user.password}</TD>
        				<TD>${user.email}</TD>
        			</TR>
        		</c:forEach>
        	</TBODY>
        </TABLE>
    </c:if>
	<p>
		<a href="/spring/">add</a>
	</p>
</body>
</html>
