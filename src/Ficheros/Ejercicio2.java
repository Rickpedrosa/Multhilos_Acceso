package Ficheros;

// 2Realiza un programa que cree un directorio en el directorio actual,luego cree tres ficheros
//         en dicho directorio donde uno se borre y otro se renombre.Crearle también un subdirectorio con un
//         fichero dentro.Después mostrar la ruta absoluta de ambos directorios y sus contenidos.

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {

    public static void main(String[] args) {
        File newDir = new File(new File("."), "NuevoDirectorio");
        newDir.mkdir();

        File f1 = new File(newDir, "fichero1.txt");
        File f2 = new File(newDir, "fichero2.txt");
        File f3 = new File(newDir, "fichero3.txt");

        try {
            if (f1.createNewFile()) {
                System.out.println("FICHEROl creado correctamente ... ");
            } else System.out.println("No se ha podido crear FICHEROl ... ");

            if (f2.createNewFile()) {
                System.out.println("FICHERO2 creado correctamente ... ");
            } else System.out.println("No se ha podido crear FICHERO2 ... ");

            if (f3.createNewFile()) {
                System.out.println("FICHERO3 creado correctamente ... ");
            } else System.out.println("No se ha podido crear FICHERO3 ... ");

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        if (f1.delete()) {
            System.out.println("Fichero borrado ... ");
        } else {
            System.out.println("No se ha podido borrar el fichero ... ");
        }

        f2.renameTo(new File(newDir, "fichero2renombrado"));


        //Creating a subdirectory inside "NewDirectory"
        File subDir = new File(newDir, "Subdirectorio");
        subDir.mkdir();

        File fSub = new File(subDir, "subfichero.txt");

        try {
            if (fSub.createNewFile()) {
                System.out.println("FICHEROSUB creado correctamente ... ");
            } else System.out.println("No se ha podido crear FICHEROSUB ... ");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        System.out.println("Ruta absoluta del nuevo directorio: " + newDir.getAbsolutePath());
        String[] archivosND = newDir.list();
        for (int i = 0; i < archivosND.length; i++) {
            File verifND = new File(newDir, archivosND[i]);
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivosND[i], verifND.isFile() ,verifND.isDirectory());
        }

        System.out.println("Ruta absoluta del subdirectorio: " + subDir.getAbsolutePath());
        String[] archivosSD = subDir.list();
        for (int i = 0; i < archivosSD.length; i++) {
            File verifSD = new File(subDir, archivosSD[i]);
            System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivosSD[i], verifSD.isFile() ,verifSD.isDirectory());
        }
    }

}
