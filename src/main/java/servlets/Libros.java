package servlets;
import beans.Libro;
import beans.Usuario;
import daos.LibroDao;
import daos.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Libros", value = "/Libros")

public class Libros extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        if (usuario== null){
            response.sendRedirect(request.getContextPath() + "/LogServlet");
            return;
        }
        LibroDao libroDao = new LibroDao();
        ArrayList<Libro> lista = libroDao.lista();
        request.setAttribute("lista",lista);


    }

}
