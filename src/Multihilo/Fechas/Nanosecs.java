package Multihilo.Fechas;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

//Realiza un m�todo que reciba una hora especificando hora, minutos y segundos y devuelva
//los nanosegundos. Para el c�lculo de los nanosegundos no se pueden usar m�todos de java.
//Hacer un programa con este m�todo y probar que da el mismo resultado que con m�todos de
//java.

public class Nanosecs {

	public long nano(LocalDateTime date) {
		int sechora = date.getHour() * 3600;
		int secmin = date.getMinute() * 60;
		int sec = date.getSecond();
		int sum = sechora + secmin + sec;
		
		long nanete = (long) (sum * 1000000000L);
		return nanete;
	}
	
	public static void main(String[] args) {
		Nanosecs lol = new Nanosecs();
		LocalDateTime omega = LocalDateTime.now();
		System.out.println(omega.getLong(ChronoField.NANO_OF_DAY) + " Sistema");
		System.out.println(lol.nano(omega) + " Metodo");
	}

}
