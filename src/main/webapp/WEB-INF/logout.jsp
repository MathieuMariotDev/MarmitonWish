<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Confirmation : logout</title>
</head>
<body>

<p>Voulez-vous vraiment vous deconnecter ?</p>

<%--methode post--%>

<form action="${pageContext.request.contextPath}/auth/logout" method="POST">
    <button type="submit">YES</button>
</form>


<%--methode get - redirection--%>
<form action="${pageContext.request.contextPath}/home" method="get">
  <button type="submit">Non</button>
</form>

</body>
</html>
