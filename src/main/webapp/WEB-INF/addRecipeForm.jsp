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
        <h1 class="d-flex justify-content-center">Add recipe</h1>

        <div class="row d-flex justify-content-center " >

            <form  class=" col-3 mb-5 mt-5 bg-white d-flex flex-column align-items-center  border border-secondary rounded" action="${pageContext.request.contextPath}/addRecipe" method="POST">
                <div class="field d-flex flex-column align-items-start">
                    <label for="recipeName">nom </label>
                    <input id="recipeName" type="text" name="recipeName">
                </div>
                <div class="field d-flex flex-column align-items-start">
                    <label for="category">Category : </label>
                    <input id="category" type="text" name="category">
                </div>
                <div class="field d-flex flex-column align-items-start">
                    <label for="timeToPrepare">temps de preparation</label>
                    <input id="timeToPrepare" type="number" name="timeToPrepare">
                </div>
                <div class="field d-flex flex-column align-items-start">
                    <label for="dificulty">difficulte</label>
                    <input id="dificulty" type="text" name="dificulty">
                </div>
                <div class="field d-flex flex-column align-items-start">
                    <label for="portion">portion</label>
                    <input id="portion" type="number" name="portion">
                </div>
                <div class="field d-flex flex-column align-items-start">
                    <label for="price">prix</label>
                    <input id="price" type="number" name="price">
                </div>
                <div class="field d-flex flex-column align-items-start">
                    <label for="preparation">preparation</label>
                    <input id="preparation" type="text" name="preparation">
                </div>
                <button class="bg-primary mt-3 mb-3 rounded" type="submit">Create</button>
            </form>

        </div>
        <jsp:include page="footer.jsp"></jsp:include>

    </div>
</body>
</html>
