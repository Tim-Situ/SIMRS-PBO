package timsitu.controllers;

import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
import timsitu.config.ConnectionDB;
import timsitu.models.User;
import timsitu.models.UserSessions;

public class AuthController {
    
    public static Boolean login(String username, String password) throws SQLException{
       try {
            ConnectionDB db = new ConnectionDB();
            String sql = "SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'";
            ResultSet res = db.getData(sql);
            if(res.next()){
                if(res.getString("role").equals("ADMIN")){
                    UserSessions.setRole(User.EnumRole.ADMIN);
                }else if(res.getString("role").equals("DOKTER")){
                    UserSessions.setRole(User.EnumRole.DOKTER);
                }else if(res.getString("role").equals("APOTEKER")){
                    UserSessions.setRole(User.EnumRole.APOTEKER);
                }

                UserSessions.setName(res.getString("nama"));
                UserSessions.setUserId(res.getInt("id"));
                
               return true;
            }else{
                JOptionPane.showMessageDialog(null, "Username atau Password Salah...", "Gagal Login", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error :"+e.getMessage(),
                    "Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public static void logout(){
        UserSessions.setName(null);
        UserSessions.setRole(User.EnumRole.NULL);
    }
}
