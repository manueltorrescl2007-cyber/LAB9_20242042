<%@ page import="java.util.ArrayList" %>
<%@ page import="beans.Libro" %>
<%@ page import="beans.Usuario" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Libro> lista = (ArrayList<Libro>) request.getAttribute("lista");
    Usuario u = (Usuario) session.getAttribute("usuario");
    String mensaje = (String) session.getAttribute("mensaje");
    session.removeAttribute("mensaje");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Libros</title>
</head>
<body>
<jsp:include page="navbar.jsp" />
<div class="container mt-4">
    <% if (mensaje != null) { %>
    <div class="alert alert-danger"><%=mensaje%></div>
    <% } %>
    <h1 class="mb-3">Libros</h1>
    <table class="table">
        <tr>
            <th>Título</th>
            <th>Autor</th>
            <th>Año de publicación</th>
            <th></th>
        </tr>
        <% for (Libro l : lista) { %>
        <tr>
            <td><%=l.getTitulo()%></td>
            <td><%=l.getAutor()%></td>
            <td><%=l.getAnioPublicacion()%></td>
            <td class="text-end">
                <% if (u.getRol().equals("LECTOR")) { %>
                <a class="btn btn-primary btn-sm"
                   href="<%=request.getContextPath()%>/Prestamos?action=solicitar&id=<%=l.getIdLibro()%>">
                    Solicitar préstamo</a>
                <% } %>
            </td>
        </tr>
        <% } %>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>