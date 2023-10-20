angular.module('myApp')
  .service('UserService', function($http) {
    this.getAllUsers = function() {
      return $http.get('/users/all');
    };

    this.getUserById = function(id) {
      return $http.get('/users/' + id);
    };
  });
