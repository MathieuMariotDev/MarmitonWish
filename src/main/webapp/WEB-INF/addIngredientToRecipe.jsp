<%--
  Created by IntelliJ IDEA.
  User: Math
  Date: 04/10/2022
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Ingredient for recipe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <div class="card mt-5">


            <div class="row">
                <div class="col">
                    <div class="from-floating">
                        <label for="unite"></label>
                        <input id="unite" type="text" name="unite" placeholder="Name" class="form-control">
                    </div>
                </div>
                <div class="col">
                    <div class="form-floating">
                        <select class="form-select" id="floatingSelectCategory"  name="ingredientId">
                            <option selected></option>
                            <c:forEach items="${ingredients}" var="ingredient">
                                <option value="${ingredient.id}">${ingredient.name}</option>
                            </c:forEach>
                        </select>
                        <label for="floatingSelectCategory">--Please choose an ingredient--</label>
                    </div>
                </div>

            </div>
            <button class="btn btn-success" id="addIngredient">Ajoute l'ingredient</button>

    </div>

</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/JavaScript/DynamicIngredient.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>
