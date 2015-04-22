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
      'config',
      'nvd3',
      'angularFileUpload',
      'ui.sortable'
    ])
    .config(function ($stateProvider, $httpProvider, $urlRouterProvider) {
      $stateProvider
        .state("login", {
          url: "/login",
          templateUrl: "views/login.html",
          controller: "LoginController"
        })
        .state("private", {
          templateUrl: "views/includes/private.html",
          controller: "HeaderController",
          resolve: { user: authenticate }
        })
        .state("private.portal", {
          url: "/portal",
          views: {
            'content': {
              templateUrl: "views/portal.html",
              controller: "PortalController"
            }
          }
        })
        .state("private.help", {
          url: "/help",
          views: {
            'content': {
              templateUrl: "views/help.html",
              controller: "HelpController"
            }
          }
        })
        .state("private.new_tune", {
          url: "/tune/new",
          views: {
            'content': {
              templateUrl: "views/new_tune.html",
              controller: "NewTuneController"
            }
          }
        })
        .state("private.new", {
          url: "/event/new",
          views: {
            'content': {
              templateUrl: "views/new_event.html",
              controller: "NewEventController"
            }
          }
        })
        .state("private.event", {
          url: "/event/:eventId",
          views: {
            'content': {
              templateUrl: "views/event.html",
              controller: "EventController"
            }
          }
        })
        .state("private.edit_event", {
          url: "/event/:eventId/edit",
          views: {
            'content': {
              templateUrl: "views/edit_event.html",
              controller: "EditEventController"
            }
          },
          resolve: {
            manager: manager
          }
        })
        .state("private.edit_members", {
          url: "/event/:eventId/member/edit",
          views: {
            'content': {
              templateUrl: "views/edit_members.html",
              controller: "MemberController"
            }
          },
          resolve: {
            manager: manager
          }
        })
        .state("private.edit_enquete", {
          url: "/event/:eventId/enquete/edit",
          views: {
            'content': {
              templateUrl: "views/edit_enquete.html",
              controller: "EditEnqueteController"
            }
          },
          resolve: {
            manager: manager
          }
        })
        .state("private.vote", {
          url: "/event/:eventId/vote",
          views: {
            'content': {
              templateUrl: "views/vote.html",
              controller: "VoteController"
            }
          },
          resolve: {
            my: member
          }
        })
        .state("private.event_my", {
          url: "/event/:eventId/my",
          views: {
            'content': {
              templateUrl: "views/event_my.html",
              controller: "EventMyController"
            }
          },
          resolve: {
            my: member
          }
        })
        .state("private.entry", {
          url: "/event/:eventId/entry",
          views: {
            'content': {
              templateUrl: "views/entry.html",
              controller: "EntryController"
            }
          },
          resolve: {
            my: member
          }
        });

      function authenticate(UtilService) {
        return UtilService.findUser();
      }

      function manager(Event, $stateParams) {
        return Event.isManager($stateParams.eventId);
      }

      function member(Member, $stateParams) {
        var data = Member.findMy($stateParams.eventId);
        data.startTime = new Date(data.startTime);
        data.endTime = new Date(data.endTime);
        return data;
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
          var msg = (error.data.message != null) ? error.data.message : 'エラーが発生しました';
          globalAlert.set({type: 'error', msg: msg});
          $state.go('private.portal');
          e.preventDefault();
        }
      });
    });
})();
