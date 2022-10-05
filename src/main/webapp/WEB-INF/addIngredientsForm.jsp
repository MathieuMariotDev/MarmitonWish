<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add User</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>


<div class="container-fluid row d-flex justify-content-center">

  <h1 class="d-flex justify-content-center">Add Ingredients</h1>

  <div class="row d-flex justify-content-center " >

    <form  class=" col-3 mb-5 mt-5 bg-white d-flex flex-column align-items-center  border border-secondary rounded" action="${pageContext.request.contextPath}/addIngredients" method="POST">
      <div class="field d-flex flex-column align-items-start">
        <label for="ingredientName">nom </label>
        <input id="ingredientName" type="text" name="ingredientName">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="ingredientsPhoto">photo</label>
        <input id="ingredientsPhoto" type="text" name="ingredientsPhoto">
      </div>
      <button class="bg-primary mt-3 mb-3 rounded" type="submit">Create</button>
    </form>

  </div>

</div>
</body>
</html>
