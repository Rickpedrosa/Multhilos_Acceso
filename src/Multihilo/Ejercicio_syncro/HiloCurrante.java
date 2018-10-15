package src.Multihilo.Ejercicio_syncro;

public class HiloCurrante implements Runnable {

    private Tropas soldados;

    public HiloCurrante(Tropas soldados) {
        this.soldados = soldados;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            soldados.reclutarUnsyn(1);
        }
    }
}
