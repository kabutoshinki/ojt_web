<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : loginPage
    Created on : Jan 9, 2022, 5:03:50 PM
    Author     : ADMIN
--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="CSS/Login.css"  type="text/css" media="all"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="global-container">
            <div class="card login-form">
                <div class="card-body">
                    <h3 class="card-title text-center">Login Account</h3>
                    <div class="card-text">

                        <c:if test="${mess!=null}">
                            <div class="alert alert-danger alert-dismissible fade show" 
                                 role="alert">${mess}
                            </div> 
                        </c:if>
                        <form action="Login" method="post">
                            <!-- to error: add class "has-danger" -->

                            <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="text" class="form-control form-control-sm"
                                       id="exampleInputEmail1" value="${fullName}" name ="email" aria-describedby="emailHelp" required="" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <a href="#" style="float:right;font-size:12px;">Forgot password? 
                                </a>
                                <input type="password" class="form-control form-control-sm"
                                    value="${email}"  id="exampleInputPassword1" name="password" required="">
                            </div>
                            <div class ="role" style="display: contents; height: fit-content; width: fit-content">

                                <div style="display: contents">
                                    <input type="radio" id="admin" name="role" ${role==0?"checked":""} value="0" required="">
                                        <label for="admin">Admin</label>
                                    
                                    
                                </div>
                                <div style="display: contents">
                                    <input type="radio" id="customer" name="role" ${role==1?"checked":""}  value="1"  required="">
                                        <label for="customer" >customer</label><br>
                                </div>
                                <div style="display: contents">
                                    <input type="checkbox" id="vehicle1" name="saveAcc" value="saveAcc">
                                    <label for="saveAcc"> Save Account</label>
                                </div>

                                  
                            </div><br>
                            <button type="submit" value="Login" class="btn btn-primary btn-block">Sign in</button>

                            <div class="sign-up">
                                Don't have an account? 
                                <a href="registerPage.jsp">Create One</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
