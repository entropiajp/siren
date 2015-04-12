(function () {
  'use strict';

  angular.module('clientApp')
    .controller('NewTuneController', function ($scope, globalAlert, $stateParams, Tune, $state, SweetAlert, UtilService) {

      $scope.alert = globalAlert.getAndClear();

      $scope.newTune = null;
      $scope.storedArtists = Tune.findArtists();
      $scope.storedSources = Tune.findSources();

      Tune.query().then(
        function(data) {
          // 受け取ったjsonでは演奏時間が'HH:mm:ss' or 'HH:mm'で表されているので、これをDateオブジェクトに変換
          var now = new Date();
          for(var i=0; i<data.length; i++) {
            data[i].time = UtilService.convertTimeToDateObject(data[i].time, now);
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
                  var msg = $scope.newTune.artist + ' / ' + $scope.newTune.name + ' を登録しました。';
                  $scope.alert = {type: 'success', msg: msg};
                  $scope.newTune.name = '';
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