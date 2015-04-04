(function () {
  'use strict';

  angular.module('clientApp')
    .controller('MemberController', function ($scope, globalAlert, $stateParams, Member, Manager, $state, SweetAlert, user, Event, UtilService) {

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

      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          $scope.event = data;
        });

      Member.query($stateParams.eventId).then(
        function(data) {
          $scope.members = data;
        }
      );

      $scope.cancel = function(memberId) {
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
                }
              );
            }
          }
        );
      };

      $scope.addManager = function(memberId) {
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
                }
              );
            }
          }
        );
      };

      $scope.removeManager = function(memberId) {
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
                }
              );
            }
          }
        );
      };


    });


})();