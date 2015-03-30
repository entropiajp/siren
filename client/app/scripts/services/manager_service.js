(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Manager', function($resource){
      var Resource = $resource('http://localhost:8081/manager/:id', {id: '@id'},{
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

      var query = function() {
        return Resource.query().$promise;
      };

      var remove = function(entity) {
        return Resource.remove(entity).$promise;
      };

      return {
        find: find,
        save: save,
        update: update,
        query: query,
        remove: remove
      };


    });


})();