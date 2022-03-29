<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>Admin</title>
    <meta content="Responsive admin theme build on top of Bootstrap 4" name="description" />
    <meta content="Themesdesign" name="author" />
    <link rel="shortcut icon" href="<c:url value="resources/assets/images/favicon.ico"/>">

    <link href="<c:url value="resources/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css"/>" rel="stylesheet">

    <!-- DataTables -->
    <link href="<c:url value="resources/plugins/datatables/dataTables.bootstrap4.min.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="resources/plugins/datatables/buttons.bootstrap4.min.css"/>" rel="stylesheet" type="text/css" />

    <!-- Responsive datatable examples -->
    <link href="<c:url value="resources/plugins/datatables/responsive.bootstrap4.min.css"/>" rel="stylesheet" type="text/css" />

    <link href="<c:url value="resources/assets/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="resources/assets/css/metismenu.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="resources/assets/css/icons.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="resources/assets/css/style.css"/>" rel="stylesheet" type="text/css">

</head>

<body>

    <!-- Begin page -->
    <div id="wrapper">

        <!-- Top Bar Start -->
        <div class="topbar">

            <!-- LOGO -->
            <div class="topbar-left">
                <a href="index.html" class="logo">
                    <img src="<c:url value="resources/assets/images/logo-light.png"/>" class="logo-lg" alt="" height="22">
                    <img src="<c:url value="resources/assets/images/logo-sm.png"/>" class="logo-sm" alt="" height="24">
                </a>
            </div>

            <!-- Search input -->
            <div class="search-wrap" id="search-wrap">
                <div class="search-bar">
                    <input class="search-input" type="search" placeholder="Search" />
                    <a href="#" class="close-search toggle-search" data-target="#search-wrap">
                        <i class="mdi mdi-close-circle"></i>
                    </a>
                </div>
            </div>

            <nav class="navbar-custom">
                <ul class="navbar-right list-inline float-right mb-0">


                 <!-- language-->
                    <li class="dropdown notification-list list-inline-item d-none d-md-inline-block">
                        <a class="nav-link dropdown-toggle arrow-none waves-effect" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                            <img src="<c:url value="resources/assets/images/flags/us_flag.jpg"/>" class="mr-2" height="12" alt="" /> English 
                        </a>
  </li>

                    <!-- full screen -->
                    <li class="dropdown notification-list list-inline-item d-none d-md-inline-block">
                        <a class="nav-link waves-effect" href="#" id="btn-fullscreen">
                            <i class="fas fa-expand noti-icon"></i>
                        </a>
                    </li>


                    <li class="dropdown notification-list list-inline-item">
                        <div class="dropdown notification-list nav-pro-img">
                            <a class="dropdown-toggle nav-link arrow-none waves-effect nav-user" data-toggle="dropdown" href="#" role="button" aria-haspopup="false" aria-expanded="false">
                                <img src="<c:url value="resources/assets/images/users/user-1.jpg"/>" alt="user" class="rounded-circle">
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-animated profile-dropdown">
                                <!-- item-->
                               <i class="mdi mdi-power text-danger"></i><a href="logout">Logout</a>
                            </div>
                        </div>
                    </li>

                </ul>

                <ul class="list-inline menu-left mb-0">
                    <li class="float-left">
                        <button class="button-menu-mobile open-left waves-effect">
                            <i class="mdi mdi-menu"></i>
                        </button>
                    </li>
                </ul>

            </nav>

        </div>
        <!-- Top Bar End -->

        <!-- ========== Left Sidebar Start ========== -->
        <div class="left side-menu">
            <div class="slimscroll-menu" id="remove-scroll">

                <!--- Sidemenu -->
                <div id="sidebar-menu">
                    <!-- Left Menu Start -->
                    <ul class="metismenu" id="side-menu">
                        <li class="menu-title">Menu</li>
                         <li>
                            <a href="dashboard" class="waves-effect">
                                <i class="dripicons-meter"></i> <span> Dashboard </span>
                            </a>
                        </li>

                       
                        <li>
                            <a href="admin-product" class="waves-effect"><span>Products</span></a>
                        </li>
						  <li>
                            <a href="admin-customer" class="waves-effect"><span>Customers</span></a>
                        </li>


                    </ul>

                </div>
                <!-- Sidebar -->
                <div class="clearfix"></div>

            </div>
            <!-- Sidebar -left -->

        </div>
        <!-- Left Sidebar End -->

        <!-- ============================================================== -->
        <!-- Start right Content here -->
        <!-- ============================================================== -->
        <div class="content-page">
            <!-- Start content -->
            <div class="content">

                <div class="container-fluid">
                    <div class="page-title-box">


                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <h4 class="mt-0 header-title" style="padding-top:10px;font-size:25px">Customers</h4>
									
									
							        

									
                                    <table id="datatable" class="table table-bordered dt-responsive nowrap" style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                                        <thead>
                                            <tr>
												<th>Name</th>
												
                                                <th>Email</th>
                                                <th>Mobile</th>
                                                <th>City</th>
                                                <th>Order Placed</th>
												<th>Action</th>
												
                                            </tr>
                                        </thead>

                                        <tbody>
                                        
                                        
                                        
                                        
                                        
                                        
                                        <c:forEach var="user" items="${users }" varStatus="loop">
                                        
                                            <tr>
                                                <td>${user.getName() }</td>
                                                <td>${user.getEmail() }</td>
                                                <td>${user.getMobile() }</td>
                                                <td>${user.address.getCity() }</td>
                                                <td>${count.get(loop.index)}</td>
												<td><a href="customers.html">Delete </a></td>
                                            </tr>
                                           
										</c:forEach>

											
                                        </tbody>
                                    </table>

                                </div>
                            </div>
                        </div>
                        <!-- end col -->
                    </div>
 
        </div>
        <!-- ============================================================== -->
        <!-- End Right content here -->
        <!-- ============================================================== -->

    </div>
    <!-- END wrapper -->

    <!-- jQuery  -->
    <script src="<c:url value="resources/assets/js/jquery.min.js"/>"></script>
    <script src="<c:url value="resources/assets/js/bootstrap.bundle.min.js"/>"></script>
    <script src="<c:url value="resources/assets/js/metismenu.min.js"/>"></script>
    <script src="<c:url value="resources/assets/js/jquery.slimscroll.js"/>"></script>
    <script src="<c:url value="resources/assets/js/waves.min.js"/>"></script>

    <script src="<c:url value="resources/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"/>"></script>

    <!-- Required datatable js -->
    <script src="<c:url value="resources/plugins/datatables/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/datatables/dataTables.bootstrap4.min.js"/>"></script>
    <!-- Buttons examples -->
    <script src="<c:url value="resources/plugins/datatables/dataTables.buttons.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/datatables/buttons.bootstrap4.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/datatables/jszip.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/datatables/pdfmake.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/datatables/vfs_fonts.js"/>"></script>
    <script src="<c:url value="resources/plugins/datatables/buttons.html5.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/datatables/buttons.print.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/datatables/buttons.colVis.min.js"/>"></script>
    <!-- Responsive examples -->
    <script src="<c:url value="resources/plugins/datatables/dataTables.responsive.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/datatables/responsive.bootstrap4.min.js"/>"></script>

    <!-- Datatable init js -->
    <script src="<c:url value="resources/assets/pages/datatables.init.js"/>"></script>

    <!-- App js -->
    <script src="<c:url value="resources/assets/js/app.js"/>"></script>

</body>

</html>