package proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import proyecto.conexion.ConexionBD;
import proyecto.modelos.Movimiento;

public class MovimientoDAO {

    public boolean registrarMovimiento(Movimiento mov) {
        String sql = "INSERT INTO movimientos_inventario (producto_id, tipo_movimiento, cantidad, motivo, usuario_id) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, mov.getProductoId());
            ps.setString(2, mov.getTipoMovimiento());
            ps.setInt(3, mov.getCantidad());
            ps.setString(4, mov.getMotivo());
            ps.setInt(5, mov.getUsuarioId());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al registrar movimiento: " + e.getMessage());
            return false;
        }
    }
}