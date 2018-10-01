package Multihilo.Ejercicio_multiplicacion;

public class Multipli_main {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            (new Thread(new Multiplicacion(i), "Hilomulti" + i)).start();
        }
    }
}
