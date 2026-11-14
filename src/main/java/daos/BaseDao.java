package daos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class BaseDao {
    private final String user = "root";
    private final String pass = "12345678";
    private final String url = "jdbc:mysql://127.0.0.1:3306/lab9_bilbioteca";
    public BaseDao(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
}
