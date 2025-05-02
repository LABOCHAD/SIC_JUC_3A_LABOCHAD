package de.sic.examples._20250324JDBC;

import java.sql.*;

public class DatabaseConnectionLibrary {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "root";
    private static final String PASSWORD = "dominik-labocha";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Verbindung konnte nicht hergestellt werden");
        }
        return null;
    }

    public static void main(String[] args) {
        try (Connection c = getConnection()) {
            if (c != null) {
                PreparedStatement p = c.prepareStatement("SELECT * FROM Books");
                ResultSet resultSet = p.executeQuery();
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("title"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
