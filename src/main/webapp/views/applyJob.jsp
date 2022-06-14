<%-- 
    Document   : registerojt
    Created on : Jun 1, 2022, 5:15:38 PM
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Form register OJT</title>
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
        <div class="wrap">
            <jsp:include page="header.jsp"/>
            <div class="container-fluid" style="justify-content: flex-start">
                <div class="row">
                    <div class="col-sm-5">
                        <img src="/img/fu.jpg" width="280"/>
                    </div>
                    <div class="col-sm-7 menu">
                        <div class="">
                            <a href=""> Home </a>
                        </div>
                        <div class="">
                            <a href=""> OJT </a>
                        </div>
                        <div class="">
                            <a href=""> CNH </a>
                        </div>
                        <div class="">
                            <a href=""> Company Tour </a>
                        </div>
                        <div>
                            <form action="" method="post">
                                <input type="text" placeholder="Search here">
                                <button type="submit">
                                    <i class="bi bi-search"> Search</i>
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <hr/>
            <br/>
            <div class="container" style="background-color: orange; border-radius: 40px; padding: 25px">
                <div class="row form-title">
                    <h2>Đăng ký OJT</h2>
                </div>
                <br/>
                <form>
                    <div class="row">
                        <div class="col-sm-4" style="border-right: 1px solid">
                            <div style="text-align: center; font-weight: 700">Avatar</div>
                            <div class="avatar" style="background: gray; margin-bottom: 30px">
                                <input type="file" value="Avatar" title="" />
                            </div>
                            <br/>
                            <div class="" style="line-height: 2">
                                <strong>
                                    <span>Name: Đặng Hữu Đạt</span><br>
                                    <span>Student ID: SE150011</span><br>
                                    <span>Mail: datdh@fpt.edu.vn</span>
                                </strong>
                            </div>
                        </div>
                        <div class="col-sm-8" style="padding: 30px 10px 30px 40px;">
                            <div>
                                <div>
                                    <div class="mb-3 row">
                                        <label for="" class="col-sm-2 col-form-label">Chuyên ngành</label>
                                        <div class="col-sm-10">
                                            <select onmousedown="if (this.options.length > 4) {
                                                        this.size = 4;
                                                    }" onchange='this.size = 0;' onblur="this.size = 0;" style=" padding: 10px; width: 50%; border-radius: 5px; border-color: gray;" class="form-select" aria-label="Default select example">
                                                <option value="chuyennganh">Kỹ thuật phần mềm</option>
                                                <option value="chuyennganh">An toàn thông tin</option>
                                                <option value="chuyennganh">Trí tuệ nhân tạo</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label for="" class="col-sm-2 col-form-label">Công ty</label>
                                        <div class="col-sm-10">
                                            <select onmousedown="if (this.options.length > 3) {
                                                        this.size = 3;
                                                    }" onchange='this.size = 0;' onblur="this.size = 0;" style="padding: 10px;width: 50%; border-radius: 5px; border-color: gray;" class="form-select" aria-label="Default select example">
                                                <option value="company">FPT Software</option>
                                                <option value="company">Zalo</option>
                                                <option value="company">Web Frontend Dev (Angular, Typescript)</option>
                                                <option value="company">a</option>
                                                <option value="company">b</option>
                                                <option value="company">c</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label for="" class="col-sm-2 col-form-label">Số lượng tuyển dụng</label>
                                        <div class="col-sm-10">
                                            <input type="number" name="" min="1" value="1"/>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label for="" class="col-sm-2 col-form-label">Cập nhật CV</label>
                                        <div class="col-sm-10">
                                            <input type="file" value="CV" title=""/>
                                        </div>
                                    </div>
                                    <div>
                                        <input type="submit" value="Đăng ký" style="border-radius: 30px; background-color: #ffcc99; color: red; padding: 5px 45px; margin: 25px 25px;"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </div>
    <div class="space">
    </div>
</body>
</html>
