/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

public class Datos_Metas {
    
    private int ID_META;
    private String  NOMBRE_META;
    private Double MONTO_META;
    private Date  FECHA_LIMITE_META;
    private Double  RECURSOS_ASIGNADOS_META;

    public int getID_META() {
        return ID_META;
    }

    public void setID_META(int ID_META) {
        this.ID_META = ID_META;
    }

    public String getNOMBRE_META() {
        return NOMBRE_META;
    }

    public void setNOMBRE_META(String NOMBRE_META) {
        this.NOMBRE_META = NOMBRE_META;
    }

    public Double getMONTO_META() {
        return MONTO_META;
    }

    public void setMONTO_META(Double MONTO_META) {
        this.MONTO_META = MONTO_META;
    }

    public Date getFECHA_LIMITE_META() {
        return FECHA_LIMITE_META;
    }

    public void setFECHA_LIMITE_META(Date FECHA_LIMITE_META) {
        this.FECHA_LIMITE_META = FECHA_LIMITE_META;
    }

    public Double getRECURSOS_ASIGNADOS_META() {
        return RECURSOS_ASIGNADOS_META;
    }

    public void setRECURSOS_ASIGNADOS_META(Double RECURSOS_ASIGNADOS_META) {
        this.RECURSOS_ASIGNADOS_META = RECURSOS_ASIGNADOS_META;
    }
    
    
    
}
