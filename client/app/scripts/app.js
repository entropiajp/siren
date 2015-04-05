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
      'angular-loading-bar',
      'autocomplete',
      'config',
      'nvd3',
      'angularFileUpload'
    ])
    .config(function ($stateProvider, $httpProvider, $urlRouterProvider) {
      $stateProvider
        .state("new", {
          url: "/event/new",
          templateUrl: "views/new_event.html",
          controller: "NewEventController",
          resolve: { user: authenticate }
        })
        .state("portal", {
          url: "/portal",
          templateUrl: "views/portal.html",
          controller: "PortalController",
          resolve: { user: authenticate }
        })
        .state("login", {
          url: "/login",
          templateUrl: "views/login.html",
          controller: "LoginController"
        })
        .state("event", {
          url: "/event/:eventId",
          templateUrl: "views/event.html",
          controller: "EventController",
          resolve: { user: authenticate }
        })
        .state("edit_event", {
          url: "/event/:eventId/edit",
          templateUrl: "views/edit_event.html",
          controller: "EditEventController",
          resolve: {
            user: authenticate,
            authorize: authorize
          }
        })
        .state("edit_members", {
          url: "/event/:eventId/member/edit",
          templateUrl: "views/edit_members.html",
          controller: "MemberController",
          resolve: {
            user: authenticate,
            authorize: authorize
          }
        })
        .state("new_tune", {
          url: "/tune/new",
          templateUrl: "views/new_tune.html",
          controller: "NewTuneController",
          resolve: { user: authenticate }
        })
        .state("help", {
          url: "/help",
          templateUrl: "views/help.html",
          controller: "HelpController",
          resolve: { user: authenticate }
        })
        .state("edit_enquete", {
          url: "/event/:eventId/enquete/edit",
          templateUrl: "views/edit_enquete.html",
          controller: "EditEnqueteController",
          resolve: {
            user: authenticate,
            authorize: authorize
          }
        })
        .state("vote", {
          url: "/event/:eventId/vote",
          templateUrl: "views/vote.html",
          controller: "VoteController",
          resolve: { user: authenticate }
        });

      function authenticate(UtilService) {
        return UtilService.findUser();
      }

      function authorize(Event, $stateParams) {
        return Event.isManager($stateParams.eventId);
      }

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
              if (response.status === 0) {
                $location.path('/login');
              }
              return $q.reject(response);
            }
          };
        }
      );
    })
    .run(function ($rootScope, $state, globalAlert) {
      $rootScope.$on('$stateChangeError', function(e, toState, toParams, fromState, fromParams, error) {
        console.log(e, toState, toParams, fromState, fromParams, error);
        // 認証チェック
        if(error.status === 401) {
          $state.go('login');
          e.preventDefault();
        }
        // 認可チェック
        if(error.status === 403) {
          globalAlert.set({type: 'error', msg: '管理者のみ許可されたページです'});
          $state.go('portal');
          e.preventDefault();
        }
      });
    });
})();
