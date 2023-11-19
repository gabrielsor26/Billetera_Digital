/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;

public class Datos_Fechas {
    
    private int ID_FECHA;
    private Date LIMITE_INFERIOR;
    private Date  LIMITE_SUPERIOR;
    private String  MES_ANO;

    public Datos_Fechas() {
        
    }
    
    public Datos_Fechas(int ID_FECHA, Date LIMITE_INFERIOR, Date LIMITE_SUPERIOR, String MES_ANO) {
        this.ID_FECHA = ID_FECHA;
        this.LIMITE_INFERIOR = LIMITE_INFERIOR;
        this.LIMITE_SUPERIOR = LIMITE_SUPERIOR;
        this.MES_ANO = MES_ANO;
    }

    public int getID_FECHA() {
        return ID_FECHA;
    }

    public void setID_FECHA(int ID_FECHA) {
        this.ID_FECHA = ID_FECHA;
    }

    public Date getLIMITE_INFERIOR() {
        return LIMITE_INFERIOR;
    }

    public void setLIMITE_INFERIOR(Date LIMITE_INFERIOR) {
        this.LIMITE_INFERIOR = LIMITE_INFERIOR;
    }

    public Date getLIMITE_SUPERIOR() {
        return LIMITE_SUPERIOR;
    }

    public void setLIMITE_SUPERIOR(Date LIMITE_SUPERIOR) {
        this.LIMITE_SUPERIOR = LIMITE_SUPERIOR;
    }

    public String getMES_ANO() {
        return MES_ANO;
    }

    public void setMES_ANO(String MES_ANO) {
        this.MES_ANO = MES_ANO;
    }
    
    public String toString() {
        return MES_ANO;
    }
    
}
