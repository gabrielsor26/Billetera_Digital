/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Datos_Familia {

    private int ID_FAMILIA;
    private String RELACION_FAMILIAR;

    public Datos_Familia() {
    }

    public Datos_Familia(String RELACION_FAMILIAR) {
        this.RELACION_FAMILIAR = RELACION_FAMILIAR;
    }

    public Datos_Familia(int ID_FAMILIA, String RELACION_FAMILIAR) {
        this.ID_FAMILIA = ID_FAMILIA;
        this.RELACION_FAMILIAR = RELACION_FAMILIAR;
    }

    public int getID_FAMILIA() {
        return ID_FAMILIA;
    }

    public void setID_FAMILIA(int ID_FAMILIA) {
        this.ID_FAMILIA = ID_FAMILIA;
    }

    public String getRELACION_FAMILIAR() {
        return RELACION_FAMILIAR;
    }

    public void setRELACION_FAMILIAR(String RELACION_FAMILIAR) {
        this.RELACION_FAMILIAR = RELACION_FAMILIAR;
    }

    public String toString() {
        return RELACION_FAMILIAR;
    }

}
