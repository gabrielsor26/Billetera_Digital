
package Modelo;

import java.sql.Date;


public class Datos_Ingreso {
    
    private int ID_INGRESO;
    private Double MONTO_INGRESO;
    private Date  FECHA_INGRESO;
    private String  DESCRIPCION_INGRESO;

    public int getID_INGRESO() {
        return ID_INGRESO;
    }

    public void setID_INGRESO(int ID_INGRESO) {
        this.ID_INGRESO = ID_INGRESO;
    }

    public Double getMONTO_INGRESO() {
        return MONTO_INGRESO;
    }

    public void setMONTO_INGRESO(Double MONTO_INGRESO) {
        this.MONTO_INGRESO = MONTO_INGRESO;
    }

    public Date getFECHA_INGRESO() {
        return FECHA_INGRESO;
    }

    public void setFECHA_INGRESO(Date FECHA_INGRESO) {
        this.FECHA_INGRESO = FECHA_INGRESO;
    }

    public String getDESCRIPCION_INGRESO() {
        return DESCRIPCION_INGRESO;
    }

    public void setDESCRIPCION_INGRESO(String DESCRIPCION_INGRESO) {
        this.DESCRIPCION_INGRESO = DESCRIPCION_INGRESO;
    }




      
}
