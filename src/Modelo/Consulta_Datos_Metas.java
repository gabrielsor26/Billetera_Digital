/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.Ventana_Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class Consulta_Datos_Metas extends Conexion {

    public boolean registrar(Datos_Metas egre, int usuario_id) {

        PreparedStatement ps = null;
        Connection con = getConexion();
        usuario_id = Ventana_Login.usuario_id;

        String sql = "INSERT INTO meta (NOMBRE_META, MONTO_META , FECHA_LIMITE_META, usuario_id) VALUES(?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, egre.getNOMBRE_META());
            ps.setDouble(2, egre.getMONTO_META());
            ps.setDate(3, egre.getFECHA_LIMITE_META());
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
