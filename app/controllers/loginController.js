
angular.module('myApp').controller('LoginController', ['$scope', '$location', 'AuthService', function ($scope, $location, AuthService) {
    $scope.user = {
        email: '',
        password: ''
    };

    $scope.loginUser = function(user) {
        if (user.username === 'demo' && user.password === 'password') {
            $location.path('/main');
        }
        else if (user.username === 'admin' && user.password === 'adminpassword') { 
            $location.path('/admin');
        } else {
            alert('Login failed. Please check your credentials.');
            
        }
    };
}]);
