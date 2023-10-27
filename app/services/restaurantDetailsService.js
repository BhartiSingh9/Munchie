angular.module("myApp").service('restaurantDetailsService', ['$http', function ($http) {
    return {
        getAllDishes: function () {

            return $http({
                url: 'http://localhost:8080/dishes',
                method: "GET",
                header: {
                    'Content-Type': 'application/json', 
                    'Accept': 'application/json',
                },
                params: {},
            });
        },
        getRestaurantDetails: function (restaurantId) {
            return $http({
                url: 'http://localhost:8080/restaurants/' + restaurantId, 
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
                },
                params: {},
            });
        },
        getDishesForRestaurant: function (restaurantId) {
            return $http({
                url: 'http://localhost:8080/dishes/restaurants/' + restaurantId, 
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json',
                },
                params: {},
            });
        },
        placeorder: function (orderData) {
            return $http({
                url: 'http://localhost:8080/orders/place-order',
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': '*/*'
                },
                data: orderData,

            }).then(function (response) {
                return response;
            }, function (response) {
                return response;
            });
        }

    };
}]);
