angular.module("myApp").service('restaurantService', ['$http', function($http) {
    return {
        getAllRestaurants: function () {
            return $http({
                url: 'http://localhost:8080/restaurants',  
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json', 
                    'Accept': 'application/json',  
                },
                params: {},
            });
        },
    };
}]);
