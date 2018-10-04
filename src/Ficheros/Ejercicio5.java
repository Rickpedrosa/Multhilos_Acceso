package Ficheros;

import java.io.*;
import java.util.Scanner;

public class Ejercicio5 {

    private String origen, destino;
    private File orgFile, destFile;
    private Scanner keyBoard;

    public static void main(String[] args) {
        Ejercicio5 ej = new Ejercicio5();
    }

    private Ejercicio5() {
        keyBoard = new Scanner(System.in);
        solicitarRutas();
    }

    private void solicitarRutas() { //Método que solicita las rutas por teclado
        System.out.print("Dame un fichero: ");
        origen = keyBoard.nextLine();
        System.out.println();
        System.out.print("Dame directorio/fichero destino: ");
        destino = keyBoard.nextLine();

        orgFile = new File(origen);
        destFile = new File(destino);
        if (!orgFile.isFile()) { //Si el archivo origen no es un archivo como tal, te insulta. Si no, ejecuta el resto del programa
            System.out.println("El origen no es un archivo, idiota. ");
        } else {
            try {
                doWeirdStuff();
            } catch (FileNotFoundException e) {
                System.out.println("Archivo no encontrado");
            }
        }
    }

    private boolean giveMeBoolean() {//Método que solicita el booleano por teclado
        boolean bul;
        System.out.print("Pásate un booleano compadre: ");
        bul = keyBoard.nextBoolean();
        keyBoard.close();
        return bul;
    }

    private void doWeirdStuff() throws FileNotFoundException {
        boolean trueOrFalse;
        if (destFile.exists()) { //Si el archivo destino existe...
            File newDestFile;
            BufferedReader buffR;
            String line;
            BufferedWriter buffW;
            FileWriter fW;
            FileReader fR;

            if (destFile.isDirectory()) { //Y si es directorio...
                File newFile = new File(destFile.getAbsolutePath(), orgFile.getName()); //Nuevo archivo en el path de destino, nombre de origen
                try {
                    System.out.println("El fichero sin contenido " + (newFile.createNewFile() ? "ha sido creado" : "no ha podido ser creado"));
                    buffR = new BufferedReader(new FileReader(orgFile));
                    buffW = new BufferedWriter(new FileWriter(newFile));

                    //Se lee el archivo origen y se escribe sobre el nuevo, linea a linea
                    while ((line = buffR.readLine()) != null) {
                        buffW.write(line);
                        buffW.newLine();
                    }
                    buffR.close();
                    buffW.close();
                    System.out.printf("Volcado de texto desde [%s] a [%s] completado", orgFile.getPath(), newFile.getPath());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                //Escritura caracter a caracter
                System.out.println("Es un archivo existente");
                trueOrFalse = giveMeBoolean();
                newDestFile = new File(destFile.getAbsolutePath().replaceAll(destFile.getName(), orgFile.getName()));
                if (trueOrFalse) {
                    System.out.println("El archivo " + (destFile.delete() ? "ha podido ser borrado para su reemplazo" : "no ha podido ser borrado"));

                    try {
                        fR = new FileReader(orgFile);
                        fW = new FileWriter(newDestFile);
                        int i = 0;

                        while ((i = fR.read()) != -1) {
                            fW.write(i);
                        }
                        fR.close();
                        fW.close();
                        System.out.println("Fin del reemplazo en true");

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    //Escritura con desplazamiento
                    System.out.println("El archivo " + (destFile.delete() ? "ha podido ser borrado para su reemplazo" : "no ha podido ser borrado"));

                    try {
                        fR = new FileReader(orgFile);
                        fW = new FileWriter(newDestFile);

                        char[] charBuff = new char[20];
                        int i = 0;
                        while ((i = fR.read(charBuff)) != -1) {
                            if (i < charBuff.length) {
                                fW.write(charBuff, 0, i);
                            } else {
                                fW.write(charBuff);
                            }
                        }
                        fR.close();
                        fW.close();
                        System.out.println("Fin del reemplazo en false");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        } else {
            //True: salta exception; False: mensaje de error
            System.out.println("El archivo no existe");
            trueOrFalse = giveMeBoolean();
            if (trueOrFalse) {
                throw new FileNotFoundException();
            } else {
                System.out.println("La copia no se ha podido realizar.\nFin del programa");
            }
        }
    }
}
