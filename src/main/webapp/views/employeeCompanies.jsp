<%-- Document : list of companies Created on : Jun 18, 2022, 8:20:20 PM Author : admin --%>

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
                    <%@include file="sliderbar.jsp" %>
                        <br />
                        <div class="container" style="border-radius: 40px;">
                            <nav aria-label="breadcrumb">
                                <ol class="breadcrumb align-items-center">
                                    <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                                    <li class="breadcrumb-item"><a href="/employee"
                                            style="padding:0;display: inline;">Employee</a></li>
                                    <li class="breadcrumb-item active" aria-current="page">Company_Manage</li>
                                </ol>
                            </nav>
                            <br />

                            <div class="row">
                                <div class="col-sm-5">
                                    <h1 style="color: orange">List of Company</h1>
                                </div>
                            </div>
                            <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#mo">
                                <i class="bi bi-box-arrow-in-down"> Import</i>
                            </button>



                            <div class="modal fade" id="mo" tabindex="-1" aria-labelledby="exampleModalLabel"
                                aria-hidden="true">
                                <div class="modal-dialog">
                                    <form action="/employee/uploadCompany" method="post" enctype="multipart/form-data">
                                        <div class="modal-content text-center">
                                            <div class="modal-header"
                                                style="background: orange; text-align: center; display: unset;">
                                                <h5 class="modal-title" id="exampleModalLabel">Import Form</h5>
                                            </div>
                                            <div class="modal-body text-center">
                                                <!-- <div class="form-group">
                                                <input type="file" name="file" class="form-control-file" required
                                                    multiple>
                                                <input type="text" name="role" value="COMPANY" hidden>
                                                <input type="text" name="redirect" value="companies" hidden>
                                            </div> -->

                                                <div class="form-group">
                                                    <div class="custom-file mt-3">
                                                        <label class="custom-file-label" for="customFile">Choose
                                                            file</label>
                                                        <input type="file" class="custom-file-input" name="file"
                                                            id="fileImage">
                                                        <input type="text" name="role" value="COMPANY" hidden>
                                                        <input type="text" name="redirect" value="companies" hidden>
                                                    </div>
                                                </div>

                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit" class="btn btn-sm btn-outline-success"><i
                                                        class="bi bi-check-circle"></i> Import</button>
                                                <button type="button" class="btn btn-sm btn-outline-danger"
                                                    data-dismiss="modal"><i class="bi bi-x-circle"></i>
                                                    Cancel</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <button class="btn btn-outline-info" formaction="<c:url value=" /" />">
                            <i class="bi bi-box-arrow-in-down"></i> Export
                            </button>
                            <a href="/template/Company.xlsx" download><button class="btn btn-outline-info" formaction="<c:url value=" /" />"><i
                                    class="bi bi-box-arrow-in-down"></i> Download template</button></a>
                            <br />
                            <br />
                            <div class="container">

                                <div class="table-responsive-lg">
                                    <table id="myTable" class="table table-bordered text-center">
                                        <thead>
                                            <tr style="text-align: center;">
                                                <th class="text-center">No.</th>
                                                <th class="text-center">Company Name</th>
                                                <th class="text-center">Email</th>
                                                <th class="text-center">Details</th>
                                                <th class="text-center">Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${companyList}" var="o" varStatus="loop">
                                                <tr style="text-align: center;">
                                                    <td>${loop.count}</td>
                                                    <td class="text-truncate" style="max-width: 150px;"
                                                        title="${o.account.fullName}">${o.account.fullName}</td>
                                                    <td class="text-truncate" style="max-width: 150px;"
                                                        title="${o.account.email}">${o.account.email}</td>
                                                    <td><a href="" class="btn btn-outline-info btn-sm"><i
                                                                class="bi bi-eye"></i> View Detail</a></td>
                                                    <td>
                                                        <button type="button" class="btn btn-outline-danger btn-sm"
                                                            style="color: red" data-toggle="modal"
                                                            data-target="#modelRemove_${o.id}">
                                                            <i class="bi bi-trash-fill"></i> Remove
                                                        </button>
                                                    </td>
                                                    <!-- ++++++++++++++++ Remove Company +++++++++++++++++ -->
                                                    <div class="modal fade" id="modelRemove_${o.id}" tabindex="-1"
                                                        aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                        <div class="modal-dialog">
                                                            <form action="/employee/removeCompany/${o.id}"
                                                                method="post">
                                                                <div class="modal-content text-center">
                                                                    <div class="modal-header"
                                                                        style="background: orange; text-align: center; display: unset;">
                                                                        <h5 class="modal-title" id="exampleModalLabel4">
                                                                            Remove Form
                                                                        </h5>
                                                                    </div>
                                                                    <h4>Are you sure you want to remove</h4>
                                                                    <h1 class="text-truncate text-center"
                                                                        title="${o.account.fullName}">
                                                                        ${o.account.fullName}</h1>
                                                                    <h4>This action cannot be undone.</h4>
                                                                    <div class="modal-footer">
                                                                        <button type="submit"
                                                                            class="btn btn-outline-danger btn-sm"
                                                                            style="color: red">
                                                                            <i class="bi bi-trash-fill"></i>
                                                                            Remove
                                                                        </button>
                                                                        <button type="button"
                                                                            class="btn btn-sm btn-outline-secondary"
                                                                            data-dismiss="modal">
                                                                            <i class="bi bi-x-circle"></i>
                                                                            Cancel
                                                                        </button>
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </div>
                                                    </div>
                                                    <!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
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

                            $(".custom-file-input").on("change", function () {
                                var fileName = $(this).val().split("\\").pop();
                                $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
                            });
                        </script>
            </body>

            </html>