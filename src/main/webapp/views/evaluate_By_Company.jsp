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
            <jsp:include page="header.jsp" />
            <br/>
            <div class="container">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb align-items-center">
                        <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                        <li class="breadcrumb-item"><a href="/company/managePage" style="padding:0;display: inline;">Company</a></li>
                        <li class="breadcrumb-item"><a href="/company/internsList" style="padding:0;display: inline;">List_Interns</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Evaluate</li>
                    </ol>
                </nav>
            </div>
            <!-- content -->
            <form class="mt-5" action="form.html">
                <div class="container rounded mt-5 mb-5">
                    <div class="row form">
                        <div class="col-lg-4 border-right">
                            <div class="mt-5 mb-5 d-none d-lg-block" style="height: 30px;"></div>
                            <div class="d-flex flex-column text-center p-3 py-5">
                                <img class="rounded-circle mx-auto d-block img-fluid mt-5 mb-3" style="height:300px"
                                    src="/img/avatar.jpg">
                                <span>Name: Nguyễn Hoàng Huy</span>
                                <span>MSSV: SE151464</span>
                                <span>Phone: 02873005588</span>
                                <span>Email: huynhse151464@fpt.edu.vn</span>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="p-3 py-5">

                                <h1 class="text-center">Evaluation Form</h1>


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
                                                            Job description
                                                        </p>
                                                    </th>
                                                    <td>
                                                        <div class="input-group">

                                                            <textarea class="form-control" rows="4" name="description_1"
                                                                aria-label="With textarea" required></textarea>
                                                        </div>

                                                    </td>
                                                    <td>
                                                        <div class="dropdown text-center btn-lg btn-block">
                                                            <select
                                                                class="form-select form-select-lg mb-3 btn btn-primary btn-lg btn-block mt-3"
                                                                id="grade1" aria-label=".form-select-lg example"
                                                                required>
                                                                <option value="" class="text-center" selected>Grade
                                                                </option>
                                                                <option value="1">1</option>
                                                                <option value="2">2</option>
                                                                <option value="3">3</option>
                                                                <option value="4">4</option>
                                                                <option value="5">5</option>
                                                                <option value="6">6</option>
                                                                <option value="7">7</option>
                                                                <option value="8">8</option>
                                                                <option value="9">9</option>
                                                                <option value="10">10</option>
                                                            </select>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <th>
                                                        <p>
                                                            Knowledge
                                                        </p>
                                                    </th>
                                                    <td>
                                                        <div class="input-group">

                                                            <textarea class="form-control" rows="4" name="description_2"
                                                                aria-label="With textarea" required></textarea>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="dropdown text-center btn-lg btn-block">
                                                            <select
                                                                class="form-select form-select-lg mb-3 btn btn-primary btn-lg btn-block mt-3"
                                                                id="grade2" aria-label=".form-select-lg example">
                                                                <option value="" class="text-center" selected>Grade
                                                                </option>
                                                                <option value="1">1</option>
                                                                <option value="2">2</option>
                                                                <option value="3">3</option>
                                                                <option value="4">4</option>
                                                                <option value="5">5</option>
                                                                <option value="6">6</option>
                                                                <option value="7">7</option>
                                                                <option value="8">8</option>
                                                                <option value="9">9</option>
                                                                <option value="10">10</option>
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

                                                            <textarea class="form-control" rows="4" name="description_3"
                                                                aria-label="With textarea" required></textarea>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="dropdown text-center btn-lg btn-block">
                                                            <select
                                                                class="form-select form-select-lg mb-3 btn btn-primary btn-lg btn-block mt-3"
                                                                id="grade3" aria-label=".form-select-lg example"
                                                                required>
                                                                <option value="" class="text-center" selected>Grade
                                                                </option>
                                                                <option value="1">1</option>
                                                                <option value="2">2</option>
                                                                <option value="3">3</option>
                                                                <option value="4">4</option>
                                                                <option value="5">5</option>
                                                                <option value="6">6</option>
                                                                <option value="7">7</option>
                                                                <option value="8">8</option>
                                                                <option value="9">9</option>
                                                                <option value="10">10</option>
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

                                                            <textarea class="form-control" rows="4" name="description_4"
                                                                aria-label="With textarea" required></textarea>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <div class="dropdown text-center btn-lg btn-block">
                                                            <select
                                                                class="form-select form-select-lg mb-3 btn btn-primary btn-lg btn-block mt-3"
                                                                id="grade4" aria-label=".form-select-lg example"
                                                                required>
                                                                <option value="" class="text-center" selected>Grade
                                                                </option>
                                                                <option value="1">1</option>
                                                                <option value="2">2</option>
                                                                <option value="3">3</option>
                                                                <option value="4">4</option>
                                                                <option value="5">5</option>
                                                                <option value="6">6</option>
                                                                <option value="7">7</option>
                                                                <option value="8">8</option>
                                                                <option value="9">9</option>
                                                                <option value="10">10</option>
                                                            </select>
                                                        </div>
                                                    </td>

                                                </tr>
                                                <tr>
                                                    <th colspan="1">Total: </th>
                                                    <td colspan="2" class="text-center"> <input type="number"
                                                            class="mr-auto ml-auto" id="total" disabled> </td>
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
                <jsp:include page="footer.jsp" />
            </footer>

            <script>
                $(function () {
                    $('#grade1, #grade2, #grade3, #grade4').change(function () {
                        var grade1 = parseInt($('#grade1').val(), 10) || 0;
                        var grade2 = parseInt($('#grade2').val(), 10) || 0;
                        var grade3 = parseInt($('#grade3').val(), 10) || 0;
                        var grade4 = parseInt($('#grade4').val(), 10) || 0;
                        $('#total').val(grade1 + grade2 + grade3 + grade4);
                    });
                });
            </script>
        </body>

        </html>