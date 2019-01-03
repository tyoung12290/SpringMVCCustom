angular.module('myApp').controller('playerCtrl', ['$http', function($http){
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
					C:0,
					total:0
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
				vm.search.pos = '';
			}
			else{
				vm.search.pos = val.currentTarget.value;
			}
			
		}
		/*vm.setClickedRow = function(activePlayer){
			let index= vm.allPlayers.data.indexOf(activePlayer)
			for (let player of vm.lineup.players){
				let props = Object.keys(player).length
				if(player.pos === activePlayer.pos && !(Object.keys(player).length > 2)){
					vm.lineup.playerCount[player.pos] ++;
					Object.assign(player, activePlayer);
					vm.allPlayers.data.splice(index,1);
					vm.lineup.playerCount.total ++;
					break;
				}
			}
			
			//TODO call function to change CSS if position has been filled
		}*/
		
		vm.inLineup = function(playerId){
			let bool = false;
			for (let player of vm.lineup.players){
				if((Object.keys(player).length > 2) && player.id === playerId){
					bool = true;
				}

			}
			return bool;
		}
		
		vm.addPlayer = function (activePlayer){
			console.log("testing")
			let index= vm.allPlayers.data.indexOf(activePlayer)
			for (let player of vm.lineup.players){
				if(player.pos === activePlayer.pos && !(Object.keys(player).length > 2)){
					vm.lineup.playerCount[player.pos] ++;
					Object.assign(player, activePlayer);
					vm.lineup.playerCount.total ++;
					break;
				}
			}
			console.log(vm.lineup.players)
		}
		//TODO need to reset lineup to original not remove
		vm.removePlayer = function(activePlayer, fromPlayers){
			console.log(fromPlayers)
			if(fromPlayers==true){
				for (let player of vm.lineup.players){
					if(activePlayer.id==player.id){
						index = vm.lineup.players.indexOf(player);
						vm.lineup.players[index] = {
								lineupId: vm.lineup.players[index].lineupId ,
								pos :vm.lineup.players[index].pos
						}
						vm.lineup.playerCount.total --;
						break;
					}
				}
			}else{
				index = vm.lineup.players.indexOf(activePlayer);
				vm.lineup.players[index] = {
						lineupId: vm.lineup.players[index].lineupId ,
						pos :vm.lineup.players[index].pos
				}
				vm.lineup.playerCount.total --;
			}
			
		}
	}]);