package src.Multihilo.Ejercicio_syncro;

public class HiloCurrante implements Runnable {

    private Tropas soldados;
    private boolean syn;

    public HiloCurrante(Tropas soldados, boolean b) {
        this.soldados = soldados;
        this.syn = b;
    }

    @Override
    public void run() {
        if (syn) {
            for (int i = 0; i < 10000; i++) {
                soldados.reclutar(1);

            }
        } else {
            for (int i = 0; i < 10000; i++) {
                soldados.reclutarUnsyn(1);
            }

        }
    }
}
