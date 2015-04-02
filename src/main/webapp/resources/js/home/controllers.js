/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */





controllers.controller('containerCtrl', ['$scope', '$http', 'homeServices', '$route', function($scope, $http, homeServices, $route) {


    }]);
controllers.controller('RootController', ['$scope', '$http', 'homeServices', '$route', function($scope, $http, homeServices, $route) {
        $scope.$on("$routeChangeSuccess", function(event, currentRoute, previousRoute) {
            //Change page title, based on Route information
            console.log(currentRoute);
//            console.log("title - "+$route.current.title);
//    $rootScope.title = $route.current.title;
        });

    }]);


controllers.controller('HomeController', ['$scope', '$http', function($scope, $http) {

    }]);
  