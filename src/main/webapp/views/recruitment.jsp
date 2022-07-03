<%-- Document : index Created on : May 30, 2022, 12:29:03 PM Author : SE150437 Vo Pham Quoc Thang --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
    <title>Job Detail</title>
</head>

<body>
    <jsp:include page="header.jsp" />
    <br/>
     <div class="container">
            <nav aria-label="breadcrumb">
              <ol class="breadcrumb align-items-center">
                <li class="breadcrumb-item"><a href="/home" style="padding:0">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">${jobDetail.company.account.fullName}</li>
              </ol>
            </nav>
            </div>
    <div style="
 display: flex;
 justify-content: space-around;
 align-items: center;
 padding: 25px 1vw;">
        <span style="font-size: 30px; font-weight:bold;">
            ${jobDetail.company.account.fullName}
        </span>
    </div>
    <hr style="height: 2px; color: black;" />
    <div class="container">
        <div class="row align-items-center">
            <div class="col-12 col-lg-4 mb-2">
                <img style="width:300px" class="img-fluid mb-3" alt="Responsive image"
                    src="https://www.fpt-software.com/wp-content/uploads/sites/2/2017/06/logofsoft.png" />
                <a href="" style="text-decoration: none;" class="btn btn-warning btn-lg btn-block" data-toggle="modal" data-target="#CV">APPLY</a>
            </div>
            <div class="col-12 col-lg-8 mt-5 mb-2">
                <p style="font-size: 30px; font-weight:bold;">
                    <c:forEach items="${companyDes}" var="o">
                        ${o}<br>
                    </c:forEach>
                    ${jobDetail.company.account.address}<br>
                </p>
            </div>
        </div>
    </div>
    <hr>

    <!-- Modal CV -->
        <div class="modal fade" id="CV" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title text-center" id="exampleModalLabel">Choose CV</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">

                <div class="dropdown text-center btn-lg btn-block">
                  <select class="form-select form-select-lg mb-3 btn btn-primary btn-lg btn-block mt-3" id="selection" aria-label=".form-select-lg example">
                  <option value="" class="text-center" selected>Select CV</option>
                  <option value="FPT">FPT</option>
                  <option value="Tiki">Tiki</option>
                  <option value="Lazada">Lazada</option>
                   <option value="/home">Other</option>
                </select>
                </div>

              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
              </div>
            </div>
          </div>
        </div>
    <!-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

    <div class="container">
        <div class="row">
            <div class="col-12 mt-5 mr-2">
                <h3>Job description:</h3>
                <ul style="font-size: 25px">
                    <c:forEach items="${jobDes}" var="o">
                        <li><i class="bi bi-dot"></i> ${o}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-12 mt-5 mb-5 mr-2">
                <h3>Qualification:</h3>
                <ul style="font-size: 25px">
                    <c:forEach items="${jobRe}" var="o">
                        <li><i class="bi bi-dot"></i> ${o}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
    <jsp:include page="footer.jsp" />


    <script>

        $(document).ready(function() {
            $("#selection").change(function() {
                var curVal = $("#selection option:selected").val();
                if (curVal.indexOf('/home') === 0) {
                    location = $("#selection option:selected").val();
                }
            });
        });

    </script>
</body>



</html>