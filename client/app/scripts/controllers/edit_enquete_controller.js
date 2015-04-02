(function () {
  'use strict';

  angular.module('clientApp')
    .controller('EditEnqueteController', function ($scope, globalAlert, $state, $stateParams, Event, Tune, Candidate) {

      $scope.alert = globalAlert.getAndClear();

      $scope.event = null;

      Event.find($stateParams.eventId).then(
        function(data){
          data.startTime = new Date(data.startTime);
          data.endTime = new Date(data.endTime);
          $scope.event = data;
        }
      );

    });


})();