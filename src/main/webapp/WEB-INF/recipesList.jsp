<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Recettes</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
        integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
  <div class="container-fluid row d-flex justify-content-center">
    <jsp:include page="header.jsp"></jsp:include>
    <h1 class="d-flex mb-5 justify-content-center">Liste de recettes</h1>
    <div class = "row mb-5 d-flex justify-content-center">
      <c:forEach items="${requestScope.recipes}" var="recipe">
        <div class="col-3  mt-5  d-flex justify-content-center">
          <div class = "card">
            <div class="card-body d-flex flex-column align-items-center">
              <div class="card-text">
                <p>${recipe.recipeName}</p>
              </div>
              <div class="card-footer d-flex justify-content-end">
                <a href="${pageContext.request.contextPath}/detailsRecipe?id=${recipe.id}" class="boutonHome btn text-white ">Détails</a>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>

  <div>
    <%--<a href="${pageContext.request.contextPath}/auth/random" class="btn btn-success">Choisir une recette au hasard</a>
    --%>

  <form action="${pageContext.request.contextPath}/auth/random" method="post">
    <input hidden name="id" value="${requestScope.idRecipe}">
    <input class="btn btn-secondary"  type="submit" value="Choisir une recette au hasard">
  </form>

  </div>

  </div>
</body>
</html>
