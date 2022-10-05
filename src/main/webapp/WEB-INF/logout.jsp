<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Confirmation : logout</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
    <div class="container-fluid row d-flex justify-content-center">
        <jsp:include page="header.jsp"></jsp:include>
        <p class=" d-flex justify-content-center">Voulez-vous vraiment vous deconnecter ?</p>
        <div class=" col-2 d-flex justify-content-between align-items-center">
            <%--methode post--%>
            <form action="${pageContext.request.contextPath}/auth/logout" method="POST">
                <button type="submit">OUI</button>
            </form>

            <%--methode get - redirection--%>
            <form action="${pageContext.request.contextPath}/home" method="get">
                <button type="submit">NON</button>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
