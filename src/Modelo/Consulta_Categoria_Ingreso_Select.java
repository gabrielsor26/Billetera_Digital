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
public class Consulta_Categoria_Ingreso_Select extends Conexion {

    public ArrayList<Datos_Categoria_Ingreso> getDatos_Categoria_Ingreso() {

        Connection con = getConexion();
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Datos_Categoria_Ingreso> listaDatos_Categoria_Ingreso = new ArrayList<>();

        try {
            String sql = "SELECT * FROM categoria_ingreso WHERE usuario_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario_id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Datos_Categoria_Ingreso datos_categoria_ingreso = new Datos_Categoria_Ingreso();
                datos_categoria_ingreso.setID_CATEGORIA_INGRESO(rs.getInt("ID_CATEGORIA_INGRESO"));
                datos_categoria_ingreso.setTIPO_INGRESO(rs.getString("TIPO_INGRESO"));
                datos_categoria_ingreso.setMONTO_INGRESO_FIJO(rs.getDouble("MONTO_INGRESO_FIJO"));
                listaDatos_Categoria_Ingreso.add(datos_categoria_ingreso);
            }
        
        
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        return listaDatos_Categoria_Ingreso;
    }

}
