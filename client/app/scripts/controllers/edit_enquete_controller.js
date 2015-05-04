(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EditEnqueteController', function ($scope, globalAlert, $state, $stateParams, event, Vote, UtilService, Tune, Song) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = event;
      $scope.result = Vote.findResult($stateParams.eventId);
      $scope.resultForGraph = null;
      $scope.tunes = null;
      $scope.checkVotedTunes = checkVotedTunes;
      $scope.submit = submit;

      Tune.findAllWithCandidates($stateParams.eventId).then(
        function(data) {
          // 受け取ったjsonでは演奏時間が'HH:mm:ss' or 'HH:mm'で表されているので、これをDateオブジェクトに変換
          var now = new Date();
          for(var i=0; i<data.length; i++) {
            data[i].time = UtilService.convertTimeToDateObject(data[i].time, now);
          }
          $scope.tunes = data;
        }
      );

      function checkVotedTunes() {
        $scope.result.forEach(function(r){
          for(var i=0; i<$scope.tunes.length; i++) {
            if(r.tuneId === $scope.tunes[i].id) {
              $scope.tunes[i].candidate = true;
              break;
            }
          }
        });
      }

      function submit() {
        var songs = $scope.tunes
          .filter(function(e){return e.candidate;})
          .map(function(e){return e.id;});
        Song.saveAll($stateParams.eventId, songs).then(
          function () {
            globalAlert.set({type: 'success', msg: 'エントリー可能曲を設定しました'});
            $state.reload();
          },
          function () {
            $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
            UtilService.scrollTop();
          }
        );
      }

    });

})();