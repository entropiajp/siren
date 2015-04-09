(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EditEventController', function ($scope, globalAlert, $stateParams, user, Event, UtilService, $state) {

      $scope.user = user;
      $scope.managedEvents = Event.findManaged();
      $scope.joinedEvents = Event.findJoined();
      $scope.logout = function() {
        UtilService.logout().success(
          function (data, status, headers, config) {
            $state.go('login');
          }
        );
      };
      $scope.alert = globalAlert.getAndClear();
      $scope.event = null;
      $scope.scheduledDate = null;

      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          data.voteStartTime = (data.voteStartTime == null) ? null : new Date(data.voteStartTime);
          data.voteEndTime = (data.voteEndTime == null) ? null : new Date(data.voteEndTime);
          $scope.event = data;
          $scope.scheduledDate = data.startTime;
        });

      $scope.$watch('scheduledDate', function(newDate, oldDate) {
        if($scope.event != null && newDate != null) {
          $scope.event.startTime = new Date(newDate.getFullYear(), newDate.getMonth(), newDate.getDate(),
            $scope.event.startTime.getHours(), $scope.event.startTime.getMinutes(), 0);
          $scope.event.endTime = new Date(newDate.getFullYear(), newDate.getMonth(), newDate.getDate(),
            $scope.event.endTime.getHours(), $scope.event.endTime.getMinutes(), 0);
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

      $scope.today = function() {
        $scope.scheduledDate = new Date();
      };

      $scope.clear = function () {
        $scope.scheduledDate = null;
      };

      $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened = true;
      };

      $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1,
        showWeeks: false
      };

      $scope.progress = 0;
      $scope.progressText = '';
      $scope.onFileDropped = function(files) {
        Event.uploadFile(files, $stateParams.eventId)
          .progress(function (evt) {
            $scope.progress = parseInt(100.0 * evt.loaded / evt.total);
          })
          .success(function (data, status, headers, config) {
            $scope.progressText = config.file.name + 'のアップロードが完了しました！'
            $scope.event.logoImage = data.message;
          })
          .error(function (data, status, headers, config) {
            $scope.progress = 0;
            $scope.progressText = 'ファイルアップロードが失敗しました。もう一度試してください'
          });
      };

    });

})();
