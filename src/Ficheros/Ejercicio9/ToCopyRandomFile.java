package src.Ficheros.Ejercicio9;

import java.io.*;
import java.util.Random;

import src.Ficheros.Ejercicio8.Agenda;
import src.Ficheros.Ejercicio8.MiObjectOutputStream;
/* private String nombre;
    private int tlf 4bytes;
    private String dir;
    private int cp 4bytes;
    private String fechanac;
    private boolean money 1byte;
    private float cantidad 4bytes;*/

public class ToCopyRandomFile {

    private Agenda contacto;

    public static void main(String[] args) {
        ToCopyRandomFile l = new ToCopyRandomFile();
    }

    public ToCopyRandomFile() {
        copyFile();
    }

    public void copyFile() {
        /*Poner StringBuffer.setLength(15) por si las moscas*/
        File archivoOrigen = new File("./NuevoDirectorio/binary.dat");
        try {
            RandomAccessFile randomFile = new RandomAccessFile(archivoOrigen, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
