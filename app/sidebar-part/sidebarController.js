angular.module('myApp').controller('SidebarController', ['$scope', 'UserService', 'OrderService', 'RestaurantService', function ($scope, UserService, OrderService, RestaurantService) {    $scope.orders = [];

    $scope.fetchOrders = function() {
        OrderService.getOrdersForUser($scope.selectedUserId).then(function(orderResponse) {
            $scope.orders = orderResponse.data;
    
            angular.forEach($scope.orders, function(order) {
                RestaurantService.getRestaurantById(order.restaurantId).then(function(restaurantResponse) {
                    order.restaurantName = restaurantResponse.data.name;
                });
            });
        });
        // The rest of your code...
    };
}]);
