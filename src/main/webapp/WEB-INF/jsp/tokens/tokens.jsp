<%-- 
    Document   : tokens
    Created on : Feb 8, 2015, 10:42:50 AM
    Author     : dubem
--%>

<div>
    <div class="row">
<!--        <div class="col-md-3">
            <div class="dashboard-stat green">
                <div class="visual"><i class="icon-user"></i></div>
                <div class="details">
                    <div class="number"  ng-bind="allcount | number"></div>
                    <div class="desc">All Users</div>
                </div>
            </div>
        </div>-->
        <div class="col-md-3">
            <div class="dashboard-stat green">
                <div class="visual"><i class="icon-user"></i></div>
                <div class="details">
                    <div class="number" ng-bind="activecount | number"></div>
                    <div class="desc">Active</div>
                </div>
            </div>
        </div>
    </div>
    <!--===============================================================-->
    <div class="row">
        <div class="col-md-12">
            <button class="btn btn-default btn-sm" ng-show="selectTokens.length > 0">delete<i class="icon-trash"></i></button>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="block-fluid table-sorting clearfix">
                <div class="dataTables_wrapper form-inline">
                    <div class="row">
                        <div class="col-md-6 col-sm-12">
                            <label>
                                <select select2 ng-model="tokensTable.size" ng-change="loadTokenstable()">
                                    <option ng-repeat="p in tokensTable.pages" value="{{p}}">{{p}}</option>
                                </select>
                                records</label>
                        </div>
                        <div class="col-md-12 col-sm-12">
                            <div id="adminTable_filter" class="dataTables_filter">
                                <label>Search: <input type="text" class="form-control input-small" ng-model="tokensTable.filter" ng-change="loadTokenstable()"></label>
                            </div>
                        </div>
                    </div>
                    <div class="dataTables_processing" ng-show="tokensTable.pending">Processing...</div>

                    <table style="width: 100%;" class="table table-condensed table-striped table-bordered table-hover table-full-width dataTable" width="100%" cellpadding="0" cellspacing="0">
                        <thead>
                            <tr role="row">
                                <th><input type="checkbox" ng-model="checkAllFlag" ng-change="selectAllTokens()"/></th>
                                <th ng-repeat="col in tokensTable.columns" class="{{col.class}}" ng-click="tokensTable.sort($index)">{{col.label}}</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr ng-repeat="t in tokens">
                                <td><input type="checkbox" ng-model="t.selected" ng-change="selectToken($index)"/></td>
                                <td ng-bind="t.token"></td>
                                <td ng-bind="t.user"></td>
                                <td ng-class="{'bg-red':t.active === 'true'}" ng-bind="t.active"></td>
                                <td ng-bind="t.type"></td>
                                <td ng-bind="t.createDate"></td>
                                <td ng-bind="t.expDate"></td>
                                <td ng-bind="t.usedDate"></td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="row">
                        <div class="col-md-5 col-sm-12">
                            <div class="dataTables_info" ng-hide="tokensTable.pending">Showing {{tokensTable.start + 1}} to {{tokensTable.start + tokensTable.fetched}} of {{tokensTable.total}} entries</div>
                        </div>
                        <div class="col-md-7 col-sm-12">
                            <div id="adminTable_paginate" class="dataTables_paginate paging_two_button" ng-hide="tokensTable.pending">
                                <pagination max-size="5" boundary-links="true" total-items="tokensTable.total" ng-model="tokensTable.page" items-per-page="tokensTable.size" ng-change="tokensTable.pageChanged()" class="pagination-sm" previous-text="&lsaquo;" next-text="&rsaquo;" first-text="&laquo;" last-text="&raquo;"></pagination>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
