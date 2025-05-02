package _20250324JDBC;

import java.sql.*;
import java.time.LocalDate;

/**
 * Beispiel wie man sich mit einer Datenbank verbindet + Abschicken eines PreparedStatements
 * Unten angegebener Code funktioniert nicht! Da Maven-Modul fehlt!!
 *
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "Data1234";

    public static Connection getConnection() {
        try {
            Connection c = DriverManager.getConnection(URL, USER, PASSWORD);
            c.setAutoCommit(false);
            return c;
        } catch (SQLException ex) {
            System.out.println("Verbindung konnte nicht hergestellt werden");
        }
        return null;
    }
}
    /* public static void main(String[] args) {
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p2 = c.prepareStatement("INSERT INTO Patient(firstname, lastname, email, " +
                        "dayOfBirth, Age, Weight, DoctorID) VALUES (?, ?, ?, ?, ?, ?, ?)");

                p2.setString(1, "Lars");
                p2.setString(2, "Müller");
                p2.setString(3, "Lars.Mueller@web.de");
                p2.setDate(4, Date.valueOf(LocalDate.parse("1999-03-14")));
                p2.setInt(5, 26);
                p2.setInt(6, 26);
                p2.setInt(7, 1);
                p2.execute();
                //c.commit(); //setzen, wenn AutoCommit ausgeschaltet
                PreparedStatement p = c.prepareStatement("SELECT * FROM Patient");
                ResultSet resultSet = p.executeQuery();
                while (resultSet.next()) {
                    System.out.print(resultSet.getString("firstname"));
                    System.out.print(" " + resultSet.getString("lastname"));
                    System.out.println(" " + resultSet.getInt("Age"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
*/