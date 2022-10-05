<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Ingredients</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>


<div class="container-fluid row d-flex justify-content-center">
  <jsp:include page="header.jsp"></jsp:include>
  <div class="row d-flex justify-content-center">
    <h1 class="d-flex justify-content-center">Recherche recette</h1>
    <form  class=" col-3 mb-5 mt-5 bg-white d-flex flex-column align-items-center  border border-secondary rounded"
           action="${pageContext.request.contextPath}/searchRecipe" method="POST">
      <div class="col-12 field d-flex flex-column align-items-start">
        <input class="form-control me-2" type="search" placeholder="Nom de la recette" aria-label="Search" name="recipeName">
      </div>

      <div class="col-12 form-floating">
        <select class="form-select" id="floatingSelectCategory"  name="category">
          <option selected></option>
          <option value="Entree">Entree</option>
          <option value="Plat">Plat</option>
          <option value="Dessert">Dessert</option>
        </select>

        <label for="floatingSelectCategory">Choisir une catégorie</label>
      </div>
      <button class="col-4 bg-primary mt-3 mb-3 rounded" type="submit">Chercher</button>
    </form>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
