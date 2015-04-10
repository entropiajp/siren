(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EditEnqueteController', function ($scope, globalAlert, $state, $stateParams, Event, Vote, user, UtilService) {

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
          var d = new Date();
          d.setHours(22);
          d.setMinutes(0);
          d.setSeconds(0);

          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);

          $scope.event = data;
          $scope.event.voteStartTime = (data.voteStartTime == null) ? d : new Date(data.voteStartTime);
          $scope.event.voteEndTime = (data.voteEndTime == null) ? d : new Date(data.voteEndTime);

        }
      );

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

      $scope.open1 = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened1 = true;
      };

      $scope.open2 = function($event) {
        $event.preventDefault();
        $event.stopPropagation();

        $scope.opened2 = true;
      };

      $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1,
        showWeeks: false
      };

      Vote.findResult($stateParams.eventId).then(
        function(data){
          $scope.data = [
            {
              "key": "Series1",
              "color": "#d62728",
              "values": null
            }
          ];
          $scope.data[0].values = data.map(function(e){
            return {
              label: e.name,
              value: e.count
            };
          });
        }
      );

      $scope.options = {
        chart: {
          type: 'multiBarHorizontalChart',
          x: function(d){return d.label;},
          y: function(d){return d.value;},
          showControls: false,
          showValues: true,
          transitionDuration: 500,
          xAxis: {
            showMaxMin: false
          },
          valueFormat: function(d){return d;},
          showYAxis: false,
          showLegend: false,
          margin: {
            top: 0,
            right: 20,
            bottom: 50,
            left: 300
          },
          tooltips: false

        }
      };

    });


})();