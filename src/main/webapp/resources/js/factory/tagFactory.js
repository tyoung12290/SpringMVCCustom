angular.module('myApp').factory('tagFactory', [function() {
    tags = [
    	{id:1,
    	 strategy:"team stack",
		 desc:"4  from same team",
		 color:"#7EDAD1",
		 status:false},
		 {id:2,
		 strategy:"game stack",
		 desc:"4 from two teams in same game",
		 color:"#C5BEE6",
		 status:false},
		 {id:3,
		 strategy:"vegas +/-",
		 desc:"4 or more from game with highest vegas over/under",
		 color:"#3EC559",
		 status:false}
    	];
    
    /*this.getTags = function(){
		return $http.get("http://localhost:8080/SpringMVCCustom/tag")
	};*/
   
    this.calcTags = function(count){
    	switch(count){
    	case 1:
    		tags[0].status=true;
    		break;
    	case 2:
    		tags[1].status=true;
    		break;
    	case 3:
    		tags[2].status=true;
    		break;
    	}
    	return tags;
    };
    
    return {
		calcTags : this.calcTags,
	}

}]);