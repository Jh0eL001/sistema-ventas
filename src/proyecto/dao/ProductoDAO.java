package proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import proyecto.conexion.ConexionBD;
import proyecto.modelos.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Producto> listarCatalogoConStock() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT p.*, "
                   + "COALESCE(SUM(CASE WHEN m.tipo_movimiento = 'entrada' THEN m.cantidad ELSE 0 END), 0) - "
                   + "COALESCE(SUM(CASE WHEN m.tipo_movimiento IN ('salida', 'merma') THEN m.cantidad ELSE 0 END), 0) AS stock_real "
                   + "FROM productos p "
                   + "LEFT JOIN movimientos_inventario m ON p.id = m.producto_id "
                   + "GROUP BY p.id";
        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto prod = new Producto();
                prod.setId(rs.getInt("id"));
                prod.setCajaId(rs.getInt("caja_id"));
                prod.setCodigo(rs.getString("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setMaterial(rs.getString("material"));
                prod.setPeso(rs.getDouble("peso"));
                prod.setCalidad(rs.getString("calidad"));
                prod.setCosto(rs.getDouble("costo"));
                prod.setPrecio(rs.getDouble("precio"));
                prod.setFoto(rs.getString("foto"));
                prod.setEstado(rs.getString("estado"));
                prod.setStockCalculado(rs.getInt("stock_real"));
                lista.add(prod);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error al listar catalogo: " + e.getMessage());
        }
        return lista;
    }
}