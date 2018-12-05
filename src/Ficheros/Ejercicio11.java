package Ficheros;

import Ficheros.Ejercicio8.Agenda;
import Ficheros.utilidad.ListOfObject;
import com.thoughtworks.xstream.XStream;

import java.io.*;

public class Ejercicio11 {
    public static void main(String[] args) {
        // XMLtoDat();
        try {
            compareFiles(new File("./NuevoDirectorio/binaryObjectxd.dat"), new File("./NuevoDirectorio/Agenda_ej11.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //leerObjeto(new File("./NuevoDirectorio/Agenda_ej11.dat"));
        //leerObjeto(new File("./NuevoDirectorio/binaryObjectxd.dat"));
    }

    @SuppressWarnings("unchecked") /*cast*/
    private static void XMLtoDat() {
        XStream xstream = new XStream();
        xstream.alias("ListaPersonasAgenda", ListOfObject.class);
        xstream.alias("DatosAgenda", Agenda.class);
        try {
            /*1.Leer el xml*/
            ListOfObject<Agenda> list = (ListOfObject<Agenda>) xstream.fromXML(new FileInputStream("Ficheros/ejercicio13/Agenda.xml"));
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("./NuevoDirectorio/Agenda_ej11.dat"));
            for (Agenda ag : list.getList()) {
                writer.writeObject(ag);
            }
            System.out.println("Escritoxd");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void leerObjeto(File file) {
        try {
            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(file));
            Agenda contacto;
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
                System.out.println("*********************************");
            }
            dataIS.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void compareFiles(File forigen, File fcreado) throws IOException {
        FileInputStream f1 = new FileInputStream(forigen);
        FileInputStream f2 = new FileInputStream(fcreado);
        int omegalol;
        int poggers;

//        while (f1.read() != -1 && f2.read() != -1) {
//            omegalol = f1.read();
//            poggers = f2.read();
//
//            if (omegalol == poggers) {
//                System.out.println("True en verdad");
//            } else {
//                System.out.println("lol noxd");
//            }
//        }
        int counter1 = 0;
        while (f1.read() != -1) {
            counter1++;
        }
        f1.close();

        int counter2 = 0;
        while (f2.read() != -1) {
            counter2++;
        }
        f2.close();
        System.out.println("Tamaño fichero1: " + counter1);
        System.out.println("Tamaño fichero2: " + counter2);


    }


}
