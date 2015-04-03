(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Tune', function($resource, API_URL){
      var Resource = $resource(API_URL + '/tunes/:id', {id: '@id'},{
        update: {method: 'PUT'}
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

      var findArtists = function() {
        return $resource(API_URL + '/tunes/artists').query().$promise;
      };

      var findSources = function() {
        return $resource(API_URL + '/tunes/sources').query().$promise;
      };

      return {
        find: find,
        save: save,
        update: update,
        query: query,
        findArtists: findArtists,
        findSources: findSources
      };


    });


})();