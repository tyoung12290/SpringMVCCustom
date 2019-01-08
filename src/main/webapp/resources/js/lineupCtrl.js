angular.module('myApp').controller('lineupCtrl', ['$http', function($http){
		let vm = this;
		vm.lineups={};
		vm.getLineup= function(userId){
			console.log("hello");
			console.log(userId)
			$http.get("http://localhost:8080/SpringMVCCustom/lineup", {params: {userId:userId}}).then(function(successData){
				console.log(successData)
				vm.lineups=successData.data;
				for (let lineup of vm.lineups){
					console.log("lineup")
					for(let player of lineup.players){
						console.log("player")
						console.log(player)
					}
				}
				}, function(error){
					console.log(error)
				});
		}
	}]);