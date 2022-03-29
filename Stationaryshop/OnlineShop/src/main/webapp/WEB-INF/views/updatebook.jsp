<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page isELIgnored="false" %>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

         
         <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <title>Admin</title>
    <meta content="Responsive admin theme build on top of Bootstrap 4" name="description" />
    <meta content="Themesdesign" name="author" />
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <link href="../plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" rel="stylesheet">

    <!--Morris Chart CSS -->
    <link rel="stylesheet" href="<c:url value="resources/plugins/morris/morris.css"/>">

    <link href="<c:url value="resources/assets/css/bootstrap.min.css"/>" rel="stylesheet" type="text/css">
    <link href="<c:url value="resources/assets/css/metismenu.min.css"/>" rel="stylesheet" type="text/css" >
    <link href="<c:url value="resources/assets/css/icons.css"/>" rel="stylesheet" type="text/css" /> >
    <link href="<c:url value="resources/assets/css/style.css"/>" rel="stylesheet" type="text/css" />>

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

                    <li class="list-inline-item dropdown notification-list d-none d-md-inline-block">
                        
                    </li>
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

                        <div class="row align-items-center ">
                           
                           
                        </div>
                    </div>
                    <!-- end page-title -->

                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">

                                    <h3 class="mt-0 header-title">Add</h3>
                                   </br></br></br>
								 <form action="updatebook" method="POST">
								 	<input type="text" name="id" value="${book.getId() }" hidden>
                                    <div class="form-group row">
                                        <label for="example-email-input" class="col-sm-2 col-form-label">ID</label>
                                        <div class="col-sm-3">
                                            <input class="form-control" type="text" name="pId" value="${book.getpId() }" readonly>
                                        </div>
										<label for="example-url-input" class="col-form-label">Name</label>
                                        <div class="col-sm-3">
                                            <input class="form-control" type="text" name="pName" value="${book.getpName() }">
                                        </div>
										
                                    </div>
                                    
                                    <div class="form-group row">
                                        <label for="example-search-input" class="col-sm-2 col-form-label">Product Description</label>
                                        <div class="col-sm-10">
                                            <input class="form-control" type="text" name="des" value="${book.getDes() }">
                                        </div>
                                    </div>
                                    
                                    
                                    <div class="form-group row">
                                        <label for="example-email-input" class="col-sm-2 col-form-label">Company Name:</label>
                                        <div class="col-sm-3">
                                            <input class="form-control" type="text" name="compName" value="${book.getCompName() }">
                                        </div>
										<label for="example-url-input" class="col-form-label">Author</label>
                                        <div class="col-sm-3">
                                            <input class="form-control" type="text" name="author" value="${book.getAuthor() }">
                                        </div>
                                        
										
                                    </div>
                                    
                                    
                                    
                                    <div class="form-group row">
                                        <label for="example-email-input" class="col-sm-2 col-form-label">Price</label>
                                        <div class="col-sm-3">
                                            <input class="form-control" type="number" name="price" value="${book.getPrice() }">
                                        </div>
										<label for="example-url-input" class="col-form-label">Quantity</label>
                                        <div class="col-sm-3">
                                            <input class="form-control" type="number" name="stock" value="${book.getStock() }">
                                        </div>
                                        <label for="example-url-input" class="col-form-label">Pages</label>
                                        <div class="col-sm-3">
                                            <input class="form-control" type="number" name="pages" value="${book.getPages() }">
                                        </div>
										
                                    </div>
                                    
                                    <div class="form-group row">
                                        <label for="example-search-input" class="col-sm-2 col-form-label">Image URL</label>
                                        <div class="col-sm-10">
                                            <input class="form-control" type="text" name="image" value="${book.getImage() }">
                                        </div>
                                    </div>
                                    
                                    </br></br>
									<button class="btn btn-primary" type="submit" style="margin-left:600px;margin-top:-32px;">
									Submit
									</button>
                                    
                                </div>
                            </div>
                        </div>
                        <!-- end col -->
                    </div>
                    </form>
                    <!-- end row -->

                </div>
                <!-- container-fluid -->

            </div>
            <!-- content -->

           
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

    <script src="<c:url value="resources/plugins/apexchart/apexcharts.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js"/>"></script>

    <!--Morris Chart-->
    <script src="<c:url value="resources/plugins/morris/morris.min.js"/>"></script>
    <script src="<c:url value="resources/plugins/raphael/raphael.min.js"/>"></script>

    <script src="<c:url value="resources/assets/pages/dashboard.init.js"/>"></script>

    <!-- App js -->
    <script src="<c:url value="resources/assets/js/app.js"/>"></script>

</body>

</html>