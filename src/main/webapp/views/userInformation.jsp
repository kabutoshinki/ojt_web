<%-- 
    Document   : studentinfo
    Created on : Jun 13, 2022, 6:12:19 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Form student' information</title>
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
        <div class="container" style="border-radius: 40px; padding: 25px;">
            <div class="row">
                <div class="col-sm-5">
                    <form action="/account/update" ModelAttribute="information" enctype="multipart/form-data" method="POST">

                            <figure class="snip1336">
                                <figcaption>
                                    <img src="/img/avatar.png" alt="profile-sample4" class="profile img-thumbnail" id="thumbnail" /><br/>
                                    <input id="fileImage" name="imgavatar" type="file" value="Avatar" title="" />
                                </figcaption>
                            </figure>

                    </form>
                </div>
                <div class="col-sm-7 col-md-6">
                    <form  action="/account/update" method="POST">


                        <div class="row">
                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">Full Name</label>
                                    <input type="hidden" value="${user.id}" name="id"/>
                                    <input
                                        name="fullName"
                                        id="name"
                                        type="text"
                                        class="form-control"
                                        value="${user.fullName}"
                                        placeholder="Full Name"
                                        disabled
                                        />
                                </div>
                            </div>
                            <!--end col-->

                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">Email</label>
                                    <input
                                        name="email"
                                        id="email"
                                        type="email"
                                        class="form-control"
                                        value="${user.email}"
                                        placeholder="Email"
                                        disabled
                                        />
                                </div>
                            </div>
                            <!--end col-->

                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">Address</label>
                                    <input
                                        name="address"
                                        id="address"
                                        type="text"
                                        class="form-control"
                                        value="${user.address}"
                                        placeholder="Address"
                                        />
                                </div>
                            </div>
                            <!--end col-->

                            <div class="col-md-6">
                                <div class="mb-3">
                                    <label class="form-label">Phone Number</label>
                                    <input
                                        name="phone"
                                        id="phone"
                                        type="text"
                                        class="form-control"
                                        value="${user.phone}"
                                        placeholder="Phone number"
                                        pattern="[0-9]{10}"
                                        />
                                </div>
                            </div>
                            <!--end col-->

                            <c:if test="${user.role.equals('STUDENT')==true}">
                                <div class="col-md-6">
                                    <div class="mb-3">
                                        <label class="form-label">Student ID</label>
                                        <input
                                            name="studentId"
                                            id="studentId"
                                            type="text"
                                            class="form-control"
                                            value="${student.studentId}"
                                            placeholder="Student ID"
                                            />
                                    </div>
                                </div>
                                <!--end col-->
                                <div class="col-md-6">
                                    <div class="mb-3">
                                        <label class="form-label">Date of birth</label>
                                        <input
                                            name="dateOfBirth"
                                            id="dob"
                                            type="date"
                                            class="form-control"
                                            value="${student.dateOfBirth}"
                                            placeholder="Date of birth"
                                            />
                                    </div>
                                </div>
                                <!--end col-->

                                <div class="col-md-6">
                                    <div class="mb-3">
                                        <label class="form-label">Gender</label><br />
                                        <input name="gender" id="male" type="radio" value="Male"
                                            <c:if test="${student.gender.equals('Male')==true}"> checked </c:if>
                                            />
                                        <label for="Male">Male</label>
                                        <input name="gender" id="female" type="radio" value="Female"
                                            <c:if test="${student.gender.equals('Female')==true}"> checked </c:if>
                                            />
                                        <label for="Female">Female</label><br />
                                    </div>
                                </div>
                                <!--end col-->
                            </c:if>

                            <c:if test="${user.role.equals('COMPANY')==true}">
                                <div class="col-md-12">
                                    <div class="mb-3">
                                        <label class="form-label">Description</label>
                                        <input
                                            name="description"
                                            id="description"
                                            type="text"
                                            class="form-control"
                                            value="${company.description}"
                                            placeholder="Company Description"
                                            />
                                    </div>
                                </div>
                                <!--end col-->
                            </c:if>

                            <c:if test="${user.role.equals('EMPLOYEE')==true}">


                            </c:if>


                            <br/>
                            <div class="col-md-12">
                                <div class="mb-3">
                                    <p><button type="submit" style="width: 30%">Save Change</button></p>
                                </div>
                            </div>
                        </div>

                </form>
                </div>
                                           <!--end row-->
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
        <script>
            $(".hover").mouseleave(
                    function () {
                        $(this).removeClass("hover");
                    }
            );
            $(document).ready(function(){
            $('#fileImage').change(function(){
                showImageThumbnail(this);
            })
        });
        function showImageThumbnail(fileInput){
            file = fileInput.files[0];
            reader = new FileReader();
            reader.onload = function(e){
                $('#thumbnail').attr('src', e.target.result);
            };
            reader.readAsDataURL(file);
        }
        </script>
    </body>
</html>
