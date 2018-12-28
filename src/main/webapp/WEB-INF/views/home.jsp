<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
	<style>
	
	div{
	border-style:solid;
	border-width:.5px;
	}
	

	
	.lineup__body {
	display: table;
    height: 640px;
    width: 100%;
    margin: 0;
    padding: 0;
	}
	
	.lineup__slot{
	display:table-row;
	border-width:.5px
	}
	
	.lineup__slot:not(.lineup__slot--has-player)>:not(.lineup__empty-state) {
	display:none;
	}
	.lineup__slot:not(.lineup__slot--has-player) .lineup__empty-state{
	display: flex
	}
	
	
	.lineup__empty-state{
	 font-size: 16px;
	 display:none;
	 cursor:pointer;
	 height:100%;
	 width:100%;
	 align-items:center;
	 position: relative
	}
	
	.lineup__player-container{
	 font-size: 16px;
	 cursor:pointer;
	 height:100%;
	 width:100%;
	 align-items:center;
	 position: relative
	}
	.lineup__player{
	 display:flex;
	 height:100%;
	 width:100%;
	 position:relative;
	}
	
	.lineup_player_info{
	 display:flex;
	 height:100%;
	 width:100%;
	 position:relative;
	}
	
	.player_filters{
	display:flex;
	justify-content:left
	}
	
	.btn-group{
	align-self: flex-start
	}
	
	.search_players{
	margin-left:auto;
	}
	
	</style>
    <jsp:include page="/WEB-INF/templates/fragments/header.jsp">

        <jsp:param name="title" value="LandingPage" />

    </jsp:include>
    
    

</head>

<body>
	
	
	<div class = "container" ng-app="myApp">
	<div class = "row">
		<span class="contest-player-list-title">
			<div>
			<h3 class="available-players-title">Available Players</h3>
			</div>
		</span>
	</div>
		<div class="row" ng-controller="player as p">
		<div class = "col-md-8"  ng-init="p.loadPlayers()">
			<jsp:include page="/WEB-INF/templates/fragments/lineup_filters.jsp">
				<jsp:param name="title" value="Lineup" />
			</jsp:include>
			<table class = "table table-color table-bordered table-hover">
				<tr ng-repeat="player in p.allPlayers.data | filter:{pos:p.search.pos}"
					ng-click="p.setClickedRow(player)">
				    <td>{{player.firstName}}</td>
				    <td>{{player.lastName}}</td>
				    <td>{{player.pos}}</td>
				    <td>{{player.team}}</td>
			    </tr>
			</table>
		</div>
	 		<div class = "col-md-4">
	 			<jsp:include page="/WEB-INF/templates/fragments/lineup_filters.jsp">
					<jsp:param name="title" value="lineupSalary" />
				</jsp:include>
				<ul class ="lineup__body">
					<li ng-repeat = "player in p.lineup.players track by player.lineupSlot" 
						class = "lineup__slot" 
						ng-class="{'lineup__slot--has-player':player.id}">
						<div class="lineup__empty-state">
							<span class="lineup__player-position">{{player.pos}}</span>
							                   Add Player                  
	                   		<span class="lineup__player-position">{{player.firstName}}</span>
						</div>
						<div class ="lineup__player-container">
							<div class = "lineup__player">
								<div class = "lineup_player_info">
									<span class="lineup_player-position">{{player.pos}}</span>
									<span class = "lineup_player_name">{{player.firstName}}</span>
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
    
	<script type="text/javascript">
	var app = angular.module('myApp', []);
	
	app.controller('player', ['$http', function($http){
		let vm = this;
		vm.player={};
		vm.allPlayers={};
		vm.lineup={
				players:[
					{lineupSlot:1,pos:"PG"},
					{lineupSlot:2,pos:"PG"},
					{lineupSlot:3,pos:"SG"},
					{lineupSlot:4,pos:"SG"},
					{lineupSlot:5,pos:"SF"},
					{lineupSlot:6,pos:"SF"},
					{lineupSlot:7,pos:"PF"},
					{lineupSlot:8,pos:"PF"},
					{lineupSlot:9,pos:"C"}
				],
				playerCount:
					{
					PG:0,
					SG:0,
					SF:0,
					PF:0,
					C:0
					}
		};
		vm.search={pos:''};
		vm.loadPlayers= function(){
			$http.get("http://localhost:8080/SpringMVCCustom/players").then(function(successData){
				vm.allPlayers=successData;
				}, function(error){
					console.log(error)
				});
		}
		vm.getVal = function(val){
			if(val.currentTarget.value==="All"){
				vm.search.pos = {};
			}
			else{
				vm.search.pos = val.currentTarget.value;
			}
			
		}
		vm.setClickedRow = function(activePlayer){
			console.log(activePlayer)
			let index= vm.allPlayers.data.indexOf(activePlayer)
			for (let player of vm.lineup.players){
				let props = Object.keys(player).length
				if(player.pos === activePlayer.pos && !(Object.keys(player).length > 2)){
					vm.lineup.playerCount[player.pos] ++;
					console.log(vm.lineup.playerCount[player.pos])
					Object.assign(player, activePlayer);
					vm.allPlayers.data.splice(index,1)
					break;
				}
			}
			
			//TODO call function to change CSS if position has been filled
			//TODO call function to change submit button if lineup has been filled
		}

	}]);
	</script>
</body>

</html>