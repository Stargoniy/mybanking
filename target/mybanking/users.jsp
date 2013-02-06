<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
    <div>
        <form method="post" action="/users" class="form-inline">
            <input name="name" type="text" class="input-medium" placeholder="Name">
            <label class="checkbox">
                <input name="system" type="checkbox"> Is system
            </label>
            <button type="submit" class="btn btn-primary">Create</button>
        </form>
    </div>

    <table class="table table-striped table-bordered">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Is system</th>
        </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.id}" /></td>
            <td><c:out value="${user.name}" /></td>
            <td><c:out value="${user.system}" /></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>