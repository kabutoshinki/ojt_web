<%--
    Document   : index
    Created on : May 19, 2022, 6:42:41 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Homepage</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <link rel="stylesheet" href="/CSS/styles.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/dda2b72c9e.js" cross-origin="anonymous"></script>
    </head>
    <body>
        <%@include file="header.jsp"%>
        <hr>
        <hr>
        <div class="container">
            <div>
                <div style="margin-bottom:20px; padding:10px; background-color:#336699; color:white;">
                    <p>Type some text to search the List:</p>
                    <input class="form-control" id="myInput" type="text" placeholder="Search.." />

                </div>
            </div>
            <div>
                <h1 style="text-align: center; color: orange">Looking for an internship chance?</h1>
                <a href="/student/externalApply"><button style="background-color: #00ff00; width: 150px; border-radius: 22px; border: none; float: right ; font-size: 14px;"><span style="font-weight: 700; color: white;">Already Intern</span><br/><span style="font-weight: 600; color: red;">Click here</span></button></a>
            </div>
        </div>
        <div class="container main-content">
            <div class="row" style="justify-content: center; padding-top: 3em;">
                <c:forEach items="${jobList}" var="o">
                    <div class="col-sm-3 list-comp" style="height: 20em;">
                        <form style="text-align: center; display: block; padding-top: 0em; margin-top: 0px;">
                            <img src="${o.company.account.avatar==null?'':o.company.account.avatar}" width="300" height="150px">
                            <hr id="hr"/>
                            <strong>Position: </strong>${o.position.position}<br/>
                            <strong>End date: </strong>${o.endDate}<br/>
                            <strong>Available slot: </strong>${o.slot}<br/>
                            <div>
                                <%--<a href="/view/recruitment/${o.id}" style="display: block; margin-top: 1em">
                                    <input type="button" class="btn" name="">Details</input>
                                </a>--%>
                                <a href="/view/recruitment/${o.id}"><input type="button" value="Details"  style=" background-color: #ccffcc; border-radius: 10px; padding: 4px 25px"/></a>
                            </div>
                        </form>
                    </div>
                </c:forEach>
            </div>
            <br/>
            <div class="" style="text-align: center">
                <a href="" style="font-size: 18px"><i class="bi bi-arrow-down-short"></i>Xem thêm</a>
            </div>
        </div>
        <%@include file="footer.jsp" %>
        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $(".list-comp").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>
    </body>
</html>
