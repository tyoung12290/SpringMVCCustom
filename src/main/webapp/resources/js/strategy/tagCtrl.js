angular.module('myApp').controller('tagCtrl', ['tagFactory', function(tagFactory) {
	let tagCtrl = this;
	tagCtrl.tags={};
	activate();
	function activate(){
		console.log("test")
		tagCtrl.tags=tagFactory.tags;
	}
}]);