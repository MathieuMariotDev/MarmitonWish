<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
    <title>Détails de la recette</title>
</head>
<body>
<div class="container-fluid row justify-content-center">
    <jsp:include page="header.jsp"></jsp:include>
        <div class="col-6">
            <div class = "card d-flex justify-content-center">
                <div class="card-body">
                    <h5 class="card-title d-flex justify-content-center">${requestScope.recipe.recipeName}</h5>
                    <div class="card-text d-flex flex-column align-items-center">
                        <p>Temps de préparation : ${requestScope.recipe.timeToPrepare}</p>
                        <p>Difficulté : ${requestScope.recipe.dificulty}</p>
                        <p>Portion : ${requestScope.recipe.portion}</p>
                        <p>Prix : ${requestScope.recipe.price}</p>
                        <p>Date de création : ${requestScope.recipe.createDate}</p>
                        <p>Ingrédients :</p>
                        <c:forEach var="recipeIngredient" items="${requestScope.recipeIngredients}" varStatus="status">
                            <img class="ingredientImage"src="${requestScope.ingredients[status.index].photo}">
                            <p>${recipeIngredient.quantity} ${recipeIngredient.unite} ${requestScope.ingredients[status.index].name}</p>
                        </c:forEach> <%--a completer--%>
                        <p>Préparation : ${requestScope.recipe.preparation}</p>
                        <%--<p>Auteur : ${requestScope.recipe.user}</p>--%> <%--a modifier > get firstname + name--%>
                    </div>
                    <c:if test="${requestScope.display_delete}">
                        <form class="d-flex justify-content-center" action="${pageContext.request.contextPath}/auth/deleteRecipe" method="post">
                            <input hidden name="id" value="${requestScope.recipe.id}">
                            <button class="btn btn-danger" type="submit">Supprimer recette</button>
                        </form>
                    </c:if>
                </div>
            </div>
        </div>

</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
