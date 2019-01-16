angular.module('myApp').factory('lineupFactory', ['$http', function($http){
	this.lineup={
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
				},
			maxPlayerCount:
				{
				PG:2,
				SG:2,
				SF:2,
				PF:2,
				C:1
				},
			remSalary:60000
	};	
	this.lineups=
	this.getLineups = function(userId){
			return $http.get("http://localhost:8080/SpringMVCCustom/lineup", {params: {userId:userId}})
		};
		
		this.formatLineup = function(lineups){
			for (let lineup of lineups){
				let filterDate = lineup.date;
				for(let playerDetail of lineup.playerDetails){
					if(playerDetail.date=filterDate){
						playerDetail.firstName=playerDetail.player.firstName;
						playerDetail.lastName= playerDetail.player.lastName;
					}
					
				}
			}
			return lineups
		}
		
		this.removeLineup = function(lineup){
			let url = "http://localhost:8080/SpringMVCCustom/lineup/" + lineup.id
			return $http.delete(url)
		};
		
		//TODO change function to this location and remove from playerCtrl
		this.saveLineup = function(userId){
			$http.post("http://localhost:8080/SpringMVCCustom/lineup", JSON.stringify(lineup)).then(function(successData){
				console.log(successData);
				}, function(error){
					console.log(error)
				});
		};
		
		this.editLineup = function(lineup){
			for (let playerDtl of lineup.playerDetails){
				for(lineupSlot of this.lineup.players){
					if(lineupSlot.pos === playerDtl.player.pos && !lineupSlot.hasOwnProperty('id')){
						lineupSlot.playerDtlId=playerDtl.id;
						this.lineup.playerCount[playerDtl.player.pos] ++;
						Object.assign(lineupSlot, playerDtl);
						lineupSlot.firstName=playerDtl.player.firstName;
						lineupSlot.lastName=playerDtl.player.lastName;
						delete lineupSlot.player;
						this.lineup.playerCount.total ++;
						break;
					}
				}
			}
			this.lineup.id = lineup.id;
			this.lineup.date=lineup.date;
			return this.lineup;
		}
		
		this.removePlayer= function(activePlayer){
			index = this.lineup.players.indexOf(activePlayer);
			this.lineup.players[index] = {
					lineupSlot: this.lineup.players[index].lineupSlot ,
					pos :this.lineup.players[index].pos
			}
			this.lineup.playerCount[activePlayer.pos] --;
			this.lineup.playerCount.total --;
		}
		
		this.clearLineup = function(lineup){
			for(let player of lineup.players){
				this.removePlayer(player);
			}
			lineup.date='';
			lineup.id='';
		}
		
		this.addPlayer = function(activePlayer){
			for (let player of this.lineup.players){
				if(player.pos === activePlayer.pos && !(Object.keys(player).length > 2)){
					this.lineup.playerCount[player.pos] ++;
					Object.assign(player, activePlayer);
					this.lineup.playerCount.total ++;
					this.lineup.remSalary=this.lineup.remSalary - player.salary;
					break;
				}
			}
		}
		
		this.removePlayer = function(activePlayer){
			for (let player of this.lineup.players){
				if(activePlayer.id==player.id){
					index = this.lineup.players.indexOf(player);
					console.log(player)
					this.lineup.players[index] = {
							lineupSlot: this.lineup.players[index].lineupSlot ,
							pos :this.lineup.players[index].pos
					}
					this.lineup.playerCount[player.pos] --;
					this.lineup.playerCount.total --;
					this.lineup.remSalary=this.lineup.remSalary + player.salary;
					break;
				}
			}
		}
		
		return {
			getLineups : this.getLineups,
			formatLineups : this.formatLineup,
			removeLineup : this.removeLineup,
			saveLineup: this.saveLineup,
			editLineup: this.editLineup,
			lineup : this.lineup,
			removePlayer: this.removePlayer,
			clearLineup : this.clearLineup,
			addPlayer: this.addPlayer
		}
	}]);