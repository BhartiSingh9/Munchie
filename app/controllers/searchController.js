angular.module('myApp').controller('SearchController', ['$scope', function($scope) {
    $scope.isSearchExpanded = false;

    $scope.expandSearch = function() {
        $scope.isSearchExpanded = true;
    };

    $scope.search = function() {
        // Implement your search functionality here
        console.log('Searching for:', $scope.searchQuery);
    };
}]);
