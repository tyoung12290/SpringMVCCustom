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
<script src="<c:url value="/resources/js/playerCtrl.js" />"></script>
<script src="<c:url value="/resources/js/tabCtrl.js" />"></script>
<script src="<c:url value="/resources/js/factory/lineupFactory.js" />"></script>
<script src="<c:url value="/resources/js/lineupCtrl.js" />"></script>
<script src="<c:url value="/resources/js/factory/tagFactory.js" />"></script>


<style>
button:disabled,
button[disabled]{
  border: 1px solid #999999;
  background-color: #cccccc;
  color: #666666;
}

.player-add{
    float:right;
}

.player-add-button{
	border: none;
	background-color:transparent;
	font-family:"fontAwesome";
	color:#36c565;
	font-size: 2rem;
	display: block;
	margin:auto;
}
.player-remove-button{
	border: none;
	background-color:transparent;
	font-family:"fontAwesome";
	color:red;
	font-size: 2rem;
	display: block;
	margin:auto;
}

td{
flex:auto;
}


.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}

.row{
margin-left:auto;
margin-right:auto
}

</style>
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
		          	<a href ng-click="t.setTab(2)">lineups</a>
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
	<div class="row" ng-controller="playerCtrl as p" ng-show="t.isSet(1)" ng-init="p.loadPlayers()">
		<jsp:include page="/WEB-INF/templates/fragments/allPlayers.jsp"></jsp:include>	
		<jsp:include page="/WEB-INF/templates/fragments/lineupBuilder.jsp"></jsp:include>	
	</div>
	<div class = "row" ng-controller="lineupCtrl as l" ng-show="t.isSet(2)">
		<jsp:include page="/WEB-INF/templates/fragments/lineups.jsp"></jsp:include>
	</div>	
	<div class = "row">
		<div class = "col-md-6">
			<div ng-show="t.isSet(3)">Research</div>
		</div>
	</div>	
	</div>
</body>

</html>