<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/templates/fragments/header.jsp">
	<jsp:param name="title" value="LandingPage" />
</jsp:include>

<script src="<c:url value="/resources/js/app.js" />"></script>
<script src="<c:url value="/resources/js/userCtrl.js" />"></script>
</head>

<style>
/* Bordered form */

/* Full-width inputs */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
  opacity: 0.8;
}

.login_container {
	margin:150px 400px 0px 400px;
	padding: 16px;
	box-sizing:border-box;
}

</style>
<div class = "login_container">
<form:form action="/SpringMVCCustom/lineup" method="POST" modelAttribute="user">
		<input id="username" type="text" placeholder="Enter Username" name="username" value="${user.username}" required></input>
		<input id="password" type="password" placeholder="Enter Password" name="password" value="${user.password}" required></input>
	<button type="submit">Login</button>

</form:form>
</div>


</html>