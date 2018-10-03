package Multihilo.Fechas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Realiza una clase ConversorFechas que tenga los siguientes m�todos. Haz un programa para
//probarlo:
//- String normalToAmericano(String): este m�todo convierte una fecha en formato
//normal d�a/mes/a�o a formato americano mes/d�a/a�o.
//- String americanoToNormal(String): este m�todo realiza el paso contrario, convierte
//fechas en formato americano a formato normal.

public class ConversorFechas {

	public String normalToAmericano(String fetxa) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate l = LocalDate.parse(fetxa, df);
		DateTimeFormatter drDisrespect = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String xd = l.format(drDisrespect);
		return xd;
	}	
	
	public String americanoToNormal(String fetxa) {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		LocalDate l = LocalDate.parse(fetxa, df);
	 	DateTimeFormatter dff = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String xd = l.format(dff);
		return xd;
	}	
	
	public static void main(String[] args) {
		ConversorFechas lol = new ConversorFechas();
		String fetxaEU = "19-04-2018";
		String fetxaNA = "04-19-2018";
		System.out.println(lol.normalToAmericano(fetxaEU));
		System.out.println(lol.americanoToNormal(fetxaNA));
	}

}