package model;

import android.graphics.drawable.Drawable;

public class ElementoListaCalcular {
    private Drawable icono;
    private String texto;
    private int horas;
    private int cantidad;
    private int id;
    private float kConsumo;
    private float totalConsunmo;

    public ElementoListaCalcular(Drawable icono, String texto, int id, float kConsumo) {
        this.icono = icono;
        this.texto = texto;
        this.id = id;
        this.kConsumo = kConsumo;
        horas = 0;
        cantidad = 0;
    }

    public float getkConsumo() {
        return kConsumo;
    }

    public void setkConsumo(float kConsumo) {
        this.kConsumo = kConsumo;
    }

    public float getTotalConsunmo() {
        return totalConsunmo;
    }

    public void setTotalConsunmo(float totalConsunmo) {
        this.totalConsunmo = totalConsunmo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Drawable getIcono() {
        return icono;
    }

    public void setIcono(Drawable icono) {
        this.icono = icono;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
