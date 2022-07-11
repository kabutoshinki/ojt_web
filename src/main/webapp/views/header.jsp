<%-- Document : header Created on : May 31, 2022, 8:30:23 AM Author : admin --%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>

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
      </style>

      <!-- <div class="header d-flex p-3 container">
        <div class="d-flex flex-grow-1 p-1 info">
          <div class='p-2 d-none d-md-block'>
            <i class="fa-solid fa-envelope"></i> <span>daihoc.hcm@fpt.edu.vn</span>
          </div>
          <div class='p-2 d-none d-md-block'>
            <i class="fa-solid fa-phone"></i> <span>(028)73005588</span>
          </div>
        </div>
        <div class="d-flex align-items-center justify-content-around">
          <div class="text-light" style="display: ${email==null?'':'none'};">
            <a href="/oauth2/authorization/google" style="color: black"><i class="fa-solid fa-user-large"></i> Login</a>
          </div>
        </div>

        <div class="dropdown">
          <button class="btn-lg btn-outline-dark dropdown-toggle" type="button" id="dropdownMenuButton"
            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
            style="display: ${email!=null?'':'none'};">
            <i class="bi bi-person-circle rounded-circle"></i></i>
          </button>
          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="/view/user">My Profile</a>
            <a class="dropdown-item" href="/employee"
              style="display: ${account.role.equals('EMPLOYEE')=='true'?'':'none'}"> Manage Page</a>
            <a class="dropdown-item" href="/company/managePage"
              style="display: ${account.role.equals('COMPANY')=='true'?'':'none'}"> Manage Page</a>
            <a class="dropdown-item" href="/student/applications"
              style="display: ${account.role.equals('STUDENT')=='true'?'':'none'}">View Apply</a>
            <a class="dropdown-item" href="/student/CVs"
              style="display: ${account.role.equals('STUDENT')=='true'?'':'none'}">View CV</a>
            <a class="dropdown-item" href="/logout">Logout</a>
          </div>
        </div>
      </div>
      <hr /> -->

      <div class="container">
        <nav class="navbar navbar-expand-md align-items-center" style="background: orange">


          <button class="navbar-toggler p-0" type="button" data-toggle="collapse" data-target="#Navbar">
            <i class="btn btn-secondary bi bi-list"></i>
          </button>


          <div class="collapse navbar-collapse" id="Navbar">

            <div class="d-flex align-items-center justify-content-around">
              <a class="navbar-brand mr-auto ml-auto mr-5" href="/home"><img src="/img/fu.jpg" class="img-fluid"
                  width="300" /></a>
            </div>

            <ul class="navbar-nav menu mr-auto ml-auto p-0 align-items-center">
              <li class="nav-item active mr-3"><a class="nav-link" href="/home">Home</a></li>
              <li class="nav-item active mr-3"><a href="/student/CVs"
                  style="text-decoration: none; display: ${account.role.equals('STUDENT')=='true'?'':'none'}">View CV
                  List</a></li>
              <li class="nav-item active mr-3"><a href="/student/applications"
                  style="text-decoration: none; display: ${account.role.equals('STUDENT')=='true'?'':'none'}">View Apply
                  Status</a></li>
              <li class="nav-item active mr-3"><a href="/student/report"
                  style="text-decoration: none; display: ${account.role.equals('STUDENT')=='true'?'':'none'}">Internship Report</a></li>
            </ul>
            <div class="d-flex align-items-center justify-content-around">
              <div class="text-light" style="display: ${email==null?'':'none'};">
                <a href="/oauth2/authorization/google" style="color: black"><i class="fa-solid fa-user-large"></i>
                  Login</a>
              </div>
            </div>
            <div class="d-flex align-items-center justify-content-around">
              <div class="dropdown">

                <a class="nav-link dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
                  aria-haspopup="true" aria-expanded="false" style="display: ${email!=null?'':'none'};">
                  <i class="bi bi-person-circle rounded-circle"></i></i>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                  <a class="dropdown-item" href="/view/user">My Profile</a>
                  <a class="dropdown-item" href="/employee"
                    style="display: ${account.role.equals('EMPLOYEE')=='true'?'':'none'}"> Manage Page</a>
                  <a class="dropdown-item" href="/company"
                    style="display: ${account.role.equals('COMPANY')=='true'?'':'none'}"> Manage Page</a>
                  <a class="dropdown-item" href="/logout">Logout</a>
                </div>
              </div>
            </div>

          </div>


        </nav>
      </div>