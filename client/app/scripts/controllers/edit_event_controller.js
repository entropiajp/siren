(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EditEventController', function ($scope, globalAlert, $stateParams, Event, event, UtilService) {

      init();

      $scope.alert = globalAlert.getAndClear();
      $scope.event = event;
      $scope.progress = 0;
      $scope.progressText = '';
      $scope.scheduledDate = event.startTime;

      $scope.$watch('scheduledDate', function(newDate, oldDate) {
        if($scope.event != null && newDate != null) {
          $scope.event.startTime = UtilService.createDateObject(
            $scope.event.startTime.getHours(), $scope.event.startTime.getMinutes(), 0, newDate);
          $scope.event.endTime = UtilService.createDateObject(
            $scope.event.endTime.getHours(), $scope.event.endTime.getMinutes(), 0, newDate);
        }
      });

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

      $scope.open = function($event, caller) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope[caller] = true;
      };

      $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1,
        showWeeks: false
      };

      $scope.onFileDropped = function(files) {
        $scope.progressText = '';
        Event.uploadFile(files, $stateParams.eventId)
          .progress(function (evt) {
            $scope.progress = parseInt(100.0 * evt.loaded / evt.total);
          })
          .success(function (data, status, headers, config) {
            $scope.progressText = config.file.name + 'のアップロードが完了しました！';
            $scope.event.imageUrl = data.message;
          })
          .error(function (data, status, headers, config) {
            $scope.progress = 0;
            $scope.progressText = 'ファイルアップロードが失敗しました。もう一度試してください';
          });
      };

      function init() {
        event.startTime = new Date(event.startTime);
        event.endTime = new Date(event.endTime);
        event.voteStartTime = new Date(event.voteStartTime);
        event.voteEndTime = new Date(event.voteEndTime);
        event.joinStartTime = new Date(event.joinStartTime);
        event.joinEndTime = new Date(event.joinEndTime);
      }

    });

})();
