/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Consulta_Obtener_Dinero_Inversion extends Conexion {

    public double obtenerDineroInversion(int usuario_id) {

        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //usuario_id = Ventana_Login.usuario_id;

        // Consulta SQL para obtener la diferencia entre la suma de ingresos y la suma de egresos
        String sql = "SELECT DINERO_INVERSION AS dinero_inversion FROM inversion WHERE usuario_id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id); // Setear el usuario_id en todos los lugares necesarios
            rs = ps.executeQuery();

            if (rs.next()) {
                double dinero_inversion = rs.getDouble("dinero_inversion");
                return dinero_inversion;
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
