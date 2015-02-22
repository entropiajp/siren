'use strict';

angular.module('clientApp')
  .controller('MainCtrl', function ($scope, $timeout) {
    $scope.startTime = new Date();
    $scope.endTime = new Date();

    $scope.$watch('startTime', function () {
      var d = new Date();
      d.setHours($scope.startTime.getHours() + 8);
      $scope.endTime = d;
    });

    $scope.today = function() {
      $scope.dt = new Date();
    };

    $scope.clear = function () {
      $scope.dt = null;
    };

    $scope.toggleMin = function() {
      $scope.minDate = $scope.minDate ? null : new Date();
    };
    $scope.toggleMin();

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

    $scope.format = 'yyyy/MM/dd (EEE)';
  });
