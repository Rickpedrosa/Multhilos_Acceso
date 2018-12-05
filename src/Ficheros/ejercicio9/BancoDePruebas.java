package Ficheros.ejercicio9;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class BancoDePruebas {
    public static void main(String[] args) {
        try {
            //File chars = new File("./NuevoDirectorio/pruebaChars");
            File utf = new File("./NuevoDirectorio/pruebaUTF");
            // RandomAccessFile f1 = new RandomAccessFile(chars, "rw");
            RandomAccessFile f2 = new RandomAccessFile(utf, "rw");
            StringBuffer buffNombre;
            String nombre = utfConverter("Paco", 14);
            long pos = 0;

            f2.seek(pos);
            buffNombre = new StringBuffer("Paco");
            buffNombre.setLength(14);
            f2.writeChars(buffNombre.toString());
//            f1.close();

            f2.seek(28);
            f2.writeUTF(nombre);
            f2.close();

            //RandomAccessFile f1Leer = new RandomAccessFile(new File("./NuevoDirectorio/pruebaChars"), "r");
            RandomAccessFile f2Leer = new RandomAccessFile(new File("./NuevoDirectorio/pruebaUTF"), "r");
            //  System.out.println("El archivo escrito a Chars (length 14) con el nombre 'Paco' mide: " + f1Leer.length());
//            System.out.println("El archivo escrito a UTF con el nombre 'Paco' mide: " + f2Leer.length());
//
//            System.out.printf("%sy%s", nombre, "Pepito");
//            System.out.println();
//            System.out.printf("%sy%s", formatUTFInput("h"), "Pepito");

            char[] charNombre = new char[10];
            String nombre2;
            try {
                do {
                    f2Leer.seek(0);
                    //nombre2 = readValueToString(f2Leer, charNombre);
                    nombre2 = f2Leer.readUTF();
                    pos += 28;

                    System.out.println(formatUTFInput(nombre2));
                } while (f2Leer.getFilePointer() != f2Leer.length());
            } catch (EOFException e) {

            }

//            f1Leer.close();
            f2Leer.close();
//            chars.deleteOnExit();
            utf.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        //System.out.println(utfConverter("h", 14));
//        System.out.println(formatUTFInput(utfConverter("h", 14)));
//        System.out.println(formatUTFInput("h"));
    }

    private static String utfConverter(String cadena, int stringLength) {
        /*Usando el ejemplo de 'Paco', y length de 14, tenemos que conseguir que la cadena
         * tenga un valor de length total de 26*/
        /*Valor inicial: 4
         * Los 2 bytes extra los agregará al usar .writeUTF()*/
        String stringFinal = cadena;
        int stringLengthFinal = ((stringLength * 2) - 2) - cadena.length();

        for (int i = 0; i < stringLengthFinal; i++) stringFinal = stringFinal.concat(" ");

        System.out.println(stringFinal.length());
        return stringFinal;
    }

    private static String formatUTFInput(String cadena) {
        /*Al convertir en utf concatenamos espacios para llenar los bytes. A la hora de leer el valor,
         * también saldrán los espacios. Formatear el string de utf para que salga el valor sin espacios a la derecha*/
        char readValue;
        /*La condición a la hora de cortar sería encontrarse dos espacios, ya que si solo hay uno podría tratarse de
         * un nombre compuesto*/
        for (int i = 0; i < cadena.length(); i++) {
            readValue = cadena.charAt(i);
            if (Character.isWhitespace(readValue) && Character.isWhitespace(cadena.charAt(i + 1))) {
                System.out.println("String escrito con .writeUTF()");
                return cadena.substring(0, i);
            }
        }
        System.out.println("String escrito con .writeCharsContacts() o nombre compuesto");
        return cadena;
    }

    private static String readValueToString(RandomAccessFile f, @NotNull char[] arrayChar) throws IOException {
        char aux;
        for (int i = 0; i < arrayChar.length; i++) {
            aux = f.readChar();
            arrayChar[i] = aux;
        }
        return String.valueOf(arrayChar);
    }
}
