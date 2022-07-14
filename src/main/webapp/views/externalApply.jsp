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

            </head>

            <body>
                <%@include file="header.jsp" %>

                    <br />
                    <div class="container">

                        <nav aria-label="breadcrumb">
                            <ol class="breadcrumb align-items-center">
                                <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">External Apply</li>
                            </ol>
                        </nav>

                        <br />
                        <div class="container" style="justify-content: center;">
                            <div>
                                <div class="row">
                                    <div class="col">
                                        <h1 style="color: orange">Apply for an External Company</h1>
                                    </div>
                                </div>
                                <br />
                                <form action="/student/applyAnExternal" method="post" enctype="multipart/form-data">
                                    <div class="modal-body text-center">
                                        <%--<div class="input-group mb-3">
                                            <div class="input-group-prepend">
                                                <label class="input-group-text" for="inputGroupSelect01">Position</label>
                                            </div>
                                            <select class="custom-select" id="inputGroupSelect01" name="position">
                                                <option selected>Choose...</option>
                                                <c:forEach var="o" items="${positionList}">
                                                    <option value="${o.id}">${o.position}</option>
                                                </c:forEach>
                                            </select>
                                        </div>--%>

                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="basic-addon2">Contract</span>
                                            <input type="file" class="form-control"
                                                   placeholder="Contract" name="contract" required>
                                        </div>

                                        <div class="input-group mb-3">
                                            <span class="input-group-text" id="basic-addon3">Letter</span>
                                            <input type="file" class="form-control"
                                                   placeholder="Letter" name="letter" required>
                                        </div>

                                    </div>
                                    <button type="submit" class="btn btn-sm btn-outline-success">
                                        <i class="bi bi-check-circle"></i>Upload
                                    </button>
                                </form>

                            </div>
                        </div>
                        <br />

                    </div>
                    </div>
                    <jsp:include page="footer.jsp" />
            </body>

            </html>