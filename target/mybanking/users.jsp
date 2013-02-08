<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <%--<script src="/bootstrap/js/bootstrap.js" type="text/javascript" />--%>
</head>
<body>
<div>
    <form method="post" action="/users" class="form-inline">
        <fieldset>
            <ul class="nav nav-tabs">
                <li class="active"><a href="/users" data-toggle="tab">Users</a></li>
                <li><a href="/accounts" data-toggle="tab">Accounts</a></li>
                <li><a href="/transactions" data-toggle="tab">Transactions</a></li>
            </ul>
            <label>Name:</label>
            <input name="name" type="text" class="input-medium" placeholder="Name">
            <label class="checkbox">
                Is system:<input name="system" type="checkbox">
            </label>
            <button type="submit" class="btn btn-primary">Create</button>
        </fieldset>
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
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.system}"/></td>
        </tr>
    </c:forEach>
</table>

<%--<!-- Button to trigger modal -->--%>
<%--<a href="#myModal" role="button" class="btn" data-toggle="modal">Launch demo modal</a>--%>

<%--<!-- Modal -->--%>
<%--<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">--%>
    <%--<div class="modal-header">--%>
        <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>--%>
        <%--<h3 id="myModalLabel">Modal header</h3>--%>
    <%--</div>--%>
    <%--<div class="modal-body">--%>
        <%--<p>One fine body…</p>--%>
    <%--</div>--%>
    <%--<div class="modal-footer">--%>
        <%--<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>--%>
        <%--<button class="btn btn-primary">Save changes</button>--%>
    <%--</div>--%>
<%--</div>--%>

</body>
</html>