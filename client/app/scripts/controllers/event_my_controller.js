(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EventMyController', function ($scope, globalAlert, $stateParams, SweetAlert, Member, Event, event, UtilService) {


      $scope.alert = globalAlert.getAndClear();
      $scope.event = event;
      $scope.isEntryPeriod = UtilService.isBetween($scope.event.joinStartTime, $scope.event.joinEndTime);
      $scope.isVotingPeriod = UtilService.isBetween($scope.event.voteStartTime, $scope.event.voteEndTime);
      $scope.my = null;
      $scope.submit = submit;
      $scope.copy = copy;

      Member.findMy($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          $scope.my = data;
        }
      );

      function submit() {
        Member.update($scope.my).then(
          function() {
            $scope.alert = {type: 'success', msg: '情報を編集しました！'};
          },
          function() {
            $scope.alert = {type: 'danger', msg: 'おや、失敗しました'};
          }
        );
      }

      function copy() {
        $scope.my.startTime = $scope.event.startTime;
        $scope.my.endTime = $scope.event.endTime;
      }


    });


})();