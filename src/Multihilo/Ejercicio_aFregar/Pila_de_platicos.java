package src.Multihilo.Ejercicio_aFregar;

import java.util.ArrayList;

public class Pila_de_platicos {

    public void agregarPlato(ArrayList<Plato> pilaPlato, String estado) {
        while (pilaPlato.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (pilaPlato.size() > 0) {
            notifyAll();
            synchronized (pilaPlato) {
                pilaPlato.add(new Plato(1, estado));
                System.out.printf("Plato %s\n", estado);
            }
        }
    }

    public void quitarPlato(ArrayList<Plato> pilaPlato) {
        while (pilaPlato.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (pilaPlato.size() > 0) {
            notifyAll();
            synchronized (pilaPlato) {
                pilaPlato.remove(pilaPlato.get(pilaPlato.size() - 1));
            }
        }
    }
}
