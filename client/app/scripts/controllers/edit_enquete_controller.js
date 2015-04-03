(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EditEnqueteController', function ($scope, globalAlert, $state, $stateParams, Event) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = null;

      Event.find($stateParams.eventId).then(
        function(data){
          var d = new Date();
          d.setHours(22);
          d.setMinutes(0);
          d.setSeconds(0);

          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);

          $scope.event = data;
          if(data.voteStartTime == null) {
            $scope.event.voteStartTime = d;
          } else {
            $scope.event.voteStartTime = new Date(data.voteStartTime);
          }
          if(data.voteEndTime == null) {
            $scope.event.voteEndTime = d;
          } else {
            $scope.event.voteEndTime = new Date(data.voteEndTime);
          }

        }
      );

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

      $scope.open1 = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened1 = true;
      };

      $scope.open2 = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened2 = true;
      };

      $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1,
        showWeeks: false
      };

    });


})();