(function () {
  'use strict';

  angular.module('clientApp')
    .controller('VoteController', function ($scope, globalAlert, $state, $stateParams, Tune, Vote, Event, UtilService, my) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = null;
      $scope.tunes = null;
      $scope.votedCount = null;
      $scope.my = my;
      $scope.isMember = (my !== null);
      $scope.isEntryPeriod = false;
      $scope.isVotingPeriod = false;

      $scope.onClick = function() {
        $scope.votedCount = $scope.tunes.filter(function(e){return e.voted;}).length;
      };

      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          if(data.voteLimit === null) {
            data.voteLimit = 9999;
          }
          $scope.event = data;
          $scope.isEntryPeriod = UtilService.isBetween($scope.event.joinStartTime, $scope.event.joinEndTime);
          $scope.isVotingPeriod = UtilService.isBetween($scope.event.voteStartTime, $scope.event.voteEndTime);
        }
      );

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

      $scope.vote = function() {
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
          }
        );
      };

    });


})();