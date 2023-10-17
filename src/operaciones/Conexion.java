/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;


import java.sql.*;
/**
 *
 * @author alan6
 */

public class Conexion {

    Connection conexion;
    final String baseDatos = "jdbc:mysql://localhost:3306/escuela";
    final String usuario = "root";
    final String password = "";

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(baseDatos, usuario, password);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error: " + e);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
