<%@ page import="uz.pdp.firstproject.repo.UserRepo" %>
<%@ page import="uz.pdp.firstproject.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="uz.pdp.firstproject.entity.Role" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="static/bootstrap.min.css">
</head>
<body>

<%
    UserRepo userRepo = new UserRepo();
    List<User> users = userRepo.findAll();
%>


<nav class="navbar bg-body-tertiary bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand text-light">First Project</a>
        <a class="btn btn-outline-light w-50" href="">Search</a>
        <div>
            <a class="btn btn-outline-success" href="login.jsp">Login</a>
        </div>
    </div>
</nav>
<div class="p-4">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Group</th>
            <th>Roles</th>
            <th>#</th>

        </tr>
        </thead>
        <tbody>
        <tr>
            <div>
                <% for (User user : users) { %>
                <tr>
                    <td><%= user.getFirstName() %>
                    </td>
                    <td><%= user.getLastName()%>
                    </td>
                    <%=user.getGroup().getName()%>
                    <td>
                    </td>
                    <%for (Role role : user.getRoles()) { %>
                    <% if (role.getName().toLowerCase().equals("student")) %>
                    <%= role.getName() %>
                    <% } %>
                    <td>
                        <a href="editUser.jsp?id=<%=user.getId()%>" class="btn btn-outline-info">edit</a>
                        <a href="http://localhost:8080/user/delete?id=<%=user.getId()%>"
                           class="btn btn-outline-danger">delete</a>
                    </td>
                </tr>
                <% } %>
            </div>
        </tbody>
    </table>
</div>

</body>
</html>