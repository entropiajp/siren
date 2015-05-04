(function () {
  'use strict';

  angular.module('clientApp')
    .controller('NewEventController', function ($scope, $resource, $state, globalAlert, Event, UtilService) {

      $scope.alert = globalAlert.getAndClear();
      $scope.minDate = new Date();
      $scope.event = {
        startTime: UtilService.createDateObject(11, 0, 0),
        endTime: UtilService.createDateObject(18, 0, 0),
        name: ''
      };
      $scope.scheduledDate = null;

      $scope.submit = function() {
        $scope.event.startTime = UtilService.createDateObject(
          $scope.event.startTime.getHours(), $scope.event.startTime.getMinutes(), 0, $scope.scheduledDate);
        $scope.event.endTime = UtilService.createDateObject(
          $scope.event.endTime.getHours(), $scope.event.endTime.getMinutes(), 0, $scope.scheduledDate);
        Event.save($scope.event).then(
          function() {
            globalAlert.set({type: 'success', msg: 'バンオフを作成しました！'});
            $state.go('private.portal');
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
