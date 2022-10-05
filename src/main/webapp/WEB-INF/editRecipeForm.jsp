<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add User</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<div class="container-fluid row d-flex justify-content-center">

  <h1 class="d-flex justify-content-center">Edit recipe</h1>

  <div class="row d-flex justify-content-center " >

    <form  class=" col-3 mb-5 mt-5 bg-white d-flex flex-column align-items-center  border border-secondary rounded" action="${pageContext.request.contextPath}/editRecipe" method="POST">
      <div class="field d-flex flex-column align-items-start">
        <label for="newRecipeName"></label>
        <input id="newRecipeName" type="text" name="newRecipeName"  value="${recipe.recipeName}" placeholder="nom">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="newTimeToPrepare"></label>
        <input id="newTimeToPrepare" type="number" name="newTimeToPrepare" value="${recipe.timeToPrepare}" placeholder="temps de preparation">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="newDificulty"></label>
        <input id="newDificulty" type="text" name="newDificulty" value="${recipe.dificulty}" placeholder="Difficulte">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="newPortion"></label>
        <input id="newPortion" type="number" name="newPortion" value="${recipe.portion}" placeholder="Portion">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="newPrice"></label>
        <input id="newPrice" type="number" name="newPrice" value="${recipe.price}" placeholder="Prix">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="newPreparation"></label>
        <input id="newPreparation" type="text" name="newPreparation" value="${recipe.preparation}" placeholder="Preparation">
      </div>
      <input hidden name="recipeId" value="${recipe.id}">
      <button class="bg-primary mt-3 mb-3 rounded" type="submit">Edit</button>
    </form>

  </div>
  <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
