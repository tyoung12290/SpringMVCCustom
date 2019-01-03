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
		<div class="col-md-4">
			<jsp:include page="/WEB-INF/templates/fragments/lineup_filters.jsp">
				<jsp:param name="title" value="lineupSalary" />
			</jsp:include>
			<ul class="lineup__body">
				<li
					ng-repeat="player in p.lineup.players track by $index"
					class="lineup__slot"
					ng-class="{'lineup__slot--has-player':player.id}">
					<div class="lineup__empty-state">
						<span class="lineup__player-position">{{player.pos}}</span> Add
						Player <span class="lineup__player-position">{{player.firstName}}</span>
					</div>
					<div class="lineup__player-container">
						<div class="lineup__player">
							<div class="lineup_player_info">
								<span class="lineup_player-position">{{player.pos}} </span> 
								<span class="lineup_player_name">{{player.firstName}} {{player.lastName}}</span>
							</div>
						</div>
						<div>
						<button class = "player-remove-button"
								ng-click= "p.removePlayer(player, false)">
							<span class="fas fa-minus-circle fas-lg"></span>
						</button>
						</div>
					</div>
				</li>
			</ul>
			<button ng-disabled="p.lineup.playerCount.total!=9">Save</button>
		</div>
</body>
</html>