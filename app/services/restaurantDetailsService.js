angular.module("myApp").service('restaurantDetailsService', ['$http', function($http) {
    return {
        getAllDishes: function() {
           
            return $http({
                url: 'http://localhost:8080/dishes',
                method: "GET",
                header:{'Content-Type': 'application/json', // Set the appropriate content type
                'Accept': 'application/json', },
                params: { }, 
            });
        }
    };
}]);
