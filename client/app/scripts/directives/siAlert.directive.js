(function () {
  'use strict';

  angular.module('clientApp')
    .directive('siAlert', function () {
      return {
        scope: {
          siAlert: '='
        },
        restrict: 'E',
        templateUrl: 'scripts/directives/siAlert.directive.html'
      };
    });
})();