<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <jsp:include page="/WEB-INF/templates/fragments/header.jsp">

        <jsp:param name="title" value="LandingPage" />

    </jsp:include>
    
    

</head>

<body>
	<div class = "container">
	<div class="col-md-2 col-md-offset-5">
		<form:form action="/SpringMVCCustom/player" method="GET">
			<input type="submit" class="btn btn-primary btn-lg" value="view all players">
		</form:form>
	</div>
	<div  class="col-md-2 col-md-offset-5" ng-app="myApp" ng-controller="savePlayerCtrl as ctrl">
		<form id="playerSubmissionForm" name="playerSubmissionForm">
			<label for="firstName">first name </label>
			<input id ="firstName" type="text"  ng-model="player.firstName" name="firstName" required/>
			<label for="firstName">last name</label>
			<input id = "lastName"  name="lastName" type="text"  ng-model="player.lastName" required/>
			<label for="firstName">posion</label>
			<input id = "pos" name = "pos" type="text"  ng-model="player.pos" optional/>
			<label for="firstName">team</label>
			<input id = "team" name = "pos" type="text"  ng-model="player.team" optional/>
			<button class="btn btn-primary btn-lg"  ng-click="playerSubmissionForm.$valid && savePlayer()">
			Save Player
			</button>
		</form>
		<div id="mydiv">
    		<table class = "table">
			  <tr ng-repeat="player in allPlayers.data">
			    <td>{{player.firstName}}</td>
			    <td>{{player.lastName}}</td>
			    <td>{{player.pos}}</td>
			    <td>{{player.team}}</td>
			  </tr>
			</table>
		</div>
		<!-- ng-repeat through returned data on scope -->
	</div>
	</div>
	
	<jsp:include page="/WEB-INF/templates/fragments/lineup.jsp">

        <jsp:param name="title" value="Lineup" />

    </jsp:include>
    
	<script type="text/javascript">
	var app = angular.module('myApp', []);
	
	app.controller('savePlayerCtrl', ['$scope', '$http', function($scope, $http){
		$scope.player={};
		$scope.allPlayers={};
		$scope.savePlayer = function (){
			$http.post("http://localhost:8080/SpringMVCCustom/savePlayer",JSON.stringify($scope.player)).then(function(successData){
				$scope.allPlayers=successData;
				}, function(error){
					console.log(error)
				});
		};
	}]);
	</script>
</body>

</html>