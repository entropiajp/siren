(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Song', function($resource, API_URL){
      var Resource = $resource(API_URL + '/songs/:id', {id: '@id'},{
        update: {method: 'PUT'},
        saveAll: {method: 'POST', params:{eventId: '@eventId'}, isArray: true}
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

      var query = function(eventId) {
        return Resource.query({eventId: eventId}).$promise;
      };

      var remove = function(entity) {
        return Resource.remove(entity).$promise;
      };

      var saveAll = function(eventId, entities) {
        return Resource.saveAll({eventId: eventId}, entities).$promise;
      };

      return {
        find: find,
        save: save,
        update: update,
        query: query,
        remove: remove,
        saveAll: saveAll
      };


    });


})();