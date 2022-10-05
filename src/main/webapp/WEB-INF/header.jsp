<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="col-12 ">
    <nav id="navHeader" class=" header navbar navbar-expand-lg fixed-top">
        <div class="container ">
            <a class="navbar-brand text-white" href="#">MarmitonWish</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <c:if test="${ empty sessionScope.user}">
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item active">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/recipes">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/add_user">Inscription</a>
                    </li>
                </ul>
            </div>
            </c:if>
            <c:if test="${! empty sessionScope.user}">
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item active">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/recipes">Home</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/auth/logout">logout</a>
                    </li>
                </ul>
            </div>
            <div class="dropdown">
                <button class="btn btn-white dropdown-toggle text-white" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                    Menu
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/addRecipe">Creer une recette</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/addIngredients">Creer un aliment</a></li>
                    <li><a class="dropdown-item" href="#">Voir aliments</a></li>
                    <li><a class="dropdown-item" href="#">Voir vos recettes</a></li>
                </ul>
            </div>
            </c:if>
        </div>
    </nav>
</header>