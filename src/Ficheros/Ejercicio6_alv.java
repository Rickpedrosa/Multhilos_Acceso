package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio6_alv {

    public static void main(String[] args) {
        String origen;
        int i = 0;
        char[] buffer = new char[15];
        char[] buffer2 = new char[15];
        Scanner scn = new Scanner(System.in);
        String cadena1;
        String cadena2;
        boolean iguales = true;


        System.out.println("Introduca el archivo que desea encriptar");
        origen = scn.nextLine();
        File archivo = new File(origen); // accedo al fichero original

        File e1 = new File(archivo.getParent(), "en1.txt");
        File e2 = new File(archivo.getParent(), "en2.txt"); // Creo los tres ficheros donde encriptar la informacion
        File e3 = new File(archivo.getParent(), "en3.txt");
        try {
            e1.createNewFile();
            e2.createNewFile();
            e3.createNewFile();
            FileReader lector = new FileReader(archivo);
            FileWriter escritor1 = new FileWriter(e1); // Creo readers y writers para todos los archivos
            FileWriter escritor2 = new FileWriter(e2);
            FileWriter escritor3 = new FileWriter(e3);
            while ((i = lector.read(buffer)) != -1) { // leo en un buffer, almacenando el numero de caracteres que
                // he leido
                if (i == 15) {
                    escritor1.write(buffer, 0, 5);
                    escritor2.write(buffer, 5, 5);
                    escritor3.write(buffer, 10, 5);
                } else if (i >= 10 && i < 15) {
                    escritor1.write(buffer, 0, 5);
                    escritor2.write(buffer, 5, 5);
                    escritor3.write(buffer, 10, i - 10);
                } else if (i < 10 && i >= 5) {
                    escritor1.write(buffer, 0, 5);
                    escritor2.write(buffer, 5, i - 5);
                } else if (i < 5) {
                    escritor1.write(buffer, 0, i);
                }

            }
            System.out.println("Archivo encriptado");
            escritor1.close();
            escritor2.close(); // Cierro los readers y los writers
            escritor3.close();
            lector.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // SEGUNDA PARTE, LEER DE FICHEROS ENCRIPTADOS Y RECONSTRUIR LA INFORMACION EN
        // UN NUEVO FICHERO
        try {
            FileReader lector1 = new FileReader(e1);
            FileReader lector2 = new FileReader(e2); // Creo lectores de los ficheros encriptados
            FileReader lector3 = new FileReader(e3);
            File archivoFinal = new File(archivo.getParent(), "archivoDesencriptado.txt"); // Creo el fichero donde
            // recuperare la informacion
            archivoFinal.createNewFile();
            FileWriter escritor4 = new FileWriter(archivoFinal); // Creo un writer en el fichero donde recuperar la
            // informacion
            System.out.println("Recomponiendo el archivo");
            while (((i = lector1.read(buffer2, 0, 5)) != -1)) { // leo en un buffer con desplazamiento
                // Usamos el primer archivo para saber si aun queda
                // informacion encriptada

                if (i == 5 && lector2.ready()) { // Antes de leer del archivo 2 y el archivo 3 pregunto si queda
                    // algun caracter que leer
                    i = i + lector2.read(buffer2, 5, 5);
                    if (i == 10 && lector3.ready()) {
                        i = i + lector3.read(buffer2, 10, 5);
                    }
                }

                if (i == 15) {
                    // Si indiceB es igual a 15 significa que ha leido de los tres ficheros
                    escritor4.write(buffer2);
                    // escribo el buffer en el fichero
                } else {
                    // Si indiceB es menor que 15 significa que no leyo de los 3 ficheros asi que
                    // usamos la escritura con desplazamiento

                    escritor4.write(buffer2, 0, i);

                }

            }

            lector1.close();
            lector2.close(); // Cierro los readers y writers
            lector3.close();
            escritor4.close();
            System.out.println("Archivo desencriptado");

            // Comprobamos si los ficheros son iguales
            System.out.println("Comprobando si los ficheros son iguales");
            // Creamos un bufferReader del archivo original y el archivo final
            BufferedReader archivoOriginal = new BufferedReader(new FileReader(archivo));
            BufferedReader archivoFinalD = new BufferedReader(new FileReader(archivoFinal));

            // Leemos una cadena de cada fichero
            cadena1 = archivoOriginal.readLine();
            cadena2 = archivoFinalD.readLine();

            while ((cadena1 != null) && (cadena2 != null) && iguales) {

                if (!cadena1.equals(cadena2)) { // si las cadenas no son iguales cambiaremos la bandera para
                    iguales = false;
                }
                cadena1 = archivoOriginal.readLine();
                cadena2 = archivoFinalD.readLine(); // Leemos en esta posicion para asegurarnos de que acaban a la vez
            }

            // Si los ficheros acabaron a la vez las cadenas seran null
            if ((iguales) && (cadena1 == null) && (cadena2 == null))
                System.out.println("Los ficheros son iguales");
            else
                System.out.println("Los ficheros son diferentes");

            archivoOriginal.close();
            archivoFinalD.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scn.close();
    }

}