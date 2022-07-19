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
<jsp:include page="header.jsp"/>


<%@include file="sliderbar.jsp" %>
<br/>

<!-- content -->
<div class="container">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb align-items-center">
            <li class="breadcrumb-item"><a href="/company" style="padding:0">Company</a></li>
            <li class="breadcrumb-item active" aria-current="page">Internships</li>
        </ol>
    </nav>

    <c:if test="${successMessage != null}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${successMessage}
            <button type="button" class="close" data-dismiss="alert">&times;</button>
        </div>
    </c:if>
    <c:if test="${dangerMessage != null}">
        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                ${dangerMessage}
            <button type="button" class="close" data-dismiss="alert">&times;</button>
        </div>
    </c:if>
    <c:if test="${warningMessage != null}">
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
                ${warningMessage}
            <button type="button" class="close" data-dismiss="alert">&times;</button>
        </div>
    </c:if>
    <% session.setAttribute("successMessage", null);
        session.setAttribute("dangerMessage", null);
        session.setAttribute("warningMessage", null); %>

    <div class="form-group row align-items-center">
        <label for="inputDateVisit" class="col-md-4 col-form-label title">
            <h1 style="color: orange;">List Of Interns</h1>
        </label>

    </div>

    <button class="btn btn-outline-info" formaction="<c:url value=" /" />">
        <i class="bi bi-box-arrow-in-down"></i> Export
    </button>


    <hr>
    <div class="container">
        <div class="table-responsive">

            <table id="myTable" class="table table-striped text-center">
                <thead>
                <tr>
                    <th class="text-center">No.</th>
                    <th class="text-center">Student Name</th>
                    <th class="text-center">Information</th>
                    <th class="text-center">Evaluation Detail</th>
                    <!-- <th>Grade</th> -->
                    <th class="text-center">Status</th>
                    <%--<th>Verifier</th>--%>
                    <th class="text-center">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${processList}" var="o" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td class="text-truncate" style="max-width: 150px;"
                            title="${o.student.account.fullName}">${o.student.account.fullName}
                        </td>
                        <td>
                            <button class="btn btn-outline-info btn-sm" data-toggle="modal"
                                    data-target="#viewModal_${o.id}">
                                <i class="bi bi-eye"></i> View
                            </button>
                        </td>
                        <td>
                            <button class="btn btn-outline-info btn-sm" data-toggle="modal"
                                    data-target="#evaluateModal_${o.id}">
                                <i class="bi bi-eye"></i> Evaluate
                            </button>
                        </td>
                        <td>${o.status}</td>
                        <td>
                            <button type="button" class="btn btn-outline-primary btn-sm"
                                    data-toggle="modal" data-target="#updateModel_${o.id}">
                                <i class="fa fa-refresh"></i> Update
                            </button>
                                <%--<button type="button" class="btn btn-outline-danger btn-sm"
                                    style="color: red" data-toggle="modal"
                                    data-target="#removeModel_${o.id}">
                                    <i class="fa fa-trash"></i> Remove
                                    </button>--%>

                            <!-- ++++++++++++++++ Update Requirement +++++++++++++++++ -->
                            <div class="modal fade" id="updateModel_${o.id}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <form action="/company/updateProcess/${o.id}"
                                          method="post">
                                        <div class="modal-content text-center">
                                            <div class="modal-header"
                                                 style="background: orange; text-align: center; display: unset;">
                                                <h5 class="modal-title"
                                                    id="exampleModalLabel2">Update Form</h5>
                                            </div>
                                            <div class="modal-body text-center">
                                                <div class="input-group mb-3">
                                                                                <span class="input-group-text"
                                                                                      id="basic-addon1">Start date</span>
                                                    <input type="date" class="form-control"
                                                           id="startDate"
                                                           value="${o.startDate}"
                                                           placeholder="Enter Start Date"
                                                           name="startDate" required>
                                                </div>
                                                <div class="input-group mb-3">
                                                                                <span class="input-group-text"
                                                                                      id="basic-addon1">End date</span>
                                                    <input type="date" class="form-control"
                                                           id="endDate" value="${o.endDate}"
                                                           placeholder="Enter End Date"
                                                           name="endDate" required>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="submit"
                                                        class="btn btn-sm btn-outline-success"
                                                        id="import"><i
                                                        class="bi bi-check-circle"></i>Upload
                                                </button>
                                                <button type="button"
                                                        class="btn btn-sm btn-outline-danger"
                                                        data-dismiss="modal"><i
                                                        class="bi bi-x-circle"></i>Cancel
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- ++++++++++++++++ End Update Requirement +++++++++++++++++ -->

                        </td>
                    </tr>

                    <!-- Evaluate Modal -->

                    <div class="modal fade" id="evaluateModal_${o.id}" tabindex="-1"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">

                            <div class="modal-content text-center">
                                <form action="/company/updateEvaluate/${o.id}">
                                    <div class="modal-header"
                                         style="background: orange; text-align: center; display: unset;">
                                        <h5 class="modal-title" id="exampleModalLabel">Evaluate
                                            Detail
                                        </h5>
                                    </div>
                                    <div class="modal-body text-center">

                                        <div class="mb-3">
                                            <img src="${o.student.account.avatar==null?'/img/default.png':o.student.account.avatar}"
                                                 alt="avatar image"
                                                 class="img-fluid" style="height: 150px;"
                                                 disabled>
                                        </div>

                                        <div class="input-group mb-3">
                                                                    <span class="input-group-text" id="basic-addon1">Job
                                                                        Description</span>

                                            <textarea class="form-control" id="description"
                                                      placeholder="Enter Description"
                                                      name="jobDescription" required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}
                                                      value="${o.description}">${o.description}</textarea>

                                        </div>

                                        <div class="form-row">
                                            <div class="col-9 input-group mb-3">
                                                                        <span class="input-group-text"
                                                                              id="basic-addon1">Knowledge</span>
                                                <textarea class="form-control" id="requirement"
                                                          placeholder="Enter Knowledge Evaluate"
                                                          name="knowledge" value="${o.knowledge}" required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}
                                                >${o.knowledge}</textarea>
                                            </div>

                                            <div class="col-3 input-group mb-3">
                                                <select name="point1" class="custom-select"
                                                        id="grade1"
                                                        aria-label=".form-select-lg example" value="${o.knowledgePoint}"
                                                        required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}>
                                                    <c:forEach begin="0" end="10" step="1" var="it">
                                                        <option value="${it}"
                                                            ${o.knowledgePoint==it?"selected":""}>
                                                                ${it}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col-9 input-group mb-3">
                                                                        <span class="input-group-text"
                                                                              id="basic-addon1">Soft skill</span>
                                                <textarea class="form-control" id="requirement"
                                                          placeholder="Enter Soft Skill Evaluate"
                                                          name="softSkill" value="${o.softSkill}" required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}
                                                >${o.softSkill}</textarea>
                                            </div>

                                            <div class="col-3 input-group mb-3">
                                                <select name="point2" class="custom-select"
                                                        id="grade2"
                                                        aria-label=".form-select-lg example" value="${o.softSkillPoint}"
                                                        required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}>
                                                    <c:forEach begin="0" end="10" step="1" var="it">
                                                        <option value="${it}"
                                                            ${o.softSkillPoint==it?"selected":""}>
                                                                ${it}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-row">
                                            <div class="col-9 input-group mb-3">
                                                                        <span class="input-group-text"
                                                                              id="basic-addon1">Attitude</span>
                                                <textarea class="form-control" id="requirement"
                                                          placeholder="Enter Attitude Evaluate"
                                                          name="attitude" value="${o.attitude}"
                                                          required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}>${o.attitude}</textarea>
                                            </div>

                                            <div class="col-3 input-group mb-3">
                                                <select name="point3" class="custom-select"
                                                        id="grade3"
                                                        aria-label=".form-select-lg example" value="${o.attitudePoint}"
                                                        required ${o.status=="Passed" || o.status == "Not Passed"?"disabled":""}>
                                                    <c:forEach begin="0" end="10" step="1" var="it">
                                                        <option value="${it}"
                                                            ${o.attitudePoint.equals(it)?"selected":""}>
                                                                ${it}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="input-group mb-3">
                                                                    <span class="input-group-text"
                                                                          id="basic-addon1">Grade</span>
                                            <input type="number" class="form-control" id="total"
                                                   value="${o.grade}" name="total" disabled>
                                        </div>

                                    </div>


                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-outline-success" ${o.status=="Passed" || o.status == "Not Passed"?"hidden":""}
                                                id="import"><i class="bi bi-check-circle"></i>
                                            Save
                                        </button>
                                        <button type="button" class="btn btn-outline-danger"
                                                data-dismiss="modal"><i class="bi bi-x-circle"></i>
                                            Close
                                        </button>
                                    </div>
                                </form>
                            </div>

                        </div>
                    </div>

                    <!-- +++++++++++++++++++++++++++++++++++++++++ -->

                    <!-- View Modal -->

                    <div class="modal fade" id="viewModal_${o.id}" tabindex="-1"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content text-center">
                                <div class="modal-header"
                                     style="background: orange; text-align: center; display: unset;">
                                    <h5 class="modal-title" id="exampleModalLabel">Detail
                                        Information
                                    </h5>
                                </div>
                                <div class="modal-body text-center">
                                    <div class="mb-3">
                                        <img src="${o.student.account.avatar==null?'/img/default.png':o.student.account.avatar}"
                                             alt="avatar image"
                                             class="img-fluid" style="height: 150px;" disabled>
                                    </div>

                                    <div class="input-group mb-3">
                                                                <span class="input-group-text" id="basic-addon1"><i
                                                                        class='fas fa-user-graduate'></i></span>
                                        <input type="text" class="form-control" id="studentName"
                                               name="studentName"
                                               value="${o.student.account.fullName}" disabled>
                                    </div>

                                    <div class="input-group mb-3">
                                                                <span class="input-group-text" id="basic-addon1"><i
                                                                        class='fas fa-id-card'></i></span>
                                        <input type="text" class="form-control" id="studentId"
                                               name="studentId" value="${o.student.studentId}"
                                               disabled>
                                    </div>

                                    <div class="input-group mb-3">
                                                                <span class="input-group-text" id="basic-addon1"><i
                                                                        class='fas fa-calendar-alt'></i></span>
                                        <input type="text" class="form-control" id="semester"
                                               name="semester"
                                               value="${o.application.semester.semester}" disabled>
                                    </div>

                                    <div class="input-group mb-3">
                                                                <span class="input-group-text" id="basic-addon1">
                                                                    <i class="bi bi-geo-fill"></i>
                                                                </span>
                                        <input type="text" class="form-control" name="position"
                                               id="position"
                                               value="${o.application.job.position.position}"
                                               disabled>
                                    </div>

                                    <div class="input-group mb-3">
                                                                <span class="input-group-text" id="basic-addon1"><i
                                                                        class="bi bi-envelope-fill"></i></span>
                                        <input type="email" class="form-control"
                                               id="studentEmail" placeholder="Student Email"
                                               name="studentEmail" value="${o.student.account.email}" disabled>
                                    </div>

                                    <div class="form-row">
                                        <div class="col-6 input-group mb-3">
                                                                    <span class="input-group-text"
                                                                          id="basic-addon1">Start Date</i></span>
                                            <input type="text" class="form-control"
                                                   name="startDate" value="${o.startDate}"
                                                   disabled>
                                        </div>
                                        <div class="col-6 input-group mb-3">
                                                                    <span class="input-group-text" id="basic-addon1">End
                                                                        Date</span>
                                            <input type="text" class="form-control"
                                                   name="endDate" value="${o.endDate}" disabled>
                                        </div>
                                    </div>


                                </div>

                                <div class="modal-footer mr-auto ml-auto">
                                    <button type="button" class="btn btn-outline-danger"
                                            data-dismiss="modal"><i class="bi bi-x-circle"></i>
                                        Close
                                    </button>
                                </div>
                            </div>

                        </div>
                    </div>

                    <!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
</div>
<hr>
<!-- footer -->
<footer>
    <jsp:include page="footer.jsp"/>
</footer>

<script src=" https://code.jquery.com/jquery-3.5.1.js"></script>
<script src=" https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src=" https://cdn.datatables.net/1.12.1/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#myTable').DataTable();
    });

    $(function () {
        $('#grade1, #grade2, #grade3').change(function () {
            var grade1 = parseInt($('#grade1').val(), 10) || 0;
            var grade2 = parseInt($('#grade2').val(), 10) || 0;
            var grade3 = parseInt($('#grade3').val(), 10) || 0;
            $('#total').val((grade1 + grade2 + grade3) / 3.0);
        });
    });
</script>
</body>

</html>