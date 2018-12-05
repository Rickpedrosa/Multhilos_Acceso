package Ficheros.ejercicio12;

import Ficheros.Ejercicio8.Agenda;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Ejercicio12 {
    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            ParseHandler parseHandler = new ParseHandler();
            saxParser.parse(new File("Ficheros/ejercicio13/Agenda.xml"), parseHandler);

            BufferedWriter bufferW = new BufferedWriter(new FileWriter("./NuevoDirectorio/SAXAgenda.txt"));

            List<Agenda> fullContacts = parseHandler.getListAgenda();
            int id = 1;
            for (Agenda contact : fullContacts) {
                bufferW.write(parseHandler.contactToString(contact, id));
                System.out.println("Contacto copiado");
                id++;
            }
            bufferW.close();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
