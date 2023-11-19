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
public class Consulta_Fechas_Select extends Conexion{
    
    public ArrayList<Datos_Fechas> getDatos_Fechas() {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Datos_Fechas> listaDatos_Fechas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM fechas";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Datos_Fechas datos_fechas = new Datos_Fechas();
                datos_fechas.setID_FECHA(rs.getInt("ID_FECHA"));
                datos_fechas.setLIMITE_INFERIOR(rs.getDate("LIMITE_INFERIOR"));
                datos_fechas.setLIMITE_SUPERIOR(rs.getDate("LIMITE_SUPERIOR"));
                datos_fechas.setMES_ANO(rs.getString("MES_ANO"));
                listaDatos_Fechas.add(datos_fechas);
            }
        
        
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return listaDatos_Fechas;
    }
    
}
