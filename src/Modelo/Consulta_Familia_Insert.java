package Modelo;

import Vista.Ventana_Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Consulta_Familia_Insert extends Conexion {

    public boolean registrar(Datos_Familia fam, int usuario_id) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        usuario_id = Ventana_Login.usuario_id;

        String sql = "INSERT INTO familia (RELACION_FAMILIAR, usuario_id) VALUES(?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, fam.getRELACION_FAMILIAR());
            ps.setInt(2, usuario_id);

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
