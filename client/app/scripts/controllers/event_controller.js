(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EventController', function ($scope, globalAlert, $stateParams, SweetAlert, Member, UtilService, Part, $modal, $state, event, Song) {

      $scope.alert = globalAlert.getAndClear();
      $scope.event = event;
      $scope.isEntryPeriod = UtilService.isBetween($scope.event.joinStartTime, $scope.event.joinEndTime);
      $scope.isVotingPeriod = UtilService.isBetween($scope.event.voteStartTime, $scope.event.voteEndTime);
      $scope.managers = null;
      $scope.members = null;
      $scope.songs = null;

      Member.query($stateParams.eventId).then(
        function(data) {
          $scope.managers = data.filter(function(e){return e.admin;});
          $scope.members = data;
        }
      );

      Part.query().then(
        function(data) {
          for(var i=0; i<data.length; i++) {
            data[i].playable = false;
          }
          $scope.parts = data;
        }
      );

      Song.query($stateParams.eventId).then(
        function(data){
          data = data
            .filter(function(e){return e.song.playable})
            .map(function(item){
              if(item.roles !== null) {
                item.roles = item.roles.filter(function(role){return role.userId !== null;});
              }
              return item;
            });

          for(var i=0; i<data.length; i++) {
            data[i].song.time = UtilService.convertTimeToDateObject(data[i].song.time, new Date());
          }
          $scope.songs = data;
        }
      );

      $scope.open = function () {

        var modalInstance = $modal.open({
          templateUrl: 'myModalContent.html',
          controller: 'ModalInstanceCtrl',
          size: 'lg',
          resolve: {
            items: function () {
              return $scope.parts;
            },
            event: function() {
              return $scope.event;
            }
          }
        });

        modalInstance.result.then(function (parts) {
          parts = parts
            .filter(function(e){return e.playable;})
            .map(function(e){
              return {id: e.id, playable: e.playable};
            });
          Member.join($stateParams.eventId, parts).then(
            function () {
              globalAlert.set({type: 'success', msg: 'バンオフに参加しました！'});
              $state.reload();
            },
            function () {
              $scope.alert = {type: 'warning', msg: 'おや、失敗しました'};
              UtilService.scrollTop();
            }
          );
        }, function () {});
      };




    });

  angular.module('clientApp')
    .controller('ModalInstanceCtrl', function ($scope, $modalInstance, items, event) {
      $scope.parts = items;
      $scope.event = event;

      $scope.ok = function () {
        $modalInstance.close($scope.parts);
      };

      $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
      };
  });


})();