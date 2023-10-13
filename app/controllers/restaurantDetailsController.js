angular.module('myApp').controller('RestaurantDetailsController', ['$scope', '$routeParams', 'restaurantDetailsService','cartService', function($scope, $routeParams, restaurantDetailsService,cartService) {
    $scope.dishes = [];
    var restaurantId = $routeParams.restaurantId;

    restaurantDetailsService.getDishesForRestaurant(restaurantId)
        .then(function(response) {
            console.log(response.data);
            $scope.dishes = response.data;
        }, function(error) {
            console.error('Error fetching dishes:', error);
        });

    $scope.isVegetarian = function(restaurant) {
        return restaurant.is_veg === 0 ? "Non-Veg" : "Veg";
    };

    $scope.addToCart = function (dish) {
        cartService.addToCart(dish);
    };

    $scope.incrementQuantity = function (dish) {
        cartService.incrementQuantity(dish);
    };

    $scope.decrementQuantity = function (dish) {
        cartService.decrementQuantity(dish);
    };

    $scope.cartItems = cartService.getCartItems();

    $scope.removeFromCart = function (cartItem) {
        cartService.removeFromCart(cartItem);
    };

    $scope.getTotalCost = function () {
        return cartService.getTotalCost();
    };
}]);
