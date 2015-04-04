(function () {
  'use strict';

  angular.module('clientApp')
    .controller('LoginController', function ($scope, $resource, globalAlert, $rootScope, $state) {

      $rootScope.isLogin = $state.is('login');

    });


})();