<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Ingredients</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <link rel="stylesheet" href="<c:url value='/css/style.css' />"/>
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
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
            crossorigin="anonymous"></script>
</body>
</html>
