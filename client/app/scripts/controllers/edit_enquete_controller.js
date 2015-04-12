(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EditEnqueteController', function ($scope, globalAlert, $state, $stateParams, Event, Vote, UtilService, Tune, Song) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = null;
      $scope.result = null;
      $scope.resultForGraph = null;
      $scope.tunes = null;


      Event.find($stateParams.eventId).then(
        function(data){
          var d = new Date();
          d.setHours(22);
          d.setMinutes(0);
          d.setSeconds(0);

          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);

          $scope.event = data;
          $scope.event.voteStartTime = (data.voteStartTime == null) ? d : new Date(data.voteStartTime);
          $scope.event.voteEndTime = (data.voteEndTime == null) ? d : new Date(data.voteEndTime);

        }
      );

      Vote.findResult($stateParams.eventId).then(
        function(data){
          $scope.result = data;
          $scope.resultForGraph = [
            {
              "key": "Series1",
              "color": "#d62728",
              "values": null
            }
          ];
          $scope.resultForGraph[0].values = data.map(function(e){
            return {
              label: e.name,
              value: e.count
            };
          });
        }
      );

      $scope.options = {
        chart: {
          type: 'multiBarHorizontalChart',
          x: function(d){return d.label;},
          y: function(d){return d.value;},
          showControls: false,
          showValues: true,
          transitionDuration: 500,
          xAxis: {
            showMaxMin: false
          },
          valueFormat: function(d){return d;},
          showYAxis: false,
          showLegend: false,
          margin: {
            top: 0,
            right: 20,
            bottom: 50,
            left: 300
          },
          tooltips: false
        }
      };

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

      $scope.checkVotedTunes = function() {
        $scope.result.forEach(function(r){
          for(var i=0; i<$scope.tunes.length; i++) {
            if(r.tuneId === $scope.tunes[i].id) {
              $scope.tunes[i].candidate = true;
              break;
            }
          }
        });
      };

      $scope.submit = function() {
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
          }
        );
      };

    });


})();