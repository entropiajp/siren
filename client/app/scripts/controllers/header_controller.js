(function () {
  'use strict';

  angular.module('clientApp')
    .controller('HeaderController', function ($scope, globalAlert, user, Event, UtilService, $state, $rootScope, HeadlineService, $timeout) {

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
      $scope.activity = null;
      $scope.visible = true;
      $rootScope.$on('onReceived', function(event, data) {
        $scope.$apply(function(){
          $scope.visible = false;
        });
        $timeout(function(){
          $scope.activity = data;
          $scope.visible = true;
        }, 1000);
      });

    });

})();