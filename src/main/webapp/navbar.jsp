<%@ page import="beans.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Usuario u = (Usuario) session.getAttribute("usuario");
%>
<nav class="navbar navbar-expand navbar-dark bg-dark px-3">
    <span class="navbar-brand">
        Biblioteca – <%=u.getNombres()%> <%=u.getApellidos()%> (<%=u.getRol()%>)
    </span>
    <ul class="navbar-nav me-auto">
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/Libros">Libros</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/Prestamos?action=mis">Mis préstamos</a>
        </li>
        <% if (u.getRol().equals("BIBLIOTECARIO")) { %>
        <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/Prestamos?action=todos">Todos los préstamos</a>
        </li>
        <% } %>
    </ul>
    <a class="btn btn-outline-light" href="<%=request.getContextPath()%>/LogServlet?action=logout">Cerrar sesión</a>
</nav>