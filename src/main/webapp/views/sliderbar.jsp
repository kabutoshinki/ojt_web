<%-- Document : header Created on : May 31, 2022, 8:30:23 AM Author : admin --%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>

      <link rel="stylesheet" href="/CSS/sliderbar.css">
      <div class="wrapper">
        <!-- Sidebar Holder -->
        <nav id="sidebar" class="">
          <div class="sidebar-header">
            <div style="border: 1px solid #fff; width: 100%"></div>
            <h3>On Job Training</h3>
            <strong>OJT</strong>
          </div>

          <ul class="list-unstyled components">
            <li>
              <a href="/employee" class="text-truncate"
                style="display: ${account.role.equals('EMPLOYEE')=='true' || account.role.equals('ADMIN')=='true'?'':'none'}">
                <i class='fas fa-home'></i>
                Home
              </a>
            </li>
            <li>
              <a href="/employee/students" class="text-truncate" style="display: ${account.role.equals('EMPLOYEE')=='true' || account.role.equals('ADMIN')=='true'?'':'none'}">
                <i class='fas fa-user-graduate'></i>
                Students
              </a>
            </li>
            <li>
              <a href="/employee/companies" class="text-truncate" style="display: ${account.role.equals('EMPLOYEE')=='true' || account.role.equals('ADMIN')=='true'?'':'none'}">
                <i class='fas fa-building'></i>
                Companies
              </a>
            </li>
            <li>
              <a href="/employee/requirements" class="text-truncate" style="display: ${account.role.equals('EMPLOYEE')=='true' || account.role.equals('ADMIN')=='true'?'':'none'}">
                <i class='fas fa-book-reader'></i>
                Internship Requirement
              </a>
            </li>
            <li>
              <a href="/employee/applications" class="text-truncate" style="display: ${account.role.equals('EMPLOYEE')=='true' || account.role.equals('ADMIN')=='true'?'':'none'}">
                <i class="bi bi-person-check-fill"></i>
                Student Application
              </a>
            </li>
            <li>
              <a href="/employee/externalApplications" class="text-truncate" style="display: ${account.role.equals('EMPLOYEE')=='true' || account.role.equals('ADMIN')=='true'?'':'none'}">
                <i class="bi bi-file-person"></i>
                Student External Application
              </a>
            </li>
            <li>
              <a href="/employee/internships" class="text-truncate" style="display: ${account.role.equals('EMPLOYEE')=='true' || account.role.equals('ADMIN')=='true'?'':'none'}">
                <i class="bi bi-award-fill"></i>
                Internship Result
              </a>
            </li>
            <li>
              <a href="/employee/semester" class="text-truncate" style="display: ${account.role.equals('ADMIN')=='true'?'':'none'}">
                <i class="bi bi-award-fill"></i>
                Semester
              </a>
            </li>

            <!-- Company -->
            <li>
              <a href="/company" class="text-truncate"
                style="display: ${account.role.equals('COMPANY')=='true'?'':'none'}">
                <i class='fas fa-home'></i>
                Home
              </a>
            </li>
            
            <li>
              <a href="/company/candidates" class="text-truncate"
                style="display: ${account.role.equals('COMPANY')=='true'?'':'none'}">
                <i class="bi bi-person-plus-fill"></i>
                Candidate Management
              </a>
            </li>

            <li>
              <a href="/company/requirements" class="text-truncate"
                style="display: ${account.role.equals('COMPANY')=='true'?'':'none'}">
                <i class='fas fa-clipboard'></i>
                Internship Requirement
              </a>
            </li>

            <li>
              <a href="/company/internships" class="text-truncate"
                style="display: ${account.role.equals('COMPANY')=='true'?'':'none'}">
                <i class='fas fa-address-card'></i>
                Intern Management
              </a>
            </li>

          </ul>
        </nav>
      <%--</div>--%>
        <!-- <script>
          $(document).ready(function () { $('#sidebarCollapse').on('click', function () { $('#sidebar').toggleClass('active'); }); });
        </script> -->