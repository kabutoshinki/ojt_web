<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h3>tLogin Page</h3>
    <!-- <p>${email}</p>
    <p>${password}</p> -->
    <c:forEach items="${majorList}" var= "o">
        <p>${o.major}</p>
    </c:forEach>

</body>
</html>