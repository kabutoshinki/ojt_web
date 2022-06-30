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
            <style>
                option {
                    overflow: auto;
                }
                a{
                    text-decoration: none;
                }
            </style>

        </head>

        <body>
            <jsp:include page="header.jsp"/>

             <div class="container">
                                    <nav aria-label="breadcrumb">
                                        <ol class="breadcrumb align-items-center">
                                            <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                                            <li class="breadcrumb-item"><a href="/company/managePage"
                                                    style="padding:0;display: inline;">Company</a></li>
                                            <li class="breadcrumb-item active" aria-current="page">Post_Internship_Requirement</li>
                                        </ol>
                                    </nav>
                                    </div>
            <!-- content -->
            <form class="mt-5" action="/company/insertJob" method="POST" ModelAttribute="Job">
                <div class="container rounded mt-5 mb-5">
                    <div class="row form">
                        <div class="col-md-4 border-right">
                            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                <img class="rounded-circle mt-5 mb-3" src="/img/logocompany.png">
                                <span>Company Name: Fsoft</span>
                                <span class="text-black-50">Phone: 02873005588</span>
                                <span>Mail: daihoc.hcm@fpt.edu.vn</span>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3 text-center">
                                    <h1>Đăng ký Doanh Nghiệp</h1>
                                </div>

                                <!-- <div class="form-group row">
                                    <label for="inputJob" class="col-sm-3 col-form-label">Apply Job</label>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control" name="applyJob" placeholder="">
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div> -->

                                <div class="form-group row">
                                    <label for="inputDescription" class="col-sm-3 col-form-label">Job
                                        Description</label>
                                    <div class="col-sm-6">
                                        <textarea class="form-control" name="description" id="description"
                                            rows="3"></textarea>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                                <div class="form-group row">
                                    <label for="inputSkill" class="col-sm-3 col-form-label">Job Requirements</label>
                                    <div class="col-sm-6">
                                        <textarea class="form-control" name="requirement" id="skill"
                                            rows="3"></textarea>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>
                                <div class="form-group row">
                                    <label for="Start Date" class="col-sm-3 col-form-label">Start Date</label>
                                    <div class="col-sm-6">
                                        <input type="date" name="startDate" id="">
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>
                                <div class="form-group row">
                                    <label for="End Date" class="col-sm-3 col-form-label">End Date</label>
                                    <div class="col-sm-6">
                                        <input type="date" name="endDate" id="">
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputMajor" class="col-sm-3 col-form-label">Major</label>
                                    <div class="col-sm-6" >
                                        <select class="form-control text-center" name ="positionId" aria-label="Default select example" >
                                            <c:forEach items="${positionList}" var= "o">
                                                <option value="${o.id}">
                                                    ${o.position}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                                <div class="form-group row">
                                    <label for="inputSlot" class="col-sm-3 col-form-label">Slot</label>
                                    <div class="col-sm-6">
                                        <input type="number" class="form-control" name="slot" placeholder="" value="1"
                                            min="1">
                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>

                                <div class="form-group row">
                                    <label for="inputVisit" class="col-sm-3 col-form-label">Form Visit</label>
                                    <div class="col-sm-7">
                                        <a class="btn btn-primary" href="formVisit.html">Create From</a>
                                    </div>
                                    <div class="col-sm-2"></div>
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
            <hr>
            <div class="space">

            </div>
        </body>

        </html>