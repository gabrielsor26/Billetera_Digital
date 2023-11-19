/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Consulta_Limites_Fechas extends Conexion {

    public ArrayList<Date> getLimitesFechas(String mesAno) {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Date> limitesFechas = new ArrayList<>();

        try {
            String sql = "SELECT LIMITE_INFERIOR, LIMITE_SUPERIOR FROM fechas WHERE MES_ANO = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, mesAno);
            rs = ps.executeQuery();

            while (rs.next()) {
                Date limiteInferior = rs.getDate("LIMITE_INFERIOR");
                Date limiteSuperior = rs.getDate("LIMITE_SUPERIOR");
                limitesFechas.add(limiteInferior);
                limitesFechas.add(limiteSuperior);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println(e.toString());
            }
        }

        return limitesFechas;
    }
}
