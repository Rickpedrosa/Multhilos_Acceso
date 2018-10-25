package Multihilo.Ejercicio_cine.xd;

public class Cine {
    public int[] entradas = {300, 300, 300, 300, 300, 300};
    Sala sala1 = new Sala();
    Sala sala2 = new Sala();
    Sala sala3 = new Sala();
    Sala sala4 = new Sala();
    Sala sala5 = new Sala();
    Sala sala6 = new Sala();

    public Cine() {
    }

    public String toString() {
        return String.format("Entradas Cine:%nSala1: %d entradas.%nSala2: %d entradas.%nSala3: %d entradas.%nSala4: %d entradas.%nSala5: %d entradas.%nSala6: %d entradas.%n", entradas[0], entradas[1], entradas[2], entradas[3], entradas[4], entradas[5]);
    }

}
