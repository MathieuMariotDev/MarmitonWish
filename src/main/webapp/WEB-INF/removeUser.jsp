<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation : Supprimer profil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
    <div class="container-fluid row d-flex justify-content-center">
        <jsp:include page="header.jsp"></jsp:include>
        <p class="d-flex justify-content-center">Voulez-vous vraiment supprimer votre profil ?</p>
            <div class=" col-2 d-flex justify-content-between align-items-center">
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
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
