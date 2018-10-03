package Multihilo.Fechas;

import java.util.Scanner;

//Realiza un m�todo que decodifique fechas del siglo XXI. El dato es un entero comprendido
//entre 10100 y 311299. El resultado es una secuencia de caracteres: n�mero del d�a dentro
//del mes, del mes dentro del a�o y del a�o dentro del siglo. Por ejemplo, para el dato 30485,
//el resultado es el texto 3-4-2085.

public class SigloXXI {

	int fetxa;
	Scanner teclado;

	public SigloXXI() {
		teclado = new Scanner(System.in);
		fetxa = 0;
	}

	// public void transf() {
	// int mes;
	// int restomes;
	// int restodia;
	// int dia;
	// int any;
	//
	// System.out.println("Introduce tu fecha codificada: ");
	// fetxa = teclado.nextInt();
	// while (fetxa < 10100 || fetxa > 311299) {
	// System.out.println("Introduce tu fecha codificada: ");
	// fetxa = teclado.nextInt();
	// }
	// dia = fetxa / 10000;
	// restodia = fetxa % 10000;
	//
	// mes = restodia / 100;
	// restomes = restodia % 100;
	//
	// any = restomes + 2000;
	//
	// System.out.println(dia + "-" + mes + "-" + any);
	//
	// teclado.close();
	// }

	public String transfer(int f) {
		int mes;
		int restomes;
		int restodia;
		int dia;
		int any;

		if (f < 10100 || f > 311299) {
			return "Usted es tonto";
		} else {
			dia = f / 10000;
			restodia = f % 10000;

			mes = restodia / 100;
			restomes = restodia % 100;

			any = restomes + 2000;

			String fetxatransf = String.valueOf(dia) + "-" + String.valueOf(mes) + "-" + String.valueOf(any);

			return fetxatransf;
		}

	}

	public static void main(String[] args) {
		SigloXXI n = new SigloXXI();
		// n.transf();
		System.out.println(n.transfer(311299));
	}

}
