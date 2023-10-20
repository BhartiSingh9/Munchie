// angular.module('myApp').controller('RestaurantController', function ($scope) {
//     $scope.restaurants = [
//         {
//             name: "La Pino'z Pizza",
//             link: "/restaurants/waffld-domlur-bangalore-303446",
//             image: "https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.8888888888888888xw:1xh;center,top&resize=1200:*",
//             rating: 3.8,
//             deliveryTime: "42 MINS",
//             priceForTwo: 250,
//             cuisines: "Italian, Pizzas, Fast Food, Mexican, Desserts, Beverages",
//             offer: "50% off | Use WELCOME50"
//         },
//         {
//           name: "La Pino'z Pizza",
//           link: "/restaurants/waffld-domlur-bangalore-303446",
//           image: "https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.8888888888888888xw:1xh;center,top&resize=1200:*",
//           rating: 3.8,
//           deliveryTime: "42 MINS",
//           priceForTwo: 250,
//           cuisines: "Italian, Pizzas, Fast Food, Mexican, Desserts, Beverages",
//           offer: "50% off | Use WELCOME50"
//         },
//         {
//           name: "La Pino'z Pizza",
//           link: "/restaurants/waffld-domlur-bangalore-303446",
//           image: "https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.8888888888888888xw:1xh;center,top&resize=1200:*",
//           rating: 3.8,
//           deliveryTime: "42 MINS",
//           priceForTwo: 250,
//           cuisines: "Italian, Pizzas, Fast Food, Mexican, Desserts, Beverages",
//           offer: "50% off | Use WELCOME50"
//         },
//         {
//           name: "La Pino'z Pizza",
//           link: "/restaurants/waffld-domlur-bangalore-303446",
//           image: "https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.8888888888888888xw:1xh;center,top&resize=1200:*",
//           rating: 3.8,
//           deliveryTime: "42 MINS",
//           priceForTwo: 250,
//           cuisines: "Italian, Pizzas, Fast Food, Mexican, Desserts, Beverages",
//           offer: "50% off | Use WELCOME50"
//         },
//         {
//           name: "La Pino'z Pizza",
//           link: "/restaurants/waffld-domlur-bangalore-303446",
//           image: "https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.8888888888888888xw:1xh;center,top&resize=1200:*",
//           rating: 3.8,
//           deliveryTime: "42 MINS",
//           priceForTwo: 250,
//           cuisines: "Italian, Pizzas, Fast Food, Mexican, Desserts, Beverages",
//           offer: "50% off | Use WELCOME50"
//         },
//         {
//           name: "La Pino'z Pizza",
//           link: "/restaurants/waffld-domlur-bangalore-303446",
//           image: "https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.8888888888888888xw:1xh;center,top&resize=1200:*",
//           rating: 3.8,
//           deliveryTime: "42 MINS",
//           priceForTwo: 250,
//           cuisines: "Italian, Pizzas, Fast Food, Mexican, Desserts, Beverages",
//           offer: "50% off | Use WELCOME50"
//         },
//         {
//           name: "La Pino'z Pizza",
//           link: "/restaurants/waffld-domlur-bangalore-303446",
//           image: "https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.8888888888888888xw:1xh;center,top&resize=1200:*",
//           rating: 3.8,
//           deliveryTime: "42 MINS",
//           priceForTwo: 250,
//           cuisines: "Italian, Pizzas, Fast Food, Mexican, Desserts, Beverages",
//           offer: "50% off | Use WELCOME50"
//         },
//         {
//           name: "La Pino'z Pizza",
//           link: "/restaurants/waffld-domlur-bangalore-303446",
//           image: "https://hips.hearstapps.com/hmg-prod/images/classic-cheese-pizza-recipe-2-64429a0cb408b.jpg?crop=0.8888888888888888xw:1xh;center,top&resize=1200:*",
//           rating: 3.8,
//           deliveryTime: "42 MINS",
//           priceForTwo: 250,
//           cuisines: "Italian, Pizzas, Fast Food, Mexican, Desserts, Beverages",
//           offer: "50% off | Use WELCOME50"
//         }
//         // Add more restaurants as needed
//     ];
// });


angular.module("myApp").service('restaurantService', ['$http', function ($http) {
  return {
    getAllRestaurants: function () {
      return $http({
        url: 'http://localhost:8080/restaurants',
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        },
        params: {},
      });
    },
  };
}]);

angular.module("myApp").controller('RestaurantController', ['$scope', 'restaurantService', '$location', function ($scope, restaurantService, $location) {
  $scope.restaurants = [];
  $scope.filteredRestaurants = [];
  $scope.searchText = '';

  // Function to load all restaurants
  var loadAllRestaurants = function () {
      restaurantService.getAllRestaurants().then(function (response) {
          console.log(response.data);
          $scope.restaurants = response.data;
          $scope.filteredRestaurants = $scope.restaurants;
      }, function (error) {
          console.error('Error fetching restaurant data: ' + error);
      });
  };

  // Call the function to load all restaurants
  loadAllRestaurants();
   // Function to toggle between search results and all restaurants
   $scope.loadAllRestaurants = function() {
    loadAllRestaurants($scope.restaurants);
    $scope.showAllRestaurants = false;
};


  $scope.isVegetarian = function (restaurant) {
      return restaurant.is_pureveg ? "Veg" : "Non-Veg";
  };

  $scope.restaurantred = function (restaurantId) {
      $location.path(`restaurant/${restaurantId}`);
  };

  // Function to filter restaurants based on search text
  $scope.searchRestaurants = function () {
      $scope.filteredRestaurants = $scope.restaurants.filter(function (restaurant) {
          return restaurant.name.toLowerCase().includes($scope.searchText.toLowerCase());
      });
  };
}]);
