(function () {
  'use strict';

  angular.module('clientApp')
    .controller('VoteController', function ($scope, globalAlert, $state, $stateParams, Tune, Vote, UtilService, event) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = event;
      $scope.tunes = null;
      $scope.votedCount = null;
      $scope.isEntryPeriod = UtilService.isBetween($scope.event.joinStartTime, $scope.event.joinEndTime);
      $scope.isVotingPeriod = UtilService.isBetween($scope.event.voteStartTime, $scope.event.voteEndTime);
      $scope.onClick = onClick;
      $scope.vote = vote;

      Vote.query($stateParams.eventId).then(
        function(data) {
          // 受け取ったjsonでは演奏時間が'HH:mm:ss' or 'HH:mm'で表されているので、これをDateオブジェクトに変換
          var now = new Date();
          for(var i=0; i<data.length; i++) {
            data[i].time = UtilService.convertTimeToDateObject(data[i].time, now);
          }

          $scope.tunes = data;
          $scope.votedCount = data.filter(function(e){return e.voted;}).length;
        }
      );

      function vote() {
        var votes = $scope.tunes
          .filter(function(e){return e.voted;})
          .map(function(e){return e.id;});
        Vote.saveAfterDelete($stateParams.eventId, votes).then(
          function () {
            globalAlert.set({type: 'success', msg: 'アンケートに回答しました'});
            $state.reload();
          },
          function () {
            $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
            UtilService.scrollTop();
          }
        );
      }

      function onClick() {
        $scope.votedCount = $scope.tunes.filter(function(e){return e.voted;}).length;
      }

    });


})();