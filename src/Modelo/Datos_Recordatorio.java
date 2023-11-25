package Modelo;

import java.sql.Date;

public class Datos_Recordatorio {

    private int ID_RECORDATORIO;
    private String TIPO_SERVICIO;
    private Double MONTO;
    private Date FECHA;
    private PrioridadEnum PRIORIDAD;
    private EstadoEnum ESTADO;

    // Getters y Setters
    public int getID_RECORDATORIO() {
        return ID_RECORDATORIO;
    }

    public void setID_RECORDATORIO(int ID_RECORDATORIO) {
        this.ID_RECORDATORIO = ID_RECORDATORIO;
    }

    public String getTIPO_SERVICIO() {
        return TIPO_SERVICIO;
    }

    public void setTIPO_SERVICIO(String TIPO_SERVICIO) {
        this.TIPO_SERVICIO = TIPO_SERVICIO;
    }

    public Double getMONTO() {
        return MONTO;
    }

    public void setMONTO(Double MONTO) {
        this.MONTO = MONTO;
    }

    public Date getFECHA() {
        return FECHA;
    }

    public void setFECHA(Date FECHA) {
        this.FECHA = FECHA;
    }

    public PrioridadEnum getPRIORIDAD() {
        return PRIORIDAD;
    }

    public void setPRIORIDAD(PrioridadEnum PRIORIDAD) {
        this.PRIORIDAD = PRIORIDAD;
    }

    public EstadoEnum getESTADO() {
        return ESTADO;
    }

    public void setESTADO(EstadoEnum ESTADO) {
        this.ESTADO = ESTADO;
    }

    // Enumeración para PRIORIDAD
    public enum PrioridadEnum {
        ALTA,
        MEDIA,
        BAJA
    }

    // Enumeración para ESTADO
    public enum EstadoEnum {
        PAGADA,
        PENDIENTE
    }
}
