<%-- 
    Document   : user-profile
    Created on : Feb 6, 2015, 5:27:52 PM
    Author     : dubem
--%>

<!--LOGIN MODAL BOX-->
<div class="modal fade"  id="profileModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
    <div class="modal-dialog" style="min-width: 40%">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title" id="myModalLabel" ng-bind="selectedUser[0]"> </h4>
            </div>

            <div class="modal-body">
                <div class="loading-screen"  ng-show="loadingProfile"></div>
                <div  ng-hide="loadingProfile">
                    <div ng-repeat="a in repAlerts" class="alert {{a.class}}">{{a.msg}}</div>
                    <div>
                        <img src="http://localhost:7070/scribbleit/posts/img/{{selectedUser.picture}}" width="80" height="100"/>
                    </div>
                    <dl class="dl-horizontal">
                        <dt>Screen Name</dt><dd ng-bind="selectedUser.screenName"></dd>
                        <dt>email</dt><dd ng-bind="selectedUser.email"></dd>
                        <dt>jokes</dt><dd ng-bind="selectedUser.jokes | number"></dd>
                        <dt>proverbs</dt><dd ng-bind="selectedUser.proverbs | number"></dd>
                        <dt>quotes</dt><dd ng-bind="selectedUser.quotes | number"></dd>
                        <dt>profile updated</dt><dd ng-bind="selectedUser.updated"></dd>
                    </dl>
                    <div class="actions">
                        <button class="btn btn-default btn-sm">Activate</button>
                        <button class="btn btn-danger btn-sm">Block</button>
                    </div>
                </div>
            </div>
            <!--                <div class="modal-footer">
                                <button type="button" class="btn btn-warning btn-sm" data-dismiss="modal">cancel</button>
                                <button class="btn btn-info btn-sm" ng-disabled="selectedJoke.reporting" ng-click="report()">
                                    <span ng-hide="selectedJoke.reporting">submit</span>
                                    <span ng-show="selectedJoke.reporting">saving</span>
                                </button>
                            </div>-->

        </div>
    </div>
</div>
<!--END OF LOGIN MODAL BOX-->
