package Multihilo.Fechas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Realiza un m�todo que reciba un mes y un d�a correspondiente a este a�o y devuelva el
//n�mero de d�as que han pasado desde el 1 de Enero de este a�o hasta dicho d�a.

public class NumeroDias {

	public long Dias(LocalDate dia) {
		if (dia.getYear() != 2018) {
			System.out.println("Any incorrecto");
			return 0;
		} else {
			LocalDate date = LocalDate.of(2018, 1, 1);
			return ChronoUnit.DAYS.between(date, dia);
		}

	}

	public static void main(String[] args) {
		NumeroDias lol = new NumeroDias();
		LocalDate hoy = LocalDate.of(2018, 2, 28);
		System.out.println(lol.Dias(hoy));
	}

}
