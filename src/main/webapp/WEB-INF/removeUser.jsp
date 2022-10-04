<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation : Supprimer profil</title>
</head>
<body>

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

</body>
</html>
