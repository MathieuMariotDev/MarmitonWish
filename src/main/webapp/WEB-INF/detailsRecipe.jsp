<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <title>Détails de la recette</title>
</head>
<body>

<div class="container">

    <div class = "row">

        <div class="col-12">
            <div class = "card">
                <div class="card-body">
                    <div class="card-text">
                        <h3>${requestScope.recipe.recipeName}</h3>
                        <p>Temps de préparation : ${requestScope.recipe.timeToPrepare}</p>
                        <p>Difficulté : ${requestScope.recipe.dificulty}</p>
                        <p>Portion : ${requestScope.recipe.portion}</p>
                        <p>Prix : ${requestScope.recipe.price}</p>
                        <p>Date de création : ${requestScope.recipe.createDate}</p>
                        <p>Ingrédients :</p>
                        <c:forEach var="recipeIngredient" items="${requestScope.recipeIngredients}" varStatus="status">
                            <img src="${requestScope.ingredients[status.index].photo}">
                            <p>${recipeIngredient.quantity}${recipeIngredient.unite} ${requestScope.ingredients[status.index].name}</p>
                        </c:forEach> <%--a completer--%>

                        <p>Préparation : ${requestScope.recipe.preparation}</p>
                        <%--<p>Auteur : ${requestScope.recipe.user}</p>--%> <%--a modifier > get firstname + name--%>
                    </div>

                </div>
            </div>
        </div>

    </div>

</div>

</body>
</html>
