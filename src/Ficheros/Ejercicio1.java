package Ficheros;

// 1 Realiza un programa que dado un fichero que se le solicite al usuario, muestre su nombre, si
//        es un ejecutable, si está oculto, la ruta relativa, la ruta absoluta y el tamaño.

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Dame un fichero: ");
        String f = teclado.nextLine();
        teclado.close();

        File fichero = new File(f);
        System.out.println(fichero.getName());
        System.out.println(fichero.canExecute());
        System.out.println(fichero.isHidden());
        System.out.println(fichero.getPath());
        System.out.println(fichero.getAbsolutePath());
        System.out.println(fichero.length());
    }

}
