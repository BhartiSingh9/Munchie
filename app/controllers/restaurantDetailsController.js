angular.module('myApp').controller('RestaurantDetailsController', ['$scope', '$http', '$routeParams', 'restaurantDetailsService', 'cartService', function ($scope, $http, $routeParams, restaurantDetailsService, cartService) {
    $scope.dishes = [];
    var restaurantId = $routeParams.restaurantId;
    $scope.cart = [];

    restaurantDetailsService.getDishesForRestaurant(restaurantId)
        .then(function (response) {
            console.log(response.data);
            $scope.dishes = response.data;
        }, function (error) {
            console.error('Error fetching dishes:', error);
        });

    $scope.isVegetarian = function (dish) {
        return dish.is_veg === 0 ? "Non-Veg" : "Veg";
    };

    $scope.cartItems = cartService.getCartItems();

    $scope.addToCart = function(dish) {
        var existingItem = $scope.cart.find(item => item.id === dish.id);
    
        if (existingItem) {
            existingItem.quantity++;
        } else {
            dish.quantity = 1;
            $scope.cart.push(angular.copy(dish));
        }
    };

    $scope.incrementQuantity = function (dish) {
        dish.quantity++;
    };

    $scope.decrementQuantity = function (dish) {
        if (dish.quantity > 1) {
            dish.quantity--;
        } else {
            var index = $scope.cart.indexOf(dish);
            if (index !== -1) {
                $scope.cart.splice(index, 1);
            }
        }
    };

    $scope.placeOrder = function () {
        var orderDto = {
            userId: 1, 
            restaurantId: restaurantId,  
            paymentMethod: "Credit Card", 
            totalCost: 0, 
            orderDetails: $scope.cart ,
     
        };
      

        
        $http.post('http://localhost:8080/orders/place-order', orderDto)
            .then(function (response) {
                alert('Order placed successfully');
                
                $scope.cart = [];
            })
            .catch(function (error) {
                alert('Failed to place the order'); 
            });
    };
}]);
