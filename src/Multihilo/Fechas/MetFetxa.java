package Multihilo.Fechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

//Escribir un m�todo que reciba una fecha y devuelva el d�a de la semana que corresponde
//para esta fecha.

public class MetFetxa {
	
	public DayOfWeek diaSemana(LocalDate semana) {
		DayOfWeek dia = semana.getDayOfWeek();
		semana.getDayOfMonth();
		return dia;
	}

	public static void main(String[] args) {
	Locale l = new Locale("es");
	MetFetxa lol = new MetFetxa();
	LocalDate date = LocalDate.now();
	System.out.printf("TextStyle.FULL:%s%n",lol.diaSemana(date).getDisplayName(TextStyle.FULL,l));
	}

}

