angular.module('myApp').controller('RestaurantDetailsController', ['$scope',  'restaurantDetailsService', function($scope, restaurantDetailsService) {

    $scope.dishes=[];
  


    restaurantDetailsService.getAllDishes()
        .then(function(response) {
            console.log(response.data)
            $scope.dishes=response.data;
        },function(error) {
            console.error('Error fetching dishes:', error);
        });
         $scope.isVegetarian = function(restaurant) {
      return restaurant.is_veg == 0 ? "Veg" : "Non-Veg";
};
}]);

