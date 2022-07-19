<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
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

</head>

<body>
<jsp:include page="header.jsp"/>
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
<%
    session.setAttribute("successMessage", null);
    session.setAttribute("dangerMessage", null);
    session.setAttribute("warningMessage", null);
%>

<br/>
<div class="container">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb align-items-center">
            <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
            <li class="breadcrumb-item"><a href="/company" style="padding:0;display: inline;">Company</a>
            </li>
            <li class="breadcrumb-item"><a href="/company/internships"
                                           style="padding:0;display: inline;">List_Interns</a></li>
            <li class="breadcrumb-item active" aria-current="page">Evaluate</li>
        </ol>
    </nav>
</div>
<!-- content -->
<form class="mt-5" action="/employee/updateEvaluate/${process.id}">
    <div class="container rounded mt-5 mb-5">
        <div class="row form">
            <div class="col-lg-4 border-right">
                <div class="mt-5 mb-5 d-none d-lg-block" style="height: 30px;"></div>
                <div class="d-flex flex-column text-center p-3 py-5">
                    <img class="rounded-circle mx-auto d-block img-fluid mt-5 mb-3" style="height:300px"
                         src="${process.student.account.avatar==null?'/avatar/avatar.png':process.student.account.avatar}">
                    <span>Name: ${process.student.account.fullName}</span>
                    <span>Student ID: ${process.student.studentId}</span>
                    <span>Phone: ${process.student.account.phone}</span>
                    <span>Email: ${process.student.account.email}</span>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="p-3 py-5">

                    <h1 class="text-center">Evaluation Form</h1>
                    Job description
                    <div class="input-group">
                                    <textarea class="form-control" rows="4" name="jobDescription"
                                              aria-label="With textarea" value="${process.description}"
                                              required>${process.description}</textarea>
                    </div>


                    <div class="form-group row">
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                <th></th>
                                <th>Description</th>
                                <th>Grade</th>

                                </thead>
                                <tbody>
                                <tr>
                                    <th>
                                        <p>
                                            Knowledge
                                        </p>
                                    </th>
                                    <td>
                                        <div class="input-group">

                                                            <textarea class="form-control" rows="4" name="knowledge"
                                                                      aria-label="With textarea"
                                                                      value="${process.knowledge}"
                                                                      required>${process.knowledge}</textarea>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="dropdown text-center btn-lg btn-block">
                                            <select name="point1"
                                                    class="form-select form-select-lg mb-3 btn btn-primary btn-lg btn-block mt-3"
                                                    id="grade2" aria-label=".form-select-lg example">

                                                <option value="1" ${process.knowledgePoint==1?"selected":""}>1</option>
                                                <option value="2" ${process.knowledgePoint==2?"selected":""}>2</option>
                                                <option value="3" ${process.knowledgePoint==3?"selected":""}>3</option>
                                                <option value="4" ${process.knowledgePoint==4?"selected":""}>4</option>
                                                <option value="5" ${process.knowledgePoint==5?"selected":""}>5</option>
                                                <option value="6" ${process.knowledgePoint==6?"selected":""}>6</option>
                                                <option value="7" ${process.knowledgePoint==7?"selected":""}>7</option>
                                                <option value="8" ${process.knowledgePoint==8?"selected":""}>8</option>
                                                <option value="9" ${process.knowledgePoint==9?"selected":""}>9</option>
                                                <option value="10" ${process.knowledgePoint==10?"selected":""}>10
                                                </option>
                                            </select>
                                        </div>
                                    </td>

                                </tr>
                                <tr>
                                    <th>
                                        <p>
                                            Soft Skill
                                        </p>
                                    </th>
                                    <td>
                                        <div class="input-group">

                                                            <textarea class="form-control" rows="4" name="softSkill"
                                                                      aria-label="With textarea"
                                                                      value="${process.softSkill}"
                                                                      required>${process.softSkill}</textarea>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="dropdown text-center btn-lg btn-block">
                                            <select name="point2"
                                                    class="form-select form-select-lg mb-3 btn btn-primary btn-lg btn-block mt-3"
                                                    id="grade3" aria-label=".form-select-lg example"
                                                    required>
                                                <option value="1" ${process.softSkillPoint==1?"selected":""}>1</option>
                                                <option value="2" ${process.softSkillPoint==2?"selected":""}>2</option>
                                                <option value="3" ${process.softSkillPoint==3?"selected":""}>3</option>
                                                <option value="4" ${process.softSkillPoint==4?"selected":""}>4</option>
                                                <option value="5" ${process.softSkillPoint==5?"selected":""}>5</option>
                                                <option value="6" ${process.softSkillPoint==6?"selected":""}>6</option>
                                                <option value="7" ${process.softSkillPoint==7?"selected":""}>7</option>
                                                <option value="8" ${process.softSkillPoint==8?"selected":""}>8</option>
                                                <option value="9" ${process.softSkillPoint==9?"selected":""}>9</option>
                                                <option value="10" ${process.softSkillPoint==10?"selected":""}>10
                                                </option>
                                            </select>
                                        </div>

                                    </td>

                                </tr>
                                <tr>
                                    <th>
                                        <p>
                                            Attitude
                                        </p>
                                    </th>
                                    <td>
                                        <div class="input-group">

                                                            <textarea class="form-control" rows="4" name="attitude"
                                                                      aria-label="With textarea"
                                                                      value="${process.attitude}"
                                                                      required>${process.attitude}</textarea>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="dropdown text-center btn-lg btn-block">
                                            <select name="point3"
                                                    class="form-select form-select-lg mb-3 btn btn-primary btn-lg btn-block mt-3"
                                                    id="grade4" aria-label=".form-select-lg example"
                                                    required>
                                                <option value="1" ${process.attitudePoint==1?"selected":""}>1</option>
                                                <option value="2" ${process.attitudePoint==2?"selected":""}>2</option>
                                                <option value="3" ${process.attitudePoint==3?"selected":""}>3</option>
                                                <option value="4" ${process.attitudePoint==4?"selected":""}>4</option>
                                                <option value="5" ${process.attitudePoint==5?"selected":""}>5</option>
                                                <option value="6" ${process.attitudePoint==6?"selected":""}>6</option>
                                                <option value="7" ${process.attitudePoint==7?"selected":""}>7</option>
                                                <option value="8" ${process.attitudePoint==8?"selected":""}>8</option>
                                                <option value="9" ${process.attitudePoint==9?"selected":""}>9</option>
                                                <option value="10" ${process.attitudePoint==10?"selected":""}>10
                                                </option>
                                            </select>
                                        </div>
                                    </td>

                                </tr>
                                <tr>
                                    <th colspan="1">Average:</th>
                                    <td colspan="2" class="text-center"><input type="number" value="${process.grade}"
                                                                               class="mr-auto ml-auto" id="total"
                                                                               name="total" disabled></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>


                    <div class="mt-5 text-center">
                        <input type="submit" name="submit" class="btn btn-primary">
                    </div>
                </div>
            </div>

        </div>
    </div>
</form>
<hr>


<!-- footer -->
<footer>
    <jsp:include page="footer.jsp"/>
</footer>

<script>
    $(function () {
        $('#grade2, #grade3, #grade4').change(function () {
            var grade2 = parseInt($('#grade2').val(), 10) || 0;
            var grade3 = parseInt($('#grade3').val(), 10) || 0;
            var grade4 = parseInt($('#grade4').val(), 10) || 0;
            $('#total').val((grade2 + grade3 + grade4) / 3.0);
        });
    });
</script>
</body>

</html>