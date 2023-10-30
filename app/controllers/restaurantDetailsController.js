angular.module('myApp').controller('RestaurantDetailsController', ['$scope', '$http', '$routeParams', 'restaurantDetailsService', 'cartService', function ($scope, $http, $routeParams, restaurantDetailsService, cartService) {
    $scope.dishes = [];
    $scope.restaurant = {};
    var restaurantId = $routeParams.restaurantId;
   
    $scope.cart = [];

    restaurantDetailsService.getDishesForRestaurant(restaurantId)
        .then(function (response) {
            console.log(response.data);
            $scope.dishes = response.data;
        }, function (error) {
            console.error('Error fetching dishes:', error);
        });
       
        
   
    restaurantDetailsService.getRestaurantDetails(restaurantId)
    .then(function (response) {
        $scope.restaurant = response.data;
    }, function (error) {
        console.error('Error fetching restaurant details:', error);
    });
    $scope.cartItems = cartService.getCartItems();
    $scope.isVegetarian = function (is_pureveg) {
        
        if(is_pureveg){
            return "veg-icon";
        }
        else{
            return "non-veg-icon";
        }
    };
    $scope.isVegOrNonVegIcon = function (is_veg) {
        if (is_veg) {
            return "veg-icon";
        } else {
            return "non-veg-icon";
        }
    };
    function calculateTotal() {
        var total = 0;
        for (var i = 0; i < $scope.cart.length; i++) {
            total += $scope.cart[i].price * $scope.cart[i].quantity;
        }
        return total;
    }
    $scope.$watch('cart', function () {
        $scope.totalCost = calculateTotal();
    }, true);
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
        var orderDetailsDtoArray = [];

        for (var i = 0; i < $scope.cart.length; i++) {
            var dish = $scope.cart[i];
            var orderDetailsDto = {
                orderId: 1,
                dishId: dish.id,
                quantity: dish.quantity,
                
            };
            orderDetailsDtoArray.push(orderDetailsDto);
        }

        var orderDto = {
            userId: 1, 
            restaurantId: restaurantId,  
            paymentMethod: "Credit Card", 
            orderDetails: orderDetailsDtoArray,
            totalCost: calculateTotal(),
        };
        console.log(orderDetailsDto);
        $scope.showOrderSuccessAlert = true;
        $scope.cart = [];
        $scope.totalCost = 0;
        $scope.dismissOrderSuccessAlert = function () {
            $scope.showOrderSuccessAlert = false;
        };
      
           restaurantDetailsService.placeorder(orderDto).then(function (response){
            console.log(response)
           }
           )
    };
}]);
