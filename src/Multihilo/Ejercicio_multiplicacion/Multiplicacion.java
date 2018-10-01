package Multihilo.Ejercicio_multiplicacion;

//programa mulithilo que muestra las tablas de multiplicar del 1 al 10
// para cada tabla un hilo

public class Multiplicacion implements Runnable {

    private int numtabla;

    public Multiplicacion(int numtabla) {
        this.numtabla = numtabla;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "x" + numtabla + "=" + (i * numtabla));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
