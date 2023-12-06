
package Modelo;

import Vista.Ventana_Login;
import static Vista.Ventana_Login.usuario_id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consulta_Datos_Presupuestos extends Conexion{
    
    public boolean registrar(Datos_Presupuestos pre, int usuario_id) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        usuario_id = Ventana_Login.usuario_id;
        
        String sql = "INSERT INTO presupuestos (CATEGORIA, MONTO_PRESUPUESTO , ID_FECHA, TIPO, usuario_id) VALUES(?,?,?,?,?)";

        try {
           
            ps = con.prepareStatement(sql);            

            ps.setString(1, pre.getCATEGORIA());
            ps.setDouble(2, pre.getMONTO_PRESUPUESTO());
            ps.setInt(3, pre.getID_FECHA());
            ps.setString(4, pre.getTIPO());
            ps.setInt(5, usuario_id);

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
