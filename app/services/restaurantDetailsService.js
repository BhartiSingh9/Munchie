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
        },
        getDishesForRestaurant: function(restaurantId) {
            return $http({
                url: 'http://localhost:8080/dishes/restaurants/' + restaurantId , // Adjust the URL to match your backend API
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
                },
                params: {},
            });
        }
    };
}]);
