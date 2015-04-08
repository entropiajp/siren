(function () {
  'use strict';

  angular.module('clientApp')
    .factory('HeadlineService', function (API_URL, $rootScope) {
      var m = '';
      var socket = new WebSocket('ws://' + API_URL.slice(7) + '/activity');
      var stompClient = Stomp.over(socket);
      stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function(data){
          m = data.body;
          $rootScope.$broadcast('onReceived', m);
        });
      });

      var pass = function() {return m;};
      return {get: pass};
    });
})();