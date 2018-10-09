package src.Multihilo.Ejercicio_return;

public class Main_return {
    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 9;
        int n3 = 6;
        Hilo_return ret1 = new Hilo_return(n1);
        Hilo_return ret2 = new Hilo_return(n2);
        Hilo_return ret3 = new Hilo_return(n3);
        double val;
        double va2;
        double va3;

        Thread h1 = new Thread(ret1);
        Thread h2 = new Thread(ret2);
        Thread h3 = new Thread(ret3);

        h1.start();
        h2.start();
        h3.start();
        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        val = ret1.getValue();
        va2 = ret2.getValue();
        va3 = ret3.getValue();

        try {
            System.out.printf("El factorial de %d es: %.3f\n", n1, val);
            Thread.sleep(2000);
            System.out.printf("El factorial de %d es: %.3f\n", n2, va2);
            Thread.sleep(2000);
            System.out.printf("El factorial de %d es: %.3f\n", n3, va3);
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("La suma de todos los factoriales es igual a: " + (val + va2 + va3));
    }
}
