<%-- 
    Document   : listofstudent
    Created on : Jun 18, 2022, 8:20:20 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>List of student</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/CSS/styles.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/dda2b72c9e.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <%@include file="header.jsp" %>
            <hr/>
            <br/>
            <div class="container-fluid" style="border-radius: 40px; padding: 25px;">
                <div style="background-color: #cccccc;">
                    <a href="" style="font-size: 15px">Home</a> |
                    <a href="" style="font-size: 15px">Employee</a> |
                    <a href="" style="font-size: 15px">Student-manage</a>
                </div>
                <br/>
                <div class="row" style="justify-content: center;" >
                    <div>
                        <div class="row">
                            <div class="col-sm-5">
                                <h1 style="color: orange">List of Students</h1>
                            </div>
                            <div class="">
                                <div>
                                    <select>
                                        <option>Find all</option>
                                        <option>Find by name</option>
                                    </select>
                                </div>
                                <div>
                                    <form action="" method="post">
                                        <input type="text" placeholder="Search here"/>
                                        <button type="submit">
                                            <i class="bi bi-search"> Search</i>
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <button style="font-size: 20px; background-color: #99ff99; border-radius: 8px; color: black; text-align: center;" type="submit" class="btn btn-link"
                                formaction="<c:url value="/"/>"><i class="bi bi-plus-circle-fill"> Create</i></button>&nbsp;&nbsp;&nbsp;&nbsp; 
                        <button style="font-size: 20px; background-color: #6699ff; border-radius: 8px; color: black; text-align: center;" type="submit" class="btn btn-link"
                                formaction="<c:url value="/"/>"><i class="bi bi-box-arrow-in-down"> Import</i></button>&nbsp;&nbsp;&nbsp;&nbsp; 
                        <button style="font-size: 20px; background-color: #66ccff; border-radius: 8px; color: black; text-align: center;" type="submit" class="btn btn-link"
                                formaction="<c:url value="/"/>"><i class="bi bi-box-arrow-in-up"></i> Export</button>
                        <br/>
                        <br/>
                        <table border="1" cellspacing="0" style="width: 1100px;">
                            <thead style="width: 100%">
                                <tr style="text-align: center;">
                                    <th>No.</th>
                                    <th>Student ID</th>
                                    <th>Student Name</th>
                                    <th>Major</th>
                                    <th>Details</th>
                                    <th>CV</th>
                                    <th>Company</th>
                                    <th>Status</th>
                                    <th>Checkbox</th>
                                    <th>Custom</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr style="text-align: center;">
                                    <td>1</td>
                                    <td>SE150000</td>
                                    <td>NGUYEN VAN A</td>
                                    <td>KY THUAT PHAN MEM</td>
                                    <td><a href="" style="font-size: 20px">Click here</a></td>
                                    <td>CV.PDF</td>
                                    <td>FPT SOFTWARE</td>
                                    <td>NOT YET</td>
                                    <td>
                                        <input type="checkbox" value="" name=""/>
                                    </td>
                                    <td>
                                        <a href=""><i class="bi bi-pencil-fill"></i></a>
                                        <a href=""><i class="bi bi-trash-fill" style="color: red"></i></a>
                                    </td>
                                </tr
                            </tbody>
                        </table>
                    </div>
                </div>
                <br/>
                <div style="text-align: center">
                    <button style="width: 40px">1</button>&nbsp;
                    <button style="width: 40px">2</button>&nbsp;
                    <button style="width: 40px">3</button>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
