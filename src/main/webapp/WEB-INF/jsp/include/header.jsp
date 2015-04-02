<%-- 
    Document   : header
    Created on : Sep 11, 2014, 5:12:50 PM
    Author     : dubem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib prefix="d" uri="/WEB-INF/tlds/dubic.tld" %>--%>
<!DOCTYPE html>
<html>
    <header>

        <div class="header navbar navbar-inverse navbar-fixed-top">
            <!-- BEGIN TOP NAVIGATION BAR -->
            <div class="header-inner">
                <!-- BEGIN LOGO -->  
                <a class="navbar-brand" href="home.jsf">
                    <!--<img src="assets/img/logo.png" alt="Scribbles" class="img-responsive">-->
                    <!--Scribbles-->
                </a>
                <!-- END LOGO -->

                
                <!--<a class="navbar-brand pull-right" data-toggle="modal" data-target="#loginModal" href="#">Login</a>-->
                <!-- BEGIN TOP NAVIGATION MENU -->
                <div>
                    <ul class="nav navbar-nav pull-right">
                        <!-- BEGIN USER LOGIN DROPDOWN -->
                        <li class="dropdown user">
                            <a href="#loginModal" class="dropdown-toggle" data-toggle="dropdown" data-click="dropdown" data-close-others="true">
                                <img alt="" src="/scribbleit/posts/img/male" width="29" height="29">
                                <span class="username">Bob Nilson</span>
                                <i class="icon-angle-down"></i>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="extra_profile.html"><i class="icon-user"></i> My Profile</a></li>
                                <li><a href="page_calendar.html"><i class="icon-calendar"></i> Logout</a></li>
                            </ul>
                        </li>
                        <!-- END USER LOGIN DROPDOWN -->
                    </ul>
                </div>
                <!-- END TOP NAVIGATION MENU -->
            </div>
            <!-- END TOP NAVIGATION BAR -->
        </div>
        <div class="clearfix"></div>

    </header>
</html>
