
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static String usuario = "root";
    private static String senha = "48795231";
    private static String host = "localhost";
    private static String porta = "3306";
    private static String bd = "db_salvationl";

    public static Connection obtemConexao() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
