
package Modelo;

import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta_Datos_Ingreso extends Conexion{
    
    public boolean registrar(Datos_Ingreso pro, int usuario_id) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        usuario_id = Ventana_Login.usuario_id;
        
        String sql = "INSERT INTO ingreso (MONTO_INGRESO, FECHA_INGRESO , DESCRIPCION_INGRESO, usuario_id) VALUES(?,?,?,?)";

        try {
           
            ps = con.prepareStatement(sql);            

            ps.setDouble(1, pro.getMONTO_INGRESO());
            ps.setDate(2, pro.getFECHA_INGRESO());
            ps.setString(3, pro.getDESCRIPCION_INGRESO());
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
