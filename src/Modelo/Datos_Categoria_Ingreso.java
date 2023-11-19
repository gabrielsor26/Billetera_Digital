/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Datos_Categoria_Ingreso {

    private int ID_CATEGORIA_INGRESO;
    private String TIPO_INGRESO;
    private Double MONTO_INGRESO_FIJO;

    public Datos_Categoria_Ingreso() {

    }

    public Datos_Categoria_Ingreso(String TIPO_INGRESO) {
        this.TIPO_INGRESO = TIPO_INGRESO;
    }

    public Datos_Categoria_Ingreso(int ID_CATEGORIA_INGRESO, String TIPO_INGRESO, Double MONTO_INGRESO_FIJO) {
        this.ID_CATEGORIA_INGRESO = ID_CATEGORIA_INGRESO;
        this.TIPO_INGRESO = TIPO_INGRESO;
        this.MONTO_INGRESO_FIJO = MONTO_INGRESO_FIJO;
    }

    public int getID_CATEGORIA_INGRESO() {
        return ID_CATEGORIA_INGRESO;
    }

    public void setID_CATEGORIA_INGRESO(int ID_CATEGORIA_INGRESO) {
        this.ID_CATEGORIA_INGRESO = ID_CATEGORIA_INGRESO;
    }

    public String getTIPO_INGRESO() {
        return TIPO_INGRESO;
    }

    public void setTIPO_INGRESO(String TIPO_INGRESO) {
        this.TIPO_INGRESO = TIPO_INGRESO;
    }

    public Double getMONTO_INGRESO_FIJO() {
        return MONTO_INGRESO_FIJO;
    }

    public void setMONTO_INGRESO_FIJO(Double MONTO_INGRESO_FIJO) {
        this.MONTO_INGRESO_FIJO = MONTO_INGRESO_FIJO;
    }

    public String toString() {
        return TIPO_INGRESO;
    }

}
