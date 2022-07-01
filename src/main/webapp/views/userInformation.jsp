<%-- Document : studentinfo Created on : Jun 13, 2022, 6:12:19 PM Author : admin --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Form student' information</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                .form {
                    background: #FC8902;
                    border-radius: 108px;
                }

                .border-right {
                    border-right: 1px solid black;

                }
            </style>
        </head>

        <body>
            <%@include file="header.jsp" %>
                <br />
                <div class="container">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb align-items-center">
                            <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Profile</li>
                        </ol>
                    </nav>
                </div>
                <form action="/account/update" ModelAttribute="information" enctype="multipart/form-data" method="POST">
                    <div class="container rounded bg-white mt-5 mb-5">
                        <div class="row form">
                            <div class="col-12 col-lg-4 border-right">
                                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                    <figure class="snip1336">
                                        <figcaption>
                                            <img src="/img/avatar.png" alt="profile-sample4"
                                                style="width: 300px;height: 300px;" class="profile img-fluid mt-5 pt-5"
                                                id="thumbnail" /><br />

                                            <div class="custom-file mt-3">
                                                <input type="file" class="custom-file-input" id="fileImage">
                                                <label class="custom-file-label" for="customFile">Choose file</label>
                                            </div>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                            <div class="col-12 col-lg-8">
                                <div class="p-3 py-5">
                                    <div class=" align-items-center mb-3 text-center">
                                        <h1>My Profile</h1>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Full Name</label>
                                                <input type="hidden" value="${user.id}" name="id" />
                                                <input name="fullName" id="name" type="text" class="form-control"
                                                    value="${user.fullName}" placeholder="Full Name" disabled />
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Email</label>
                                                <input name="email" id="email" type="email" class="form-control"
                                                    value="${user.email}" placeholder="Email" disabled />
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Address</label>
                                                <input name="address" id="address" type="text" class="form-control"
                                                    value="${user.address}" placeholder="Address" />
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Phone number</label>
                                                <input name="phone" id="phone" type="text" class="form-control"
                                                    value="${user.phone}" placeholder="Phone number"
                                                    pattern="[0-9]{10}" />
                                            </div>
                                        </div>

                                        <c:if test="${user.role.equals('STUDENT')==true}">
                                            <div class="col-md-6">
                                                <div class="mb-3">
                                                    <label class="form-label">Student ID</label>
                                                    <input name="studentId" id="studentId" type="text"
                                                        class="form-control" value="${student.studentId}"
                                                        placeholder="Student ID" />
                                                </div>
                                            </div>
                                            <!--end col-->
                                            <div class="col-md-6">
                                                <div class="mb-3">
                                                    <label class="form-label">Date of birth</label>
                                                    <input name="dateOfBirth" id="dob" type="date" class="form-control"
                                                        value="${student.dateOfBirth}" placeholder="Date of birth" />
                                                </div>
                                            </div>
                                            <!--end col-->

                                            <div class="col-md-6">
                                                <div class="mb-3">
                                                    <label class="form-label">Gender</label><br />
                                                    <input name="gender" id="male" type="radio" value="Male" <c:if
                                                        test="${student.gender.equals('Male')==true}"> checked
                                        </c:if>
                                        />
                                        <label for="Male">Male</label>
                                        <input name="gender" id="female" type="radio" value="Female" <c:if
                                            test="${student.gender.equals('Female')==true}"> checked </c:if>
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
                                            <textarea name="description" id="description"   class="form-control"
                                                value="${company.description}" placeholder="Company Description" >${company.description}</textarea>
                                        </div>
                                    </div>
                                    <!--end col-->
                                </c:if>

                                <c:if test="${user.role.equals('EMPLOYEE')==true}">


                                </c:if>
                            </div>
                            <br />
                            <div class="row">
                                <div class="col-12 col-md-6 mt-5 text-center">
                                    <button class="btn btn-primary profile-button" type="submit">Save Profile</button>
                                </div>
                            </div>

                        </div>
                    </div>
                    </div>
                    </div>
                </form>
                <jsp:include page="footer.jsp" />
                <script>
                    $(".hover").mouseleave(
                        function () {
                            $(this).removeClass("hover");
                        }
                    );
                    $(document).ready(function () {
                        $('#fileImage').change(function () {
                            showImageThumbnail(this);
                        })
                    });
                    function showImageThumbnail(fileInput) {
                        file = fileInput.files[0];
                        reader = new FileReader();
                        reader.onload = function (e) {
                            $('#thumbnail').attr('src', e.target.result);
                        };
                        reader.readAsDataURL(file);
                    }
                    $(".custom-file-input").on("change", function () {
                        var fileName = $(this).val().split("\\").pop();
                        $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
                    });
                </script>
        </body>

        </html>