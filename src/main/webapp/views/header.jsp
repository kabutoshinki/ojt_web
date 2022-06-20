<%-- 
    Document   : header
    Created on : May 31, 2022, 8:30:23 AM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header d-flex p-3">
    <div class="d-flex flex-grow-1 p-1 info">
        <div class='p-2'>
            <i class="fa-solid fa-envelope"></i> <span>daihoc.hcm@fpt.edu.vn</span>
        </div>
        <div class='p-2'>
            <i class="fa-solid fa-phone"></i> <span>(028)73005588</span> 
        </div>
    </div>
        <div class="d-flex align-items-center justify-content-around p-1" >
            <div class="text-light" style="display: ${email==null?'':'none'};">
                <a href="/oauth2/authorization/google" style="color: black"><i class="fa-solid fa-user-large"></i> Login</a>
            </div>
        </div>
        <div class="dropdown" >
            <button class="btn-lg btn-outline-dark" style="display: ${email!=null?'':'none'};"><i class="bi bi-person-circle"></i></i></button>
             <div class="dropdown-content">
                 <a href="#"><i class="bi bi-file-person"></i>Infomation</a>
                 <a href="/logout"><i class="bi bi-box-arrow-left"></i> Logout</a>
                 <a href="/companyController/managePage" style="display: ${account.role.equals('COMPANY')=='true'?'':'none'}"><i class="bi bi-box-arrow-left"></i> Manage Page</a>
                 <a href="/employeeController/managePage" style="display: ${account.role.equals('EMPLOYEE')=='true'?'':'none'}"><i class="bi bi-box-arrow-left"></i> Manage Page</a>
                 <a href="/studentController/viewApply" style="display: ${account.role.equals('STUDENT')=='true'?'':'none'}"><i class="bi bi-box-arrow-left"></i> View Apply</a>
             </div>
         </div>
</div> 
<hr/>
<div class="container-fluid ">
    <div class="row">
        <div class="col-sm-5">
            <img src="/img/fu.jpg" width="280" />
        </div>
        <div class="col-sm-7 menu">
            <div class="">
                <a href=""> Home </a>
            </div>
            <div class="">
                <a href=""> OJT </a>
            </div>
            <div class="">
                <a href=""> CNH </a>
            </div>
            <div class="">
                <a href=""> Company Tour </a>
            </div>
            <div>
                <form action="" method="post">
                    <input type="text" placeholder="Search here">
                    <button type="submit">
                        <i class="bi bi-search"> Search</i>
                    </button>
                </form>
            </div>
        </div>

    </div>
</div>