(function () {
  'use strict';

  angular.module('clientApp')
    .controller('HeaderController', function ($scope, globalAlert, user, Event, UtilService, $state, $rootScope, HeadlineService) {

      $scope.user = user;
      $scope.managedEvents = Event.findManaged();
      $scope.joinedEvents = Event.findJoined();
      $scope.logout = function () {
        UtilService.logout().success(
          function (data, status, headers, config) {
            globalAlert.set({type: 'success', msg: 'ログアウトしました'});
            $state.go('login');
          }
        );
      };
      $scope.headline = HeadlineService.get();
      $rootScope.$on('onReceived', function(event, data) {
        $scope.headline = data;
        $scope.$apply();
      });

    });

})();