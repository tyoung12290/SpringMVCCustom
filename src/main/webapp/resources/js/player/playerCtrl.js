angular.module('myApp').controller('playerCtrl', ['$http', 'tagFactory', 'lineupFactory', function($http, tagFactory, lineupFactory){
		let vm = this;
		vm.player={};
		vm.allPlayers=[];
		vm.lineup=lineupFactory.lineup;
		
		vm.search={pos:'',
					fuzzy:''};
		vm.loadPlayers= function(){
			$http.get("http://localhost:8080/SpringMVCCustom/players").then(function(successData){
				vm.allPlayers=successData.data;
				for(let playerDetail of vm.allPlayers){
					playerDetail.playerDtlId=playerDetail.id
					playerDetail.id=playerDetail.player.id;
					playerDetail.firstName=playerDetail.player.firstName;
					playerDetail.lastName=playerDetail.player.lastName;
					playerDetail.pos=playerDetail.player.pos;
					playerDetail.team=playerDetail.player.team;
					delete playerDetail.player;
				}
				}, function(error){
					console.log(error)
				});
		}
		vm.getVal = function(val){
			if(val.currentTarget.value==="All"){
				vm.search.pos = '';
			}
			else{
				vm.search.pos = val.currentTarget.value;
			}
			
		}
		vm.inLineup = function(playerId){
			let bool = false;
			for (let player of vm.lineup.players){
				if((Object.keys(player).length > 2) && player.id === playerId){
					bool = true;
				}

			}
			return bool;
		}
		
		vm.isPosFilled = function(pos){
			let bool = false;
			if(vm.lineup.playerCount[pos] == vm.lineup.maxPlayerCount[pos]){
				bool=true;
			}
			return bool;
		}
		
		vm.addPlayer = function (activePlayer){
			lineupFactory.addPlayer(activePlayer);
			vm.tags = tagFactory.calcTags(vm.lineup.playerCount.total);
		}
		vm.removePlayer = function(activePlayer){
			lineupFactory.removePlayer(activePlayer);
			vm.tags = tagFactory.calcTags(vm.lineup.playerCount.total);
		}
		
		vm.search
	}]);