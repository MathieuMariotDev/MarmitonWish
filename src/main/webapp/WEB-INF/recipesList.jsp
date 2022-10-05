<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Recettes</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
        integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

</head>
<body>

<div class="container">

  <h1>Liste de recettes</h1>

  <div class = "row">

    <c:forEach items="${requestScope.recipes}" var="recipe">
      <div class="col-3">
        <div class = "card">
          <div class="card-body">
            <div class="card-text">
              <p>${recipe.recipeName}</p>
            </div>

            <%--
            <div class="card-footer d-flex justify-content-end">
              <a href="${pageContext.request.contextPath}/auth/editCountry?id=${country.id}" class="btn btn-primary">Edit</a>

              <form action="${pageContext.request.contextPath}/auth/deleteCountry" method="post">
                <input hidden name="idCountry" value="${country.id}">
                <button class="btn btn-secondary" type="submit">Delete</button>
              </form>
            --%>

              <a href="${pageContext.request.contextPath}/auth/detailsRecipe?id=${recipe.id}" class="btn btn-success">Détails</a>
            </div>


          </div>
        </div>
      </div>
    </c:forEach>

  </div>

</div>

</body>
</html>
