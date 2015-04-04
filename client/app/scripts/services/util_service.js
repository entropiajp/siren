(function () {
  'use strict';

  angular.module('clientApp')
    .factory('UtilService', function($resource, $http, API_URL){

      var convertTimeToDateObject = function (timeStr, date){
        var HHmmss = timeStr.split(':');
        if(HHmmss[2] === undefined) {
          return new Date(date.getFullYear(), date.getMonth(), date.getDate(), date.getHours(), HHmmss[1], 0);
        } else {
          return new Date(date.getFullYear(), date.getMonth(), date.getDate(), date.getHours(), HHmmss[1], HHmmss[2]);
        }
      };

      var findUser = function() {
        return $resource(API_URL + '/user').get().$promise;
      };

      var logout = function() {
        return $http.post(API_URL + '/logout', {});
      };

      return {
        convertTimeToDateObject: convertTimeToDateObject,
        findUser: findUser,
        logout: logout
      };

    });

})();