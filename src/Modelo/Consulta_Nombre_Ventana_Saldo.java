package Modelo;

import Vista.Ventana_Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta_Nombre_Ventana_Saldo extends Conexion {

    public String obtenerNombreUsuario(int usuario_id) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        String nombreUsuario = null;
        //usuario_id = Ventana_Login.usuario_id;

        try {
            String sql = "SELECT nombre FROM usuarios WHERE usuario_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                nombreUsuario = rs.getString("nombre");
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return nombreUsuario;

    }

}
