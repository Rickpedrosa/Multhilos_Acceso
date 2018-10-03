package Multihilo.Fechas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

//Realiza un m�todo que reciba d�a, mes y a�o y devuelva una cadena con la fecha. Ejemplo:
//D�a: Martes
//Mes: Mayo
//A�o: 2012
//El m�todo devolver� 02/05/2012 ya que coge el primer martes de mayo.

public class DiaMesAny {
	
	public String conversor(String d, String m, int any) {
		DayOfWeek dia = DayOfWeek.valueOf(d);
		int day = dia.getValue();
		Month mes = Month.valueOf(m);
		Year stany = Year.of(any);
		int year = stany.getValue();
		
		if(stany.isLeap()) {
			if(mes == Month.FEBRUARY) {
				day = day - 1;
			}
		}
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/LL/yyyy");
		LocalDate l = LocalDate.of(year, mes, day);
				
		String loquetienequeser = l.format(formato);
		
		return loquetienequeser;
	}
	
	public static void main(String[] args) {
		String dia, mes;
		int any;
		Scanner teclado = new Scanner(System.in);
		System.out.print("D�a: ");
		dia = teclado.next();
		System.out.print("Mes: ");
		mes = teclado.next();
		System.out.print("A�o: ");
		any = teclado.nextInt();
		
		teclado.close();

		
		DiaMesAny lol = new DiaMesAny();
		System.out.printf(lol.conversor(dia, mes, any));
		System.out.println();
		System.out.println(Locale.getDefault());
		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
	}

}
