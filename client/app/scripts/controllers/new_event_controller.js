(function () {
  'use strict';

  angular.module('clientApp')
    .controller('NewEventController', function ($scope, $resource, $state, globalAlert, Event) {

      $scope.alert = globalAlert.getAndClear();

      var d = new Date();
      $scope.minDate = d;
      $scope.event = {
        startTime: new Date(d.getFullYear(), d.getMonth(), d.getDate(), 11, 0, 0),
        endTime: new Date(d.getFullYear(), d.getMonth(), d.getDate(), 18, 0, 0),
        name: ''
      };
      $scope.scheduledDate = null;

      $scope.submit = function() {
        $scope.event.startTime = new Date($scope.scheduledDate.getFullYear(), $scope.scheduledDate.getMonth(), $scope.scheduledDate.getDate(),
          $scope.event.startTime.getHours(), $scope.event.startTime.getMinutes(), 0);
        $scope.event.endTime = new Date($scope.scheduledDate.getFullYear(), $scope.scheduledDate.getMonth(), $scope.scheduledDate.getDate(),
          $scope.event.endTime.getHours(), $scope.event.endTime.getMinutes(), 0);

        Event.save($scope.event).then(
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
