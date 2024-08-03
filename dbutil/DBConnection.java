/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author garim
 */
public class DBConnection {
    private static Connection conn;
    static{
        try{
            conn= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","yumxpress", "foodie");
            JOptionPane.showMessageDialog(null,"connection opened");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"cannot open the connection");
            ex.printStackTrace();
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"cannot close the connection");
            ex.printStackTrace();
        }
    }
}
