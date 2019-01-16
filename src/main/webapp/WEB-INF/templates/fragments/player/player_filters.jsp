<html>
	<head>
	    <jsp:include page="/WEB-INF/templates/fragments/header.jsp">
	        <jsp:param name="title" value="LandingPage" />
	    </jsp:include>
	</head>
<body>
	<div class="player_filters">
			<div class="btn-group btn-group-m">
			  <button type="button" ng-model="p.search.pos" value="PG" ng-click="p.getVal($event)" class="btn btn-primary">PG</button>
			  <button type="button" ng-model="p.search.pos" value="SG" ng-click="p.getVal($event)" class="btn btn-primary">SG</button>
			  <button type="button" ng-model="p.search.pos" value="SF" ng-click="p.getVal($event)" class="btn btn-primary">SF</button>
			  <button type="button" ng-model="p.search.pos" value="PF" ng-click="p.getVal($event)" class="btn btn-primary">PF</button>
			  <button type="button" ng-model="p.search.pos" value="C" ng-click="p.getVal($event)" class="btn btn-primary">C</button>
			  <button type="button" ng-model="p.search.pos" value="All" ng-click="p.getVal($event)" class="btn btn-primary">All</button>
			</div>
			<div class = "search_players">
				<input id="player_search" placeholder="Search"  ng-model="p.search.fuzzy"></input>
			</div>
	</div>


</body>

</html>