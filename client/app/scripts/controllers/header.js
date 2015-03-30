(function () {
  'use strict';

  angular.module('clientApp')
    .controller('HeaderController', function ($scope, $resource, Event, $http, $state) {

      $scope.user = $resource('http://localhost:8081/user').get();

      Event.findManaged().then(function(data){
        $scope.managedEvents = data;
      });

      Event.findJoined().then(function(data){
        $scope.joinedEvents = data;
      });

      $scope.logout = function() {
        $http.post('http://localhost:8081', {}).
          success(function(data, status, headers, config) {
            $state.go('login');
          });
      }

    });

})();