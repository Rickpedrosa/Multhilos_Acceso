package Ficheros.ejercicio9;

import Ficheros.utilidad.UtilidadForRandom;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MenuForRandomAccess {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        File origen = new File("NuevoDirectorio/binaryRandom.dat");
        System.out.print("¿Quieres el menú para Chars[true] o UTF[false]? ->");
        boolean opt = teclado.nextBoolean();
        if (opt) {
            if (origen.exists()) {
                menuChars();
            } else {
                UtilidadForRandom.copyFiletoRandomFile();
                menuChars();
            }
        } else {
            if (origen.exists()) {
                menuUTF();
            } else {
                UtilidadForRandom.copyFiletoRandomFileUTFVersion();
                menuUTF();
            }
        }
        origen.deleteOnExit();
    }

    private static void menuChars() {
        RandomAccessUtils rChar = new RandomAccessUtils();
        System.out.println("****************MENÚ***************");
        System.out.println("1. Consultar todos los contactos");
        System.out.println("2. Consultar contacto por ID");
        System.out.println("3. Añadir nuevo contacto");
        System.out.println("4. Borrar contacto por ID");
        System.out.println("5. Modificar deudas por ID");
        System.out.println("6. Compactación del fichero");
        System.out.println("0. Salir");
        System.out.println("**********************************\n");

        Scanner teclado = new Scanner(System.in);
        System.out.print("Escribe el número del menú: ");
        int op = teclado.nextInt();
        switch (op) {
            case 0:
                System.exit(0);
                break;
            case 1:
                rChar.requestAllCharContacts(true);
                menuChars();
                break;
            case 2:
                rChar.requestCharContactByID();
                menuChars();
                break;
            case 3:
                rChar.writeCharsContacts();
                menuChars();
                break;
            case 4:
                rChar.logicalDeleteByID();
                menuChars();
                break;
            case 5:
                rChar.modifyDebtsByID();
                menuChars();
                break;
            case 6:
                try {
                    rChar.depurarFichero(false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
                break;
        }
    }

    private static void menuUTF() {
        RandomAccessUtils rUTF = new RandomAccessUtils();
        System.out.println("****************MENÚ***************");
        System.out.println("1. Consultar todos los contactos");
        System.out.println("2. Consultar contacto por ID");
        System.out.println("3. Añadir nuevo contacto");
        System.out.println("4. Borrar contacto por ID");
        System.out.println("5. Modificar deudas por ID");
        System.out.println("6. Compactación del fichero");
        System.out.println("0. Salir");
        System.out.println("**********************************\n");

        System.out.print("Escribe el número del menú: ");
        int op = teclado.nextInt();
        switch (op) {
            case 0:
                System.exit(0);
                break;
            case 1:
                rUTF.requestAllUTFContacts(true);
                menuUTF();
                break;
            case 2:
                rUTF.requestUTFContactByID();
                menuUTF();
                break;
            case 3:
                rUTF.writeUTFContacts();
                menuUTF();
                break;
            case 4:
                rUTF.logicalDeleteByID();
                menuUTF();
                break;
            case 5:
                rUTF.modifyDebtsByID();
                menuUTF();
                break;
            case 6:
                try {
                    rUTF.depurarFichero(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
                break;
        }
    }
}
