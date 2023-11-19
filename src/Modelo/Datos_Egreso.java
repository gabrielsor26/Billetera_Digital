
package Modelo;

import java.sql.Date;

public class Datos_Egreso {
    
    private int ID_EGRESO;
    private Double MONTO_EGRESO;
    private Date  FECHA_EGRESO;
    private String  TIPO_EGRESO;

    public int getID_EGRESO() {
        return ID_EGRESO;
    }

    public void setID_EGRESO(int ID_EGRESO) {
        this.ID_EGRESO = ID_EGRESO;
    }

    public Double getMONTO_EGRESO() {
        return MONTO_EGRESO;
    }

    public void setMONTO_EGRESO(Double MONTO_EGRESO) {
        this.MONTO_EGRESO = MONTO_EGRESO;
    }

    public Date getFECHA_EGRESO() {
        return FECHA_EGRESO;
    }

    public void setFECHA_EGRESO(Date FECHA_EGRESO) {
        this.FECHA_EGRESO = FECHA_EGRESO;
    }

    public String getTIPO_EGRESO() {
        return TIPO_EGRESO;
    }

    public void setTIPO_EGRESO(String TIPO_EGRESO) {
        this.TIPO_EGRESO = TIPO_EGRESO;
    }
    
    
}
