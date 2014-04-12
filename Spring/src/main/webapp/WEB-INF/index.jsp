<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello  
		<security:authorize access="isAuthenticated()">  
      	  <strong><security:authentication property="principal.username"/></strong>
   		</security:authorize> !</h1>  
	<h2>Click To | <a href="<c:url value="j_spring_security_logout" />">Logout</a>  
  </h2>  

	<p>
		<a href="/spring/users">LIST</a>
	</p>
	<p>
		<a href="/spring/addUserGet">add</a>
	</p>
	<p>
		<a href="/spring/resources/test.html">test</a>
	</p>
	<p>
		<a href="/spring/login">login</a>
	</p>
	<p>
		<a href="/spring/resources/te.html">error404</a>
	</p>

</body>
</html>
