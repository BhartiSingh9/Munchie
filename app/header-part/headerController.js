angular.module('myApp').controller('HeaderController', function ($scope) {
    $scope.headerItems = [
        {
            link: '/my-orders', 
            text: 'My Orders'
        },
        {
            link: '/cart', 
            text: 'Cart'
        }
    ];
});


// angular.module('myApp').controller('HeaderController', function ($scope, $location) {
//     var currentRoute = $location.path();
//     console.log(currentRoute);

//     $scope.showMyOrders = true; // Show by default
//     $scope.showCart = true; // Show by default

//     if (currentRoute === '/login') {
//         $scope.showMyOrders = false; // Hide on the login page
//         $scope.showCart = false; // Hide on the login page
//     }

//     $scope.goToMyOrders = function () {
//         // Define the logic to navigate to the "My Orders" page
//         $location.path('/my-orders'); // Update with your actual route
//     };

//     $scope.goToCart = function () {
//         // Define the logic to navigate to the "Cart" page
//         $location.path('/cart'); // Update with your actual route
//     };
// });
