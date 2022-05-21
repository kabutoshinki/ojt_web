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
        <%-- <link rel="stylesheet" href="../CSS/Login.css"  type="text/css" media="all"/> --%>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css">
    </head>
    <body>
        <div>
    <h2>Please Login</h2>
    <br/>
</div>
<div>
    <h4><a href="/oauth2/authorization/google">Login with Google</a></h4>   
</div>
<div><p>OR</p></div>
     
<form action="@{/login}" method="post" style="max-width: 400px; margin: 0 auto;">
<div class="border border-secondary rounded p-3">
    <div th:if="${param.error}">
        <p class="text-danger">Invalid username or password.</p>
    </div>
    <div th:if="${param.logout}">
        <p class="text-warning">You have been logged out.</p>
    </div>
    <div>
        <p><input type="email" name="email" required class="form-control" placeholder="E-mail" /></p>
    </div>
    <div>
        <p><input type="password" name="pass" required class="form-control" placeholder="Password" /></p>
    </div>
    <div>
        <p><input type="submit" value="Login" class="btn btn-primary" /></p>
    </div>
</div>
</form>

    </body>
</html>
