(function () {
  'use strict';

  angular.module('clientApp')
    .factory('HeadlineService', function (API_URL, $rootScope, $location) {
      var m = null;
      var hostport = (API_URL === '') ? $location.host() + ':' + $location.port() : API_URL.slice(7);
      var url = 'ws://' + hostport + '/activity';
      var socket = new WebSocket(url);
      var stompClient = Stomp.over(socket);

      stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/activity', function(data){
          m = angular.fromJson(data.body);
          $rootScope.$broadcast('onReceived', m);
        });
      });

      var pass = function() {return m;};
      return {get: pass};
    });
})();