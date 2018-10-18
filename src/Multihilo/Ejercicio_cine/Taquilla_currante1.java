package src.Multihilo.Ejercicio_cine;

public class Taquilla_currante1 implements Runnable {

    private Cine cine;

    public Taquilla_currante1(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
           // int random1 = (int) ((Math.random() * 50) + 1);
            //int random2 = (int) ((Math.random() * 30) + 1);
            cine.comprarButaca(50, i);
            cine.dejarButaca(30, i);
        }
    }
}
