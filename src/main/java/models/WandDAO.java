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

    public List<Wand> getAll() throws SQLException {
        List<Wand> result = new ArrayList<>();
        String sql = "SELECT * FROM wand";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            result.add(
                    new Wand(rs.getInt("id"),
                            rs.getString("wood"),
                            rs.getString("core"),
                            rs.getDouble("length"))
            );
        }

        rs.close();
        return result;
    }

    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM Wand where id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }
}
