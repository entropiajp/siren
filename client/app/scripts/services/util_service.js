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

      // 時、分、秒の文字列からDateオブジェクトを生成する。dateObjが指定されていればその年月日を設定する
      function createDateObject(HH, mm, ss, dateObj) {
        if(dateObj === undefined) {
          dateObj = new Date();
        }
        return new Date(dateObj.getFullYear(), dateObj.getMonth(), dateObj.getDate(), HH, mm, ss);
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