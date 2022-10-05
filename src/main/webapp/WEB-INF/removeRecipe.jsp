<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation : Supprimer recette</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <p>Voulez-vous vraiment supprimer cette recette ?</p>

    <%--methode post--%>
    <form action="${pageContext.request.contextPath}/auth/deleteRecipe" method="post">
        <input hidden value="${requestScope.idRecipe}" name="id">
        <button type="submit">Oui</button>
    </form>

    <%--methode get - redirection--%>
    <form action="${pageContext.request.contextPath}/recipes" method="get">
        <button type="submit">Non</button>
    </form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
