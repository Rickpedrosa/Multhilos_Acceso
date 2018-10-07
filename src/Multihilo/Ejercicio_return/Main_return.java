package Multihilo.Ejercicio_return;

public class Main_return {
    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 9;
        int n3 = 6;
        Hilo_return ret1 = new Hilo_return(n1);
        Hilo_return ret2 = new Hilo_return(n2);
        Hilo_return ret3 = new Hilo_return(n3);
        double val = 0;
        double va2 = 0;
        double va3 = 0;

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
            //Si no ponemos el join a los hilos, habrá veces que se ejecuten bien los 3, y habrá veces que no
            //Haciendo esto nos aseguramos que salgan bien los 3
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        val = ret1.getValue();
        va2 = ret2.getValue();
        va3 = ret3.getValue();

        System.out.printf("El factorial de %d es: %f\n", n1, val);
        System.out.printf("El factorial de %d es: %f\n", n2, va2);
        System.out.printf("El factorial de %d es: %f\n", n3, va3);
        System.out.println("La suma de todos los factoriales es igual a: " + (val + va2 + va3));
    }
}
