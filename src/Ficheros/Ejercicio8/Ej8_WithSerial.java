package src.Ficheros.Ejercicio8;

import java.io.*;
import java.util.Scanner;

public class Ej8_WithSerial {

    private Scanner teclado;
    private String nombre;
    private int tlf;
    private String dir;
    private int cp;
    private String fechanac;
    private boolean money;
    private float cantidad;
    private Agenda contacto;
    private File fichero;

    public Ej8_WithSerial() {
        teclado = new Scanner(System.in);
        fichero = new File("./NuevoDirectorio/binaryObjectxd.dat");
        menu();
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

    private void escribirObjectBinario() {
        try {
            ObjectOutputStream dataOS;
            solicitarContacto();
            contacto = new Agenda(nombre, tlf, dir, cp, fechanac, money, cantidad);
            if (!fichero.exists()) {
                dataOS = new ObjectOutputStream(new FileOutputStream(fichero));
                dataOS.writeObject(contacto);
                System.out.println("hi");
            } else {
                dataOS = new MiObjectOutputStream(new FileOutputStream(fichero, true));
                dataOS.writeObject(contacto);
                System.out.println("bye");
            }
            dataOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void leerObjectBinario() {
        try {
            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fichero));
            try {
                System.out.println("*********************************");
                System.out.println("Mi Agenda Telefónica");
                System.out.println("*********************************");
                while (true) {
                    contacto = (Agenda) dataIS.readObject();
                    System.out.println();
                    System.out.printf("Nombre: %s\n", contacto.getNombre());
                    System.out.printf("Teléfono: %d\n", contacto.getTlf());
                    System.out.printf("Dirección: %s\n", contacto.getDir());
                    System.out.printf("Código Postal: %d\n", contacto.getCp());
                    System.out.printf("Fecha nacimiento: %s\n", contacto.getFechanac());
                    System.out.printf("¿Le debo dinero?: %b\n", contacto.getMoney());
                    System.out.printf("Cantidad: %.2f€\n", contacto.getCantidad());
                }
            } catch (EOFException ex) {

            }
            System.out.println("*********************************");
            dataIS.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
                escribirObjectBinario();
                menu();
                break;
            case 2:
                leerObjectBinario();
                menu();
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

}
