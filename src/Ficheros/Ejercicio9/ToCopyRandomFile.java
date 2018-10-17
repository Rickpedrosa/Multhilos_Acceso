package src.Ficheros.Ejercicio9;

import java.io.File;
import java.io.IOException;
import src.Ficheros.Ejercicio8.Agenda;
/* private String nombre;
    private int tlf 4bytes;
    private String dir;
    private int cp 4bytes;
    private String fechanac;
    private boolean money 1byte;
    private float cantidad 4bytes;*/

public class ToCopyRandomFile {

    public ToCopyRandomFile() {
    }

    public void copyFile(File ficheroACopiar) throws IOException {
        File newRandFile = new File(ficheroACopiar, "randFile.dat");
        System.out.printf("El fichero " + (newRandFile.createNewFile() ? "ha sido copiado" : "no ha podido ser copiado"));

    }
}
