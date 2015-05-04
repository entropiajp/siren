(function () {
  'use strict';

  angular.module('clientApp').
    directive('bars', function ($parse) {
      return {
        scope: {
          data: '='
        },
        restrict: 'E',
        replace: true,
        template: '<div id="chart" style="margin-bottom: 16px"></div>',
        link: function (scope, element, attrs) {
          scope.$watch('data', function(newVal) {
            if(newVal) {
              var data = newVal;
              var maxCount = Math.max.apply([], data.map(function(e){return e.count}));
              console.log(maxCount);
              var chart = d3.select('#chart')
                .append("div").attr("class", "chart")
                .selectAll('div')
                .data(data).enter()
                .append("div")
                .style("width", function(d) { return d.count*98/maxCount + "%"; })
                .text(function(d) { return d.name + ' (' + d.count + '票)'; });
            }
          }, true);

        }
      };
    }
  );

})();