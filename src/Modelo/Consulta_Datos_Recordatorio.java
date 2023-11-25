
package Modelo;

import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta_Datos_Recordatorio extends Conexion{
    
    public boolean registrar(Datos_Recordatorio datos, int usuario_id) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        usuario_id = Ventana_Login.usuario_id;
        
        String sql = "INSERT INTO recordatorios (TIPO_SERVICIO, MONTO , FECHA, PRIORIDAD, ESTADO, usuario_id) VALUES(?,?,?,?,?,?)";

        try {
           
            ps = con.prepareStatement(sql);            

            ps.setString(1, datos.getTIPO_SERVICIO());
            ps.setDouble(2, datos.getMONTO());
            ps.setDate(3, datos.getFECHA());
            ps.setString(4, datos.getPRIORIDAD().name());
            ps.setString(5, datos.getESTADO().name());
            ps.setInt(6, usuario_id);

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
