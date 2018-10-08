package Ficheros.Ejercicio8;

import java.io.*;
import java.util.Scanner;

public class Ej8_noSerial {

    private Scanner teclado;
    private String nombre;
    private int tlf;
    private String dir;
    private int cp;
    private String fechanac;
    private boolean money;
    private float cantidad;

    public static void main(String[] args) {
        Ej8_noSerial l = new Ej8_noSerial();
        l.menu();
    }

    private void escribirBinario() {
        solicitarContacto();
        try {
            FileOutputStream writeBin = new FileOutputStream("C:\\Users\\Rickdam\\Desktop\\binary.dat", true);
            DataOutputStream datOut = new DataOutputStream(writeBin);

            datOut.writeUTF(nombre);
            datOut.write(tlf);
            datOut.writeUTF(dir);
            datOut.write(cp);
            datOut.writeUTF(fechanac);
            datOut.writeBoolean(money);
            datOut.writeFloat(cantidad);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Ej8_noSerial() {
        teclado = new Scanner(System.in);
    }

    private void solicitarContacto() {
        System.out.print("Nombre: ");
        nombre = teclado.next();
        System.out.print("Teléfono: ");
        tlf = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Dirección: ");
        dir = teclado.nextLine();
        System.out.print("C.Postal: ");
        cp = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Fecha nacimiento: ");
        fechanac = teclado.nextLine();
        System.out.print("¿Debo dinero?: ");
        money = teclado.nextBoolean();
        if (money) {
            System.out.print("Cantidad: ");
            cantidad = teclado.nextFloat();
        } else {
            cantidad = 0;
        }
    }

    private void leerBinario() {
        try {
            FileInputStream readBin = new FileInputStream("C:\\Users\\Rickdam\\Desktop\\binary.dat");
            DataInputStream datIn = new DataInputStream(readBin);

            try {
                System.out.println("*********************************");
                System.out.println("Mi Agenda Telefónica");
                System.out.println("*********************************");
                while (true) {
                    nombre = datIn.readUTF();
                    tlf = datIn.read();
                    dir = datIn.readUTF();
                    cp = datIn.read();
                    fechanac = datIn.readUTF();
                    money = datIn.readBoolean();
                    cantidad = datIn.readFloat();

                    System.out.println();
                    System.out.printf("Nombre: %s\n", nombre);
                    System.out.printf("Teléfono: %d\n", tlf);
                    System.out.printf("Dirección: %s\n", dir);
                    System.out.printf("Código Postal: %d\n", cp);
                    System.out.printf("Fecha nacimiento: %s\n", fechanac);
                    System.out.printf("¿Le debo dinero?: %b\n", money);
                    System.out.printf("Cantidad: %f\n", cantidad);
                }
            } catch (EOFException e) {
            }
            datIn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("1.Añadir contacto");
        System.out.println("2.Ver contactos");
        System.out.println("0.Salir");
        int op;

        System.out.print("¿Qué quieres hacer? > ");
        op = teclado.nextInt();
//        teclado.close();

        switch (op) {
            case 1:
                escribirBinario();
                menu();
                break;
            case 2:
                leerBinario();
                menu();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}