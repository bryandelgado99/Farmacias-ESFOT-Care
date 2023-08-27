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
    final String DB_URL="jdbc:mysql://localhost/ESFOT-CARE"; //cadena de conexion
    final String USER="root"; //usuario
    final String PASS="root2023"; //password

    public boolean iniciarSesionDB(String tabla, String cod_user, String ci_user, String password_user, String cod_in,String ci_in, String password_in){
        try(
                Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT "+cod_user+","+ci_user+","+password_user+" from "+tabla+" where "+cod_user+" = '"+cod_in+"' or "+ci_user+" = '"+ci_in+"'");
                ){
            while(resultSet.next()){
                String obtenerCod = resultSet.getString(cod_user);
                String obtenerCI = resultSet.getString(ci_user);
                String obtenerPass = resultSet.getString(password_user);
                if((cod_in.equals(obtenerCod) && password_in.equals(obtenerPass)) | 
                    (ci_in.equals(obtenerCI) && password_in.equals(obtenerPass))){
                    return true;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }

}
