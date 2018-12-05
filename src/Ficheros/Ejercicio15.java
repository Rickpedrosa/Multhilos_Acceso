package Ficheros;

import Ficheros.Ejercicio8.Agenda;
import Ficheros.ejercicio10.ListOfAgenda;
import Ficheros.utilidad.StringUtility;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio15 {
    public static void main(String[] args) {
        try {
            createAgendaFromJson();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createAgendaFromJson() throws IOException {
        File jsonFile = new File("./NuevoDirectorio/agenda.json");
        File jsonTxt = new File("./NuevoDirectorio/agendajson.txt");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        BufferedReader bufferedJson = new BufferedReader(new FileReader(jsonFile));
        BufferedWriter bufferedJsonToTxt = new BufferedWriter(new FileWriter(jsonTxt));

        ListOfAgenda contacts = gson.fromJson(bufferedJson, ListOfAgenda.class);
        List<Agenda> listOfContacts = new ArrayList<>(contacts.getList());

        /*Header beginning*/
        bufferedJsonToTxt.write(StringUtility.repeat(78, "*"));
        bufferedJsonToTxt.newLine();
        bufferedJsonToTxt.write(StringUtility.repeat(28, " "));
        bufferedJsonToTxt.write("AGENDA TELEFÓNICA");
        bufferedJsonToTxt.write(StringUtility.repeat(28, " "));
        bufferedJsonToTxt.newLine();
        bufferedJsonToTxt.write(StringUtility.repeat(78, "*"));
        bufferedJsonToTxt.newLine();
        /*Header end*/

        /*Body beginning*/
        for (Agenda listOfContact : listOfContacts) {
            bufferedJsonToTxt.write("Nombre: " + listOfContact.getNombre());
            bufferedJsonToTxt.newLine();
            bufferedJsonToTxt.write("Teléfono: " + listOfContact.getTlf());
            bufferedJsonToTxt.newLine();
            bufferedJsonToTxt.write("Dirección: " + listOfContact.getDir());
            bufferedJsonToTxt.newLine();
            bufferedJsonToTxt.write("Código Postal: " + listOfContact.getCp());
            bufferedJsonToTxt.newLine();
            bufferedJsonToTxt.write("Fecha de nacimiento: " + listOfContact.getFechanac());
            bufferedJsonToTxt.newLine();
            bufferedJsonToTxt.write("Le debo dinero: " + listOfContact.getMoney());
            bufferedJsonToTxt.newLine();
            bufferedJsonToTxt.write("Cuánto: " + listOfContact.getCantidad());
            bufferedJsonToTxt.newLine();
            bufferedJsonToTxt.write(StringUtility.repeat(78, "*"));
            bufferedJsonToTxt.newLine();
        }
        /*Body end*/

        bufferedJsonToTxt.write(StringUtility.repeat(28, " "));
        bufferedJsonToTxt.write("FIN AGENDA TELEFÓNICA");
        bufferedJsonToTxt.write(StringUtility.repeat(28, " "));
        bufferedJsonToTxt.newLine();
        bufferedJsonToTxt.write(StringUtility.repeat(78, "*"));
        /*End*/

        bufferedJson.close();
        bufferedJsonToTxt.close();
        System.out.println("Json to txt completed");
    }
}
