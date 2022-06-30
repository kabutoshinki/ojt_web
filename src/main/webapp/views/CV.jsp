<%-- Document : listofstudent Created on : Jun 18, 2022, 8:20:20 PM Author : admin --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>List of student</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/CSS/styles.css">
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
    <style>

    </style>
</head>

<body>
    <%@include file="header.jsp" %>
        <br />
        <div class="container">

                    <nav aria-label="breadcrumb">
                      <ol class="breadcrumb align-items-center">
                        <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                        <li class="breadcrumb-item"><a href="/employee" style="padding:0;display: inline;">Employee</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Student_Manage</li>
                      </ol>
                    </nav>

            <br />
            <div class="container" style="justify-content: center;">
                <div>
                    <div class="row">
                        <div class="col">
                            <h1 style="color: orange">List of CV</h1>
                        </div>
                    </div>
                    <button type="button" class="btn btn-outline-primary" data-toggle="modal"
                        data-target="#mo">
                        <i class="bi bi-upload"> Upload CV</i>
                    </button>

                    <!-- Notification-->
                    <c:if test="${not empty file}">
                        <div class="modal fade" id="success" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                  <div class="modal-dialog" role="document">
                                                    <div class="modal-content">
                                                      <div class="modal-header bg-success">
                                                        <h5 class="modal-title ml-auto mr-auto" id="exampleModalLabel"><i  class="bi bi-check-circle"  style="font-size:100px"></i></h5>
                                                    </div>
                                                    <div class="modal-body text-center">
                                                        Success Import
                                                      </div>
                                                    <div class="modal-footer mr-auto ml-auto">
                                                        <button type="button" class="btn btn-danger" id="close" data-dismiss="modal" >Close</button>
                                                    </div>
                                                </div>
                                                </div>
                                                </div>
                    </c:if>

                    <!-- +++++++++++++++++++++++++++++++++ -->
                    <div class="modal fade" id="mo" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <form action="/employee/upload" method="post" enctype="multipart/form-data">
                                <div class="modal-content text-center">
                                    <div class="modal-header"
                                        style="background: orange; text-align: center; display: unset;">
                                        <h5 class="modal-title" id="exampleModalLabel">Import Form</h5>
                                    </div>
                                    <div class="modal-body text-center">
                                        <div class="form-group">
                                            <input type="file" name="file" class="form-control-file"
                                                required multiple>
                                            <input type="text" name="role" value="STUDENT" hidden>
                                            <input type="text" name="redirect" value="students" hidden>
                                        </div>

                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-sm btn-outline-success" id="import"><i
                                                class="bi bi-check-circle"></i> Import</button>
                                        <button type="button" class="btn btn-sm btn-outline-danger"
                                            data-dismiss="modal"><i class="bi bi-x-circle"></i>
                                            Cancel</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <br />
                    <br />
                    <div class="container">
                        <p>Type something in the input field to search the table</p>
                        <input class="form-control" id="myInput" type="text" placeholder="Search..">
                        <br>
                        <div class="table-responsive">
                        <table class="table table-bordered text-center">
                            <thead>
                                <tr>
                                    <th>No.</th>
                                    <th>CV </th>
                                    <th>View CV</th>
                                    <th>Operation</th>
                                </tr>
                            </thead>
                            <tbody id="myTable">
                                <c:forEach items="${studentList}" var="o" varStatus="loop">
                                    <tr style="text-align: center;">
                                        <td>${loop.count}</td>
                                        <td>${o.account.fullName}</td>
                                        <td><a href="" style="font-size: 20px">Click here</a></td>
                                        <td>
                                            <input type="radio" class="btn btn-success">
                                                      <i class="bi bi-trash-fill" style="color: red"></i> Choose CV</input>
                                            <a href=""><i class="bi bi-trash-fill"
                                                    style="color: red"></i></a>
                                        </td>
                                    </tr
                                    
                                    </c:forEach>
                                    <tr>
                                        <td>1</td>
                                        <td>2</td>
                                        <td>3</td>
                                        <td>
                                           <button class="btn btn-outline-danger m-0"><i class="bi bi-trash-fill" style="color: red"></i> Delete</button>
                                        </td>
                                    </tr>
                            </tbody>
                        </table>
                        </div>
                    </div>
                </div>
            </div>
            <br />
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
        </div>
        </div>
        <jsp:include page="footer.jsp" />

        <script>
            $(document).ready(function () {
                $("#myInput").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });

            $(document).ready(function () {
                  $("#import").click(function () {
                    $("#success").modal();
                  });
                });
        </script>
</body>

</html>