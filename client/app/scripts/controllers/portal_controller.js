(function () {
  'use strict';

  angular.module('clientApp')
    .controller('PortalController', function ($scope, globalAlert, user, Event, UtilService, $state) {

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

      Event.query().then(
        function(data) {
          // ng-ifでDateの比較をしたいので変換
          data.map(function(e){
            e.endTime = new Date(e.endTime);
            return e;
          });
          $scope.events = data;
        }
      );
      $scope.now = new Date();

    });

})();
