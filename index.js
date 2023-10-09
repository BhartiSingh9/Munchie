angular.module('myApp').controller('indexController', ['$scope','$location', function($scope, $location) {

    $scope.user = {
        username: '',
        password: ''
    };
    $location.path('/login');
    
}]);
