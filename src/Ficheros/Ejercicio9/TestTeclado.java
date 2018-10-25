package src.Ficheros.Ejercicio9;

import java.util.Scanner;

public class TestTeclado {
    private Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        TestTeclado t = new TestTeclado();
        t.teclado();
    }

    private void teclado() {
        System.out.print("menu");
        teclado.nextInt();
        System.out.println();
        System.out.print("id");
        teclado.nextInt();
        System.out.println();
        System.out.print("menu");
        teclado.nextInt();
        System.out.println();
        System.out.print("id");
        teclado.nextInt();
        System.out.println();
        System.out.print("float");
        teclado.nextFloat();
        System.out.println();
        System.out.print("menu");
        teclado.nextInt();
        System.out.println();
        System.out.print("id");
        teclado.nextInt();
        System.out.println();
    }
}
