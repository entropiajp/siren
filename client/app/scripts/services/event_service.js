(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Event', function($resource, API_URL, $upload){
      var Resource = $resource(API_URL + '/events/:id', {id: '@id'},{
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

      var remove = function(id) {
        return Resource.remove({id: id}).$promise;
      };

      var findManaged = function() {
        return $resource(API_URL + '/events/managed').query();
      };

      var findJoined = function() {
        return $resource(API_URL + '/events/joined').query();
      };

      var isManager = function(id) {
        return $resource(API_URL + '/events/:id/is-manager').get({id: id}).$promise;
      };

      var isMember = function(id) {
        return $resource(API_URL + '/events/:id/is-member').get({id: id}).$promise;
      };

      var endJoin = function(id) {
        return $resource(API_URL + '/events/:id/end-join', {id: '@id'}).save({id: id}).$promise;
      };

      var uploadFile = function(files, eventId) {
        return $upload.upload({
          url: API_URL + '/events/' + eventId + '/image',
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
        isManager: isManager,
        isMember: isMember,
        uploadFile: uploadFile,
        endJoin: endJoin
      };


    });


})();