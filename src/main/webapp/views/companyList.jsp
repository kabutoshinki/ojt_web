<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script>
      $(function () {
        $("[data-toggle=tooltip]").tooltip();

        $(".grid-view").click(function () {});
      });
    </script>
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>
    <link
      rel="stylesheet"
      href="../CSS/companyList.css"
      type="text/css"
      media="all"
    />
    <title>Company List</title>
  </head>
  <body>
    <div class="container pt-5">
      <div class="row align-items-center justify-content-between">
        <div class="col-lg-2 col-md-3 col-sm-4 col-7">
          <div class="input-group input-group-sm">
            <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">42 Items</span>
            </div>
            <select name="" class="form-control form-control-sm">
              <option value="">12</option>
              <option value="">24</option>
              <option value="">48</option>
            </select>
          </div>
        </div>

        <div class="col-md-3 col-5 text-right order-md-1">
          <a href="#" class="btn btn-primary grid-view btn-sm">
            <i class="fa fa-th-large"></i>
          </a>
          <a href="#" class="btn btn-primary list-view btn-sm">
            <i class="fa fa-bars"></i>
          </a>
        </div>

        <div class="col-md-3 order-md-0 mt-2 mt-md-0">
          <select class="form-control form-control-sm">
            <option value="">Sort By</option>
            <option value="">Popylar</option>
            <option value="">Name</option>
          </select>
        </div>
      </div>
    </div>

    <div class="container">
      <hr />
    </div>

    <div class="container">
      <div class="row">
        <div class="col-md-4 mb-3">
          <div class="card h-100">
            <div class="d-flex justify-content-between position-absolute w-100">
              <div class="label-new">
                <span
                  class="text-white bg-success small d-flex align-items-center px-2 py-1"
                >
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <span class="ml-1">New</span>
                </span>
              </div>
              <div class="label-sale">
                <span
                  class="text-white bg-primary small d-flex align-items-center px-2 py-1"
                >
                  <i class="fa fa-tag" aria-hidden="true"></i>
                  <span class="ml-1">Sale</span>
                </span>
              </div>
            </div>
            <c:forEach items="${companyList}" var="o">
            <a href="#">
              <img
                src="https://picsum.photos/700/550"
                class="card-img-top"
                alt="Product"
              />
            </a>
            
              <div class="card-body px-2 pb-2 pt-1">
              <div class="d-flex justify-content-between">
                <div>
                  <p class="h4 text-primary">${o.slot}</p>
                </div>
                <div>
                  <a
                    href="#"
                    class="text-secondary lead"
                    data-toggle="tooltip"
                    data-placement="left"
                    title="Compare"
                  >
                    <i class="fa fa-line-chart" aria-hidden="true"></i>
                  </a>
                </div>
              </div>
              <p class="text-warning d-flex align-items-center mb-2">
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
              </p>
              <p class="mb-0">
                <strong>
                  <a href="#" class="text-secondary">${o.companyName}</a>
                </strong>
              </p>
              <p class="mb-1">
                <small>
                  <a href="#" class="text-secondary">Brands</a>
                </small>
              </p>
              <div class="d-flex mb-3 justify-content-between">
                <div>
                  <p class="mb-0 small"><b>UPC: </b> 2310010</p>
                  <p class="mb-0 small"><b>PART#: </b> 2121</p>
                  <p class="mb-0 small"><b>MPN#: </b> mpn22651</p>
                </div>
                <div class="text-right">
                  <p class="mb-0 small"><b>Free Shipping</b></p>
                  <p class="mb-0 small"><b>MSRP: </b> $119.99</p>
                  <p class="mb-0 small"><b>REG: </b> $19.99</p>
                  <p class="mb-0 small text-primary">
                    <span class="font-weight-bold">Save</span> $20.00 (16%)
                  </p>
                </div>
              </div>
              <div class="d-flex justify-content-between">
                <div class="col px-0">
                  <button class="btn btn-outline-primary btn-block">
                    Add To Cart
                    <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                  </button>
                </div>
                <div class="ml-2">
                  <a
                    href="#"
                    class="btn btn-outline-success"
                    data-toggle="tooltip"
                    data-placement="left"
                    title="Add to Wishlist"
                  >
                    <i class="fa fa-heart" aria-hidden="true"></i>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-md-4 mb-3">
          <div class="card h-100">
            <div
              class="labels d-flex justify-content-between position-absolute w-100"
            >
              <div class="label-new"></div>
              <div class="label-sale">
                <span
                  class="text-white bg-primary small d-flex align-items-center px-2 py-1"
                >
                  <i class="fa fa-tag" aria-hidden="true"></i>
                  <span class="ml-1">Sale</span>
                </span>
              </div>
            </div>
            </c:forEach>
                

            <a href="#">
              <img
                src="https://picsum.photos/700/550"
                class="card-img-top"
                alt="Product"
              />
            </a>
            <div class="card-body px-2 pb-2 pt-1 d-flex flex-column">
              <div class="d-flex justify-content-between">
                <div>
                  <p class="h4 text-primary">$130,00</p>
                </div>
                <div>
                  <a
                    href="#"
                    class="text-secondary lead"
                    data-toggle="tooltip"
                    data-placement="left"
                    title="Compare"
                  >
                    <i class="fa fa-line-chart" aria-hidden="true"></i>
                  </a>
                </div>
              </div>
              <p class="text-warning d-flex align-items-center mb-2">
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
              </p>
              <p class="mb-0">
                <strong>
                  <a href="#" class="text-secondary">Product Title</a>
                </strong>
              </p>
              <p class="mb-1">
                <small>
                  <a href="#" class="text-secondary">Brands</a>
                </small>
              </p>
              <div class="d-flex mb-3 justify-content-between">
                <div>
                  <p class="mb-0 small"><b>PART#: </b> 2121</p>
                  <p class="mb-0 small"><b>MPN#: </b> mpn22651</p>
                </div>
                <div class="text-right">
                  <p class="mb-0 small"><b>MSRP: </b> $119.99</p>
                  <p class="mb-0 small"><b>REG: </b> $19.99</p>
                </div>
              </div>
              <div class="d-flex justify-content-between mt-auto">
                <div class="col px-0">
                  <button class="btn btn-outline-primary btn-block">
                    Add To Cart
                    <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                  </button>
                </div>
                <div class="ml-2">
                  <a
                    href="#"
                    class="btn btn-outline-success"
                    data-toggle="tooltip"
                    data-placement="left"
                    title="Add to Wishlist"
                  >
                    <i class="fa fa-heart" aria-hidden="true"></i>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-md-4 mb-3">
          <div class="card h-100">
            <div
              class="labels d-flex justify-content-between position-absolute w-100"
            >
              <div class="label-new">
                <span
                  class="text-white bg-success small d-flex align-items-center px-2 py-1"
                >
                  <i class="fa fa-star" aria-hidden="true"></i>
                  <span class="ml-1">New</span>
                </span>
              </div>
              <div class="label-sale">
                <span
                  class="text-white bg-primary small d-flex align-items-center px-2 py-1"
                >
                  <i class="fa fa-tag" aria-hidden="true"></i>
                  <span class="ml-1">Sale</span>
                </span>
              </div>
            </div>
            <a href="#">
              <img
                src="https://picsum.photos/700/550"
                class="card-img-top"
                alt="Product"
              />
            </a>
            <div class="card-body px-2 pb-2 pt-1">
              <div class="d-flex justify-content-between">
                <div>
                  <p class="h4 text-primary">$150,20</p>
                </div>
                <div>
                  <a
                    href="#"
                    class="text-secondary lead"
                    data-toggle="tooltip"
                    data-placement="left"
                    title="Compare"
                  >
                    <i class="fa fa-line-chart" aria-hidden="true"></i>
                  </a>
                </div>
              </div>
              <p class="text-warning d-flex align-items-center mb-2">
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
                <i class="fa fa-star" aria-hidden="true"></i>
              </p>
              <p class="mb-0">
                <strong>
                  <a href="#" class="text-secondary">Product Title</a>
                </strong>
              </p>
              <p class="mb-1">
                <small>
                  <a href="#" class="text-secondary">Brands</a>
                </small>
              </p>
              <div class="d-flex mb-3 justify-content-between">
                <div>
                  <p class="mb-0 small"><b>UPC: </b> 2310010</p>
                  <p class="mb-0 small"><b>PART#: </b> 2121</p>
                  <p class="mb-0 small"><b>MPN#: </b> mpn22651</p>
                </div>
                <div class="text-right">
                  <p class="mb-0 small"><b>Free Shipping</b></p>
                  <p class="mb-0 small"><b>MSRP: </b> $119.99</p>
                  <p class="mb-0 small"><b>REG: </b> $19.99</p>
                  <p class="mb-0 small text-primary">
                    <span class="font-weight-bold">Save</span> $20.00 (16%)
                  </p>
                </div>
              </div>
              <div class="d-flex justify-content-between">
                <div class="col px-0">
                  <button class="btn btn-outline-primary btn-block">
                    Add To Cart
                    <i class="fa fa-shopping-basket" aria-hidden="true"></i>
                  </button>
                </div>
                <div class="ml-2">
                  <a
                    href="#"
                    class="btn btn-outline-success"
                    data-toggle="tooltip"
                    data-placement="left"
                    title="Add to Wishlist"
                  >
                    <i class="fa fa-heart" aria-hidden="true"></i>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="container">
      <hr />
    </div>

    <div class="container pb-5">
      <div class="row align-items-center justify-content-between">
        <div class="col-lg-2 col-md-3 col-sm-4 col-7">
          <div class="input-group input-group-sm">
            <div class="input-group-prepend">
              <span class="input-group-text" id="basic-addon1">42 Items</span>
            </div>
            <select name="" class="form-control form-control-sm">
              <option value="">12</option>
              <option value="">24</option>
              <option value="">48</option>
            </select>
          </div>
        </div>

        <div class="col-5 text-right">
          <a href="#" class="btn btn-primary grid-view btn-sm">
            <i class="fa fa-th-large"></i>
          </a>
          <a href="#" class="btn btn-primary list-view btn-sm">
            <i class="fa fa-bars"></i>
          </a>
        </div>
      </div>
    </div>
  </body>
</html>
