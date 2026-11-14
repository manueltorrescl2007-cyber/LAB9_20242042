package servlets;
import daos.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(name = "RegistroUsuario", value = "/RegistroUsuario")

public class RegistroUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
        view.forward(request.response);

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email =  request.getParameter("email ");
        String password =  request.getParameter("password");
        UsuarioDao usuario = new UsuarioDao();
        if(usuario.existeEmail(email)){
            request.setAttribute("error", "El correo ya se encuentra" + "registrado.");
            RequestDispatcher view  = request.getRequestDispatcher(registro.jsp);
            view.forward(request,response);
            return;
        }else{
            usuario.registrar(nombres,apellidos,email,password);
            request.getSession().setAttribute("mensaje","Cuenta creada correctamente");
            response.sendRedirect(request.getContextPath()+"/LogServlet");
        }
    }

}
