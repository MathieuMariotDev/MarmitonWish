<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <title>Détails de la recette</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid d-flex justify-content-center">

    <div class = "row">

        <div class="col-12">
            <div class = "card">
                <div class="card-body">

                    <h5 class="card-title">${requestScope.recipe.recipeName}</h5>

                    <div class="card-text">
                        <p>Temps de préparation : ${requestScope.recipe.timeToPrepare}</p>
                        <p>Difficulté : ${requestScope.recipe.dificulty}</p>
                        <p>Portion : ${requestScope.recipe.portion}</p>
                        <p>Prix : ${requestScope.recipe.price}</p>
                        <p>Date de création : ${requestScope.recipe.createDate}</p>
                        <p>Ingrédients :</p>
                        <c:forEach var="recipeIngredient" items="${requestScope.recipeIngredients}" varStatus="status">
                            <img src="${requestScope.ingredients[status.index].photo}">
                            <p>${recipeIngredient.quantity} ${recipeIngredient.unite} ${requestScope.ingredients[status.index].name}</p>
                        </c:forEach>
                        <%--<c:forEach items="${requestScope.recipe.recipeIngredients}" var="recipeIngredients">
                            <img src="${requestScope.recipeIngredients.ingredients.photo}">
                            <p>${requestScope.recipeIngredients.quantity} ${requestScope.recipeIngredients.unite} ${requestScope.recipeIngredients.ingredients.name}</p>
                        </c:forEach>--%> <%--try to simplify code--%>

                        <p>Préparation : ${requestScope.recipe.preparation}</p>
                        <p>Auteur : ${requestScope.recipe.user.firstname} ${requestScope.recipe.user.name}</p>
                    </div>

                    <c:if test="${requestScope.display_delete}">
                        <a href="${pageContext.request.contextPath}/auth/deleteRecipe?id=${requestScope.recipe.id}" class="btn btn-danger">Supprimer recette</a>
                    </c:if>


                </div>
            </div>
        </div>

    </div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
