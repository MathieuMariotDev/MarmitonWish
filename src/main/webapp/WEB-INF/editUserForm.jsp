<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add User</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>


<div class="container-fluid row d-flex justify-content-center">

  <h1 class="d-flex justify-content-center">Edit User</h1>

  <div class="row d-flex justify-content-center " >

    <form  class=" col-3 mb-5 mt-5 bg-white d-flex flex-column align-items-center  border border-secondary rounded" action="${pageContext.request.contextPath}/edit_user" method="POST">
      <div class="field d-flex flex-column align-items-start">
        <label for="newName">nom </label>
        <input id="newName" type="text" value="${user.name}" name="newName">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="newFirstName">prenom</label>
        <input id="newFirstName" type="text" value="${user.firstname}"  name="newFirstName">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="email">email</label>
        <input id="email" type="text" value="${user.email}" name="newEmail">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="newUrlPicture">photo</label>
        <input id="newUrlPicture" type="text" value="${user.photo}" name="newUrlPicture">
      </div>
      <div class="field d-flex flex-column align-items-start">
        <label for="newMdp">mot de passe</label>
        <input id="newMdp" type="password" value="${user.mdp}" name="newPassword">
      </div>
      <button class="bg-primary mt-3 mb-3 rounded" type="submit">edit</button>
    </form>

  </div>

</div>
<

</body>
</html>
