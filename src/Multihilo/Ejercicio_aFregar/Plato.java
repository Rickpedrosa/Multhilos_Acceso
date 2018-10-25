package src.Multihilo.Ejercicio_aFregar;

import java.util.ArrayList;

public class Plato {

    private int cantidad_plato;
    private String estadoPlato;

    public int getCantidad_plato() {
        return cantidad_plato;
    }

    public void setCantidad_plato(int cantidad_plato) {
        this.cantidad_plato = cantidad_plato;
    }

    public String getEstadoPlato() {
        return estadoPlato;
    }

    public void setEstadoPlato(String estadoPlato) {
        this.estadoPlato = estadoPlato;
    }

    public Plato(int cantidad_plato, String estadoPlato) {
        this.cantidad_plato = cantidad_plato;
        this.estadoPlato = estadoPlato;
    }

    public static void losPlatosSucios(ArrayList<Plato> platos) {
        for (int i = 0; i < 50; i++) {
            platos.add(new Plato(i+1, "SUCIO"));
        }
    }

}
