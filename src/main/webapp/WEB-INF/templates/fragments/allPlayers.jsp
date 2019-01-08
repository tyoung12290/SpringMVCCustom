<html>
<head>
</head>
<body>
<div class="col-md-8" ng-init="p.loadPlayers()">
	<jsp:include page="/WEB-INF/templates/fragments/lineup_filters.jsp">
		<jsp:param name="title" value="Lineup" />
	</jsp:include>
	<table class="table table-color table-bordered table-hover">
		<tr
			ng-repeat="player in p.allPlayers.data | filter:{pos:p.search.pos}"
			ng-click="p.setClickedRow(player)">
			<td class="col-md-1">{{player.pos}}</td>
			<td class="col-md-4">{{player.firstName}} {{player.lastName}}</td>
			<td class="col-md-2">{{player.team}}</td>
			<td class = "player-add col-md-1">
				<button class = "player-add-button"
						ng-if="!p.inLineup(player.id)"
						ng-click= "p.addPlayer(player)">
					<span class="fas fa-plus-circle fas-sm"></span>
				</button>
				<button class = "player-remove-button"
						ng-if="p.inLineup(player.id)"
						ng-click= "p.removePlayer(player, true)">
					<span class="fas fa-minus-circle fas-lg"></span>
				</button>
			</td>
		</tr>
	</table>
</div>
</body>
</html>