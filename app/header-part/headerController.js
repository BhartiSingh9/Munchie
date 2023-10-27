angular.module('myApp').controller('HeaderController', ['$scope', '$http', '$location', 'restaurantService', function ($scope, $http, $location, restaurantService) {
    $scope.headerItems = [];
    $scope.userOrders = [];

    // Function to fetch restaurant name by ID
    function fetchRestaurantName(restaurantId) {
        return restaurantService.getRestaurantById(restaurantId)
            .then(function (response) {
                return response.data.name;
            })
            .catch(function (error) {
                console.error('Failed to fetch restaurant name: ' + error);
                return "Restaurant Name Not Found";
            });
    }

    $scope.fetchOrdersForUser = function () {
        console.log("fetchOrdersForUser function called");
        $http.get('http://localhost:8080/orders/user/1')
            .then(function (response) {
                console.log("My Orders link clicked");
                $scope.userOrders = response.data;

                // Fetch restaurant name for each order
                $scope.userOrders.forEach(function (order) {
                    fetchRestaurantName(order.restaurantId).then(function (restaurantName) {
                        order.restaurantName = restaurantName;
                    });
                });
            })
            .catch(function (error) {
                console.error('Failed to fetch user orders: ' + error);
            });
    };

    $scope.goToMyOrders = function () {
        $location.path('/myorders');
        $scope.fetchOrdersForUser();
    };

}]);
