package Ficheros;

import java.io.*;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        File ficheroMain = new File("./NuevoDirectorio/ficheroMain.txt");
        int i;
        char[] buff = new char[15];
        try {
            FileReader fr = new FileReader(ficheroMain);
            FileWriter fw1 = new FileWriter("./NuevoDirectorio/fichero1.txt");
            FileWriter fw2 = new FileWriter("./NuevoDirectorio/fichero2.txt");
            FileWriter fw3 = new FileWriter("./NuevoDirectorio/fichero3.txt");
            while ((i = fr.read(buff)) != -1) {
                if (i <= 5) {
                    fw1.write(buff, 0, i);
                } else if (i <= 10) {
                    fw1.write(buff, 0, 5);
                    fw2.write(buff, 5, i - 5);
                } else if (i <= 15) {
                    fw1.write(buff, 0, 5);
                    fw2.write(buff, 5, 5);
                    fw3.write(buff, 10, i - 10);
                } else {
                    fw1.write(buff, 0, 5);
                    fw2.write(buff, 5, 5);
                    fw3.write(buff, 10, 5);
                }
                System.out.println(i);
            }
            fr.close();
            fw1.close();
            fw2.close();
            fw3.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
