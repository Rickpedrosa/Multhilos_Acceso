package Ficheros;

//14 A partir del fichero XML de la agenda telefónica, obtener un fichero Json utilizando la librería Gson.

import Ficheros.Ejercicio8.Agenda;
import Ficheros.ejercicio10.ListOfAgenda;
import Ficheros.utilidad.ListOfObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio14 {
    public static void main(String[] args) {
        try {
            fromXMLtoJsonV2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fromXMLtoJson() throws IOException {
        File fileXML = new File("C:\\Users\\Rickdam\\Desktop\\Multhilos_Acceso\\" +
                "src\\Ficheros\\ejercicio13\\Agenda.xml");
        File json = new File("./NuevoDirectorio/agenda.json");
        System.out.println(json.createNewFile() ? "Archivo Json creado" : "Archivo Json ya existe");

        ObjectInputStream dataIS = new ObjectInputStream(new FileInputStream(fileXML));
        FileWriter fw = new FileWriter(json);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Agenda> listContacto = new ArrayList<>();
        try {
            //noinspection InfiniteLoopStatement
            while (true) {
                listContacto.add((Agenda) dataIS.readObject());
            }
        } catch (EOFException e) {
            System.out.println("Final de lectura");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dataIS.close();

        gson.toJson(listContacto, fw);
        fw.close();
    }

    private static void fromXMLtoJsonV2() throws IOException {
        File json = new File("./NuevoDirectorio/agenda.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter(json);

        File xml = new File("C:\\Users\\Rickdam\\Desktop\\Multhilos_Acceso\\" +
                "src\\Ficheros\\ejercicio13\\Agenda.xml");
        XStream xStream = new XStream();
        ListOfObject<Agenda> list;
        xStream.alias("ListaPersonasAgenda", ListOfObject.class);
        xStream.alias("DatosAgenda", Agenda.class);

        //noinspection unchecked
        list = (ListOfObject<Agenda>) xStream.fromXML(new FileInputStream(xml));
        fw.write(gson.toJson(list));

        fw.close();
    }

}
