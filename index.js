angular.module('myApp').controller('indexController', ['$scope','$location', function($scope, $location) {

    $scope.user = {
        username: '',
        password: ''
    };


    // $scope.init=function(){
    //     $location.path('/login');

    // }
    

    // $scope.init();
    
}]);
