(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Role', function($resource, API_URL){
      var Resource = $resource(API_URL + '/roles/:id', {id: '@id'},{
        update: {method: 'PUT'}
      });

      var find = function(id) {
        return Resource.get({id: id}).$promise;
      };

      var save = function(entity) {
        return Resource.save(entity).$promise;
      };

      var join = function(id, memberId) {
        return Resource.update({memberId: memberId}, {id: id}).$promise;
      };

      var cancel = function(id) {
        return $resource(API_URL + '/roles/:id/cancel', {id: '@id'}).save({id: id}).$promise;
      };

      var query = function() {
        return Resource.query().$promise;
      };

      var remove = function(entity) {
        return Resource.remove(entity).$promise;
      };

      var findMy = function(eventId) {
        return $resource(API_URL + '/roles/my').query({eventId: eventId});
      };

      return {
        find: find,
        save: save,
        join: join,
        query: query,
        remove: remove,
        cancel: cancel,
        findMy: findMy
      };


    });


})();