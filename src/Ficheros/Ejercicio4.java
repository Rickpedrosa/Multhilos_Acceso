package Ficheros;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class Ejercicio4 implements FilenameFilter {

    String dir;
    String ext;

    public Ejercicio4(){
        dir = "";
        ext = "";
    }

    public static void main(String[] args) {
        Ejercicio4 l = new Ejercicio4();
        l.fileFilt();
    }

    public void fileFilt(){
        input();
        File direct = new File(dir);
        String[] filtedContent = direct.list(this);
        for(String f : filtedContent){
            System.out.println(f);
        }
    }


    @Override
    public boolean accept(File dir, String name) {
        if(name.endsWith(".txt")){
            return true;
        } else {
            return false;
        }

    }

    private void input(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Dame un directorio: ");
        dir = teclado.nextLine();
        System.out.print("Dame una extensión del archivo: ");
        ext = teclado.nextLine();
        teclado.close();
    }


}
