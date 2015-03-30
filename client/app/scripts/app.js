(function(){
  'use strict';

  angular
    .module('clientApp', [
      'ngAnimate',
      'ngCookies',
      'ngResource',
      'ngSanitize',
      'ngTouch',
      'ui.bootstrap',
      'ui.router',
      'oitozero.ngSweetAlert',
      'angular-loading-bar'
    ])
    .config(function ($stateProvider, $httpProvider, $urlRouterProvider) {
      $stateProvider
        .state("new", {
          url: "/event/new",
          templateUrl: "views/new_event.html",
          controller: "NewEventController"
        })
        .state("portal", {
          url: "/portal",
          templateUrl: "views/portal.html",
          controller: "PortalController"
        })
        .state("login", {
          url: "/login",
          templateUrl: "views/login.html",
          controller: "LoginController"
        })
        .state("event", {
          url: "/event/:eventId",
          templateUrl: "views/event.html",
          controller: "EventController"
        })
        .state("edit_event", {
          url: "/event/:eventId/edit",
          templateUrl: "views/edit_event.html",
          controller: "EditEventController"
        })
        .state("edit_candidate", {
          url: "/event/:eventId/candidate/edit",
          templateUrl: "views/edit_candidate.html",
          controller: "CandidateController"
        })
        .state("edit_members", {
          url: "/event/:eventId/member/edit",
          templateUrl: "views/edit_members.html",
          controller: "MemberController"
        })
        .state("new_tune", {
          url: "/tune/new",
          templateUrl: "views/new_tune.html",
          controller: "NewTuneController"
        })
        .state("help", {
          url: "/help",
          templateUrl: "views/help.html"
        });

      $urlRouterProvider.otherwise('/portal');

      // サーバ側でajax通信を判定するためのheader追加
      $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

      // CookieのセッションIDをすべてのリクエストに付与するための設定
      $httpProvider.defaults.withCredentials = true;

      // ログインしていなければログインページヘ強制遷移させるinterceptor
      $httpProvider.interceptors.push(function ($q, $rootScope, $location) {
          return {
            'responseError': function(response) {
              if (response.status === 401) {
                $location.path('/login');
              }
              return $q.reject(response);
            }
          };
        }
      );
    });
})();
