<%-- 
    Document   : index
    Created on : May 30, 2022, 12:29:03 PM
    Author     : SE150437 Vo Pham Quoc Thang
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/CSS/styles.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
            rel="stylesheet"
            />
        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
            />
        <!-- MDB -->
        <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.1.0/mdb.min.css"
            rel="stylesheet"
            />
        <script
            type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.1.0/mdb.min.js"
        ></script>
        <title>Job Detail</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <hr>
        
        <div style="
             display: flex;
             justify-content: space-around;
             align-items: center;
             padding: 25px 1vw;">
            <span style="font-size: 30px; font-weight:bold;">
<<<<<<< HEAD
                ${jobDetail.company.name}
=======
                ${jobDetail.company.companyName}
>>>>>>> 26c4eacbba2ba4706c3beb9bd9a8b4875dc2fbf2
            </span>
        </div>
        <hr style="height: 2px; color: black;"/>
        <div class="container-fluid">
            <div class="row">
                <div class="col-4">
                    <img style="height: 70%; align-items: center; position: absolute; padding-left: 100px; padding-bottom: 200px"  src="https://scontent.fsgn5-5.fna.fbcdn.net/v/t1.6435-9/96390018_2696615493801270_8485826556134948864_n.png?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=jfQvr3P7PPkAX8zMuYJ&_nc_ht=scontent.fsgn5-5.fna&oh=00_AT_BIEXxQrEsLNBnweMlukjHUyjIegSZHwc1B3Mg0JGSwQ&oe=62BB7CE0"/>
                </div>
                <div class="col-8">
                    <p style="font-size: 30px; font-weight:bold; padding-top: 70px;">
                        <c:forEach items="${companyDes}" var="o">
                            ${o}<br>
                        </c:forEach>
<<<<<<< HEAD
                        ${jobDetail.company.address}<br>
=======
                        ${jobDetail.company.companyAddress}<br>
>>>>>>> 26c4eacbba2ba4706c3beb9bd9a8b4875dc2fbf2
                    </p>
                </div>
            </div>
        </div>
        <div style="padding: 50px">
            <h3>Job description:</h3>
            <ul style="font-size: 25px">
                <c:forEach items="${jobDes}" var="o">
                    <li>${o}</li>
                </c:forEach>
            </ul>
        </div>
        <div style="padding: 50px">
            <h3>Qualification:</h3>
            <ul style="font-size: 25px">
                <c:forEach items="${jobRe}" var="o">
                    <li>${o}</li>
                </c:forEach>
            </ul>
        </div>
        <div style="
             display: flex;
             justify-content: left;
             align-items: center;
             padding: 10px 10vw;">
            <div style="padding-left: 200px">
                <a href="">
                    <button style="width: 15vw; border-radius: 20px !important ; padding: 10px; background-color: #FC8902; color: white; border: hidden ">
                        APPLY
                    </button>
                </a>
            </div>
            <div style="padding-left: 300px">
                <button style="width: 15vw; border-radius: 20px !important ; padding: 10px; background-color: #7EC585; color: white;border: hidden">
                    VISIT
                </button>
            </div>
        </div>
    </body>
    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>
