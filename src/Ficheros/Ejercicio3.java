package Ficheros;

import java.io.File;
import java.util.Scanner;

public class Ejercicio3 {
// 3 Realiza un programa que muestre el nombre y tipo (fichero o directorio) de los ficheros y subdirectorios contenidos en un directorio solicitado al usuario.
//    Mostrar también el contenido de todos los subdirectorios y si éstos contienen subdirectorios también...
//    y así sucesivamente hasta mostrar todo el contenido de dicho directorio.

    public static void main(String[] args) {
        Ejercicio3 l = new Ejercicio3();
        String d = l.teclado();
        l.listFiles(d);
    }

    public String teclado() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Dame un directorio: ");
        String dir = teclado.nextLine();
        teclado.close();
        return dir;
    }

    public void listFiles(String mainDir) {
        File main = new File(mainDir);

        String[] fileContent = main.list();
        if (fileContent != null) {
            for (int i = 0; i < fileContent.length; i++) {
                File verifContent = new File(main, fileContent[i]);
                if (verifContent.isFile()) {
                    System.out.printf("Archivo de [%s]: %s",main.getName(), fileContent[i]);
                    System.out.println();
                } else {
                    System.out.printf("Subdirectorio de [%s]: %s",main.getName(), fileContent[i]);
                    System.out.println();
                    listFiles(verifContent.getPath());
                }
            }
        }
    }

}
