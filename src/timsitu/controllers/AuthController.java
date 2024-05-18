/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package timsitu.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
import timsitu.config.ConnectionDB;
import timsitu.models.User;
import timsitu.models.UserSessions;
import timsitu.pages.MainPage;

/**
 *
 * @author fauzeinmulyawarman
 */
public class AuthController {
    
    public static void login(String username, String password) throws SQLException{
       String sql = "SELECT * FROM users";
        Connection conn = ConnectionDB.getConnection();
        System.out.println(conn);
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);

        // Mendapatkan metadata dari ResultSet
        ResultSetMetaData rsmd = res.getMetaData();
        int columnCount = rsmd.getColumnCount();

        // Menampilkan nama kolom
        System.out.println("Nama Kolom:");
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
        }
        System.out.println();

        
        
//        if(res.next()){
//            if(res.getString("role").equals("ADMIN")){
//                UserSessions.setRole(User.EnumRole.ADMIN);
//                
//            }else if(res.getString("role").equals("DOKTER")){
//                UserSessions.setRole(User.EnumRole.DOKTER);
//            }
//            
//            UserSessions.setName(res.getString("nama"));
//        }
    }
}
