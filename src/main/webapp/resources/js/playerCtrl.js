angular.module('myApp').controller('savePlayerCtrl', ['$scope', '$http', function($scope, $http){
	var self = this;
	self.player = {firstName : '', lastName: ''};
	
	function savePlayer(){
		$http.post("/savePlayer", self.data).then(function(successData){
			//do something
			}, function(error){
			//do something
			});
	};
	
}]);