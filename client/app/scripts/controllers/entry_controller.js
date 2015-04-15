(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EntryController', function ($scope, globalAlert, Event, $stateParams, Song, Role, user, $state, my) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = null;
      $scope.songs = null;
      $scope.newRole = [];
      $scope.user = user;
      $scope.joinedCount = null;
      $scope.my = my;
      $scope.isMember = (my !== null);

      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          if(data.joinLimit === null) {
            data.joinLimit = 9999;
          }
          $scope.event = data;
        }
      );

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

      $scope.addRole = function(songId){
        $scope.newRole[songId].songId = songId;
        Role.save($scope.newRole[songId]).then(
          function () {
            var msg = $scope.newRole[songId].name + ' を登録しました';
            $scope.alert = {type: 'success', msg: msg};
            $scope.newRole[songId] = {};
          },
          function () {
            $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
          }
        );
      };

      $scope.join = function(roleId){
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
      };

      $scope.cancel = function(roleId){
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
      };

    });


})();