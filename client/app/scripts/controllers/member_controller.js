(function () {
  'use strict';

  angular.module('clientApp')
    .controller('MemberController', function ($scope, globalAlert, $stateParams, Member, Manager, $state, SweetAlert, event, user, UtilService) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = event;
      $scope.user = user;
      $scope.members = null;
      $scope.cancel = cancel;
      $scope.addManager = addManager;
      $scope.removeManager = removeManager;

      Member.query($stateParams.eventId).then(
        function(data) {
          $scope.members = data;
        }
      );

      function cancel(memberId) {
        SweetAlert.swal({
            title: "参加者をキャンセルしますか？",
            text: "この操作はやり直せません。",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "キャンセルする",
            closeOnConfirm: true
          },
          function (isConfirm) {
            if (isConfirm) {
              Member.remove(memberId).then(
                function () {
                  globalAlert.set({type: 'success', msg: '参加者をキャンセルしました'});
                  $state.reload();
                },
                function () {
                  $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
                  UtilService.scrollTop();
                }
              );
            }
          }
        );
      }

      function addManager(memberId) {
        var manager = {
          eventId: $stateParams.eventId,
          memberId: memberId
        };
        SweetAlert.swal({
            title: "管理者に追加しますか？",
            text: "すぐに管理者になります",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "追加する",
            closeOnConfirm: true
          },
          function (isConfirm) {
            if (isConfirm) {
              Manager.save(manager).then(
                function () {
                  globalAlert.set({type: 'success', msg: '管理者を追加しました'});
                  $state.reload();
                },
                function () {
                  $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
                  UtilService.scrollTop();
                }
              );
            }
          }
        );
      }

      function removeManager(memberId) {
        var manager = {
          eventId: $stateParams.eventId,
          memberId: memberId
        };
        SweetAlert.swal({
            title: "管理者から外しますか？",
            text: "すぐに管理者から外れます",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "外す",
            closeOnConfirm: true
          },
          function (isConfirm) {
            if (isConfirm) {
              Manager.remove(manager).then(
                function () {
                  globalAlert.set({type: 'success', msg: '管理者から外しました'});
                  $state.reload();
                },
                function () {
                  $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
                  UtilService.scrollTop();
                }
              );
            }
          }
        );
      }


    });


})();