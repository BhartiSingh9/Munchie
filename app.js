// // Create an AngularJS module named 'myApp' and specify its dependencies (e.g., ngRoute for routing)

// var app = angular.module('myApp', ['ngRoute']); // Initialize the AngularJS app

// angular.module('myApp')
//     .config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

//         $routeProvider
//             .when('/', {
//                 templateUrl: 'views/login.html',
//                 controller: 'LoginController'
//             })
//             .when('/login', {
//                 templateUrl: '/views/login.html',
//                 controller: 'LoginController' // Use the name of your login controller
//             })
//             .when('/main', {
//                 templateUrl: 'views/main.html',
//                 controller: 'RestaurantController' // Use the name of your restaurant controller
//             })
            
//             .when('/restaurant/:restaurantId',{
//                 templateUrl: 'views/restaurantDetail.html',
//                 controller: 'RestaurantDetailsController' 
//             })
//             .otherwise({ redirectTo: '/login' });
//         $locationProvider.html5Mode({
//             enabled: true,
//             requireBase: true,
//             rewriteLinks: false
//         });
//     }]);

var app = angular.module('myApp', ['ngRoute']);

app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
    // Define the route permissions based on your application's logic
    var routePermission = {
        isLoggedIn: function (AuthService) {
            return AuthService.isAuthenticated();
        }
    };

    $routeProvider
        .when('/', {
            templateUrl: 'views/login.html',
            controller: 'LoginController'
        })
        .when('/login', {
            templateUrl: 'views/login.html',
            controller: 'LoginController'
        })
        .when('/main', {
            templateUrl: 'views/main.html',
            controller: 'RestaurantController',
            resolve: routePermission.isLoggedIn 
        })
        .when('/restaurant/:restaurantId', {
            templateUrl: 'views/restaurantDetail.html',
            controller: 'RestaurantDetailsController',
            resolve: routePermission.isLoggedIn 
        })
        .when('/admin', {
            templateUrl: 'views/adminmain.html',
            controller: 'AdminController',
       
        })
        .when('/myorders', {
                templateUrl: 'views/myorders.html', 
                controller: 'HeaderController' 
              })
        .otherwise({ redirectTo: '/login' });
    
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: true,
        rewriteLinks: false
    });
}]);
