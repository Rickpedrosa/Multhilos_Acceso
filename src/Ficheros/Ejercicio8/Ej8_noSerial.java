package Ficheros.Ejercicio8;

import java.io.*;
import java.util.Scanner;

class Ej8_noSerial {

    private Scanner teclado;
    private String nombre;
    private int tlf;
    private String dir;
    private int cp;
    private String fechanac;
    private boolean money;
    private float cantidad;

    Ej8_noSerial() {
        teclado = new Scanner(System.in);
        menu();
    }

    private void escribirBinario() {
        FileOutputStream writeBin;
        DataOutputStream datOut;
        solicitarContacto();
        File filesilla = new File("E:\\2dam\\prog_movil\\IdeaProjects\\MA\\NuevoDirectorio\\binaryGOD.dat");
        try {
            if (!filesilla.exists()) {
                System.out.println(filesilla.createNewFile() ? "Creado" : "No creado");
                writeBin = new FileOutputStream(filesilla);
            } else {
                writeBin = new FileOutputStream(filesilla, true);
            }
            datOut = new DataOutputStream(writeBin);

            datOut.writeUTF(nombre);
            datOut.writeInt(tlf);
            datOut.writeUTF(dir);
            datOut.writeInt(cp);
            datOut.writeUTF(fechanac);
            datOut.writeBoolean(money);
            datOut.writeFloat(cantidad);

            datOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            DataInputStream datIn = new DataInputStream(new FileInputStream("./NuevoDirectorio/binaryGOD.dat"));
            try {
                System.out.println("*********************************");
                System.out.println("Mi Agenda Telefónica");
                System.out.println("*********************************");
                //noinspection InfiniteLoopStatement
                while (true) {
                    nombre = datIn.readUTF();
                    tlf = datIn.readInt();
                    dir = datIn.readUTF();
                    cp = datIn.readInt();
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
                    System.out.printf("Cantidad: %.2f€\n", cantidad);
                }
            } catch (EOFException e) {
                System.out.println("*********************************");
                System.out.println("*********************************");
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
