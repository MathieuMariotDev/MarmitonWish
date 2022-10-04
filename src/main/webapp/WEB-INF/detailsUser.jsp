<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

  <title>Details User</title>
</head>
<body>

  <div class="container">

    <div class = "row">

      <div class="col-3">
        <div class = "card">
          <div class="card-body">
            <div class="card-text">
              <p>${requestScope.user.name}</p>
              <p>${requestScope.user.firstname}</p>
              <img src="#"> <%--photo--%>
              <p>${requestScope.user.mdp}</p>
            </div>

              <%--delete--%>
              <form action="${pageContext.request.contextPath}/deleteUser" method="post">
                <input hidden name="idUser" value="${requestScope.user.id}">
                <button class="btn btn-secondary" type="submit">Supprimer profil</button>
              </form>
            </div>

          </div>
        </div>
      </div>

    </div>

  </div>

</body>
</html>
