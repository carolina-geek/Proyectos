package com.mycompany.tienda1;

import com.mycompany.persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngresoController {

    public boolean autenticarUsuario(String nombre, String clave) {
        String query = "SELECT * FROM usuario WHERE nombre = ? AND clave = ?";
        try (Connection conn = Conexion.getConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, nombre);
            stmt.setString(2, clave);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return true;  // Usuario y clave correctos
            }
        } catch (SQLException e) {
            System.out.println("Error durante la autenticación: " + e.getMessage());
        }
        return false;  // Usuario o clave incorrectos
    }
}
