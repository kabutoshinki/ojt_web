<%-- Document : index Created on : May 30, 2022, 12:29:03 PM Author : SE150437 Vo Pham Quoc Thang --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/CSS/style.css">
    <link rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/dda2b72c9e.js" crossorigin="anonymous"></script>
    <title>Job Detail</title>
</head>

<body>
    <jsp:include page="header.jsp" />
    <hr>

    <div style="
 display: flex;
 justify-content: space-around;
 align-items: center;
 padding: 25px 1vw;">
        <span style="font-size: 30px; font-weight:bold;">
            ${jobDetail.company.account.fullName}
        </span>
    </div>
    <hr style="height: 2px; color: black;" />
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-4 mb-2">
                <img style="width:400px" class="img-fluid" alt="Responsive image"
                    src="https://scontent.fsgn5-5.fna.fbcdn.net/v/t1.6435-9/96390018_2696615493801270_8485826556134948864_n.png?_nc_cat=100&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=jfQvr3P7PPkAX8zMuYJ&_nc_ht=scontent.fsgn5-5.fna&oh=00_AT_BIEXxQrEsLNBnweMlukjHUyjIegSZHwc1B3Mg0JGSwQ&oe=62BB7CE0" />
            </div>
            <div class="col-12 col-md-8 mb-2">
                <p style="font-size: 30px; font-weight:bold;">
                    <c:forEach items="${companyDes}" var="o">
                        ${o}<br>
                    </c:forEach>
                    ${jobDetail.company.account.address}<br>
                </p>
            </div>
        </div>
    </div>
    <hr>
    <div class="container">
        <a href="/student/applyForm/${jobDetail.id}" style="text-decoration: none;" class="btn btn-warning btn-lg btn-block">APPLY</a>
        <div class="row">
            <div class="col-12 mt-5 mr-2">
                <h3>Job description:</h3>
                <ul style="font-size: 25px">
                    <c:forEach items="${jobDes}" var="o">
                        <li><i class="bi bi-dot"></i> ${o}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-12 mt-5 mb-5 mr-2">
                <h3>Qualification:</h3>
                <ul style="font-size: 25px">
                    <c:forEach items="${jobRe}" var="o">
                        <li><i class="bi bi-dot"></i> ${o}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
</body>



</html>