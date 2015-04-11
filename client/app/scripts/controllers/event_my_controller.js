(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EventMyController', function ($scope, globalAlert, $stateParams, SweetAlert, Member, user, Event, UtilService) {

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
      $scope.event = null;

      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          $scope.event = data;
        });

      Member.findMy($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          $scope.my = data;
        }
      );

      $scope.submit = function() {
        Member.update($scope.my).then(
          function() {
            $scope.alert = {type: 'success', msg: '情報を編集しました！'};
          },
          function() {
            $scope.alert = {type: 'danger', msg: 'おや、失敗しました'};
          }
        );
      };

      $scope.copy = function() {
        $scope.my.startTime = $scope.event.startTime;
        $scope.my.endTime = $scope.event.endTime;
      };

    });


})();