package Ficheros;

import java.io.*;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        //deconstruirFile();
        Ejercicio6 l = new Ejercicio6();
        l.construirFile();

    }

    public void deconstruirFile() {
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

    public void construirFile() {
        try {
            File ficheroReconstruido = new File("./NuevoDirectorio/ficheroReconstruido.txt");
            FileReader decF1 = new FileReader("./NuevoDirectorio/fichero1.txt");
            FileReader decF2 = new FileReader("./NuevoDirectorio/fichero2.txt");
            FileReader decF3 = new FileReader("./NuevoDirectorio/fichero3.txt");
            FileWriter decFW = new FileWriter(ficheroReconstruido);
            boolean flag = true;
            int contador = 1;
            int j = 0;
            int i = 0;
            char[] buff = new char[15];

//            j = i;    dentro del while
//            decFW.write(buff, i - j, j);


//            for (i = 0; i < 1; i++) {
//                System.out.println(i = decF1.read(buff, 5, 5));
//                System.out.println(buff);
//            }

            System.out.println("ok ya");
            decF1.close();
            decF2.close();
            decF3.close();
            decFW.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void xd() {

    }
}
