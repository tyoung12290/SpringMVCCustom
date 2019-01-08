angular.module('myApp').controller('tabCtrl', [function() {
	let tm = this;
    tm.tab = 2;

    tm.setTab = function(newTab){
      tm.tab = newTab;
    };

    tm.isSet = function(tabNum){
      return tm.tab === tabNum;
    };
    

}]);