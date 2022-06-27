<%-- 
    Document   : header
    Created on : May 31, 2022, 8:30:23 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="CSS/style.css">
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  margin-left: 10px;
  overflow: hidden;
}

li {
  float: left;
}

li a {
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  padding: 12px 16px;
  z-index: 1;
}

.dropdown:hover .dropdown-content {
  display: block;
}

</style>

<div class="header d-flex p-3 container">
    <div class="d-flex flex-grow-1 p-1 info">
        <div class='p-2 d-none d-md-block'>
            <i class="fa-solid fa-envelope"></i> <span>daihoc.hcm@fpt.edu.vn</span>
        </div>
        <div class='p-2 d-none d-md-block'>
            <i class="fa-solid fa-phone"></i> <span>(028)73005588</span>
        </div>
    </div>
        <div class="d-flex align-items-center justify-content-around" >
            <div class="text-light" style="display: ${email==null?'':'none'};">
                <a href="/oauth2/authorization/google" style="color: black"><i class="fa-solid fa-user-large"></i> Login</a>
            </div>
        </div>

        <div class="dropdown">
           <button class="btn-lg btn-outline-dark dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="display: ${email!=null?'':'none'};">
                    <i class="bi bi-person-circle rounded-circle"></i></i>
           </button>
           <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
             <a class="dropdown-item" href="#">My Profile</a>
             <a class="dropdown-item" href="/employee" style="display: ${account.role.roleName.equals('EMPLOYEE')=='true'?'':'none'}"> Manage Page</a>
               <a class="dropdown-item" href="/company/managePage" style="display: ${account.role.roleName.equals('COMPANY')=='true'?'':'none'}"> Manage Page</a>
              <a class="dropdown-item" href="/student/viewApply" style="display: ${account.role.roleName.equals('STUDENT')=='true'?'':'none'}"><i class="bi bi-box-arrow-left"></i> View Apply</a>
             <a  class="dropdown-item" href="/logout">Logout</a>
           </div>
         </div>
</div>
<hr/>


<nav class="navbar navbar-expand-md align-items-center">
    <div class="container">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
            <i class="btn btn-secondary bi bi-list"></i>
        </button>
        <a class="navbar-brand mr-auto" href="/home"><img src="/img/fu.jpg" class="img-fluid" width="300" /></a>
        <div class="collapse navbar-collapse" id="Navbar">
            <ul class="navbar-nav menu mr-auto ml-auto">
                <li class="nav-item active mr-5"><a class="nav-link" href="/home">Home</a></li>
            </ul>
        </div>

    </div>
 </nav>
<hr/>