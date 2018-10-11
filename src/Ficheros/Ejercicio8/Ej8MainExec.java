package src.Ficheros.Ejercicio8;

import java.util.Scanner;

public class Ej8MainExec {
    public static void main(String[] args) {
        boolean elec;
        Scanner keyb = new Scanner(System.in);
        System.out.print("True[Sin serial]/False[Con objeto]: ");
        elec = keyb.nextBoolean();

        if (elec) {
            Ej8_noSerial l = new Ej8_noSerial();
        } else {
            Ej8_WithSerial p = new Ej8_WithSerial();
        }
    }
}
