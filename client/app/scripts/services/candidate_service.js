(function () {
  'use strict';

  angular.module('clientApp')
    .factory('Candidate', function($resource){
      var Resource = $resource('http://localhost:8081/candidate/:eventId', {eventId: '@eventId'},{
        update: {method: 'PUT'},
        saveAfterDelete: {method: 'POST', params:{eventId: '@eventId'}, isArray: true}
      });

      var saveAfterDelete = function(eventId, entities) {
        return Resource.saveAfterDelete({eventId: eventId}, entities).$promise;
      };

      var findAll = function() {
        return Resource.query().$promise;
      };

      return {
        findAll: findAll,
        saveAfterDelete: saveAfterDelete
      };


    });


})();