package models;

import database.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WandDAO {

    private Connection conn;

    public WandDAO() throws SQLException {
        conn = MySQLConnection.getConnection();
    }

    public void create(Wand wand) throws SQLException {

        String sql = "INSERT INTO wand (wood, core, length) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, wand.getWood());
        ps.setString(2, wand.getCore());
        ps.setDouble(3, wand.getLength());
        ps.executeUpdate();
        ps.close();
    }

 
}
