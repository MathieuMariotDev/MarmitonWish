<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
    <div class="container-fluid row d-flex justify-content-center">
        <jsp:include page="header.jsp"></jsp:include>
        <div id="loginTitle">
            <h2 class="text-center">CONNEXION</h2>
        </div>
        <div class = "d-flex justify-content-center align-items-center">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="col-10 form-group">
                    <label for="email"></label>
                    <input class="form-control" id="email" name="email" placeholder="Email">
                </div>
                <div class="col-10 form-group">
                    <label for="mdp"></label>
                    <input class="form-control" id="mdp" name="mdp" placeholder="Mot de passe" type="password">
                </div>
                <button type="submit" class="btn btn-primary">Connexion</button>

                <c:if test="${not empty requestScope.error_email}">
                <div class="alert alert-danger" role="alert">
                    Email invalide
                </div>
                </c:if>

                <c:if test="${not empty requestScope.error_password}">
                <div class="alert alert-danger" role="alert">
                    Mot de passe invalide
                </div>
                </c:if>
            </form>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
            crossorigin="anonymous"></script>
</body>
</html>
