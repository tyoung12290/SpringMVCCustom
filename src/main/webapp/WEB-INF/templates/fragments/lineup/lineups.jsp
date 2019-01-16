<html>
	<head>
	</head>
<body>
	<div class = "col-md-6" >
		<button class="btn-lg" ng-click="l.getLineup(${userId})" )>Retrieve Lineups</button>
		<table class="table table-color table-bordered table-hover">
		<tr ng-repeat="lineup in l.lineups">
			<td ng-repeat = "player in lineup.playerDetails" class="col-md-4">
				<div>{{player.player.firstName}}</div>
				<div>{{player.player.lastName}}</div>
				<div>{{player.salary}}</div>
				<div>{{player.score}}</div>
			</td>
			<td>
			<div>
				<button class = "player-remove-button"
						ng-click= "l.removeLineup(lineup)">
					<span class="fas fa-minus-circle fas-lg"></span>
				</button>
			</div>
			</td>	
			<td>
			<div>
				<button class = "lineup-edit-button"
						ng-click= "l.editLineup(lineup);t.setTab(1)">
					<i class="far fa-edit"></i>
				</button>
			</div>
			</td>
		</tr>
	</table>	
	</div>

</body>

</html>