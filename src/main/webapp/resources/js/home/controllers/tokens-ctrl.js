/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

controllers.controller('tokensCtrl', function($scope, $http, homeServices, mainPath) {

    $scope.months = 'JANUARY,FEBUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER'.split(',');
    $http.get(mainPath + 'tokens/stats').success(function(resp) {
//        $scope.allcount = resp.all;
        $scope.activecount = resp.active;
    });
    $scope.selectTokens = [];
    $scope.selectToken = function(index) {

        if ($scope.tokens[index].selected) {
            $scope.selectTokens.push($scope.tokens[index].id);
            console.log($scope.selectTokens);
        } else {
            $scope.selectTokens.splice($scope.selectTokens.indexOf($scope.tokens[index].id), 1);
            console.log($scope.selectTokens);
        }
    };
    $scope.checkAllFlag = false;
    $scope.selectAllTokens = function() {
        if ($scope.checkAllFlag) {
            for (var i = 0; i < $scope.tokens.length; i++) {
                $scope.tokens[i].selected = true;
                $scope.selectTokens.push($scope.tokens[i].id);
            }
        } else {
            for (var i = 0; i < $scope.tokens.length; i++) {
                $scope.tokens[i].selected = false;
                $scope.selectTokens.splice($scope.selectTokens.indexOf($scope.tokens[i].id), 1);
            }
        }
    };

    $scope.loadTokenstable = function() {
//        console.log($scope.Filter);
        var dt = {size: $scope.tokensTable.size, start: $scope.tokensTable.start, filter: $scope.tokensTable.filter, sortcol: $scope.tokensTable.sortcol, sortasc: $scope.tokensTable.sortasc, search: $scope.Filter};
        $http.post(mainPath + 'tokens/table', dt).success(function(resp) {

            $scope.tokensTable.update(resp.total, resp.tokens.length);
            $scope.tokens = resp.tokens;
            $scope.tokensTable.pending = false;
        });
    };

    $scope.tokensTable = homeServices.table($scope.loadTokenstable);
    $scope.tokensTable.columns = [
        {label: 'Token', sorting: true},
        {label: 'User', sorting: true},
        {label: 'Active', sorting: true},
        {label: 'Type', sorting: true},
        {label: 'Create Date', sorting: true, sort: 'desc'},
        {label: 'Expiry Date', sorting: true},
        {label: 'Used Date', sorting: true}
    ];
    $scope.tokensTable.init();
    $scope.tokensTable.size = $scope.tokensTable.pages[0];

});
