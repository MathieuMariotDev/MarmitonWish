<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Ingredients</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container-fluid row d-flex justify-content-center">
      <jsp:include page="header.jsp"></jsp:include>
      <div class="row d-flex justify-content-center">
        <h1 class="d-flex justify-content-center">Ajouter ingredient</h1>
        <form  class=" col-3 mb-5 mt-5 bg-white d-flex flex-column align-items-center  border border-secondary rounded" action="${pageContext.request.contextPath}/addIngredients" method="POST">
          <div class="field d-flex flex-column align-items-start">
            <label for="ingredientName"> </label>
            <input id="ingredientName" type="text" name="ingredientName" placeholder="nom">
          </div>
          <div class="field d-flex flex-column align-items-start">
            <label for="ingredientsPhoto"></label>
            <input id="ingredientsPhoto" type="text" name="ingredientsPhoto" placeholder="photo">
          </div>
          <button class="bg-primary mt-3 mb-3 rounded" type="submit">Creer</button>
        </form>
      </div>
      <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <div class="dropdown">
      <button class="btn btn-white dropdown-toggle text-white" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
        Menu
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/addRecipe">Creer une recette</a></li>
        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/addIngredients">Creer un aliment</a></li>
        <li><a class="dropdown-item" href="#">Voir aliments</a></li>
        <li><a class="dropdown-item" href="#">Voir vos recettes</a></li>
      </ul>
    </div>

</body>
</body>
</html>
