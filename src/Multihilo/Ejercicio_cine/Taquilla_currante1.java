package src.Multihilo.Ejercicio_cine;

public class Taquilla_currante1 implements Runnable {

    private Cine cine;

    public Taquilla_currante1(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void run() {
        cine.comprarButaca(30, 0);
        cine.dejarButaca(12, 0);
        cine.comprarButaca(25, 1);
        cine.dejarButaca(23, 1);
        cine.comprarButaca(36, 2);
        cine.dejarButaca(32, 2);
        cine.comprarButaca(100, 3);
        cine.dejarButaca(0, 3);
        cine.comprarButaca(30, 4);
        cine.dejarButaca(12, 4);
        cine.comprarButaca(23, 5);
        cine.dejarButaca(6, 5);
    }

}
