(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Event', function($resource){
      var Resource = $resource('http://localhost:8081/event/:id', {id: '@id'},{
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

      var remove = function() {

      };

      var findManaged = function() {
        return $resource('http://localhost:8081/event/managed').query().$promise;
      };

      var findJoined = function() {
        return $resource('http://localhost:8081/event/joined').query().$promise;
      };

      var findFuture = function() {
        return $resource('http://localhost:8081/event/future').query().$promise;
      };

      var findPast = function() {
        return $resource('http://localhost:8081/event/past').query().$promise;
      };

      return {
        find: find,
        save: save,
        update: update,
        remove: remove,
        findManaged: findManaged,
        findJoined: findJoined,
        findFuture: findFuture,
        findPast: findPast
      };


    });


})();