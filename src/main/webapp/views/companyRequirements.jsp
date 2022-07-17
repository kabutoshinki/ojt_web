<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>

        <html>

        <head>
            <title>TODO supply a title</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
            <link rel="stylesheet" href="/CSS/styles.css">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
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
            <jsp:include page="header.jsp" />
            <%@include file="sliderbar.jsp" %>
                <br />
                <!-- content -->
                <div class="container">

                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb align-items-center">
                            <li class="breadcrumb-item"><a href="/company" style="padding:0">Company</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Requirements</li>
                        </ol>
                    </nav>

                    <div class="form-group row align-items-center">
                        <label for="inputDateVisit" class="col col-form-label title">
                            <h1 style="color: orange;">Internship Requirement</h1>
                        </label>
                    </div>
                    <hr>

                    <div class="container">
                        <div class="table-responsive-lg">
                            <button type="button" class="btn btn-outline-primary mb-3" data-toggle="modal" data-target="#mo">
                                <i class="bi bi-upload"> New Requirement</i>
                            </button>
                            <!-- ++++++++++++++++ Upload Requirement +++++++++++++++++ -->
                            <div class="modal fade" id="mo" tabindex="-1" aria-labelledby="exampleModalLabel"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <form action="/company/uploadRequirement" method="post">
                                        <div class="modal-content text-center">
                                            <div class="modal-header"
                                                style="background: orange; text-align: center; display: unset;">
                                                <h5 class="modal-title" id="exampleModalLabel2">Import Form</h5>
                                            </div>
                                            <div class="modal-body text-center">
                                                <!-- <div class="input-group mb-3">
                                                    <div class="input-group-prepend">
                                                        <span class="input-group-text" id="basic-addon1">Position</span>   
                                                    </div>
                                                    <select name="position"
                                                        class="form-select form-select-lg mb-3 btn btn-primary btn-lg btn-block mt-3"
                                                        id="position" aria-label=".form-select-lg example">
                                                        <c:forEach var="o" items="${positionList}">
                                                            <option value="${o.id}">${o.position}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div> -->
                                                
                                                <div class="input-group mb-3">
                                                    <div class="input-group-prepend">
                                                      <label class="input-group-text" for="inputGroupSelect01">Position</label>
                                                    </div>
                                                    <select class="custom-select" id="inputGroupSelect01" name="position">
                                                      <option selected>Choose...</option>
                                                      <c:forEach var="o" items="${positionList}">
                                                            <option value="${o.id}">${o.position}</option>
                                                        </c:forEach>
                                                    </select>
                                                  </div>

                                                <div class="input-group mb-3">
                                                    <span class="input-group-text" id="basic-addon1">Description</span>
                                                    <input type="text" class="form-control" id="description"
                                                        placeholder="Enter Description" name="description" required>
                                                </div>
                                                <div class="input-group mb-3">
                                                    <span class="input-group-text" id="basic-addon1">Requirement</span>
                                                    <input type="text" class="form-control" id="requirement"
                                                        placeholder="Enter Requirement" name="requirement" required>
                                                </div>
                                                <div class="input-group mb-3">
                                                    <span class="input-group-text" id="basic-addon1">Start date</span>
                                                    <input type="date" class="form-control" id="startDate"
                                                        placeholder="Enter Start Date" name="startDate" required>
                                                </div>
                                                <div class="input-group mb-3">
                                                    <span class="input-group-text" id="basic-addon1">End date</span>
                                                    <input type="date" class="form-control" id="endDate"
                                                        placeholder="Enter End Date" name="endDate" required>
                                                </div>
                                                <div class="input-group mb-3">
                                                    <span class="input-group-text" id="basic-addon1">Slot</span>
                                                    <input type="number" class="form-control" id="slot" min="1"
                                                        max="100" placeholder="Enter Slot" name="slot" required>
                                                </div>

                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-sm btn-outline-success"
                                                    id="import"><i class="bi bi-check-circle"></i>Upload</button>
                                                <button type="button" class="btn btn-sm btn-outline-danger"
                                                    data-dismiss="modal"><i class="bi bi-x-circle"></i>Cancel</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <table id="myTable" class="table table-striped">
                                <thead>
                                    <tr>
                                        <th class="text-center">No</th>
                                        <th class="text-center">Position</th>
                                        <th class="text-center">Detail</th>
                                        <th class="text-center">Status</th>
                                        <th class="text-center">Verifier</th>
                                        <th class="text-center">Operations</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${jobList}" var="o" varStatus="loop">
                                        <tr>
                                            <td>${loop.count}</td>
                                            <td>${o.position.position}</td>
                                            <td>
                                                <a href="/view/recruitment/${o.id}" class="btn btn-outline-info btn-sm "><i
                                                        class="bi bi-eye"></i> View Detail</a>
                                            </td>
                                            <td>${o.status}</td>
                                            <td>${o.employee.account.fullName}</td>
                                            <td>
                                                <%--<a
                                                    style="${o.status!='Accepted'?'':'pointer-events: none; background-color: lightgrey'}"
                                                    href="verifyRequirement/${o.id}/Accepted"
                                                    class="btn btn-sm btn-outline-success mt-auto mb-auto" name="op"
                                                    value="accept">
                                                    <i class="bi bi-check-circle"></i> Accept
                                                    </a>
                                                    <a style="${o.status!='Denied'?'':'pointer-events: none; background-color: lightgrey'}"
                                                        href="verifyRequirement/${o.id}/Denied"
                                                        class="btn btn-sm btn-outline-danger mt-auto mb-auto" name="op"
                                                        value="remove">
                                                        <i class="bi bi-x-circle"></i> Deny
                                                    </a>--%>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
                </div>

                <hr>
                <!-- footer -->

                <jsp:include page="footer.jsp" />


                <script src=" https://code.jquery.com/jquery-3.5.1.js"></script>
                <script src=" https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
                <script src=" https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
                <script>
                    // $(document).ready(function () {
                    //     $("#myInput").on("keyup", function () {
                    //         var value = $(this).val().toLowerCase();
                    //         $("#myTable tr").filter(function () {
                    //             $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    //         });
                    //     });
                    // });
                    $(document).ready(function () {
                        $('#myTable').DataTable();
                    });

                    $(document).ready(function () {
                        $("#import").click(function () {
                            $("#success").modal();
                        });
                    });
                </script>
        </body>

        </html>