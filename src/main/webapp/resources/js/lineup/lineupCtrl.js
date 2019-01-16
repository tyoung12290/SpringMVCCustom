angular.module('myApp').controller('lineupCtrl', ['$http', 'lineupFactory','tagFactory', function($http, lineupFactory,tagFactory){
		let vm = this;
		vm.lineups={};
		vm.lineup=lineupFactory.lineup;
		
		vm.getLineup = function(userId) {
			lineupFactory.getLineups(userId).success(function(result){
				vm.lineups=result;
				console.log(vm.lineups)
			}).error(function(error){
				console.log(error)
		});
		}
		
		vm.removeLineup = function(lineup) {
			index=vm.lineups.indexOf(lineup);
			lineupFactory.removeLineup(lineup).success(function(result){
				vm.lineups.splice(index,1);
				//TODO modify JAVA classes from Lineup -- Player -- PlayerDetail to Lineup -- PlayerDetail -- PlayerDetail
			}).error(function(error){
				console.log(error)
		});
		}
		
		vm.saveLineup = function(userId){
			let date = new Date();
			let dateString = new Date(date.getTime() - (date.getTimezoneOffset() * 60000 ))
			                    .toISOString()
			                    .split("T")[0];
			let lineup = {};
			lineup.playerDetails=[];
			for (let player of vm.lineup.players){
				let tempPlayer = {};
				tempPlayer.id=player.id;
				let playerNested={};
				playerNested.id=player.id
				tempPlayer.player=playerNested;
				tempPlayer.date=player.date;
				tempPlayer.score=player.score;
				tempPlayer.salary=player.score;
				lineup.playerDetails.push(tempPlayer);
			}
			lineup.userId=userId;
			lineup.date=dateString;
			$http.post("http://localhost:8080/SpringMVCCustom/lineup", JSON.stringify(lineup)).then(function(successData){
				console.log(successData);
				}, function(error){
					console.log(error)
				});
			lineupFactory.clearLineup(vm.lineup);
			tagFactory.calcTags(0);
			
		}
		
		vm.editLineup = function(lineup){
			vm.lineup=lineupFactory.editLineup(lineup);
			console.log(vm.lineup)
		}
		
		vm.updateLineup = function(lineup){
			persistLineup={};
			persistPlayers=[];
			for (let player of lineup.players){
				let persistPlayerDetails={};
				persistPlayerDetails.id=player.playerDtlId;
				persistPlayerDetails.date=player.date;
				persistPlayerDetails.score=player.score;
				persistPlayerDetails.salary=player.salary;
				let persistPlayer={};
				persistPlayer.id=player.id
				persistPlayerDetails.player=persistPlayer
				persistPlayers.push(persistPlayerDetails)
			}
			persistLineup.playerDetails=persistPlayers;
			persistLineup.userId=1;
			persistLineup.date=lineup.date;
			persistLineup.id = lineup.id;
			console.log(persistLineup);
			$http.put("http://localhost:8080/SpringMVCCustom/lineup", JSON.stringify(persistLineup)).then(function(successData){
				console.log(successData);
				}, function(error){
					console.log(error)
				});
		}
		vm.removePlayer = function(activePlayer){
			lineupFactory.removePlayer(activePlayer);
		}
		
		vm.clearLineup = function(lineup){
			lineupFactory.clearLineup(lineup);
		}
	}]);