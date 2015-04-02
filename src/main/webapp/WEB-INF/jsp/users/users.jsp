<%-- 
    Document   : users
    Created on : Nov 22, 2014, 12:41:30 PM
    Author     : dubem
--%>
<%@taglib prefix="d" uri="/WEB-INF/tld/dubic.tld" %>

<div class="row">
    <div class="col-md-3">
        <div class="dashboard-stat green">
            <div class="visual"><i class="icon-user"></i></div>
            <div class="details">
                <div class="number"  ng-bind="allcount| number"></div>
                <div class="desc">All Users</div>
            </div>
        </div>
    </div>
    <div class="col-md-3">
        <div class="dashboard-stat green">
            <div class="visual"><i class="icon-user"></i></div>
            <div class="details">
                <div class="number" ng-bind="activecount| number"></div>
                <div class="desc">Active</div>
            </div>
        </div>
    </div>
    <!--===============================================================-->
    <!--CHARTS-->

    <div class="row">
        <div class="col-md-10">
            Month: 
            <select ng-model="chartMonth" ng-change="userReg()">
                <option ng-repeat="m in months" value="{{$index}}" ng-bind="m"></option> 
            </select>
            <div id="reg-chart" class="chart-block"></div>
            <!--<button class="btn" onclick="usersChart('/scribbles-admin/users/reg/chart')">test</button>-->
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="block-fluid table-sorting clearfix">
                <div class="dataTables_wrapper form-inline">
                    <div class="row">
                        <div class="col-md-6 col-sm-12">
                            <label>
                                <select select2 ng-model="usersTable.size" ng-change="loadUserstable()">
                                    <option ng-repeat="p in usersTable.pages" value="{{p}}">{{p}}</option>
                                </select>
                                records</label>
                        </div>
                        <div class="col-md-12 col-sm-12">
                            <div id="adminTable_filter" class="dataTables_filter">
                                <label>Search: <input type="text" class="form-control input-small" ng-model="usersTable.filter" ng-change="loadUserstable()"></label>
                            </div>
                        </div>
                    </div>
                    <div class="dataTables_processing" ng-show="usersTable.pending">Processing...</div>

                    <table style="width: 100%;" class="table table-condensed table-striped table-bordered table-hover table-full-width dataTable" width="100%" cellpadding="0" cellspacing="0">
                        <thead>
                            <tr role="row">
                                <th ng-repeat="col in usersTable.columns" class="{{col.class}}" ng-click="usersTable.sort($index)">{{col.label}}</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr ng-repeat="u in users">
                                <td>{{u[0]}}</td>
                                <td><a href="" ng-click="openProfile($index)">{{u[1]}}</a></td>
                                <td ng-class="{'bg-red':u[2]==='false'}">{{u[2]}}</td>
                                <td>{{u[3]}}</td>
                                <td>{{u[4]}}</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col-md-5 col-sm-12">
                            <div class="dataTables_info" ng-hide="usersTable.pending">Showing {{usersTable.start + 1}} to {{usersTable.start + usersTable.fetched}} of {{usersTable.total}} entries</div>
                        </div>
                        <div class="col-md-7 col-sm-12">
                            <div id="adminTable_paginate" class="dataTables_paginate paging_two_button" ng-hide="usersTable.pending">
                                <pagination max-size="5" boundary-links="true" total-items="usersTable.total" ng-model="usersTable.page" items-per-page="usersTable.size" ng-change="usersTable.pageChanged()" class="pagination-sm" previous-text="&lsaquo;" next-text="&rsaquo;" first-text="&laquo;" last-text="&raquo;"></pagination>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="user-profile.jsp"/>

