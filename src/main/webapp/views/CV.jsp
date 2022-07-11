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
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css">
</head>

<body>
<%@include file="header.jsp" %>
<br />
<div class="container">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb align-items-center">
            <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">CV List</li>
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
                <div class="modal fade" id="success" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header bg-success">
                                <h5 class="modal-title ml-auto mr-auto" id="exampleModalLabel"><i
                                        class="bi bi-check-circle" style="font-size:100px"></i></h5>
                            </div>
                            <div class="modal-body text-center">
                                Success Import
                            </div>
                            <div class="modal-footer mr-auto ml-auto">
                                <button type="button" class="btn btn-danger" id="close"
                                        data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

            <!-- ++++++++++++++++ Import CV +++++++++++++++++ -->
            <div class="modal fade" id="mo" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/student/uploadCV" method="post" enctype="multipart/form-data">
                        <div class="modal-content text-center">
                            <div class="modal-header"
                                 style="background: orange; text-align: center; display: unset;">
                                <h5 class="modal-title" id="exampleModalLabel2">Import Form</h5>
                            </div>
                            <div class="modal-body text-center">
                                <div class="form-group">
                                    <!-- <input type="file" name="file" class="form-control-file"
                                        required multiple> -->
                                    <div class="custom-file mt-3">
                                        <label class="custom-file-label" for="customFile">Choose
                                            file</label>
                                        <input type="file" class="custom-file-input" name="file" id="fileImage">
                                    </div>
                                    <!-- <input type="text" name="name" required>
                                    <input type="text" name="description">
                                    <input type="text" name="role" value="STUDENT" hidden>
                                    <input type="text" name="redirect" value="students/CVs" hidden> -->
                                </div>

                                <div class="input-group mb-3">
                                    <span class="input-group-text" id="basic-addon1">Name CV</span>
                                    <input type="text" class="form-control" id="name"
                                           placeholder="Enter name" name="name" required>
                                </div>

                                <div class="input-group mb-3">
                                                        <span class="input-group-text"
                                                              id="basic-addon1">Description</span>
                                    <input type="text" class="form-control" id="description"
                                           placeholder="Enter Description" name="description" required>
                                </div>
                                <input type="text" name="role" value="STUDENT" hidden>
                                <input type="text" name="redirect" value="students/CVs" hidden>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-sm btn-outline-success"
                                        id="import"><i class="bi bi-check-circle"></i> Import</button>
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

                <div class="table-responsive">
                    <table id="myTable" class="table table-bordered text-center">
                        <thead>
                        <tr>
                            <th class="text-center">No.</th>
                            <th class="text-center">CV </th>
                            <th class="text-center">Description</th>
                            <th class="text-center">View CV</th>
                            <th class="text-center">Operation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cvList}" var="o" varStatus="loop">
                            <tr style="text-align: center;">
                                <td>${loop.count}</td>
                                <td>${o.name}</td>
                                <td>${o.description}</td>
                                <td><a href="" class="btn btn-outline-info"><i
                                        class="bi bi-eye"></i> View Detail</a></td>
                                <td>
                                    <a class="btn btn-outline-success"><i
                                            class="bi bi-check-circle"></i> Choose CV</a>
                                        <%--<a href="" class="btn btn-outline-danger"><i
                                                class="fa fa-refresh"></i> Update</a>--%>
                                    <button type="button" class="btn btn-outline-primary"
                                            data-toggle="modal" data-target="#modelUpdate_${o.id}">
                                        <i class="fa fa-refresh"></i> Update
                                    </button>
                                </td>
                            </tr>

                            <!-- ++++++++++++++++ Update CV +++++++++++++++++ -->
                            <div class="modal fade" id="modelUpdate_${o.id}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <form action="/student/updateCV/${o.id}" method="post"
                                          enctype="multipart/form-data">
                                        <div class="modal-content text-center">
                                            <div class="modal-header"
                                                 style="background: orange; text-align: center; display: unset;">
                                                <h5 class="modal-title" id="exampleModalLabel3">
                                                    Update Form</h5>
                                            </div>
                                            <div class="modal-body text-center">
                                                <div class="form-group">
                                                    <input type="file" name="file"
                                                           class="form-control-file" required>
                                                </div>

                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit"
                                                        class="btn btn-sm btn-outline-success"
                                                        id="update"><i
                                                        class="bi bi-check-circle"></i>
                                                    Update</button>
                                                <button type="button"
                                                        class="btn btn-sm btn-outline-danger"
                                                        data-dismiss="modal"><i
                                                        class="bi bi-x-circle"></i>
                                                    Cancel</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <br />

</div>
</div>
<jsp:include page="footer.jsp" />
<script src=" https://code.jquery.com/jquery-3.5.1.js"></script>
<script src=" https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src=" https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#myTable').DataTable();
    });

    $(document).ready(function () {
        $("#import").click(function () {
            $("#success").modal();
        });
    });

    $(document).ready(function () {
        $("#update").click(function () {
            $("#success").modal();
        });
    });

    $(".custom-file-input").on("change", function () {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });

</script>
</body>

</html>