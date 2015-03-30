(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EditEventController', function ($scope, globalAlert, $stateParams, Event) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = null;

      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          $scope.event = data;
          $scope.scheduledDate = data.startTime;
        });

      $scope.$watch('scheduledDate', function(newDate, oldDate) {
        $scope.event.startTime = new Date(newDate.getFullYear(), newDate.getMonth(), newDate.getDate(),
          $scope.event.startTime.getHours(), $scope.event.startTime.getMinutes(), 0);
        $scope.event.endTime = new Date(newDate.getFullYear(), newDate.getMonth(), newDate.getDate(),
          $scope.event.endTime.getHours(), $scope.event.endTime.getMinutes(), 0);
      });

      $scope.submit = function() {

        Event.update($scope.event).then(
          function() {
            $scope.alert = {type: 'success', msg: 'バンオフ情報を編集しました！'};
          },
          function() {
            $scope.alert = {type: 'danger', msg: 'おや、失敗しました'};
          }
        );
      };

      $scope.today = function() {
        $scope.scheduledDate = new Date();
      };

      $scope.clear = function () {
        $scope.scheduledDate = null;
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
