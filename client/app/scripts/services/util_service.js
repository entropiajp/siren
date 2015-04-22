(function () {
  'use strict';

  angular.module('clientApp')
    .factory('UtilService', function($resource, $http, API_URL){

      var convertTimeToDateObject = function (timeStr, date){
        var HHmmss = timeStr.split(':');
        if(HHmmss[2] === undefined) {
          return new Date(date.getFullYear(), date.getMonth(), date.getDate(), 0, HHmmss[1], 0);
        } else {
          return new Date(date.getFullYear(), date.getMonth(), date.getDate(), 0, HHmmss[1], HHmmss[2]);
        }
      };

      var findUser = function() {
        return $resource(API_URL + '/user').get().$promise;
      };

      var logout = function() {
        return $http.post(API_URL + '/logout', {});
      };

      // 現在時刻がfromdateTimeとtoDateTimeの間に含まれているかを判定する
      var isBetween = function(fromDateTime, toDateTime) {
        if(typeof(fromDateTime) === 'string') {
          fromDateTime = new Date(fromDateTime);
        }
        if(typeof(toDateTime) === 'string') {
          toDateTime = new Date(toDateTime);
        }
        var d = new Date();
        return (fromDateTime <= d) && (d <= toDateTime);
      };

      // date1, date2を演奏時間とみなしてmm:ssのみ加算した値を返す
      var addTime = function(date1, date2) {
        var d = new Date();
        d.setHours(date1.getHours() + date2.getHours());
        d.setMinutes(date1.getMinutes() + date2.getMinutes());
        d.setSeconds(date1.getSeconds() + date2.getSeconds());
        return d;
      };

      function createDateObject(HH,mm,ss) {
        var d = new Date();
        return new Date(d.getFullYear(), d.getMonth(), d.getDate(), HH, mm, ss);
      }

      return {
        convertTimeToDateObject: convertTimeToDateObject,
        findUser: findUser,
        logout: logout,
        isBetween: isBetween,
        addTime: addTime,
        createDateObject: createDateObject
      };

    });

})();