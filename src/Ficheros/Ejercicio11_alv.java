package Ficheros;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class Ejercicio11_alv {
//
//    public static void main(String[] args) {
//        DataOutputStream fichero = null;
//        DataInputStream fichero2 = null;
//        DataInputStream fichero3 = null;
//        int cadena1 = 0;
//        int cadena2 = 0;
//        boolean iguales = true;
//        Contactos contacto = null;
//        XStream xstream = new XStream(); // Creo el objeto XStream
//        xstream.allowTypesByRegExp(new String[]{".*"});// Le asigno como valido todas las clases
//        xstream.alias("ListaContactos", ListaContactos.class);
//        xstream.alias("Contactos", Contactos.class); // Asigno los alias que puse anteriormente en el fichero XML
//        xstream.addImplicitCollection(ListaContactos.class, "lista"); // Creo la coleccion
//        ListaContactos listadoCon;
//        File ficheroO = null;
//        Iterator it;
//        try {
//            System.out.println("Leyendo el archivo XML");
//            listadoCon = (ListaContactos) xstream.fromXML(new FileInputStream("Personas.xml")); // Paso la informacion
//            // del fichero a un
//            // objeto listaContacto
//            List<Contactos> listaContactos = new ArrayList<Contactos>(); // Creo una lista de contacto
//            listaContactos = listadoCon.getListaContactos(); // Obtengo la lista de la clase ListaContantos
//            it = listaContactos.iterator();
//            System.out.println("Creando el bichero binario");
//            ficheroO = new File("ficheroBinarioEjercicio11.dat"); // Creo el fichero binario donde guardaremos la
//            // informacion del archivo XML
//            fichero = new DataOutputStream(new FileOutputStream(ficheroO));
//
//            while (it.hasNext()) { // Leo toda la lista de contactos usando un iterador
//                contacto = (Contactos) it.next();
//                fichero.writeUTF(contacto.getName());
//                fichero.writeUTF(contacto.getNumero());
//                fichero.writeUTF(contacto.getDireccion()); // Utilizo la funcion necesaria con los gets del objeto
//                fichero.writeInt(contacto.getCodigoP());
//                fichero.writeUTF(contacto.getFecha());
//                fichero.writeBoolean(contacto.getdeberD());
//                fichero.writeDouble(contacto.getCantidad());
//
//            }
//            fichero.close();
//            // Cierro el fichero y acabo la primera parte del ejercicio
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        // Segunda parte comparar los ficheros
//        try {
//            fichero2 = new DataInputStream(new FileInputStream(new File("ficheroBinario.dat")));
//            fichero3 = new DataInputStream(new FileInputStream(ficheroO)); // Accedo a los dos ficheros que voy a
//            // comparar: El fichero binario creado en
//            // este ejercicio y el fichero binario del
//            // ejercicio 8 sin objetos
//            System.out.println("Comparando byte a byte los dos fichero binarios");
//            while (cadena1 != -1 || cadena2 != -1) {
//                cadena1 = fichero2.read(); // Leo byte a byte hasta el final del fichero
//                cadena2 = fichero3.read();
//
//                if ((cadena1 != cadena2)) {
//                    iguales = false;
//                }
//            }
//
//        } catch (EOFException eo) { // Capturo la excepcion sin mensaje
//
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        // Pregunto si son o no iguales
//        if ((iguales) && (cadena1 == -1 && cadena2 == -1)) {
//            System.out.println("los fichero si son iguales");
//        } else {
//            System.out.println("Los ficheros no son iguales");
//        }
//        try {
//            fichero2.close(); // Cierro ambos ficheros
//            fichero3.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }

}
