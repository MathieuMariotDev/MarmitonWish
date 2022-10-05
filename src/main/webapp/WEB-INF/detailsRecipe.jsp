<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
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

                        </c:forEach> <%--a completer--%>
                        <p>Préparation : ${requestScope.recipe.preparation}</p>
                        <p>Auteur : ${requestScope.recipe.user.firstname} ${requestScope.recipe.user.name}</p>
                    </div>
                    <c:if test="${requestScope.display_delete}">


                        <form class="d-flex justify-content-center" action="${pageContext.request.contextPath}/auth/deleteRecipe" method="post">
                            <input hidden name="id" value="${requestScope.recipe.id}">
                            <button class="btn btn-danger" type="submit">Supprimer recette</button>
                        </form>

                        <a href="${pageContext.request.contextPath}/auth/deleteRecipe?id=${requestScope.recipe.id}" class="btn btn-danger">Supprimer recette</a>

                    <form action="${pageContext.request.contextPath}/auth/addCookedRecipe" method="post">
                        <input hidden name="id" value="${requestScope.idRecipe}">
                        <button class="btn btn-secondary" type="submit">Recette cuisinée ? Cliquez ici</button>
                    </form>


                    </c:if>
                </div>
            </div>
        </div>
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
