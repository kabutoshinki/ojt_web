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
            <hr/>
            <br/>
            <div class="container" style="background-color: orange; border-radius: 40px; padding: 25px">
                <div class="row form-title">
                    <h2>Insert Information</h2>
                </div>
                <br/>
                <form action="/account/insert" ModelAttribute="information" enctype="multipart/form-data"  method= "POST">
                    <div class="row">
                        <div class="col-md-4 border-right" style="border-right: 1px solid">
                            <div style="text-align: center; font-weight: 700">Avatar</div>
                            <div class="avatar" style="background: gray; margin-bottom: 30px">
                                <img class="img-thumbnail" id="thumbnail">
                                <input id="fileImage" name="imgavatar" type="file" value="Avatar" title="" />
                            </div>
                            <br/>
                            <div class="" style="line-height: 2">
                                <strong>
                                    <span name="fullName" >Name: ${userName}</span><br>
                                    <span>Student ID: SE150011</span><br>
                                    <span name="email">Mail: ${email}</span>
                                </strong>
                            </div>
                        </div>
                        <div class="col-sm-8" style="padding: 30px 10px 30px 40px;">
                            <div>
                                <div>
                                    
                                    <div class="mb-3 row">
                                        <label for="" class="col-sm-2 col-form-label">Address</label>
                                        <div class="col-sm-10">
                                            <textarea class="form-control" name="address" id="address"
                                            rows="3"></textarea>
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label for="" class="col-sm-2 col-form-label">Date of birth</label>
                                        <div class="col-sm-10">
                                            <input type="date" name="dateOfBirth" id="dateOfBirth">
                                        </div>
                                    </div>
                                    <div class="mb-3 row">
                                        <label for="" class="col-sm-2 col-form-label">Phone number</label>
                                        <div class="col-sm-10">
                                            <input type="tel" name="phone" />
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
    <script type="text/javascript">
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
