(function () {
  'use strict';

  angular.module('clientApp')
    .controller('PortalController', function ($scope, globalAlert, user, Event, UtilService) {

      $scope.user = user;
      $scope.managedEvents = Event.findManaged();
      $scope.joinedEvents = Event.findJoined();
      $scope.logout = function() {
        UtilService.logout().success(
          function (data, status, headers, config) {
            $state.go('login');
          }
        );
      };
      $scope.alert = globalAlert.getAndClear();

      $scope.futureEvents = Event.findFuture();
      $scope.pastEvents = Event.findPast();

    });

})();
