<%-- 
    Document   : sidebar
    Created on : Nov 22, 2014, 12:00:46 PM
    Author     : dubem
--%>
<!-- BEGIN SIDEBAR -->
    <div class="page-sidebar navbar-collapse collapse">
        <!-- BEGIN SIDEBAR MENU -->        
        <ul class="page-sidebar-menu">
            <li>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
                <div class="sidebar-toggler hidden-phone"></div>
                <!-- BEGIN SIDEBAR TOGGLER BUTTON -->
            </li>
            <li>
                <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
                <form class="sidebar-search" action="extra_search.html" method="POST">
                    <div class="form-container">
                        <div class="input-box">
                            <a href="javascript:;" class="remove"></a>
                            <input type="text" placeholder="Search..."/>
                            <input type="button" class="submit" value=" "/>
                        </div>
                    </div>
                </form>
                <!-- END RESPONSIVE QUICK SEARCH FORM -->
            </li>
            <li class="start ">
                <a href="#/dashboard">
                    <i class="icon-home"></i> 
                    <span class="title">Dashboard</span>
                </a>
            </li>
            <li>
                <a href="users">
                    <i class="icon-user"></i> 
                    <span class="title">Users</span>
                    <span class="arrow "></span>
                </a>
                <ul class="sub-menu">
                    <li >
                        <a href="#/users">Users</a>
                    </li>
                    <li >
                        <a href="#/tokens">Tokens</a>
                    </li>
                </ul>
            </li>
            
            <li>
                <a href="/scribbles-admin/posts/jokes.jsf">
                    <i class="icon-user"></i> 
                    <span class="title">Posts</span>
                    <span class="arrow "></span>
                </a>
                <ul class="sub-menu">
                    <li >
                        <a href="/scribbles-admin/users/users.jsf">Jokes</a>
                    </li>
                </ul>
            </li>
            
            <li>
                <a href="/scribbles-admin/posts/jokes.jsf">
                    <i class="icon-user"></i> 
                    <span class="title">Application</span>
                    <span class="arrow "></span>
                </a>
                <ul class="sub-menu">
                    <li >
                        <a href="/scribbles-admin/application/errors.jsf">Jokes</a>
                    </li>
                </ul>
            </li>

        </ul>
        <!-- END SIDEBAR MENU -->
    </div>
    <!-- END SIDEBAR -->