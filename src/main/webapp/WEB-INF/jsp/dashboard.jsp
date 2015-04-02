<%-- 
    Document   : dashboard
    Created on : Nov 22, 2014, 11:25:00 AM
    Author     : dubem
--%>




<div class="row">
    <div class="col-md-3">
        <div class="dashboard-stat blue">
            <div class="visual"><i class="icon-user"></i></div>
            <div class="details">
                <div class="number" ng-bind="userscount"></div>
                <div class="desc">Users</div>
            </div><a class="more" href="#/users">View more <i class="m-icon-swapright m-icon-white"></i></a></div>
    </div>
    <div class="col-md-3">
        <div class="dashboard-stat blue">
            <div class="visual"><i class="icon-lock"></i></div>
            <div class="details">
                <div class="number" ng-bind="tokenscount"></div>
                <div class="desc">Active Tokens</div>
            </div><a class="more" href="#/tokens">View more <i class="m-icon-swapright m-icon-white"></i></a></div>
    </div>
</div>

