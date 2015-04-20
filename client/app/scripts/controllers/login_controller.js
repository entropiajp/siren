(function () {
  'use strict';

  angular.module('clientApp')
    .controller('LoginController', function ($scope, globalAlert, $rootScope, $state, API_URL) {

      $scope.alert = globalAlert.getAndClear();
      $rootScope.isLogin = $state.is('login');
      $scope.loginUrl = API_URL + '/auth/twitter';

    });


})();