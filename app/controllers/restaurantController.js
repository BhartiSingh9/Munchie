
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
    getRestaurantById: function (restaurantId) {
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
  };
}]);

angular.module("myApp").controller('RestaurantController', ['$scope', 'restaurantService', '$location', function ($scope, restaurantService, $location) {
  $scope.restaurants = [];
  $scope.filteredRestaurants = [];
  $scope.searchText = '';

  var loadAllRestaurants = function () {
    restaurantService.getAllRestaurants().then(function (response) {
      console.log(response.data);
      $scope.restaurants = response.data;
      $scope.filteredRestaurants = $scope.restaurants;
    }, function (error) {
      console.error('Error fetching restaurant data: ' + error);
    });
  };

  loadAllRestaurants();
  $scope.fetchRestaurantName = function (restaurant) {
    restaurantService.getRestaurantById(restaurant.id).then(function (response) {
      restaurant.name = response.data.name;
    }, function (error) {
      console.error('Error fetching restaurant name: ' + error);
    });
  };

  $scope.restaurants.forEach(function (restaurant) {
    $scope.fetchRestaurantName(restaurant);
  });
  $scope.loadAllRestaurants = function () {
    loadAllRestaurants($scope.restaurants);
    $scope.showAllRestaurants = false;
  };


  $scope.isVegetarian = function (restaurant) {
    return restaurant._pureveg ? "Veg" : "Non-Veg";
  };

  $scope.restaurantred = function (restaurantId) {
    $location.path(`restaurant/${restaurantId}`);
  };
  $scope.getStars = function (rating) {
    const starArray = [];
    for (let i = 0; i < rating; i++) {
      starArray.push(i);
    }
    return starArray;
  };
  $scope.searchRestaurants = function () {
    $scope.filteredRestaurants = $scope.restaurants.filter(function (restaurant) {
      return restaurant.name.toLowerCase().includes($scope.searchText.toLowerCase());
    });
  };


}]);
