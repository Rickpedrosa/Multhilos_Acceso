package src.Multihilo.Ejercicio_aFregar;

public class Baldomero_secador implements Runnable {

    private Pila_de_platicos pilaSecado, pilaColocado;

    public Baldomero_secador(Pila_de_platicos pilaSecado, Pila_de_platicos pilaColocado) {
        this.pilaSecado = pilaSecado;
        this.pilaColocado = pilaColocado;
    }

    @Override
    public void run() {

    }
}
