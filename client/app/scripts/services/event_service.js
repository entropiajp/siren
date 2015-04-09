(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Event', function($resource, API_URL, $upload){
      var Resource = $resource(API_URL + '/event/:id', {id: '@id'},{
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

      var remove = function() {

      };

      var findManaged = function() {
        return $resource(API_URL + '/event/managed').query();
      };

      var findJoined = function() {
        return $resource(API_URL + '/event/joined').query();
      };

      var findFuture = function() {
        return $resource(API_URL + '/event/future').query();
      };

      var findPast = function() {
        return $resource(API_URL + '/event/past').query();
      };

      var isManager = function(id) {
        return $resource(API_URL + '/event/:id/is-manager').get({id: id}).$promise;
      };

      var uploadFile = function(files, eventId) {
        return $upload.upload({
          url: API_URL + '/event/' + eventId + '/image',
          file: files[0]
        });
      };

      return {
        find: find,
        save: save,
        update: update,
        query: query,
        remove: remove,
        findManaged: findManaged,
        findJoined: findJoined,
        findFuture: findFuture,
        findPast: findPast,
        isManager: isManager,
        uploadFile: uploadFile
      };


    });


})();