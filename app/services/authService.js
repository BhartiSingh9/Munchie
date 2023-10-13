angular.module('myApp').factory('AuthService', ['$http', function ($http) {
    var authService = {};


    authService.isAuthenticated = function () {
        var token = localStorage.getItem('token');
        return !!token;
    };
    authService.login = function (user) {
        var config = {
            method:'POST',
            url:'http://localhost:8080/users/getbyemail',
            data: user,
            headers: {
                'Content-Type': 'application/json'
            }
        };

        return $http( config); 
    };

    authService.setToken = function (token) {
        localStorage.setItem('token', token);
    };

    authService.getToken = function () {
        return localStorage.getItem('token');
    };

    authService.logout = function () {
        localStorage.removeItem('token');
    };

    return authService;
}]);