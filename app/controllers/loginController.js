angular.module('myApp').controller('LoginController', ['$scope','$location', function($scope, $location) {

    $scope.user = {
        username: '',
        password: ''
    };

    $scope.loginUser = function(user) {
        // Implement your user authentication logic here
        if (user.username === 'demo' && user.password === 'password') {
            // Redirect to the main page after successful login
            // window.location.href = '/main';
            $location.path('/main');
        } else {
            alert('Login failed. Please check your credentials.');
            
        }
    };
}]);
