angular.module('myApp').directive('userSidebar', function () {
    return {
        restrict: 'E',
        templateUrl: 'app/sidebar-part/sidebar.html',
        controller: 'SidebarController',
    };
})