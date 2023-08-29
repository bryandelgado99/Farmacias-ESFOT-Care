/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import java.sql.*;
/**
 *
 * @author Hp
 */
public class DatabaseConnection {
    protected static Connection iniciarDB()
        throws SQLException, ClassNotFoundException
    {
        // Conexion a la base de datos
        String DB_URL="jdbc:mysql://localhost/ESFOT-CARE"; //cadena de conexion
        String USER="root"; //usuario
        String PASS="root2023"; //password
        //String DB_name="ESFOT-CARE";
  
        Connection connection = DriverManager.getConnection(DB_URL, USER,PASS);
        return connection;
    }
}
