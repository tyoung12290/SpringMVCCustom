angular.module('myApp.controllers').controller('savePlayerCtrl', ['$scope', '$http', function($scope, $http){
	$scope.myData={};
	
	$http.post("/savePlayer", {jsonObjectToPost}).then(function(successData){
		//do something
		}, function(error){
		//do something
		});
}]);