package src.Multihilo.Ejercicio_aFregar;

import java.util.ArrayList;

public class Pedro_fregador implements Runnable {

    private Pila_de_platicos pila;


    public Pedro_fregador(Pila_de_platicos pila) {
        this.pila = pila;
    }

    @Override
    public void run() {
        ArrayList<Plato> pilaIni = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            try {
                Thread.sleep(2000);
                pila.agregarPlato(pilaIni, "FREGADO");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
