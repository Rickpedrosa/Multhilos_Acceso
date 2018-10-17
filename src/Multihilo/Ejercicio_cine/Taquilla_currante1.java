package src.Multihilo.Ejercicio_cine;

public class Taquilla_currante1 implements Runnable {

    private Cine cine;

    public Taquilla_currante1(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            cine.comprarButaca(60, i);
            cine.dejarButaca(0, i);
        }
    }
}
