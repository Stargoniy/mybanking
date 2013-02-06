<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css">
</head>
<body>
    <div>
        <form method="post" action="/accounts" class="form-inline">
            <select name="user_id">
                <c:forEach var="user" items="${users}">
                    <option value="<c:out value="${user.id}"/>"><c:out value="${user.name}"/></option>
                </c:forEach>
            </select>
            <input name="name" type="text" class="input-medium" placeholder="Name">
            <button type="submit" class="btn btn-primary">Create</button>
        </form>
    </div>

    <table class="table table-striped table-bordered">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>User</th>
            <th>Is system</th>
        </tr>
        <c:forEach var="account" items="${accounts}">
            <tr>
                <td><c:out value="${account.id}" /></td>
                <td><c:out value="${account.name}" /></td>
                <td><c:out value="${account.user.name}" /></td>
                <td><c:out value="${account.user.system}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>