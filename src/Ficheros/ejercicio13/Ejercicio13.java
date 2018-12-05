package Ficheros.ejercicio13;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio13 {
    public static void main(String[] args) {
        try {
            FileOutputStream htmlWriting = new FileOutputStream(
                    new File("C:\\Users\\Rickdam\\Desktop\\Multhilos_Acceso\\src\\Ficheros\\ejercicio13\\agenda.html"));
            Source style = new StreamSource("C:\\Users\\Rickdam\\Desktop\\Multhilos_Acceso\\src\\Ficheros\\ejercicio13\\agendasXSL.xsl");
            Source data = new StreamSource("C:\\Users\\Rickdam\\Desktop\\Multhilos_Acceso\\src\\Ficheros\\ejercicio13\\Agenda.xml");

            Result result = new StreamResult(htmlWriting);
            Transformer transformer = TransformerFactory.newInstance().newTransformer(style);
            transformer.transform(data, result);

            htmlWriting.close();
        } catch (TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}
