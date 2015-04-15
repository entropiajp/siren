(function () {
  'use strict';

  angular.module('clientApp')
    .controller('LoginController', function ($scope, globalAlert, $rootScope, $state) {

      $scope.alert = globalAlert.getAndClear();
      $rootScope.isLogin = $state.is('login');

    });


})();