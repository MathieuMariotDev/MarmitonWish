<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation : Supprimer profil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/css/style.css' />"/>
</head>
<body>
<div class="container-fluid row d-flex justify-content-center">
    <p>Voulez-vous vraiment supprimer votre profil ?</p>
    <%--methode post--%>
    <form action="${pageContext.request.contextPath}/deleteUser" method="post">
        <input hidden value="${requestScope.idUser}" name="id">
        <button type="submit">Oui</button>
    </form>
    <%--methode get - redirection--%>
    <form action="${pageContext.request.contextPath}/#" method="get">
        <button type="submit">Non</button>
    </form>
</div>
</body>
</html>
