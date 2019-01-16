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
<link href="<c:url value="/resources/style.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/app.js" />"></script>
<script src="<c:url value="/resources/js/player/playerCtrl.js" />"></script>
<script src="<c:url value="/resources/js/ui/tabCtrl.js" />"></script>
<script src="<c:url value="/resources/js/lineup/lineupFactory.js" />"></script>
<script src="<c:url value="/resources/js/lineup/lineupCtrl.js" />"></script>
<script src="<c:url value="/resources/js/strategy/tagFactory.js" />"></script>
<script src="<c:url value="/resources/js/strategy/tagCtrl.js" />"></script>

</head>

<body>
	<div class="container" ng-app="myApp" ng-controller="tabCtrl as t">
	<div class="row">
		<div class="col-sm-12">
			<ul class="nav nav-pills" >
		       	<li ng-class="{ active: t.isSet(1) }">
		          	<a href ng-click="t.setTab(1)">builder</a>
		       	</li>
		       	
		       	<li ng-class="{ active: t.isSet(2) }">
		          	<a href ng-click="t.setTab(2)" >lineups</a>
		       	</li>
		       	<li ng-class="{ active: t.isSet(3) }">
		          	<a href ng-click="t.setTab(3)">research</a>
		       	</li>
		   	</ul>
   		</div>
   	</div>
   	<div class="row">
		<div class="col-sm-8">
			<div ng-show="t.isSet(1)">
				<span class="contest-player-list-title">
					<div>
						<h3 class="available-players-title">Available Players</h3>
					</div>
				</span>
			</div>
		</div>
	</div>
	<div class="row"  ng-show="t.isSet(1)" ng-controller="playerCtrl as p" ng-init="p.loadPlayers()">
		<jsp:include page="/WEB-INF/templates/fragments/player/players.jsp"></jsp:include>	
		<jsp:include page="/WEB-INF/templates/fragments/lineup/lineup_builder.jsp"></jsp:include>	
	</div>
	<div class = "row" ng-controller="lineupCtrl as l" ng-show="t.isSet(2)">
		<jsp:include page="/WEB-INF/templates/fragments/lineup/lineups.jsp"></jsp:include>
	</div>	
	<div class = "row">
		<div class = "col-md-6">
			<div ng-show="t.isSet(3)">Research</div>
		</div>
	</div>	
	</div>
</body>

</html>