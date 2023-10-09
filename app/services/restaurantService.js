angular.module("myApp").service('restaurantService', ['$http', function($http) {
    return {
        getAllRestaurants: function () {
            return $http({
                url: 'http://localhost:8080/restaurants',  // Ensure this URL is correct
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json', // Set the appropriate content type
                    'Accept': 'application/json', // Specify the expected response format
                    // Add other headers as needed
                },
                params: {},
            });
        },
    };
}]);
