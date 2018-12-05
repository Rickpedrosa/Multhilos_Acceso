package Ficheros.ejercicio10;

import Ficheros.Ejercicio8.Agenda;
import Ficheros.utilidad.ListOfObject;
import com.thoughtworks.xstream.XStream;

import java.io.*;

//10 Haz un programa que lea los contactos del fichero binario de la agenda telefónica
// y los escriba en un fichero XML usando la librería XStream

public class Ejercicio10 {

    public static void main(String[] args) {
        File originFile = new File("./NuevoDirectorio/binaryObjectxd.dat");
        ListOfObject<Agenda> lista = new ListOfObject<>();
        try {
            ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(originFile));
            System.out.println("Comienza el proceso...");
            //noinspection CatchMayIgnoreException
            try {
                Agenda agenda;
                //noinspection InfiniteLoopStatement
                while (true) {
                    agenda = (Agenda) dataIS.readObject();
                    lista.add(agenda);
                }
            } catch (EOFException ex) {

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            dataIS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Pues no hubo error omegaLOL");

        XStream converToXML = new XStream();
        converToXML.alias("ListaPersonasAgenda", ListOfObject.class);
        converToXML.alias("DatosAgenda", Agenda.class);
       // converToXML.addImplicitCollection(ListOfObject.class, "lista", "Agenda", Agenda.class);
        //converToXML.addImplicitCollection(ListOfObject.class, "lista", Agenda.class);
//        converToXML.addImplicitCollection(ListOfObject.class, "lista");
        try {
            converToXML.toXML(lista, new FileOutputStream("Ficheros/ejercicio13/Agenda.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
