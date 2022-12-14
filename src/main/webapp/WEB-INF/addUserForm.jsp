<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add User</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>

  <div class="container-fluid row d-flex justify-content-center">
    <jsp:include page="header.jsp"></jsp:include>
    <h1 class="d-flex justify-content-center">Add User</h1>

    <div class="row d-flex justify-content-center " >

      <form  class=" col-3 mb-5 mt-5 bg-white d-flex flex-column align-items-center  border border-secondary rounded" action="${pageContext.request.contextPath}/add_user" method="POST">

        <div class="field d-flex flex-column align-items-start">
          <label for="name">nom </label>
          <input id="name" type="text" name="name">
        </div>
        <div class="field d-flex flex-column align-items-start">
          <label for="firtsName">prenom</label>
          <input id="firtsName" type="text" name="firstName">
        </div>
        <div class="field d-flex flex-column align-items-start">
          <label for="email">email</label>
          <input id="email" type="text" name="email">
        </div>
        <div class="field d-flex flex-column align-items-start">
          <label for="photo">photo</label>
          <input id="photo" type="text" name="photo">
        </div>
        <div class="field d-flex flex-column align-items-start">
          <label for="mdp">mot de passe</label>
          <input id="mdp" type="password" name="password">
        </div>
        <input hidden name="id" value="${country.id}">
        <button class="bg-primary mt-3 mb-3 rounded" type="submit">Create</button>
      </form>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
  </div>
</div>
</body>
</html>
