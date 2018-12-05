package Ficheros.utilidad;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class UtilidadForRandom {
    private UtilidadForRandom() {
    }

    @NotNull
    public static String readValueToString(RandomAccessFile f, @NotNull char[] arrayChar) throws IOException {
        char aux;
        for (int i = 0; i < arrayChar.length; i++) {
            aux = f.readChar();
            arrayChar[i] = aux;
        }
        return String.valueOf(arrayChar);
    }

    public static String formatStringToRead(String cadena) {
        /*Al convertir en utf concatenamos espacios para llenar los bytes. A la hora de leer el valor,
         * también saldrán los espacios. Formatear el string de utf para que salga el valor sin espacios a la derecha*/
        char readValue;
        /*La condición a la hora de cortar sería encontrarse dos espacios, ya que si solo hay uno podría tratarse de
         * un nombre compuesto*/
        for (int i = 0; i < cadena.length(); i++) {
            readValue = cadena.charAt(i);
            if (Character.isWhitespace(readValue) && Character.isWhitespace(cadena.charAt(i + 1))) {
                return cadena.substring(0, i);
            }
        }
        return cadena;
    }

    public static String utfConverter(String cadena, int stringLength) {
        String stringFinal = cadena;
        int stringLengthFinal = ((stringLength * 2) - 2) - cadena.length();

        for (int i = 0; i < stringLengthFinal; i++) stringFinal = stringFinal.concat(" ");

        return stringFinal;
    }

    public static void copyToCompact(RandomAccessFile fileOrigen,
                                     RandomAccessFile ficheroToDepurar,
                                     long longitudContacto,
                                     long posBooleanLogico,
                                     boolean charsOrUTF) throws IOException {
        long pos = posBooleanLogico;
        int vueltas = 1;
        try {
            do {
                fileOrigen.seek(pos);
                if (fileOrigen.readBoolean()) {
                    pos = pos - posBooleanLogico;
                    fileOrigen.seek(pos);

                    if (charsOrUTF) { //false == chars || true == utf
                        fullContactUTF(fileOrigen, ficheroToDepurar, vueltas);
                        vueltas++;
                        pos += longitudContacto + posBooleanLogico;

                    } else {
                        fullContactChars(fileOrigen, ficheroToDepurar, vueltas);
                        vueltas++;
                        pos += longitudContacto + posBooleanLogico;
                    }

                } else {
                    pos += longitudContacto;
                }

            } while (fileOrigen.getFilePointer() != fileOrigen.length());
        } catch (EOFException ex) {
            System.out.println("Fin de copiado para compactación");
        }
        fileOrigen.close();
        ficheroToDepurar.close();
        System.out.println("Reordenación de IDs completada. Fichero compactado al 100%");
    }

    private static void fullContactUTF(RandomAccessFile fileOrigen,
                                       RandomAccessFile ficheroToDepurar, int vueltas) throws IOException {
        ficheroToDepurar.writeUTF(fileOrigen.readUTF()); //nombre

        fileOrigen.readInt(); /*Aunque no los utilice en la escritura, hay que declarar la lectura para que
                    no se pierdan los bytes y se pueda completar sin problemas*/
        fileOrigen.readBoolean();

        ficheroToDepurar.writeInt(vueltas);
        ficheroToDepurar.writeBoolean(true);

        ficheroToDepurar.writeInt(fileOrigen.readInt()); //tlf

        ficheroToDepurar.writeUTF(fileOrigen.readUTF()); //dir

        ficheroToDepurar.writeInt(fileOrigen.readInt()); //cp

        ficheroToDepurar.writeUTF(fileOrigen.readUTF()); //fecha_nacimiento

        ficheroToDepurar.writeBoolean(fileOrigen.readBoolean()); //money (debe dinero?)
        ficheroToDepurar.writeFloat(fileOrigen.readFloat()); //cantidad

        System.out.println("Contacto copiado");
    }

    private static void fullContactUTF(RandomAccessFile randomFile, DataInputStream datIn, int id) throws IOException {
        randomFile.writeUTF(UtilidadForRandom.utfConverter(datIn.readUTF(), 14)); //nombre

        randomFile.writeInt(id);
        randomFile.writeBoolean(true);

        randomFile.writeInt(datIn.readInt()); //tlf

        randomFile.writeUTF(UtilidadForRandom.utfConverter(datIn.readUTF(), 20)); //dir

        randomFile.writeInt(datIn.readInt()); //cp

        randomFile.writeUTF(UtilidadForRandom.utfConverter(datIn.readUTF(), 10)); //fecha_nacimiento

        randomFile.writeBoolean(datIn.readBoolean()); //money (debe dinero?)
        randomFile.writeFloat(datIn.readFloat()); //cantidad
        System.out.println("Contacto copiado");
    }

    private static void fullContactChars(RandomAccessFile fileOrigen,
                                         RandomAccessFile ficheroToDepurar, int vueltas) throws IOException {
        StringBuffer buffNombre;
        StringBuffer buffDir;
        StringBuffer buffFecha_nac;

        buffNombre = new StringBuffer(readValueToString(fileOrigen, new char[14]));
        buffNombre.setLength(14);
        ficheroToDepurar.writeChars(buffNombre.toString()); //nombre

        fileOrigen.readInt(); /*Aunque no los utilice en la escritura, hay que declarar la lectura para que
                    no se pierdan los bytes y se pueda completar sin problemas*/
        fileOrigen.readBoolean();

        ficheroToDepurar.writeInt(vueltas);
        ficheroToDepurar.writeBoolean(true);

        ficheroToDepurar.writeInt(fileOrigen.readInt()); //tlf

        buffDir = new StringBuffer(readValueToString(fileOrigen, new char[20]));
        buffDir.setLength(20);
        ficheroToDepurar.writeChars(buffDir.toString()); //dir

        ficheroToDepurar.writeInt(fileOrigen.readInt()); //cp

        buffFecha_nac = new StringBuffer(readValueToString(fileOrigen, new char[10]));
        buffFecha_nac.setLength(10);
        ficheroToDepurar.writeChars(buffFecha_nac.toString()); //fecha_nacimiento

        ficheroToDepurar.writeBoolean(fileOrigen.readBoolean()); //money (debe dinero?)
        ficheroToDepurar.writeFloat(fileOrigen.readFloat()); //cantidad

        System.out.println("Contacto copiado");
    }

    public static void copyFiletoRandomFile() {
        /*Poner StringBuffer.setLength(15) por si las moscas*/
        File archivoOrigen = new File("NuevoDirectorio/binaryGOD.dat");
        try {
            DataInputStream datIn = new DataInputStream(new FileInputStream(archivoOrigen));
            RandomAccessFile randomFile = new RandomAccessFile("NuevoDirectorio/binaryRandom.dat", "rw");
            int id = 1;
            StringBuffer buffNombre;
            StringBuffer buffDir;
            StringBuffer buffFecha_nac;

            try {
                //noinspection InfiniteLoopStatement
                while (true) {
                    buffNombre = new StringBuffer(datIn.readUTF());
                    buffNombre.setLength(14);
                    randomFile.writeChars(buffNombre.toString()); //nombre

                    randomFile.writeInt(id);
                    randomFile.writeBoolean(true);

                    randomFile.writeInt(datIn.readInt()); //tlf

                    buffDir = new StringBuffer(datIn.readUTF());
                    buffDir.setLength(20);
                    randomFile.writeChars(buffDir.toString()); //dir

                    randomFile.writeInt(datIn.readInt()); //cp

                    buffFecha_nac = new StringBuffer(datIn.readUTF());
                    buffFecha_nac.setLength(10);
                    randomFile.writeChars(buffFecha_nac.toString()); //fecha_nacimiento

                    randomFile.writeBoolean(datIn.readBoolean()); //money (debe dinero?)
                    randomFile.writeFloat(datIn.readFloat()); //cantidad
                    id++;
                    System.out.println("Contacto copiado");
                }
            } catch (EOFException ex) {
                System.out.println("Fin de copiado");
            }
            datIn.close(); //fin de lectura
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFiletoRandomFileUTFVersion() {
        /*Poner StringBuffer.setLength(15) por si las moscas*/
        File archivoOrigen = new File("NuevoDirectorio/binaryGOD.dat");
        try {
            FileInputStream readBin = new FileInputStream(archivoOrigen);
            DataInputStream datIn = new DataInputStream(readBin);
            RandomAccessFile randomFile = new RandomAccessFile("NuevoDirectorio/binaryRandom.dat", "rw");
            int id = 1;

            try {
                //noinspection InfiniteLoopStatement
                while (true) {
                    fullContactUTF(randomFile, datIn, id);
                    id++;
                }
            } catch (EOFException ex) {
                System.out.println("Fin de copiado");
            }
            datIn.close(); //fin de lectura
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
