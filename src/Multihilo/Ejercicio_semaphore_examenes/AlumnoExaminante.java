package Multihilo.Ejercicio_semaphore_examenes;

public class AlumnoExaminante implements Runnable {

    private ColaDeExamen colaDeExamen;

    public AlumnoExaminante(ColaDeExamen colaDeExamen) {
        this.colaDeExamen = colaDeExamen;
    }

    @Override
    public void run() {
        colaDeExamen.hacerExamen();
    }
}
