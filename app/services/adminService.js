angular.module("myApp").service('AdminService', ['$http', function ($http) {
    
   
    
    var baseUrl = 'http://localhost:8080';  

    this.getRestaurants = function () {
        return $http({
            url: baseUrl + '/restaurants',  
            method: 'GET',
            headers: {
                'Content-Type': 'application/json', 
                'Accept': 'application/json',  
            },
            params: {},
        });
    };


    this.addRestaurant = function (newRestaurant) {
        return $http({
            url: baseUrl + '/restaurants',
            method: 'POST',
            data: newRestaurant,
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    };
    
    this.removeRestaurant = function (id) {
        return $http({
            url: baseUrl + '/restaurants/' + id,
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    };

    this.getOrders = function () {
        return $http({
            url: baseUrl + '/orders',
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    };

    this.getDishes = function () {
        return $http({
            url: baseUrl + '/dishes',
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    };

    this.addDish = function (restaurantId, newDish) {
        return $http({
            url: baseUrl + '/dishes/restaurants/' + restaurantId + '/add-dish',
            method: 'POST',
            data: newDish,
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    };

    this.removeDish = function (restaurantId, dishId) {
        return $http({
            url: baseUrl + '/dishes/restaurants/' + restaurantId + '/remove/' + dishId,
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    };
    this.getOrders = function () {
        return $http({
            url: baseUrl + '/orders',
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
    };


    // this.getOrderDetails = function (orderId) {
    //     return $http({
    //         url: baseUrl + '/order-details/by-order-id/' + orderId, 
    //         method: 'GET',
    //         headers: {
    //             'Content-Type': 'application/json',
    //             'Accept': 'application/json'
    //         }
    //     });
    // };
    
    
  }]);
  
