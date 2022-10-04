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

        <div class="col-3">
            <div class = "card">
                <div class="card-body">
                    <div class="card-text">
                        <h3>${requestScope.recipe.recipeName}</h3>
                        <p>Temps de préparation : ${requestScope.recipe.timeToPrepare}</p>
                        <p>Difficulté : ${requestScope.recipe.dificulty}</p>
                        <p>Portion : ${requestScope.recipe.portion}</p>
                        <p>Prix : ${requestScope.recipe.price}</p>
                    </div>

                </div>
            </div>
        </div>

    </div>

</div>

</body>
</html>
