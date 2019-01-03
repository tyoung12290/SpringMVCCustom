angular.module('myApp').controller('userCtrl', ['$http', function($http){
	let vm = this;
	vm.username='';
	vm.user={};
	vm.getUser = function(username){
		console.log(username)
		$http.get("http://localhost:8080/SpringMVCCustom/user/" + username).then(function(successData){
			vm.user=successData.data;
		}, function(error){
			console.log(error)
		});
	}
}]);