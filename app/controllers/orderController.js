angular.module('myApp').controller('OrderController', ['$scope', 'OrderService', 'RestaurantService', 'UserService', '$location', function($scope, OrderService, RestaurantService, UserService, $location) {
    $scope.user = {};
    $scope.orders = [];
    $scope.selectedUserId = 1; 
    $scope.fetchOrders = function() {
        UserService.getUserById($scope.selectedUserId).then(function(userResponse) {
            $scope.user = userResponse.data;

            OrderService.getOrdersForUser($scope.selectedUserId).then(function(orderResponse) {
                $scope.orders = orderResponse.data;

                angular.forEach($scope.orders, function(order) {
                    RestaurantService.getRestaurantById(order.restaurantId).then(function(restaurantResponse) {
                        order.restaurantName = restaurantResponse.data.name;
                    });
                });
            });
        });

        $location.path('/myorders');
    };

    $scope.fetchOrders();
}]);
