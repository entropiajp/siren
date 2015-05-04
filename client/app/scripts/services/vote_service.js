(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Vote', function($resource, API_URL){
      var Resource = $resource(API_URL + '/votes/:eventId', {eventId: '@eventId'},{
        update: {method: 'PUT'},
        saveAfterDelete: {method: 'POST', params:{eventId: '@eventId'}, isArray: true}
      });

      var saveAfterDelete = function(eventId, entities) {
        return Resource.saveAfterDelete({eventId: eventId}, entities).$promise;
      };

      var findAll = function() {
        return Resource.query().$promise;
      };

      var query = function(eventId) {
        return Resource.query({eventId: eventId}).$promise;
      };

      var findResult = function(eventId) {
        return $resource(API_URL + '/votes/:eventId/result', {eventId: '@eventId'}).query({eventId: eventId});
      };

      return {
        findAll: findAll,
        saveAfterDelete: saveAfterDelete,
        query: query,
        findResult: findResult
      };


    });


})();