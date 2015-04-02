<%-- 
    Document   : home
    Created on : Nov 22, 2014, 1:21:28 PM
    Author     : dubem
--%>

<!DOCTYPE html>
<!-- 
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <meta charset="utf-8" />
   <title>Scribbles Admin</title>
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <meta name="MobileOptimized" content="320">
   <!-- BEGIN GLOBAL MANDATORY STYLES -->          
   <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
   <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
   <link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
   <!-- END GLOBAL MANDATORY STYLES -->
   <!-- BEGIN PAGE LEVEL PLUGIN STYLES --> 
   <link href="assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
   <link href="assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css" />
   <link href="assets/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
   <link href="assets/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
   <link href="assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css"/>
   <!-- END PAGE LEVEL PLUGIN STYLES -->
   <!-- BEGIN THEME STYLES --> 
   <link href="assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
   <link href="assets/css/style.css" rel="stylesheet" type="text/css"/>
   <link href="assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
   <link href="assets/css/plugins.css" rel="stylesheet" type="text/css"/>
   <link href="assets/css/pages/tasks.css" rel="stylesheet" type="text/css"/>
   <link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
   <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
   <link href="assets/css/dubic.css" rel="stylesheet" type="text/css"/>
   <link href="resources/css/datatables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
   <!-- END THEME STYLES -->
   <link rel="shortcut icon" href="favicon.ico" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed" ng-app="app">
   <!-- BEGIN HEADER -->   
   <%@include file="include/header.jsp" %>
   <!-- END HEADER -->
   <div class="clearfix"></div>
   <!-- BEGIN CONTAINER -->
   <div class="page-container">
      <!-- BEGIN SIDEBAR -->
      <%@include file="include/sidebar.jsp" %>
      <!-- END SIDEBAR -->
      <!-- BEGIN PAGE -->
      <div id="page-notif" style="top:142px" >

            <div style="text-align: center" class="margin-bottom-10">
                <div style="display: inline-block;background: #b9cbd5;padding: 15px;box-shadow: 0px 2px 35px 2px #263138;" ng-show="loading" ng-bind="loadingMsg"></div>
            </div>
            <div style="text-align: center">
                <div style="display: inline-block;background: #b9cbd5;padding: 15px;box-shadow: 0px 2px 35px 2px #263138;" ng-show="notif" ng-bind="notif"></div>
            </div>
        </div>
      <div class="page-content">
         <!-- BEGIN PAGE HEADER-->
         <!-- END PAGE HEADER-->
         <div ui-view></div>
      </div>
      <!-- END PAGE -->
   </div>
   <!-- END CONTAINER -->
   <!-- BEGIN FOOTER -->
   <div class="footer">
<!--      <div class="footer-inner">
         2013 &copy; Metronic by keenthemes.
      </div>
      <div class="footer-tools">
         <span class="go-top">
         <i class="icon-angle-up"></i>
         </span>
      </div>-->
   </div>
   <!-- END FOOTER -->
   <script src="assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
   <script src="assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>   
   <!-- IMPORTANT! Load jquery-ui-1.10.3.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
   <script src="assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
   <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
   <script src="assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript" ></script>
   <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
   <script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>  
   <script src="assets/plugins/jquery.cookie.min.js" type="text/javascript"></script>
   <script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript" ></script>
   <script src="assets/plugins/highcharts.js" type="text/javascript" ></script>
   <!-- END CORE PLUGINS -->
   <!-- BEGIN PAGE LEVEL PLUGINS -->  
   <script src="assets/plugins/jquery.pulsate.min.js" type="text/javascript"></script>   
   <script src="assets/plugins/gritter/js/jquery.gritter.js" type="text/javascript"></script> 
   <!-- END PAGE LEVEL PLUGINS -->
   <!-- BEGIN PAGE LEVEL SCRIPTS -->
   <script src="assets/scripts/app.js" type="text/javascript"></script>
   <script src="resources/js/jquery.datatables.min.10.2.js" type="text/javascript"></script>
   <script src="resources/js/angular.min.js" type="text/javascript"></script>
   <script src="resources/js/angular-animate.min.js" type="text/javascript"></script>
   <script src="resources/js/angular-ui-router.min.js" type="text/javascript"></script>
   <script src="resources/js/home/app.js" type="text/javascript"></script>
   <script src="resources/js/home/services.js" type="text/javascript"></script>
   <script src="resources/js/home/controllers/dashboard-ctrl.js" type="text/javascript"></script>
   <script src="resources/js/home/controllers/users-ctrl.js" type="text/javascript"></script>
   <script src="resources/js/home/controllers/tokens-ctrl.js" type="text/javascript"></script>
   <script src="resources/js/directives/match.js" type="text/javascript"></script>
   <script src="resources/js/directives/ngRemoteValidate.js" type="text/javascript"></script>
   <script src="resources/js/directives/ui-bootstrap-tpls-0.11.0.min.js" type="text/javascript"></script>
   <script src="resources/js/home.js" type="text/javascript"></script>
   
   <!-- END PAGE LEVEL SCRIPTS -->  
   <script>
      jQuery(document).ready(function() {    
         App.init(); // initlayout and core plugins
      });
   </script>
   <!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
