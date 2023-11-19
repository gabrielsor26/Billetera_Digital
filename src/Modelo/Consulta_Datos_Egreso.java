
package Modelo;

import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta_Datos_Egreso extends Conexion{
    
    public boolean registrar(Datos_Egreso egre, int usuario_id) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        usuario_id = Ventana_Login.usuario_id;

        String sql = "INSERT INTO egreso (MONTO_EGRESO, FECHA_EGRESO , TIPO_EGRESO, usuario_id) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, egre.getMONTO_EGRESO());
            ps.setDate(2, egre.getFECHA_EGRESO());
            ps.setString(3, egre.getTIPO_EGRESO());
            ps.setInt(4, usuario_id);
            
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
