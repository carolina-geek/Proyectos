package com.mycompany.tienda1;

import com.mycompany.persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProductoDAO {
    
    // Método para crear un producto
    public static boolean guardarProducto(Producto producto) {
        String sql = "INSERT INTO Producto(codigo, descripcion, cantidad, valor_unitario) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexion.getConexion(); 
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, producto.getCodigo());
            pstmt.setString(2, producto.getDescripción());
            pstmt.setInt(3, producto.getCantidad());
            pstmt.setFloat(4, producto.getValor_unitario());

            pstmt.executeUpdate(); // Ejecutar el SQL de inserción
            return true;
        } catch (SQLException e) {
            System.out.println("Error al guardar producto: " + e.getMessage());
            return false;
        }
    }

    // Método para leer todos los productos
    public static ArrayList<Producto> leerProductos() {
        // Método para leer todos los productos y devolverlos como una lista de objetos Producto
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        
        try (Connection conn = Conexion.getConexion(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Crear un nuevo objeto Producto con los valores obtenidos de la BD
                Producto producto = new Producto(
                    rs.getInt("id"),                // ID del producto
                    rs.getString("codigo"),         // Código del producto
                    rs.getString("descripcion"),    // Descripción del producto
                    rs.getInt("cantidad"),          // Cantidad disponible
                    rs.getFloat("valor_unitario")   // Valor unitario
                );
                productos.add(producto); // Agregar producto a la lista
            }
        } catch (SQLException e) {
            System.out.println("Error al leer productos: " + e.getMessage());
        }
       return productos;    
    }
    
    // Método para mostrar los detalles de un producto en las cajas de texto
    public static void mostrarProductoEnCampos(Producto producto, JTextField txt_cod, JTextField txt_des, JTextField txt_cant, JTextField txt_val_uni) {
        if (producto != null) {
            txt_cod.setText(producto.getCodigo());
            txt_des.setText(producto.getDescripción());
            txt_cant.setText(String.valueOf(producto.getCantidad()));
            txt_val_uni.setText(String.valueOf(producto.getValor_unitario()));
        } else {
            System.out.println("El producto no existe.");
        }
    }

    // Método para configurar el listener en el JList
    public static void configurarListenerParaJList(JList<Producto> Lista, JTextField txt_cod, JTextField txt_des, JTextField txt_cant, JTextField txt_val_uni) {
        Lista.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Obtener el producto seleccionado
                    Producto productoSeleccionado = Lista.getSelectedValue();
                    // Mostrar los detalles del producto en las cajas de texto
                    mostrarProductoEnCampos(productoSeleccionado, txt_cod, txt_des, txt_cant, txt_val_uni);
                }
            }
        });
    }
    // Método para buscar un producto por su código y mostrarlo en las cajas de texto
    public static void buscarYMostrarProducto(String codigo, ArrayList<Producto> productos, JTextField txt_cod, JTextField txt_des, JTextField txt_cant, JTextField txt_val_uni) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                mostrarProductoEnCampos(producto, txt_cod, txt_des, txt_cant, txt_val_uni);
                return;
            }
        }
        System.out.println("Producto con código " + codigo + " no encontrado.");
    }

    // Método para actualizar un producto
    public static boolean actualizarProducto(String codigo, String descripcion, int cantidad, double valorUnitario) {
        String sql = "UPDATE Producto SET descripcion = ?, cantidad = ?, valor_unitario = ? WHERE codigo = ?";
        
        try (Connection conn = Conexion.getConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descripcion);
            pstmt.setInt(2, cantidad);
            pstmt.setDouble(3, valorUnitario);
            pstmt.setString(4, codigo);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un producto
    public static boolean eliminarProducto(String codigo) {
        String sql = "DELETE FROM Producto WHERE codigo = ?";
        
        try (Connection conn = Conexion.getConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }
}