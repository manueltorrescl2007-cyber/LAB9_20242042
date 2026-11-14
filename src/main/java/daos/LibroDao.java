package daos;

import beans.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class LibroDao extends BaseDao{
    public ArrayList<Libro> listar(){
        ArrayList<Libro> listarLibros(){
            ArrayList<Libro> lista = new ArrayList<>();
            String sql = "SELECT * FROM libro";
            return lista;
        }
    }

}
