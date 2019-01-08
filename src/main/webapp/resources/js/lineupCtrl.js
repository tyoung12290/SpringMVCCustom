angular.module('myApp').controller('lineupCtrl', ['$http', 'lineupFactory', function($http, lineupFactory){
		let vm = this;
		vm.lineups={};
		vm.getLineup = function(userId) {
			lineupFactory.getLineups(userId).success(function(result){
				vm.lineups=lineupFactory.formatLineups(result)
				//TODO modify JAVA classes from Lineup -- Player -- PlayerDetail to Lineup -- PlayerDetail -- PlayerDetail
			}).error(function(error){
				console.log(error)
		});
		}
	}]);