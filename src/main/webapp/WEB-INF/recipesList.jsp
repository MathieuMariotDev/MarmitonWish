<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Recettes</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
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
                <a href="${pageContext.request.contextPath}/auth/detailsRecipe?id=${recipe.id}" class="boutonHome btn text-white ">Détails</a>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
  </div>
</body>
</html>
