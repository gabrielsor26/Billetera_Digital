
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Consulta_Obtener_Suma_Recursos_Asignados_Metas extends Conexion {
    
    public double obtenerRecursosAsignados(int usuario_id) {
    
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //usuario_id = Ventana_Login.usuario_id;

        // Consulta SQL para obtener la diferencia entre la suma de ingresos y la suma de egresos
        String sql = "SELECT SUM(RECURSOS_ASIGNADOS) AS suma_recursos_asignados FROM meta WHERE usuario_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id); // Setear el usuario_id en todos los lugares necesarios
            rs = ps.executeQuery();

            if (rs.next()) {
                double suma_metas = rs.getDouble("suma_recursos_asignados");
                return suma_metas;
            } else {
                return 0.0; // Si no hay datos, retornamos 0.0
            }
        } catch (SQLException e) {
            System.err.println(e);
            return 0.0; // En caso de error, también retornamos 0.0
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    
    }
    
}
