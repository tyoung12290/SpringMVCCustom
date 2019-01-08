angular.module('myApp').factory('lineupFactory', ['$http', function($http){
		this.getLineups = function(userId){
			return $http.get("http://localhost:8080/SpringMVCCustom/lineup", {params: {userId:userId}})
		};
		
		this.formatLineup = function(lineups){
			for (let lineup of lineups){
				let filterDate = lineup.date;
				for(let player of lineup.players){
					for(let playerDtl of player.playerDetails){
						if(playerDtl.date==filterDate){
							player.salary=playerDtl.salary;
							player.score= playerDtl.score || 0;
						}
					}
				}
			}
			return lineups
		}
		
		return {
			getLineups : this.getLineups,
			formatLineups : this.formatLineup
		}
	}]);