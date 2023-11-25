package Modelo;

public class Datos_Tipo_Servicio {

    private int ID_SERVICIO;
    private String TIPO_SERVICIO;

    public Datos_Tipo_Servicio() {
    }

    public Datos_Tipo_Servicio(String TIPO_SERVICIO) {
        this.TIPO_SERVICIO = TIPO_SERVICIO;
    }

    public Datos_Tipo_Servicio(int ID_SERVICIO, String TIPO_SERVICIO) {
        this.ID_SERVICIO = ID_SERVICIO;
        this.TIPO_SERVICIO = TIPO_SERVICIO;
    }

    public int getID_SERVICIO() {
        return ID_SERVICIO;
    }

    public void setID_SERVICIO(int ID_SERVICIO) {
        this.ID_SERVICIO = ID_SERVICIO;
    }

    public String getTIPO_SERVICIO() {
        return TIPO_SERVICIO;
    }

    public void setTIPO_SERVICIO(String TIPO_SERVICIO) {
        this.TIPO_SERVICIO = TIPO_SERVICIO;
    }

    public String toString() {
        return TIPO_SERVICIO;
    }

}
