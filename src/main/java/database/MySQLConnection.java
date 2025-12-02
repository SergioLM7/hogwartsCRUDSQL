package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/hp";
    private static final String USER = "root";
    private static final String PASSWORD = "ThePowerFP";

    public static Connection getConnection() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅🏰Conexión exitosa a la BBDD de Hogwarts");
        } catch (SQLException e) {
            System.out.println("❌Error de conexión: " + e.getMessage());
        }

        return conn;
    }
}
