<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <title>Homepage</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/CSS/styles.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
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
    <script src="https://kit.fontawesome.com/dda2b72c9e.js" cross-origin="anonymous"></script>
    <%--<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        rel="stylesheet">
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        --%>
</head>

<body>
${mess}
<%@include file="header.jsp" %>
<c:if test="${successMessage != null}">
    <div class="container alert alert-success alert-dismissible fade show" role="alert">
            ${successMessage}
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
</c:if>
<c:if test="${dangerMessage != null}">
    <div class="container alert alert-danger alert-dismissible fade show" role="alert">
            ${dangerMessage}
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
</c:if>
<c:if test="${warningMessage != null}">
    <div class="container alert alert-warning alert-dismissible fade show" role="alert">
            ${warningMessage}
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
</c:if>
<% session.setAttribute("successMessage", null);
    session.setAttribute("dangerMessage", null);
    session.setAttribute("warningMessage", null); %>


<div class="container">
    <div class="row align-items-center text-center">
        <div class="col-12 ${account.role.equals('STUDENT')=='true'?'col-md-8':'col-12'}">
            <h1 class="ml-5" style="text-align: center;display: inline ;color: orange;">
                Looking for an internship chance?
            </h1>
        </div>
        <div class="col-12 col-md-4">
            <!-- <a href="/student/externalApply" style="display: ${account.role.equals('STUDENT')=='true'?'inline':'none'}"> -->
            <button style="background-color: #00ff00; width: 150px; border-radius: 22px;
                                border: none; font-size: 14px; 
                                display: ${account.role.equals('STUDENT')=='true'?'inline':'none'}" data-toggle="modal"
                    data-target="#externalModal">
                <span style="font-weight: 700; color: white;">Already Intern</span>
                <br/>
                <span style="font-weight: 600; color: red;">Click here</span>
            </button>
            <!-- </a> -->
        </div>

    </div>
</div>

<!-- +++++++++++++++++++++++++External Apply Modal +++++++++++++++++++++++++++++++++++++-->
<div class="modal fade" id="externalModal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <form action="/student/applyAnExternal" method="post" enctype="multipart/form-data">
            <div class="modal-content text-center">
                <div class="modal-header"
                     style="background: orange; text-align: center; display: unset;">
                    <h5 class="modal-title" id="exampleModalLabel">External Application Form
                    </h5>
                </div>
                <div class="modal-body text-center">

                    <div class="input-group mb-3">
                                                    <span class="input-group-text" id="basic-addon1"><i
                                                            class="bi bi-building"></i></span>
                        <input type="text" class="form-control" id="nameCompany"
                               placeholder="Company name" name="companyName" required>
                    </div>

                    <div class="input-group mb-3">
                                                    <span class="input-group-text" id="basic-addon1"><i
                                                            class="bi bi-envelope-fill"></i></span>
                        <input type="email" class="form-control" id="mailCompany"
                               placeholder="Company mail" name="companyEmail" required>
                    </div>

                    <div class="input-group mb-3">
                                                    <span class="input-group-text" id="basic-addon1"><i
                                                            class="bi bi-telephone-fill"></i></span>
                        <input type="tel" class="form-control" id="phoneCompany"
                               placeholder="Company phone" name="companyPhone" required>
                    </div>

                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                                        <span class="input-group-text" id="inputGroupFileAddon01"
                                                              style="height: 35px;">Contract</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" class="custom-file-input"
                                   id="inputGroupFile01" name="contract"
                                   aria-describedby="inputGroupFileAddon01" accept=".pdf" required>
                            <label class="custom-file-label" for="inputGroupFile01">Choose
                                file</label>
                        </div>
                    </div>

                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                                                        <span class="input-group-text" id="inputGroupFileAddon01"
                                                              style="height: 35px;">
                                                            Letter
                                                        </span>
                        </div>
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" name="letter"
                                   aria-describedby="inputGroupFileAddon01" accept=".pdf" required>
                            <label class="custom-file-label" for="inputGroupFile01">Choose
                                file</label>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-sm btn-outline-success"
                            id="import"><i class="bi bi-check-circle"></i>
                        Upload
                    </button>
                    <button type="button" class="btn btn-sm btn-outline-danger"
                            data-dismiss="modal"><i class="bi bi-x-circle"></i>
                        Cancel
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
<br/>
<div class="container">

    <br/>
    <div>
        <div
                style="margin-bottom:20px; padding:10px; background-color:#336699; color:white;">
            <p>Type some text to search the List:</p>
            <input class="form-control" id="myInput" type="text" placeholder="Search.."/>
            <form class="form-row m-0" action="/home">
                <%--<div class="col-3 input-group mb-3 mt-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text d-none d-lg-block"
                            for="inputGroupSelect01">Major</label>
                    </div>
                    <select class="custom-select" id="inputGroupSelect01" name="major">
                        <option selected value="-1">Select...</option>
                        <c:forEach var="o" items="${majorList}">
                            <option value="${o.id}">${o.name}</option>
                        </c:forEach>
                    </select>
                </div>--%>

                <div class="col-3 input-group mb-3 mt-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text d-none d-lg-block"
                               for="inputGroupSelect01">Position</label>
                    </div>
                    <select class="custom-select" id="inputGroupSelect01" name="position" style="height: 40px">
                        <option value="-1">None</option>
                        <c:forEach var="o" items="${positionList}">
                            <option value="${o.id}" ${positionID==o.id?"selected":""}>${o.position}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="col-3 input-group mb-3 mt-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text d-none d-lg-block"
                               for="inputGroupSelect01">Sort</label>
                    </div>
                    <select class="custom-select" id="inputGroupSelect01" name="sort" style="height: 40px">
                        <option value="-1">None</option>
                        <option value="1" ${sortID==1?"selected":""}>Sort increasing by date
                        </option>
                        <option value="2" ${sortID==2?"selected":""}>Sort decreasing by date
                        </option>
                        <option value="3" ${sortID==3?"selected":""}>Sort increasing by slot
                        </option>
                        <option value="4" ${sortID==4?"selected":""}>Sort decreasing by slot
                        </option>
                    </select>
                </div>
                <c:if test="${account.role.equals('STUDENT') == true}">
                    <div class="col-3 input-group mb-3 mt-3">
                        <div class="input-group-prepend">
                            <label class="input-group-text d-none d-lg-block"
                                   for="inputGroupSelect01">Recommend</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01" name="recommend" style="height: 40px">
                            <option value="-1">None</option>
                            <option value="1" ${recommendID==1?"selected":""}>Recommend
                            </option>
                            </option>
                        </select>
                    </div>
                </c:if>
                <div class="col-3 mt-3 mb-3">
                    <button type="submit" class="btn btn-info btn-sm btn-block"
                            style="padding: 8px;"><i class="bi bi-funnel-fill"></i> Filter
                    </button>
                </div>

            </form>
        </div>

    </div>
</div>
<div class="container main-content">
    <div class="row" style="justify-content: center;">
        <c:forEach items="${jobList}" var="o">
            <div class="col-12 col-lg-3 list-comp mr-auto ml-auto mt-3">
                <form
                        style="text-align: center; display: block;">
                    <img src="${o.company.account.avatar==null?'/img/avatar.png':o.company.account.avatar}"
                         width="300" class="mt-3" height="150px" class="img-fluid rounded mx-auto d-block">
                    <hr id="hr"/>
                    <strong>Position: </strong>${o.position.position}<br/>
                    <strong>End date: </strong>${o.endDate}<br/>
                    <strong>Available slot: </strong>${o.slot}<br/>
                    <strong>${o.recommend}</strong>
                    <div class="mt-3">
                            <%--<a href="/view/recruitment/${o.id}"
                                style="display: block; margin-top: 1em">
                                <input type="button" class="btn" name="">Details</input>
                                </a>--%>
                        <a href="/view/recruitment/${o.id}"><input type="button"
                                                                   value="Details"
                                                                   style=" background-color: #ccffcc; border-radius: 10px; padding: 4px 25px"/></a>
                    </div>
                </form>
            </div>
        </c:forEach>
    </div>
    <br/>
    <!-- Phân Trang -->
    <div class="row">
        <div class="col" style="text-align: right;">
            <br/>
            <form action="/home">
                <button type="submit" class="btn btn-sm btn-info" name="op" value="FirstPage" title="First Page" <c:if test="${page==1}">disabled</c:if>><i class="bi bi-chevron-bar-left"></i></button>
                <button type="submit" class="btn btn-sm btn-info" name="op" value="PreviousPage" title="Previous Page" <c:if test="${page==1}">disabled</c:if>><i class="bi bi-chevron-left"></i></button>
                <button type="submit" class="btn btn-sm btn-info" name="op" value="NextPage" title="Next Page" <c:if test="${page==totalPage}">disabled</c:if>><i class="bi bi-chevron-right"></i></button>
                <button type="submit" class="btn btn-sm btn-info" name="op" value="LastPage" title="Last Page" <c:if test="${page==totalPage}">disabled</c:if>><i class="bi bi-chevron-bar-right"></i></button>
                <input type="text" name="gotoPage" value="${page}" class="btn btn-sm btn-outline-default" style="text-align: right;width: 32px;" title="Enter page number"/>
                <button type="submit" class="btn btn-sm btn-info" name="op" value="GotoPage" title="Goto Page"><i class="bi bi-arrow-up-right-circle"></i></button>
            </form>
            Page ${page}/${totalPage}
        </div>
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
    $(".custom-file-input").on("change", function () {
        var fileName = $(this).val().split("\\").pop();
        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
    });
</script>
</body>

</html>