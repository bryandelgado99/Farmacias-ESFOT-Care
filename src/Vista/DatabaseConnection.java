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
    final String PASS="melA01.2"; //password

    public boolean iniciarSesionDB_caj(String QUERY, String cod_in,String ci_in, String password_in){
        try(
                Connection connection = DriverManager.getConnection(DB_URL,USER,PASS);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(QUERY)
                ){
            while(resultSet.next()){
                String obtenerCod_caj = resultSet.getString("codigo_caj");
                String obtenerCI_caj = resultSet.getString("ci_caj");
                String obtenerPass_caj = resultSet.getString("password_caj");
                if((cod_in.equals(obtenerCod_caj) && password_in.equals(obtenerPass_caj)) | 
                    (ci_in.equals(obtenerCI_caj) && password_in.equals(obtenerPass_caj))){
                    return true;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return false;
    }

}
