package proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import proyecto.conexion.ConexionBD;
import proyecto.modelos.Producto;

public class ProductoDAO {

    public boolean registrarProducto(Producto producto) {
        // AQUÍ ESTÁ EL TRUCO: Agregamos categoria_id y le pasamos un 1 fijo en los VALUES
        String sql = "INSERT INTO productos (caja_id, categoria_id, codigo, nombre, material, peso, calidad, costo, precio, foto, estado) VALUES (?, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, producto.getCajaId());
            ps.setString(2, producto.getCodigo());
            ps.setString(3, producto.getNombre());
            ps.setString(4, producto.getMaterial());
            ps.setDouble(5, producto.getPeso());
            ps.setString(6, producto.getCalidad());
            ps.setDouble(7, producto.getCosto());
            ps.setDouble(8, producto.getPrecio());
            ps.setString(9, producto.getFoto());
            ps.setString(10, producto.getEstado());
            
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (Exception e) {
            System.out.println("Error al registrar producto: " + e.getMessage());
            return false;
        }
    }
}