package Ficheros;


import java.io.*;

public class Ejercicio07_ale {

//    public static void main(String[] args) {
//        String encriptadora;
//        boolean encriptar;
//        File f = new File("C:\\zProyectos\\AccesoADatos\\Esnuevoo\\encriptacion\\Soyunfichero.txt");
//        File f1 = new File("C:\\zProyectos\\AccesoADatos\\Esnuevoo\\encriptacion", "jaja.txt");
//        FileReader read;
//        FileWriter wr;
//        int contador = 0, caracter = 0, charClave, resultado;
//
//        System.out.println("Clave de encriptado/desencriptado:");
//        encriptadora = Teclado.leerString();
//
//        encriptar = Teclado.leerBoolean("¿Encriptar o desencriptar?", "Encriptar", "Desencriptar");
//
//        try {
//            f1.createNewFile();
//            read = new FileReader(f);
//            wr = new FileWriter(f1);
//            while ((caracter = read.read()) != -1) {
//                charClave = encriptadora.charAt(contador);
//                if (encriptar) {
//                    resultado = caracter + charClave;
//                } else {
//                    resultado = caracter - charClave;
//                }
//                wr.write(resultado);
//                contador++;
//                if (contador == encriptadora.length()) {
//                    contador = 0;
//                }
//            }
//            read.close();
//            wr.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        f.delete();
//        f1.renameTo(new File("C:\\zProyectos\\AccesoADatos\\Esnuevoo\\encriptacion", "Soyunfichero.txt"));
//        Teclado.cerrarTeclado();
//    }
}
