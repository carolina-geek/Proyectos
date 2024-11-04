package com.mycompany.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:sqlite:tienda.db";  // Cambia la ruta si es necesario

    public static Connection getConexion() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Conexión establecida");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            return null;
        }
    }
}