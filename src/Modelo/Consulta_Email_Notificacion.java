package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta_Email_Notificacion extends Conexion {

    public String obtenerEmailUsuario(int usuario_id) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        String emailUsuario = null;
        //usuario_id = Ventana_Login.usuario_id;

        try {
            String sql = "SELECT email FROM usuarios WHERE usuario_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emailUsuario = rs.getString("email");
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

        return emailUsuario;

    }

}
