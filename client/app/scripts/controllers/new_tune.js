(function () {
  'use strict';

  angular.module('clientApp')
    .controller('NewTuneController', function ($scope, globalAlert, $stateParams, Tune, $state, SweetAlert) {

      $scope.alert = globalAlert.getAndClear();
      $scope.newTune = null;
      $scope.storedArtists = null;
      $scope.storedSources = null;

      Tune.findArtists().then(function(data) {
        $scope.storedArtists = data;
      });
      Tune.findSources().then(function(data) {
        $scope.storedSources = data;
      });

      function convertTimeToDateObject(timeStr, date){
        var HHmmss = timeStr.split(':');
        if(HHmmss[2] === undefined) {
          return new Date(date.getFullYear(), date.getMonth(), date.getDate(), date.getHours(), HHmmss[1], 0);
        } else {
          return new Date(date.getFullYear(), date.getMonth(), date.getDate(), date.getHours(), HHmmss[1], HHmmss[2]);
        }
      }

      Tune.query().then(
        function(data) {
          // 受け取ったjsonでは演奏時間が'HH:mm:ss' or 'HH:mm'で表されているので、これをDateオブジェクトに変換
          var now = new Date();
          for(var i=0; i<data.length; i++) {
            data[i].time = convertTimeToDateObject(data[i].time, now);
          }
          $scope.tunes = data;
        }
      );

      $scope.addTune = function() {
        SweetAlert.swal({
            title: "楽曲を登録しますか？",
            text: "この操作はやり直せません。",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "登録する",
            closeOnConfirm: true
          },
          function (isConfirm) {
            if (isConfirm) {
              Tune.save($scope.newTune).then(
                function () {
                  globalAlert.set({type: 'success', msg: '楽曲を登録しました。ご協力ありがとうございます。'});
                  $state.reload();
                },
                function () {
                  $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
                }
              );
            }
          }
        );
      };

    });


})();