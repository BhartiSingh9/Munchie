angular.module('myApp').service('OrderService', ['$http', function($http) {
    this.getOrdersForUser = function(userId) {
      return $http.get('http://localhost:8080/orders?userId=' + userId);
    };
  }]);
  