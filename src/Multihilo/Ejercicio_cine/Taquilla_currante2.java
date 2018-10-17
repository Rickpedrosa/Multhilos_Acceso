package src.Multihilo.Ejercicio_cine;

public class Taquilla_currante2 implements Runnable {

    private Cine cine;

    public Taquilla_currante2(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            cine.comprarButaca(10, i);
            cine.dejarButaca(30, i);
        }
    }
}
