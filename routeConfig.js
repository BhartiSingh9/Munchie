
// angular.module('myApp')
//     .config(['$routeProvider','$locationProvider', function($routeProvider, $locationProvider) {

//         $routeProvider
//             .when('/login', {
//                 templateUrl: 'views/login.html',
//                 controller: 'LoginController' // Use the name of your login controller
//             })
//             .when('/main', {
//                 templateUrl: 'views/main.html',
//                 controller: 'RestaurantController' // Use the name of your restaurant controller
//             })
//             .when('/',{
//                 templateUrl:'index.html',
//             })
//             .otherwise({ redirectTo: '/main' });
//             $locationProvider.html5Mode({
//                 enabled: true,
//                 requireBase: true,
//                 rewriteLinks: false
//                 });
//     }]);
