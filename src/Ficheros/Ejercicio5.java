package Ficheros;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5 {

    private String origen, destino;
    private File orgFile, destFile;
    private Scanner keyBoard;

    public static void main(String[] args) throws IOException {
        Ejercicio5 ej = new Ejercicio5();
    }

    private Ejercicio5() throws IOException {
        keyBoard = new Scanner(System.in);
        solicitarRutas();
        doWeirdStuff();
    }

    private void solicitarRutas() {
        System.out.print("Dame un fichero: ");
        origen = keyBoard.nextLine();
        System.out.println();
        System.out.print("Dame directorio/fichero destino: ");
        destino = keyBoard.nextLine();

        orgFile = new File(origen);
        destFile = new File(destino);
        if (!orgFile.isFile() || !origen.endsWith(".txt")) {
            System.out.println("El origen no es un archivo de texto, idiota. ");
            System.exit(0);
        }
    }

    private boolean giveMeBoolean() {
        boolean bul;
        System.out.print("Pásate un booleano ompadre: ");
        bul = keyBoard.nextBoolean();
        keyBoard.close();
        return bul;
    }

    private void doWeirdStuff() throws IOException {
        boolean trueOrFalse;
        if (destFile.exists()) {
            File newDestFile;
            BufferedReader buffR;
            String line;
            BufferedWriter buffW;
            FileWriter fW;
            FileReader fR;

            if (destFile.isDirectory()) {
                File newFile = new File(destFile.getAbsolutePath(), orgFile.getName());
                System.out.println("El fichero sin contenido " + (newFile.createNewFile() ? "ha sido copiado" : "no ha podido ser copiado"));

                buffR = new BufferedReader(new FileReader(orgFile));
                buffW = new BufferedWriter(new FileWriter(destFile.getAbsolutePath() + "\\" + orgFile.getName()));

                while ((line = buffR.readLine()) != null) {
                    buffW.write(line);
                    buffW.newLine();
                }
                buffR.close();
                buffW.close();
                System.out.printf("Volcado de texto desde [%s] a [%s] completado", orgFile.getPath(), destFile.getAbsolutePath() + "\\" + orgFile.getName());

                //newFile.delete();
            } else {
                //lo que sea con ficheros siempre que existan, pedir el boolean
                System.out.println("Es un archivo existente");
                trueOrFalse = giveMeBoolean();
                newDestFile = new File(destFile.getAbsolutePath().replaceAll(destFile.getName(), orgFile.getName()));
                int i;
                if (trueOrFalse) {
                    System.out.println("El archivo " + (destFile.delete() ? "ha podido ser borrado para su reemplazo" : "no ha podido ser boorado"));

                    fR = new FileReader(orgFile);
                    fW = new FileWriter(newDestFile);

                    while ((i = fR.read()) != -1) {
                        fW.write(i);
                    }
                    fR.close();
                    fW.close();
                    System.out.println("Fin del reemplazo en true");

                } else {
                    System.out.println("El archivo " + (destFile.delete() ? "ha podido ser borrado para su reemplazo" : "no ha podido ser boorado"));

                    fR = new FileReader(orgFile);
                    fW = new FileWriter(newDestFile);

                    ArrayList<Character> omegaLUL = new ArrayList<>();
                    while ((i = fR.read()) != -1) {
                        omegaLUL.add((char) i);
                    }
                    fR.close();
                    System.out.println("ArrayList cargado");

                    char[] mepegountiro = new char[omegaLUL.size()];
                    for (i = 0; i < mepegountiro.length; i++) {
                        mepegountiro[i] = omegaLUL.get(i);
                    }
                    System.out.println("Búfer cargado con éxito");


                    for (i = 0; i < mepegountiro.length; i++) {
                        fW.write(mepegountiro[i]);
                    }
                    fW.close();
                    System.out.println("Fin del reemplazo en false");
                }
            }
        } else {
            //lo que sea con ficheros pero que no existen, pedir el boolean
            System.out.println("El archivo no existe");
            trueOrFalse = giveMeBoolean();
            if (trueOrFalse) {
                throw new FileNotFoundException();
            } else {
                System.out.println("La copia no se ha podido realizar.\nFin del programa");
            }
        }

//C:\Users\RickDAM\Desktop\Dirmain\Sub1
    }
}
