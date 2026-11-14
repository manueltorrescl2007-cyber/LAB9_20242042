package servlets;
import beans.Usuario;
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
@WebServlet(name = "LogServlet", value = "/LogServlet")
public class LogServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("acton") == null ? "form" : request.getParameter("action");
        HttpSession session = request.getSession();
        if (action.equals("logout")){
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/LogServlet");
            return;
        }
        if(session.getAttribute("usuario")!= null){
            response.sendRedirect(request.getContextPath()+"/Libros");
            return;
        }
        RequestDispatcher view = request.getRequestDispatcher("login.jsp");
        view.forward(request,response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UsuarioDao usuarioDao = new UsuarioDao;
        Usuario usuario = usuarioDao.validarContrasenha(email,password);
        if (usuario == null){
            request.setAttribute("error", "Correo o contraseña incorrectos");
            RequestDispatcher view = request.getRequestDispatcher("login.jsp");
            view.forward(request,response);

        }else{
            HttpSession session = request.getSession();
            session.setAttribute("usuario",usuario);
            response.sendRedirect(request.getContextPath()+ "/Libros");

        }

    }
}
