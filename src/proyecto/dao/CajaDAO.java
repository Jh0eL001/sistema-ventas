package proyecto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyecto.conexion.ConexionBD;
import proyecto.modelos.Caja;

public class CajaDAO {

    public boolean registrarCaja(Caja caja) {
        String sql = "INSERT INTO cajas (numero_remision, proveedor, cantidad_declarada, estado, fecha_recepcion) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, caja.getNumeroRemision());
            ps.setString(2, caja.getProveedor());
            ps.setInt(3, caja.getCantidadDeclarada());
            ps.setString(4, caja.getEstado());
            ps.setString(5, caja.getFechaRecepcion());
            ps.executeUpdate();
            ps.close();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al registrar caja: " + e.getMessage());
            return false;
        }
    }

    public List<Caja> listarCajas() {
        List<Caja> lista = new ArrayList<>();
        String sql = "SELECT * FROM cajas";
        try {
            Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Caja caja = new Caja();
                caja.setId(rs.getInt("id"));
                caja.setNumeroRemision(rs.getString("numero_remision"));
                caja.setProveedor(rs.getString("proveedor"));
                caja.setCantidadDeclarada(rs.getInt("cantidad_declarada"));
                caja.setEstado(rs.getString("estado"));
                caja.setFechaRecepcion(rs.getString("fecha_recepcion"));
                lista.add(caja);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error al listar cajas: " + e.getMessage());
        }
        return lista;
    }
}
