
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/CSS/style.css">
    <link rel="stylesheet" href="/CSS/manage.css">
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
        <hr>    
    </div>

    <!-- content -->
    <header class="container">
            
        <div class="form-group row align-items-center">
            <label for="inputDateVisit" class="col-md-4 col-form-label title"><h1>Status Of Company</h1></label>
                 
                    <div class="col-md-4">
                            
                                <div class="dropdown" style="float: right;">
                                  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Find All
                                  </button>
                                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="#">Find By Id</a>
                                    <a class="dropdown-item" href="#">Find By Name</a>
                                    <a class="dropdown-item" href="#">Find By Company</a>
                                  </div>
                                </div>
                            
                        
                    </div>
                    <div class="col-md-4">
                                 <input type="text" name="search" class="search">
                                 <button class="btn btn-secondary ">
                                     <i class="bi bi-search" type="submit"></i>
                                 </button>
                    </div>
            
        </div>
        
        <div class="form-group row align-items-center mb-3 mr-3">
            <a class="btn btn-lg btn-outline-success mr-3" href="#"><i class="bi bi-plus-circle"></i> Create</a>
            <a class="btn btn-lg btn-outline-primary" href="#"><i class="bi bi-arrow-clockwise"></i> Reload</a>
        </div>
   
    </header>

   
 <hr>   


<table  class="table table-striped container">
    <thead>
        <tr>
            <th>No</th>
            <th>Company</th>
            <th>Job Description</th>
            <th>Major</th>
            <th>Slot</th>
            <th>Form visit</th>
            <th>Status</th>
            <th>Operations</th>
        </tr>
    </thead>
    <tbody> 
        <c:forEach items="${jobList}" var="o">
            <tr>
                <td>${o.idJob}</td>
                <td>${o.company.companyName}</td>
                <td>${o.description}</td>
                <td>${o.position.positon}</td>
                <td>
                   ${o.slot}
                </td>
                <td>
                    none
                </td>
                <td>${o.status}</td>
                <td>
                    <a href="/employee/updateStatus/${o.idJob}/1">
                        <button type="submit" class="btn btn-sm btn-outline-success"  name="op" value="update"><i class="bi bi-check-circle"></i> Accepted
                        </button>
                    </a>
                    <a href="/employee/updateStatus/${o.idJob}/2">
                        <button type="button" class="btn btn-sm btn-outline-danger" data-bs-dismiss="modal" name="op" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
                    </a>
                </td>
            </tr>
        </c:forEach>

        
       
    </tbody>
</table>
    
  <nav aria-label="Page navigation example">
      <ul class="pagination justify-content-center">
        <li class="page-item disabled">
          <a class="page-link" href="#" tabindex="-1">Previous</a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
          <a class="page-link" href="#">Next</a>
        </li>
      </ul>
   </nav>

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