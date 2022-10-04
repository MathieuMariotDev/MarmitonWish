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

    <h1 class="d-flex justify-content-center">Add recipe</h1>

    <div class="row d-flex justify-content-center " >

        <form  class=" col-3 mb-5 mt-5 bg-white d-flex flex-column align-items-center  border border-secondary rounded" action="${pageContext.request.contextPath}/addRecipe" method="POST">
            <div class="field d-flex flex-column align-items-start">
                <label for="recipeName"></label>
                <input id="recipeName" type="text" name="recipeName" placeholder="nom">
            </div>
            <div class="field d-flex flex-column align-items-start">
                <label for="timeToPrepare"></label>
                <input id="timeToPrepare" type="number" name="timeToPrepare" placeholder="temps de preparation">
            </div>
            <div class="field d-flex flex-column align-items-start">
                <label for="dificulty"></label>
                <input id="dificulty" type="text" name="dificulty" placeholder="difficulte">
            </div>
            <div class="field d-flex flex-column align-items-start">
                <label for="portion"></label>
                <input id="portion" type="number" name="portion" placeholder="portion">
            </div>
            <div class="field d-flex flex-column align-items-start">
                <label for="price"></label>
                <input id="price" type="number" name="price" placeholder="prix">
            </div>
            <div class="field d-flex flex-column align-items-start">
                <label for="preparation"></label>
                <input id="preparation" type="text" name="preparation" placeholder="preparation">
            </div>
            <button class="bg-primary mt-3 mb-3 rounded" type="submit">Create</button>
        </form>

    </div>

</div>


</body>
</html>
