angular.module('myApp')
  .controller('UserController', function($scope, UserService) {
    $scope.users = [];
    $scope.selectedUser = null;

    $scope.fetchUsers = function() {
      UserService.getAllUsers()
        .then(function(response) {
          $scope.users = response.data;
        })
        .catch(function(error) {
          console.error('Error fetching users:', error);
        });
    };

    $scope.fetchUserById = function(id) {
      UserService.getUserById(id)
        .then(function(response) {
          $scope.selectedUser = response.data;
        })
        .catch(function(error) {
          console.error('Error fetching user by ID:', error);
        });
    };

    $scope.fetchUsers();
  });
