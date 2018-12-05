package Multihilo.Ejercicio_semaphore_examenes;

//Pedro pone un examen práctico a sus alumnos, pero como en clase solo hay 5 ordenadores los 12 alumnos no pueden hacer el
// examen a la vez. Por tanto, a la vez solo podrá haber 5 alumnos haciendo el examen. Cada ordenador está numerado con un
//identificador numérico (de 0 al 4).
//Realizar un programa multihilo suponiendo que cada alumno es un hilo y que cada alumno tarda en hacer el examen un tiempo
//aleatorio entre 1 y 5 segundos. Cuando el alumno empieza, se debe mostrar un mensaje del tipo "Alumno 1 comienza el examen
//en el ordenador 3", y cuando termine se mostrará "Alumno 1 termina el examen en el ordenador 3".
//En el momento en que un alumno deja disponible el ordenador, otro alumno que espera deberá entrar en la clase y seleccionar
//el ordenador de entre los que estén disponibles.
public class Main_semaforo {
    public static void main(String[] args) {
//        ColaDeExamen colita = new ColaDeExamen();
//        Thread[] alumnos = new Thread[12];
//        for (int i = 0; i < alumnos.length; i++) {
//            alumnos[i] = new Thread(new AlumnoExaminante(colita));
//        }
//
//        for (Thread alumno : alumnos) {
//            alumno.start();
//        }
    }
}
