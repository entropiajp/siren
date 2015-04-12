(function () {
  'use strict';

  angular.module('clientApp')
    .controller('PortalController', function ($scope, globalAlert, user, Event) {

      $scope.alert = globalAlert.getAndClear();

      Event.query().then(
        function(data) {
          // ng-ifでDateの比較をしたいので変換
          data.map(function(e){
            e.endTime = new Date(e.endTime);
            return e;
          });
          $scope.events = data;
        }
      );
      $scope.now = new Date();

    });

})();
