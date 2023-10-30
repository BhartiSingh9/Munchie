angular.module('myApp').controller('SearchController', ['$scope', function($scope) {
    $scope.isSearchExpanded = false;

    $scope.expandSearch = function() {
        $scope.isSearchExpanded = true;
    };

    $scope.search = function() {
      
        console.log('Searching for:', $scope.searchQuery);
    };
}]);
