(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EventController', function ($scope, globalAlert, $stateParams, SweetAlert, Member, Event) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = null;

      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          $scope.event = data;
        });

      $scope.join = function() {
        SweetAlert.swal({
            title: "このバンオフに参加しますか？",
            text: "参加キャンセルする場合、主催まで連絡してください",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "参加する！",
            closeOnConfirm: true
          },
          function (isConfirm) {
            if(isConfirm) {
              Member.join($stateParams.eventId).then(
                function () {
                  $scope.alert = {type: 'success', msg: 'バンオフに参加しました！'};
                },
                function () {
                  $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
                }
              );
            }
          }
        );
      }


    });


})();