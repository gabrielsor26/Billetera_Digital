

package Modelo;

import Vista.Ventana_Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Consulta_Categoria_Ingreso_Insert extends Conexion {
    
    public boolean registrar(Datos_Categoria_Ingreso catIn, int usuario_id) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        usuario_id = Ventana_Login.usuario_id;

        String sql = "INSERT INTO categoria_ingreso (TIPO_INGRESO, MONTO_INGRESO_FIJO, usuario_id) VALUES(?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, catIn.getTIPO_INGRESO());
            ps.setDouble(2, catIn.getMONTO_INGRESO_FIJO());
            ps.setInt(3, usuario_id);
            
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
