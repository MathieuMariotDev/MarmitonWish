<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation : Supprimer recette</title>
</head>
<body>

    <p>Voulez-vous vraiment supprimer cette recette ?</p>

    <%--methode post--%>
    <form action="${pageContext.request.contextPath}/auth/deleteRecipe" method="post">
        <input hidden value="${requestScope.idUser}" name="id">
        <button type="submit">Oui</button>
    </form>

    <%--methode get - redirection--%>
    <form action="${pageContext.request.contextPath}/recipes" method="get">
        <button type="submit">Non</button>
    </form>

</body>
</html>
