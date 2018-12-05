package Ficheros;

// 16 Dado el fichero Json anterior, mostrar todos los datos de un contacto cuyo nombre nos indique el usuario.
// La búsqueda se hará directamente en el fichero Json. No utilizar Gson.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio16 {

    public static void main(String[] args) {
        try {
            isContactInsideJson("Loler");
            isContactInsideJson("Habubi");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void isContactInsideJson(String contact) throws IOException {
        String contactMatch = "\\b" + contact + "\\b";
        ArrayList<String> contactInfo = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./NuevoDirectorio/agenda.json"));

        Pattern pattern = Pattern.compile(contactMatch);
        Matcher matcher;
        String bufferedLine = bufferedReader.readLine();
        while (bufferedLine != null) {
            matcher = pattern.matcher(bufferedLine);
            if (matcher.find()) {
                while (!bufferedLine.contains("}")) {
                    contactInfo.add(bufferedLine.substring(bufferedLine.indexOf(":") + 2).
                            replaceAll("\"", "").replaceAll(",", ""));
                    bufferedLine = bufferedReader.readLine();
                }
            }
            bufferedLine = bufferedReader.readLine();
        }
        bufferedReader.close();

        for (int i = 0; i < contactInfo.size(); i++) {
            System.out.println(formatContactInfo(contactInfo.get(i), i));
        }
    }

    private static String formatContactInfo(String line, int field) {
        String cleanedLine = "";
        if (field > 6) {
            if (field % 7 == 0) {
                field = 0;
            } else if ((field - 1) % 7 == 0) {
                field = 1;
            } else if ((field - 2) % 7 == 0) {
                field = 2;
            } else if ((field - 3) % 7 == 0) {
                field = 3;
            } else if ((field - 4) % 7 == 0) {
                field = 4;
            } else if ((field - 5) % 7 == 0) {
                field = 5;
            } else if ((field - 6) % 7 == 0) {
                field = 6;
            }
        }
        switch (field) {
            case 0:
                cleanedLine = "Datos del contacto " + line;
                break;
            case 1:
                cleanedLine = "Teléfono: " + line;
                break;
            case 2:
                cleanedLine = "Dirección: " + line;
                break;
            case 3:
                cleanedLine = "Código Postal: " + line;
                break;
            case 4:
                cleanedLine = "Fecha de nacimiento: " + line;
                break;
            case 5:
                String debts = (Boolean.parseBoolean(line) ? "Sí" : "No");
                cleanedLine = "¿Debe dinero?: " + debts;
                break;
            case 6:
                cleanedLine = "Cantidad de la deuda: " + line + "€\n";
                break;
        }
        return cleanedLine;
    }
}
