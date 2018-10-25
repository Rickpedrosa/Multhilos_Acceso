package Ficheros.Ejercicio8;

import java.io.Serializable;

public class Agenda implements Serializable {

    private String nombre;
    private int tlf;
    private String dir;
    private int cp;
    private String fechanac;
    private boolean money;
    private float cantidad;

    public Agenda(String nombre, int tlf, String dir, int cp, String fechanac, boolean money, float cantidad) {
        this.nombre = nombre;
        this.tlf = tlf;
        this.dir = dir;
        this.cp = cp;
        this.fechanac = fechanac;
        this.money = money;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public boolean isMoney() {
        return money;
    }

    public void setMoney(boolean money) {
        this.money = money;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public boolean getMoney(){
        return money;
    }

}
