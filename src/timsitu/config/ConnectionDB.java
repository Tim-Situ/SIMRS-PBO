package timsitu.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ConnectionDB {
//    static final String DB_URL = DatabaseConfig.getDbUrl();
//    static final String DB_USER = DatabaseConfig.getDbUser();
//    static final String DB_PASS = DatabaseConfig.getDbPassword();
    static final String DB_URL = "jdbc:mysql://localhost/simrs-pbo";
    static final String DB_USER = "root";
    static final String DB_PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public ConnectionDB() throws SQLException {
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,""+e.getMessage(),
                    "Connection Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public ResultSet getData(String SQLString) {
        try {
            rs = stmt.executeQuery(SQLString);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
    
    public int addQuery(String SQLString) {
        try {
            // Membuat PreparedStatement dengan opsi untuk mengambil kunci yang dihasilkan
            PreparedStatement pstmt = conn.prepareStatement(SQLString, Statement.RETURN_GENERATED_KEYS);

            // Mengeksekusi pernyataan SQL
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Inserting data failed, no rows affected.");
            }

            // Mengambil kunci yang dihasilkan
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) { // Jika ada kunci yang dihasilkan
                int generatedId = generatedKeys.getInt(1);
                return generatedId;
            } else {
                throw new SQLException("Inserting data failed, no generated keys obtained.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: " + e.getMessage(),
                    "Communication Error", JOptionPane.WARNING_MESSAGE);
            return -1;
        }
    }
    
    public void query(String SQLString) {
        try {
            stmt.executeUpdate(SQLString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Communication Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
