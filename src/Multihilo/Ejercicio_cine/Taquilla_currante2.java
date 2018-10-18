package src.Multihilo.Ejercicio_cine;

public class Taquilla_currante2 implements Runnable {

    private Cine cine;

    public Taquilla_currante2(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            int random1 = (int) ((Math.random() * 50) + 1);
            int random2 = (int) ((Math.random() * 30) + 1);
            cine.comprarButaca(random1, i);
            cine.dejarButaca(random2, i);
        }
    }
}
