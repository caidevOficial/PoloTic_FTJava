<%-- 
    Document   : registerEmployee
    Created on : 18 dic. 2020, 06:52:03
    Author     : <FacuFalcone - CaidevOficial> Copyright (C) 2020
--%>
<%@page import="Logic.Controller.LogicController"%>
<%@page import="Logic.Entities.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Register Game</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <meta name="apple-mobile-web-app-capable" content="yes"> 

        <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />

        <link href="resources/css/font-awesome.css" rel="stylesheet">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">

        <link href="resources/css/style.css" rel="stylesheet" type="text/css">
        <link href="resources/css/pages/signin.css" rel="stylesheet" type="text/css">
        <link href="resources/css/pages/dashboard.css" rel="stylesheet">
    </head>

    <body>
        <%
        /*    HttpSession thisSession = request.getSession();
            String user = (String) request.getSession().getAttribute("theUsername");

            if (user == null) {
                response.sendRedirect("error.jsp");
            } else {*/
                LogicController LC = new LogicController();
                //thisSession.setAttribute("control", LC);
        %>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>

                    <a class="brand" href="#">
                        Register a Game				
                    </a>		

                    <div class="nav-collapse">
                        <ul class="nav pull-right">
                            <li class="">						
                                <a href="management.jsp" class="">
                                    <i class="icon-chevron-left"></i>
                                    Back to Management page
                                </a>

                            </li>
                        </ul>
                    </div><!--/.nav-collapse -->	
                </div> <!-- /container -->
            </div> <!-- /navbar-inner -->
        </div> <!-- /navbar -->

        <div class="container-fluid cata-flex">
            <div class="row ">
                <div class="span5 ">

                    <div class="widget widget-table action-table">
                        <div class="widget-header"> <i class="icon-th-list"></i>
                            <h3>Employees List</h3>
                        </div>
                        <div class="widget-content ">
                            <table class="table table-striped table-bordered">
                                <thead>
                                    <tr>
                                        <th><center>ID Employee</center></th>
                                <th><center>Name</center></th>
                                <th><center>Surname</center></th>
                                <th><center>Username</center></th>
                                </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <%
                                            //LC = new LogicController();//(LogicController) thisSession.getAttribute("control");
                                            List<Employee> allEmployees = LC.getAllEmployees();
                                            for (Employee thisEmployee : allEmployees) {
                                        %>
                                        <td><center><%=thisEmployee.getId_employee()%></center></td>
                                <td><center><%=thisEmployee.getName()%></center></td>
                                <td><center><%=thisEmployee.getSurname()%></center></td>
                                <td><center><%=thisEmployee.getEmployeeUser().getUsername()%></center></td>

                                </tr>
                                <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>

                    <!-- TABLA DE ABAJO --> 
                    <div class="account-container register ">
                        <div class="content clearfix widget">
                            <form action="RegisterGame" method="POST">
                                <h1>Register Game</h1>			
                                <div class="login-fields">
                                    <p>Write the new data:</p>
                                    <div class="field">
                                        <label for="user">ID:</label>
                                        <input type="text" id="user" name="id_employee" value="" placeholder="id_employee" class="login" required/>
                                    </div> <!-- /field -->

                                    <div class="field">
                                        <label for="gameName">Game Name:</label>
                                        <input type="text" id="gameName" name="gameName" value="" placeholder="gameName" class="login" required/>
                                    </div> <!-- /field -->
                                    
                                    <div class="field">
                                        <label for="timeFrom">From (Hours):</label>
                                        <input type="timeFrom" id="FromH" name="timeFromHours" value="" placeholder="From Hours" class="login" required/>
                                    </div> <!-- /field -->

                                    <div class="field">
                                        <label for="timeFrom">From (Minutes):</label>
                                        <input type="timeFrom" id="FromM" name="timeFromMinutes" value="" placeholder="From Minutes" class="login" required/>
                                    </div> <!-- /field -->
                                    
                                    <div class="field">
                                        <label for="timeTo">To (Hours):</label>	
                                        <input type="timeTo" id="ToH" name="timeToHours" value="" placeholder="To Hours" class="login" required/>
                                    </div> <!-- /field -->
                                    
                                    <div class="field">
                                        <label for="timeTo">To (Minutes):</label>	
                                        <input type="timeTo" id="ToM" name="timeToMinutes" value="" placeholder="To Minutes" class="login" required/>
                                    </div> <!-- /field -->
                                    
                                </div> <!-- /login-fields -->

                                <div class="login-actions">
                                    <span class="login-checkbox">
                                        <input id="Field" name="Field" type="checkbox" class="field login-checkbox" value="First Choice" tabindex="4" required/>
                                        <label class="choice" for="Field">Agree with the ridiculously long Terms & Conditions that you didn't bother to read.</label>
                                    </span>

                                    <button class="button btn btn-primary btn-large">Register Game</button>
                                </div> <!-- .actions -->
                            </form>
                        </div> <!-- /content -->
                    </div> <!-- /account-container -->

                </div>
            </div>
        </div>



        <!-- Text Under Box -->

        <script src="resources/js/jquery-1.7.2.min.js"></script>
        <script src="resources/js/bootstrap.js"></script>
        <script src="resources/js/signin.js"></script>
        <%
            //}
        %>
    </body>
</html>
