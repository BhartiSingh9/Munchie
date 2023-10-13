angular.module("myApp").controller('AdminController', ['$scope', 'AdminService', function ($scope, AdminService) {
    $scope.showTable = null; 
    $scope.orders = [];
    $scope.restaurants = [];
    $scope.dishes = [];
     
    $scope.addRestaurant = {
        address: "",
        city: "",
        close_time: 0,
        cuisine_type: "",
        descrip: "",
        is_pureveg: true,
        license_id: "",
        name: "",
        open_time: 0,
        phone_number: 0,
        ratings: 0.0,
    };

    $scope.addDish = {
        name: "",
        descrip: "", 
        is_veg: true,
        price: 0.0,  
        restaurant_fk: 0, 
        picture: "" 
    };
    
    $scope.toggleAddRestaurantForm = function() {
        $scope.showAddRestaurantForm = true; 
    };
    
    $scope.closeAddRestaurantForm = function() {
        $scope.showAddRestaurantForm = false; 
    };

    $scope.toggleAddDishForm = function() {
        $scope.showAddDishForm = true;
    };

    $scope.closeAddDishForm = function() {
        $scope.showAddDishForm = false;
    };

    $scope.toggleTable = function(table) {
        $scope.showTable = table;

        if (table === 'viewOrders') {
            AdminService.getOrders().then(function (response) {
                $scope.orders = response.data;
            }, function (error) {
                console.error('Error fetching orders: ' + error);
            });
        } else if (table === 'viewRestaurants') {
            AdminService.getRestaurants().then(function (response) {
                console.log('beforee');
                $scope.restaurants = response.data;
                console.log('Fetched restaurants:', $scope.restaurants);
            }, function (error) {
                console.error('Error fetching restaurants: ' + error);
            });
        } else if (table === 'viewDishes') {
            AdminService.getDishes().then(function (response) {
                $scope.dishes = response.data;
            }, function (error) {
                console.error('Error fetching dishes: ' + error);
            });
        }
    };

    $scope.addNewRestaurant = function() {
        AdminService.addRestaurant($scope.addRestaurant).then(function(response) {
            console.log("Restaurant added: " + response.data);
            $scope.addRestaurant = {
                address: "",
                city: "",
                close_time: 0,
                cuisine_type: "",
                descrip: "",
                is_pureveg: true,
                license_id: "",
                name: "",
                open_time: 0,
                phone_number: 0,
                ratings: 0.0,
            };
        }, function(error) {
            console.error('Error adding restaurant: ' + error);
        });
        $scope.closeAddForm();
    };

    $scope.removeRestaurant = function(restaurantId) {
        AdminService.removeRestaurant(restaurantId).then(function(response) {
            console.log("Restaurant removed: " + response.data);
            $scope.toggleTable('viewRestaurants');
        }, function(error) {
            console.error('Error removing restaurant: ' + error);
        });
    };

    $scope.addNewDish = function() {
        
        const restaurantId = $scope.addDish.restaurant_fk; // Get restaurant_id from the form
    
    
        AdminService.addDish(restaurantId, $scope.addDish).then(function(response) {
            console.log("Dish added: " + response.data);
            $scope.addDish = {
                name: "",
                descrip: "",
                is_veg: true,
                price: 0.0,
                restaurant_fk: 1,
                picture: ""
            };
        }, function(error) {
            console.error('Error adding dish: ' + error);
        });
        $scope.closeAddDishForm();
    };
    
    
    $scope.removeDish = function(restaurantId, dishId) {
        AdminService.removeDish(restaurantId, dishId).then(function(response) {
            console.log("Dish removed: " + response.data);
            $scope.toggleTable('viewDishes');
        }, function(error) {
            console.error('Error removing dish: ' + error);
        });
    };

    $scope.showOrders = function() {
        AdminService.getOrders().then(function(response) {
            $scope.orders = response.data;
        }, function(error) {
            console.error('Error fetching orders: ' + error);
        });
    };
    
    $scope.showOrderDetails = function(orderId) {
        AdminService.getOrderDetails(orderId).then(function(response) {
          $scope.orderDetails = response.data;
          $scope.showOrderDetailsTable = true;
      
          // Map dish IDs to dish names
          $scope.orderDetails.forEach(function(orderDetail) {
            const dish = $scope.dishes.find(d => d.id === orderDetail.dishId);
            if (dish) {
              orderDetail.dishName = dish.name;
            }
          });
        }, function(error) {
          console.error('Error fetching order details: ' + error);
        });
      };
      
    
    $scope.indianCurrencySymbol = "₹";
}]);

angular.module("myApp").filter("formatDateTime", function () {
    return function (dateTimeArray) {
        if (angular.isArray(dateTimeArray) && dateTimeArray.length === 5) {
            const [year, month, day, hour, minute] = dateTimeArray;
            const date = new Date(year, month - 1, day, hour, minute);

            const formattedDateTime = date.toLocaleString(); 

            return formattedDateTime;
        } else {
            return "Invalid Date and Time";
        }
    };
});