package mx.com.rm.jdbc;

import java.sql.*;
import java.util.logging.*;

public class Test {
    
    public static void main(String[] args) {
        //Cadena de coneccion mysql
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        //Conexion
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin5983");
            Statement instruccion = conexion.createStatement();
            var sql = "SELECT id_persona,nombre,apellido,email,telefono FROM persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("id persona:"+resultado.getInt("id_persona"));
                System.out.print(" Nombre:"+resultado.getString("nombre"));
                System.out.print(" Apellido:"+resultado.getString("apellido"));
                System.out.print(" Email:"+resultado.getString("email"));
                System.out.print(" Telefono:"+resultado.getString("telefono"));
                System.out.print(" ");
            }
            resultado.close();
            instruccion.cancel();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
