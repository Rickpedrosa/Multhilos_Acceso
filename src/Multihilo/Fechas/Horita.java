package Multihilo.Fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Realiza un programa que muestre la fecha del sistema de la siguiente manera:
//Hoy es s�bado 12-marzo-2011 a las 10:22:13

public class Horita {

	public static void main(String[] args) {
	Horita h = new Horita();
	h.horaDelSistema();
	}

	public void horaDelSistema() {
		LocalDateTime hora = LocalDateTime.now();
		LocalDate hoy = LocalDate.now();
		
		DateTimeFormatter hoyformat = DateTimeFormatter.ofPattern("EEEE dd-MM-yyyy");
		DateTimeFormatter horaformat = DateTimeFormatter.ofPattern("hh:mm:ss");
		System.out.println("Hoy es " + hoy.format(hoyformat) + " a las " + hora.format(horaformat));
	}

}
