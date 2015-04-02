/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

controllers.controller('dashCtrl',function($scope, $http, homeServices,mainPath) {
        $http.get(mainPath + 'users/stats').success(function(resp) {
        $scope.userscount = resp.all;
    });
        $http.get(mainPath + 'tokens/stats').success(function(resp) {
        $scope.tokenscount = resp.active;
    });

    });
