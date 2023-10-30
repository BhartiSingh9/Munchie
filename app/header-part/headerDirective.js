angular.module('myApp').directive('myHeader', function () {
    return {
   
         templateUrl: 'app/header-part/header-part.html',
        controller: 'HeaderController'
    };
});
