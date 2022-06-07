
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
    <title>TODO supply a title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" href="CSS/style.css">
    <link rel="stylesheet" href="CSS/manage.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/dda2b72c9e.js" crossorigin="anonymous"></script>

</head>

<body>
    <div class="wrap">
        <div class="container-fluid header d-flex p-3 align-items-center">
            <div class="col  d-flex flex-grow-1 p-1 info">
                <div class='p-2'>
                    <i class="fa-solid fa-envelope"></i> <span>daihoc.hcm@fpt.edu.vn</span>
                </div>
                <div class='p-2'>
                    <i class="fa-solid fa-phone"></i> <span>(028)73005588</span>
                </div>
            </div>
            <div class="col ">
                <a href="manage.html" class="btn btn-light">Company</a>
            </div>
            <div class="col  d-flex align-items-center justify-content-around p-1">
                <div class="text-light">
                    <a href="/oauth2/authorization/google" class="btn btn-light"><i class="bi bi-google"></i> Login</a>
                </div>
            </div>
        </div>


        <nav class="navbar navbar-expand-md">
            <div class="container">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#Navbar">
                    <i class="btn btn-secondary bi bi-list"></i>
                </button>  
                <a class="navbar-brand mr-auto" href="#"><img src="img/fu.jpg" width="300" /></a>
                <div class="collapse navbar-collapse" id="Navbar">
                    <ul class="navbar-nav menu mr-auto ml-auto">
                        <li class="nav-item active mr-5"><a class="nav-link" href="index.html">Home</a></li>
                        <li class="nav-item mr-5"><a class="nav-link" href="#">OJT</a></li>
                        <li class="nav-item mr-5"><a class="nav-link" href="#">CNH</a></li>
                        <li class="nav-item mr-5"><a class="nav-link" href="#">Company Tour</a></li>
                    </ul>   
                </div>         
            </div>
        </nav>



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
            <th>Apply Job</th>
            <th>Job Description</th>
            <th>Skill needed</th>
            <th>Slot</th>
            <th>Form visit</th>
            <th>Status</th>
            <th>Operations</th>
        </tr>
    </thead>
    <tbody> 
        <tr>
            <td>1</td>
            <td>Frontend Developer</td>
            <td>Tham gia phân tích yêu cầu và thiết kế kiến trúc phần...</td>
            <td>React, Java web</td>
            <td>
               100
            </td>
            <td>
                none
            </td>
            <td>Accepted</td>
            <td>
                <button type="submit" class="btn btn-sm btn-outline-success"  name="op" value="update"><i class="bi bi-check-circle"></i> Accepted
                </button>
                <button type="button" class="btn btn-sm btn-outline-danger" data-bs-dismiss="modal" name="op" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
            </td>
        </tr>

        <tr>
            <td>1</td>
            <td>Frontend Developer</td>
            <td>Tham gia phân tích yêu cầu và thiết kế kiến trúc phần...</td>
            <td>React, Java web</td>
            <td>
               100
            </td>
            <td>
                none
            </td>
            <td>Accepted</td>
            <td>
               <button type="submit" class="btn btn-sm btn-outline-success"  name="op" value="update"><i class="bi bi-check-circle"></i> Accepted
                </button>
                <button type="button" class="btn btn-sm btn-outline-danger" data-bs-dismiss="modal" name="op" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
            </td>
        </tr>

        <tr>
            <td>1</td>
            <td>Frontend Developer</td>
            <td>Tham gia phân tích yêu cầu và thiết kế kiến trúc phần...</td>
            <td>React, Java web</td>
            <td>
               100
            </td>
            <td>
                none
            </td>
            <td>Accepted</td>
            <td>
                <button type="submit" class="btn btn-sm btn-outline-success"  name="op" value="update"><i class="bi bi-check-circle"></i> Accepted
                </button>
                <button type="button" class="btn btn-sm btn-outline-danger" data-bs-dismiss="modal" name="op" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
            </td>
        </tr>
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 ft-logo">
                    <img src="img/logofpt.png" width="200" />
                </div>
                <diV class="col-3">
                    <h2 style="font-size: larger">Lô E2a-7, Đường D1, phường Long Thạnh Mỹ,
                        Thành Phố Thủ Đức, Thành phố Hồ Chí Minh
                    </h2>
                    <p>
                        contact@lift.agencyr.com<br />
                        (028) 7300 5588
                    </p>


                </diV>
                <div class="col-2">
                    <ul>
                        <li>About</li>
                        <li>Growers</li>
                        <li>Merchants</li>
                        <li>Partners</li>
                        <li>Contact</li>
                    </ul>
                </div>
                <div class="col-2">
                    <ul>
                        <li>Facebook</li>
                        <li>Twitter</li>
                        <li>Linkedin</li>
                        <li>Instagram</li>
                    </ul>
                </div>
                <div class="col-2 arrow-up">
                    <i class="bi bi-arrow-up-circle-fill"></i>
                </div>
            </div>
        </div>
    </footer>
    <hr>
    <div class="space">

    </div>
</body>

</html>