

package Modelo;

import Vista.Ventana_Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Consulta_Tipo_Servicio_Insert extends Conexion {
    
    public boolean registrar(Datos_Tipo_Servicio tipSer, int usuario_id) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        usuario_id = Ventana_Login.usuario_id;

        String sql = "INSERT INTO tipo_servicio (TIPO_SERVICIO, usuario_id) VALUES(?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tipSer.getTIPO_SERVICIO());
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
