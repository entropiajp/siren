(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Member', function($resource){
      var Resource = $resource('http://localhost:8081/members/:id', {id: '@id'},{
        update: {method: 'PUT'},
        queryByEventId: {method: 'GET', params:{eventId: '@eventId'}, isArray: true},
        join: {method: 'POST', params:{eventId: '@eventId'}}
      });

      var find = function(id) {
        return Resource.get({id: id}).$promise;
      };

      var save = function(entity) {
        return Resource.save(entity).$promise;
      };

      var update = function(entity) {
        return Resource.update(entity).$promise;
      };

      var queryByEventId = function(eventId) {
        return Resource.queryByEventId({eventId: eventId}).$promise;
      };

      var remove = function(id) {
        return Resource.remove({id: id}).$promise;
      };

      var join = function(eventId) {
        return Resource.join({eventId: eventId}).$promise;
      };

      return {
        find: find,
        save: save,
        update: update,
        query: queryByEventId,
        remove: remove,
        join: join
      };


    });


})();