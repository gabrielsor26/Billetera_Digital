/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import static Vista.Ventana_Login.usuario_id;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Consulta_Familia_Select extends Conexion {

    public ArrayList<Datos_Familia> getDatos_Familia() {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Datos_Familia> listaDatos_Familia = new ArrayList<>();

        try {
            String sql = "SELECT * FROM familia WHERE usuario_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Datos_Familia datos_familia = new Datos_Familia();
                datos_familia.setID_FAMILIA(rs.getInt("ID_FAMILIA"));
                datos_familia.setRELACION_FAMILIAR(rs.getString("RELACION_FAMILIAR"));
                listaDatos_Familia.add(datos_familia);
            }

        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return listaDatos_Familia;
    }

}
