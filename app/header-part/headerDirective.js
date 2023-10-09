angular.module('myApp').directive('myHeader', function () {
    return {
        restrict: 'E',
         templateUrl: 'app/header-part/header-part.html',
        controller: 'HeaderController'
    };
});
