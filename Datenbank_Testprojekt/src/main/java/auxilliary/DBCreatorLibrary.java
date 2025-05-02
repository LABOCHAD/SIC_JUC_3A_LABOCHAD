package auxilliary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Singleton for SQL connection
public class DBCreatorLibrary {
    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "dominik-labocha";

    private DBCreatorLibrary() {}

    public static synchronized Connection getConnection() {
        if (connection == null) {
            try { //HikariCP could be used for Pooling multiple Connection instead
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                connection.setAutoCommit(false); //commit must be done manually, if wanted as persistent
                //this is intended so, I can test and play around without breaking my Database (like transactions)
            } catch (SQLException ex) {
                System.out.println("Verbindung konnte nicht hergestellt werden");
            }
        }
        return connection;
    }
}
