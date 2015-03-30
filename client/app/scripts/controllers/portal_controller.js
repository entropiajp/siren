(function () {
  'use strict';

  angular.module('clientApp')
    .controller('PortalController', function ($scope, globalAlert, Event) {

      $scope.alert = globalAlert.getAndClear();

      Event.findManaged().then(function(data){
        $scope.managedEvents = data;
      });

      Event.findJoined().then(function(data){
        $scope.joinedEvents = data;
      });

      Event.findFuture().then(function(data){
        $scope.futureEvents = data;
      });

      Event.findPast().then(function(data){
        $scope.pastEvents = data;
      });

    });

})();
