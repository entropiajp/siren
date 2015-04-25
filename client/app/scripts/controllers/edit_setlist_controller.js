(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EditSetlistController', function ($scope, globalAlert, $state, $stateParams, Event, UtilService, Song, user) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = null;
      $scope.songs = null;
      $scope.wholeTime = null;
      $scope.playableSongsCount = 0;
      $scope.recalc = recalc;
      $scope.sortableListener = {
        orderChanged: function(event) {
          $scope.songs = assignSongOrder($scope.songs);
        }
      };
      $scope.submit = submit;
      $scope.endJoin = endJoin;


      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          $scope.event = data;
        }
      );

      Song.query($stateParams.eventId).then(
        function(data){
          for(var i=0; i<data.length; i++) {
            data[i].song.time = UtilService.convertTimeToDateObject(data[i].song.time, new Date());
          }
          $scope.songs = assignSongOrder(data);
          $scope.wholeTime = calcWholeTime(data);
          $scope.playableSongsCount = calcPlayableSongsCount(data);
        }
      );

      function recalc() {
        $scope.wholeTime = calcWholeTime($scope.songs);
        $scope.playableSongsCount = calcPlayableSongsCount($scope.songs);
        $scope.songs = assignSongOrder($scope.songs);
      }

      function submit() {
        var data = $scope.songs
          .map(function(e){
            return {
              id: e.song.id,
              eventId: e.song.eventId,
              tuneId: e.song.tuneId,
              playable: e.song.playable,
              songOrder: e.song.songOrder
            };
          });

        Song.updateAll($stateParams.eventId, data).then(
          function () {
            $scope.alert = {type: 'success', msg: 'セットリストを変更しました'};
          },
          function () {
            $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
          }
        );
      }

      function endJoin() {
        Event.endJoin($stateParams.eventId).then(
          function () {
            $scope.alert = {type: 'success', msg: 'エントリーを終了しました'};
          },
          function () {
            $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
          }
        );
      }

      function calcWholeTime(songs) {
        var times = songs.filter(function(e){return e.song.playable;}).map(function(e){return e.song.time});
        if(times.length === 0) {
          return UtilService.createDateObject(0,0,0);
        }
        return times.reduce(function(a,b){return UtilService.addTime(a,b);});
      }

      function calcPlayableSongsCount(songs) {
        return songs.filter(function(e){return e.song.playable;}).length;
      }

      function assignSongOrder(songs) {
        var index = 1;
        for(var i=0; i< songs.length; i++) {
          if(songs[i].song.playable) {
            songs[i].song.songOrder = index;
            index += 1;
          } else {
            songs[i].song.songOrder = null;
          }
        }
        return songs;
      }

    });


})();