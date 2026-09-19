package proyecto.conexion;

/**
 * @author Jhoel Zeballos Z.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sistema_ventas", "root", "");
        } catch (Exception e) {
            System.out.println("Hubo un error al conectar: " + e.getMessage());
        }
        return con;
    }
}
