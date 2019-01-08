<html>
	<head>
	<style>
	
	.lineup_tags{
	border:solid;
	border-width:thin;
	}
	
	.tag{
	border:solid;
	border-width:thin;
	margin:1px;
	background-color:#7EDAD1;
	display:inline-blocks
	}
	
	</style>
	</head>
<body>
	<div class="lineup_tags">
		<span class="tag" ng-repeat="tag in p.tags | filter:{status:true}" ng-style="{'background-color':'{{tag.color}}'}">{{tag.strategy}}</span>
	</div>


</body>

</html>