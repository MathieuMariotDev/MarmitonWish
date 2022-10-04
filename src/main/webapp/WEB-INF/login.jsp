<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

<html>
<head>
    <title>Login</title>
</head>
<body class="d-flex flex-column min-vh-100">

    <div class="container">

        <form action="${pageContext.request.contextPath}/login" method="post">

            <label for="username">User</label>
            <input id="username" type="text" name="username">

            <button type="submit">Log in</button>
        </form>

    </div>

</body>
</html>
