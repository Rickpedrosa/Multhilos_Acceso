package Ficheros.Ejercicio9;

import java.io.*;

/* private String nombre;
    private int tlf 4bytes;
    private String dir;
    private int cp 4bytes;
    private String fechanac;
    private boolean money 1byte;
    private float cantidad 4bytes;*/

public class ToCopyRandomFile {

    private ToCopyRandomFile() {
    }

    public static void copyFiletoRandomFile() {
        /*Poner StringBuffer.setLength(15) por si las moscas*/
        File archivoOrigen = new File("NuevoDirectorio/binaryGOD.dat");

        try {
            FileInputStream readBin = new FileInputStream(archivoOrigen);
            DataInputStream datIn = new DataInputStream(readBin);
            RandomAccessFile randomFile = new RandomAccessFile("NuevoDirectorio/binaryRandom.dat", "rw");
            int id = 1;
            StringBuffer buffNombre;
            StringBuffer buffDir;
            StringBuffer buffFecha_nac;

            try {
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


}
