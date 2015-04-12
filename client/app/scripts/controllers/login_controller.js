(function () {
  'use strict';

  angular.module('clientApp')
    .controller('LoginController', function ($scope, globalAlert, $rootScope, $state) {

      $rootScope.isLogin = $state.is('login');

    });


})();