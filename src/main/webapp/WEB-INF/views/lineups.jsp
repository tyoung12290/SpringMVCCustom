<%@taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<jsp:include page="/WEB-INF/templates/fragments/header.jsp">
	<jsp:param name="title" value="Lineups" />
</jsp:include>
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/app.js" />"></script>
<script src="<c:url value="/resources/js/userCtrl.js" />"></script>
</head>
<body>
<div>
	<h3>${user.username} has successfully logged in</h3>
</div>


</body>
</html>