package Multihilo.ejercicio_countDownLash;

//Se quiere organizar una conferencia de asesores de educación de la unión europea. La conferencia comenzará cuando haya
//al menos 10 participantes. Cada uno de los 15 paises participantes pueden llevar un número aleatorio de asesores
//entre 1 y 4.
//Cuando comienza la conferencia, el presidente dice las palabras "SE INISIA LA CONFEREMSIAXD" y a partir de ese momento
//cada país puede hacer una sugerencia. Para hacer la sugerencia tardará entre 0 y 3 segundos.
//Realiza el ejercicio anterior suponiendo que cada país es un hilo. Cuando todos los paises hayan sugerido, se mostrará
//el mensaje "HA TERMINAO LOL" de parte del presidente.

public class Main {

    public static void main(String[] args) {
        Conferencia conferencia = new Conferencia(10);
        Thread hilo_conferencia = new Thread(conferencia, "Presidente");

        hilo_conferencia.start();
        for (int i = 0; i < 15; i++) {
            Hilo_Pais paisParticipante = new Hilo_Pais();
            Thread participantes = new Thread(paisParticipante, "País" + i);
            participantes.start();
        }
    }
}
