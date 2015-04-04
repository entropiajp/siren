(function () {
  'use strict';

  angular.module('clientApp')
    .controller('NewEventController', function ($scope, $resource, $state, globalAlert, user, Event, UtilService) {

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

      $scope.minDate = new Date();
      $scope.startTime = new Date($scope.minDate.getFullYear(), $scope.minDate.getMonth(), $scope.minDate.getDate(), 11, 0, 0);
      $scope.endTime = new Date($scope.minDate.getFullYear(), $scope.minDate.getMonth(), $scope.minDate.getDate(), 18, 0, 0);
      $scope.eventName = '';
      $scope.scheduledDate = null;

      $scope.submit = function() {

        var Event = $resource('http://localhost:8081/event');

        $scope.startTime = new Date($scope.scheduledDate.getFullYear(), $scope.scheduledDate.getMonth(), $scope.scheduledDate.getDate(),
          $scope.startTime.getHours(), $scope.startTime.getMinutes(), 0);
        $scope.endTime = new Date($scope.scheduledDate.getFullYear(), $scope.scheduledDate.getMonth(), $scope.scheduledDate.getDate(),
          $scope.endTime.getHours(), $scope.endTime.getMinutes(), 0);

        var event = new Event({
          name: $scope.eventName,
          startTime: $scope.startTime,
          endTime: $scope.endTime
        });

        event.$save(
          function() {
            globalAlert.set({type: 'success', msg: 'バンオフを作成しました！'});
            $state.go('portal');
          },
          function() {
            $scope.alert = {type: 'error', msg: 'おや、失敗しました'};
          }
        );
      };

      $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
      };

      $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1,
        showWeeks: false
      };


    });

})();
