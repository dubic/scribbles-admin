/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('app', ['ui.router', 'remoteValidation','ngAnimate', 'InputMatch', 'ui.bootstrap', 'controllers']);
app.constant("mainPath", "/scribbles-admin/");
app.constant("spinner", "/scribbles-admin/resources/img/spinner.gif");

var controllers = angular.module('controllers', []);

app.config(function($stateProvider, $urlRouterProvider) {
    $stateProvider.
            state('dashboard', {
                url: '/dashboard',
                templateUrl: 'dashboard',
                controller: 'dashCtrl',
                data:{displayName:''}
            }).
            state('users', {
                url: '/users',
                templateUrl: 'users/page?p=users',
                controller: 'usersCtrl',
                data:{displayName:'Users'}
            }).
            state('tokens', {
                url: '/tokens',
                templateUrl: 'tokens/page?p=tokens',
                controller: 'tokensCtrl',
                data:{displayName:''}
            }).
            state('home', {
                url: '/home',
                templateUrl: '/scribbleit/home',
                controller: 'mainCtrl',
                data:{displayName:'home'}
            }).
            state('home.jokes', {
                url: '/jokes',
                templateUrl: '/scribbleit/posts/load?page=jokes',
                controller: 'jokesCtrl',
                data:{displayName:'Jokes'}
            }).            
            state('home.proverbs', {
                url: '/proverbs',
                templateUrl: '/scribbleit/posts/load?page=proverbs',
                controller: 'provCtrl',
                data:{displayName:'Proverbs'}
            }).            
            state('home.quotes', {
                url: '/quotes',
                templateUrl: '/scribbleit/posts/load?page=quotes',
                controller: 'quotesCtrl',
                data:{displayName:'Quotes'}
            }).            
            state('profile', {
                url: '/profile/{user}',
                templateUrl: '/scribbleit/profile/home',
                controller: 'profileCtrl',
                data:{displayName:'profile'}
            }).
            state('profile.activity', {
//                url: '/profile/activity',
                templateUrl: '/scribbleit/profile/activity',
                controller: 'activityCtrl',
                data:{displayName:'profile activity'}
            }).
            state('profile.account', {
                templateUrl: '/scribbleit/profile/account',
                controller: 'accountCtrl',
                data:{displayName:'profile account'}
            }).
            state('profile.pword', {
                templateUrl: '/scribbleit/profile/pword',
                controller: 'pwordCtrl',
                data:{displayName:'change password'}
            });

//    $urlRouterProvider.when('/profile','/home/jokes');
    $urlRouterProvider.otherwise('/dashboard');

//      $locationProvider.html5Mode(true);
});

app.run(function($rootScope, $state, $window) {
    
    $rootScope.navigate = function(state,params) {
        $state.go(state, params, {location: false});
    };
    $rootScope.route = function(state) {
        $state.go(state);
    };
    $rootScope.back = function() {
        $window.history.back();
    };

    $rootScope.alerts = [];
    $rootScope.$on('$stateChangeStart', function(e, to) {
        $rootScope.loading = true;
        $rootScope.loadingMsg = 'Loading '+to.data.displayName+'...';
        console.log('name - ' + to.name);
    });
    $rootScope.$on('$stateChangeSuccess', function(e, to) {
        $rootScope.loading = false;
        $rootScope.activePage = to.name;
    });
});

console.log("angular configured");
//  $rootScope.$on("$routeChangeSuccess", function(currentRoute, previousRoute){
//    //Change page title, based on Route information
//    console.log("$route.current.title");
////    $rootScope.title = $route.current.title;
//  });
