package daos;
import beans.Usuario;
import java.sql.*;
public class UsuarioDao extends BaseDao {
    public boolean existeEmail(String email){
        String sql = "SELECT 1 FROM usuarios where email = ?";
        return false;
    }
    public void registrar(String nombres,String apellidos,String email,String password){
        String sql = "INSERT INTO usuario(nombres, apellidos, email , password_hash,rol)"
                   + "VALUES (?,?,?, SHA2(?,256) , 'LECTOR')";


    }
    public Usuario validarContrasenha(String email,String password){
        String sql = "SELECT * FROM usario where email = ? AND passwordHash = SHA2(?,256)";
        return null;
    }



}
