<html>
	<head>
	</head>
	<body>
		<div class="lineup_tags">
			<span class="tag" ng-repeat="tag in p.tags | filter:{status:true}" ng-style="{'background-color':'{{tag.color}}'}">{{tag.strategy}}</span>
		</div>
	</body>

</html>