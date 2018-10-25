package src.Multihilo.Ejercicio_aFregar;

import java.util.ArrayList;

public class Main_fregar {
    public static void main(String[] args) {
//        ArrayList<Plato> platosSucios = new ArrayList<>();
//        ArrayList<Plato> platosSecos = new ArrayList<>();

        Pila_de_platicos pilaDeFregado = new Pila_de_platicos();
        Pila_de_platicos pilaDeColocado = new Pila_de_platicos();

        Pedro_fregador fregar = new Pedro_fregador(pilaDeFregado);
        Baldomero_secador secar = new Baldomero_secador(pilaDeFregado, pilaDeColocado);
        GermanGines_colocador colocar = new GermanGines_colocador(pilaDeColocado);

        Thread hiloFregar = new Thread(fregar);
        Thread hiloSecar = new Thread(secar);
        Thread hiloColocar = new Thread(colocar);

        hiloFregar.start();
        hiloSecar.start();
        hiloColocar.start();

        try {
            hiloFregar.join();
            hiloSecar.join();
            hiloColocar.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
