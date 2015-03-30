(function () {
  'use strict';

  angular.module('clientApp')
    .controller('CandidateController', function ($scope, globalAlert, $state, $stateParams, Event, Tune, Candidate) {

      $scope.alert = globalAlert.getAndClear();

      $scope.event = null;

      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          $scope.event = data;
        });

      Tune.query($stateParams.eventId).then(
        function(data) {
          // 受け取ったjsonでは演奏時間が'HH:mm:ss' or 'HH:mm'で表されているので、これをDateオブジェクトに変換
          var now = new Date();
          for(var i=0; i<data.length; i++) {
            var HHmmss = data[i].time.split(':');
            if(HHmmss[2] === undefined) {
              data[i].time = new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), HHmmss[1], 0);
            } else {
              data[i].time = new Date(now.getFullYear(), now.getMonth(), now.getDate(), now.getHours(), HHmmss[1], HHmmss[2]);
            }
          }

          $scope.tunes = data;
        }
      );

      $scope.updateCandidates = function() {
        var candidates = $scope.tunes
          .filter(function(e){return e.candidate})
          .map(function(e){
            return {
              eventId: $stateParams.eventId,
              tuneId: e.id
            };
          });
        Candidate.saveAfterDelete($stateParams.eventId, candidates).then(
          function () {
            globalAlert.set({type: 'success', msg: '候補曲を変更しました。'});
            $state.reload();
          },
          function () {
            $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
          }
        );
      };

    });


})();