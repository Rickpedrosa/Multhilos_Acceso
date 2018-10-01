package Multihilo.Ejercicio_inicial;

public class Mihilo extends Thread {
    @Override
    public void run() {
        //super.run();
        for(int i = 0; i < 5; i++){
            System.out.println("Hola");
        }

        //UTILIZAR SIEMPRE EL IMPLEMENTS RUNNABLE
    }
}
