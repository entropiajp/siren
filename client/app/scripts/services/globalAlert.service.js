(function () {
  'use strict';

  angular.module('clientApp')
    .factory('globalAlert', function () {
      var alert = {};
      return {
        getAndClear: getAndClear,
        set: set
      };

      function getAndClear() {
        var temp = alert;
        alert = {};
        return temp;
      }

      function set(newAlert) {
        alert = newAlert;
      }
    });
})();