package Ficheros.Ejercicio9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BancoDePruebas {
    public static void main(String[] args) {
        try {
            File chars = new File("./NuevoDirectorio/pruebaChars");
            File utf = new File("./NuevoDirectorio/pruebaUTF");
            RandomAccessFile f1 = new RandomAccessFile(chars, "rw");
            RandomAccessFile f2 = new RandomAccessFile(utf, "rw");
            StringBuffer buffNombre;
            String nombre = utfConverter("Paco", 14);
            long pos = 0;

            f1.seek(pos);
            buffNombre = new StringBuffer("Paco");
            buffNombre.setLength(14);
            f1.writeChars(buffNombre.toString());
            f1.close();

            f2.seek(pos);
            f2.writeUTF(nombre);
            f2.close();

            RandomAccessFile f1Leer = new RandomAccessFile(new File("./NuevoDirectorio/pruebaChars"), "r");
            RandomAccessFile f2Leer = new RandomAccessFile(new File("./NuevoDirectorio/pruebaUTF"), "r");
            System.out.println("El archivo escrito a Chars (length 14) con el nombre 'Paco' mide: " + f1Leer.length());
            System.out.println("El archivo escrito a UTF con el nombre 'Paco' mide: " + f2Leer.length());

            System.out.printf("%sy%s", utfConverter("Paco", 14), "Pepito");
            System.out.println();
            System.out.printf("%sy%s", formatUTFInput(nombre), "Pepito");

            f1Leer.close();
            f2Leer.close();
            chars.deleteOnExit();
            utf.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String utfConverter(String cadena, int stringLength) {
        /*Usando el ejemplo de 'Paco', y length de 14, tenemos que conseguir que la cadena
         * tenga un valor de length total de 26*/
        /*Valor inicial: 4
         * Los 2 bytes extra los agregará al usar .writeUTF()*/
        String stringFinal = cadena;
        int stringLengthFinal = ((stringLength * 2) - 2) - cadena.length();

        for (int i = 0; i < stringLengthFinal; i++) stringFinal = stringFinal.concat(" ");

        return stringFinal;
    }

    private static String formatUTFInput(String cadena) {
        /*Al convertir en utf concatenamos espacios para llenar los bytes. A la hora de leer el valor,
         * también saldrán los espacios. Formatear el string de utf para que salga el valor sin espacios a la derecha*/
        int flag = 0;
        int pos = 0;
        /*La condición a la hora de cortar sería encontrarse dos espacios, ya que si solo hay uno podría tratarse de
         * un nombre compuesto*/
        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isWhitespace(cadena.charAt(i))) {
                flag++;
            }
            if (flag == 2) {
                pos = i - 1;
            }
        }
        return cadena.substring(0, pos);
    }
}
