<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="<c:url value='/css/style.css'/>"/>
</head>
<body>
    <div class="container-fluid mt-4 mb-4 p-3 d-flex justify-content-center">

      <div class="card p-4">
        <div class=" image d-flex flex-column justify-content-center align-items-center">
          <button class="btn btn-secondary">
            <img src="${requestScope.user.photo}" height="100" width="100" />
          </button>
          <div class="d-flex flex-row justify-content-center align-items-center mt-3">
            <span class="name mt-3">${requestScope.user.name}</span>
          </div>
          <div class="d-flex flex-row justify-content-center align-items-center mt-3">
            <span class="name mt-3">${requestScope.user.firstname}</span>
          </div>
          <div class="d-flex flex-row justify-content-center align-items-center mt-3">
            <span class="idd">${requestScope.user.email}</span> <div class="d-flex flex-row justify-content-center align-items-center gap-2">
          </div>
        </div>
          <form action="${pageContext.request.contextPath}/deleteUser" method="post">
            <input hidden name="id" value="${requestScope.user.id}">
            <button class="btn btn-secondary" type="submit">Supprimer profil</button>
            <a href="${pageContext.request.contextPath}/auth/edit_user?id=${requestScope.user.id}"
               class="btn btn-primary me-2">Edit</a>
          </form>
          <div class="text mt-3"> <span>Eleanor Pena is a creator of minimalistic x bold graphics and digital artwork.
            <br><br> Artist/ Creative Director by Day #NFT minting@ with FND night.
          </span>
          </div> <div class="gap-3 mt-3 icons d-flex flex-row justify-content-center align-items-center">
          <span><i class="fa fa-twitter"></i></span> <span><i class="fa fa-facebook-f"></i></span> <span><i class="fa fa-instagram"></i></span>
          <span><i class="fa fa-linkedin"></i></span> </div> <div class=" px-2 rounded mt-4 date "> </div> </div>
      </div>
    </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
  </div>
</body>
</html>
