(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EntryController', function ($scope, globalAlert, $stateParams, Song, Role, user, $state, UtilService, event) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = event;
      $scope.songs = null;
      $scope.newRole = [];
      $scope.user = user;
      $scope.joinedCount = null;
      $scope.isEntryPeriod = UtilService.isBetween($scope.event.joinStartTime, $scope.event.joinEndTime);
      $scope.isVotingPeriod = UtilService.isBetween($scope.event.voteStartTime, $scope.event.voteEndTime);
      $scope.addRole = addRole;
      $scope.join = join;
      $scope.cancel = cancel;

      Song.query($stateParams.eventId).then(
        function(data){
          $scope.joinedCount = data.map(function(e){
            if(e.roles !== null) {
              return e.roles.filter(function(e){ return e.userId === user.userId}).length;
            } else {
              return 0;
            }
          }).reduce(function(v,e){ return e+v }, 0);

          $scope.songs = data;
        }
      );

      function addRole(songId){
        $scope.newRole[songId].songId = songId;
        Role.save($scope.newRole[songId]).then(
          function () {
            var msg = $scope.newRole[songId].name + ' を登録しました';
            globalAlert.set({type: 'success', msg: msg});
            $state.reload();
          },
          function () {
            $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
          }
        );
      }

      function join(roleId){
        Role.join(roleId, $stateParams.eventId).then(
          function () {
            var msg = 'エントリーしました';
            globalAlert.set({type: 'success', msg: msg});
            $state.reload();
          },
          function () {
            $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
          }
        );
      }

      function cancel(roleId){
        Role.cancel(roleId).then(
          function () {
            var msg = 'キャンセルしました';
            globalAlert.set({type: 'success', msg: msg});
            $state.reload();
          },
          function () {
            $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
          }
        );
      }

    });


})();