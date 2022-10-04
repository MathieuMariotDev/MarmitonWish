<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation : Remove User</title>
</head>
<body>

    <p>Voulez-vous vraiment supprimer votre profil ?</p>

    <%--methode post--%>
    <form action="${pageContext.request.contextPath}/deleteUser" method="post">
        <input hidden value="${requestScope.idUser}" name="id">
        <button type="submit">Yes</button>
    </form>

    <%--methode get - redirection--%>
    <form action="${pageContext.request.contextPath}/#" method="get">
        <button type="submit">No</button>
    </form>

</body>
</html>
