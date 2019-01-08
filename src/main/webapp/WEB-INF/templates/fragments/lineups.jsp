<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
	<head>
	</head>
<body>
	<div class = "col-md-6">
		<button class="btn-lg" ng-click="l.getLineup(${userId})">Retrieve Lineups</button>
		<table class="table table-color table-bordered table-hover">
		<tr ng-repeat="lineup in l.lineups">
			<td ng-repeat = "player in lineup.players" class="col-md-4">
				<div>{{player.firstName}}</div>
				<div>{{player.lastName}}</div>
				<div>{{player.playerDetail.salary}}</div>
		</tr>
	</table>	
	</div>

</body>

</html>