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
public class Consulta_Tipo_Servicio_Select extends Conexion {

    public ArrayList<Datos_Tipo_Servicio> getDatos_Tipo_Servicio() {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Datos_Tipo_Servicio> listaDatos_Tipo_Servicio = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tipo_servicio WHERE usuario_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Datos_Tipo_Servicio datos_tipo_servicio = new Datos_Tipo_Servicio();
                datos_tipo_servicio.setID_SERVICIO(rs.getInt("ID_SERVICIO"));
                datos_tipo_servicio.setTIPO_SERVICIO(rs.getString("TIPO_SERVICIO"));
                listaDatos_Tipo_Servicio.add(datos_tipo_servicio);
            }
        
        
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return listaDatos_Tipo_Servicio;
    }

}
