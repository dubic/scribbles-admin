/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

controllers.controller('usersCtrl', function($scope, $http, homeServices, mainPath) {
//    $scope.users = [
//        {name: 'dubic', email: 'd.u@gmail.com', active: 'true'},
//        {name: 'dubine', email: 'udubic@gmail.com', active: 'false'}
//    ];
    $scope.months = 'JANUARY,FEBUARY,MARCH,APRIL,MAY,JUNE,JULY,AUGUST,SEPTEMBER,OCTOBER,NOVEMBER,DECEMBER'.split(',');
    $http.get(mainPath + 'users/stats').success(function(resp) {
        $scope.allcount = resp.all;
        $scope.activecount = resp.active;
    });
    
    $scope.openProfile = function(index) {
        $scope.loadingProfile = true;
        homeServices.openDialog('profileModal');
        $http.get(mainPath + 'users/profile?id='+$scope.users[index][0]).success(function(resp) {
            $scope.selectedUser = resp;
            $scope.loadingProfile = false;
        });
    };

    $scope.loadUserstable = function() {
        console.log($scope.Filter);
        var dt = {size: $scope.usersTable.size, start: $scope.usersTable.start, filter: $scope.usersTable.filter, sortcol: $scope.usersTable.sortcol, sortasc: $scope.usersTable.sortasc, search: $scope.Filter};
        $http.post(mainPath + 'users/table', dt).success(function(resp) {

            $scope.usersTable.update(resp.total, resp.users.length);
            $scope.users = resp.users;
            $scope.usersTable.pending = false;
        });
    };

    $scope.usersTable = homeServices.table($scope.loadUserstable);
    $scope.usersTable.columns = [
        {label: 'ID', sorting: true},
        {label: 'Name', sorting: true},
        {label: 'Active', sorting: true},
        {label: 'Last Login', sorting: true},
        {label: 'Create Date', sorting: true, sort: 'desc'}
    ];
    $scope.usersTable.init();
    $scope.usersTable.size = $scope.usersTable.pages[0];


    //////////////CHART///////////////////////
    $scope.chartMonth = -1;
    $scope.userReg = function() {
        $http.get(mainPath + 'users/chart?m='+$scope.chartMonth).success(function(resp) {
            $scope.chartMonth = resp.month;
            $('#reg-chart').highcharts({
                title: {text: 'Users - '+$scope.months[resp.month], x: -20},
                xAxis: {categories: resp.categories},
                yAxis: {min: 0, title: {text: 'Amount (N)'}, plotLines: [{value: 0, width: 1, color: '#808080'}]},
//            tooltip: {valueSuffix: 'N'},
                legend: {layout: 'vertical', align: 'right', verticalAlign: 'middle', borderWidth: 0},
                series: [{name: 'users', data: resp.data}]
            });
        });
    };
    $scope.userReg();
});
