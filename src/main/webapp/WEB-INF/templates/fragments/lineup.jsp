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
<div class="container">
	<div class="player_filters">
		<div class="player_filters_pos_btns">
			<div class="btn-group btn-group-m col-md-3 col-md-offset-5">
			  <button type="button" class="btn btn-primary">PG</button>
			  <button type="button" class="btn btn-primary">SG</button>
			  <button type="button" class="btn btn-primary">SF</button>
			</div>
		</div>
	</div>
</div>
	
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