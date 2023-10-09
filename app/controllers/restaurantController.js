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
angular.module("myApp").controller('RestaurantController', ['$scope', 'restaurantService', function ($scope, restaurantService) {
  $scope.restaurants = [];

  // Call the service method to get all restaurants
  restaurantService.getAllRestaurants().then(function (response) {
    console.log(response.data);
      // Assign the response data to the scope variable
      $scope.restaurants = response.data;
  }, function (error) {
     
      console.error('Error fetching restaurant data: ' + error);
  });
  $scope.isVegetarian = function(restaurant) {
    return restaurant.is_pureveg === 1 ? "Veg" : "Non-Veg";
};

}]);


