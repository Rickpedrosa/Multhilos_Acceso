package Multihilo.Fechas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Prueba {

	public static void main(String[] args) {
		String fechaInicial = "1906-12-31";
		LocalDate fechaTomada = LocalDate.parse(fechaInicial);
		System.out.printf("Fecha: %s%n",fechaTomada);
		String fechaInicialHora = "1906-12-31T12:05";
		LocalDateTime fechaHoraTomada = LocalDateTime.parse(fechaInicialHora);
		System.out.printf("Fecha/Hora: %s%n",fechaHoraTomada);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MM yyyy");
		System.out.printf("%s con nuevo formato: %s",fechaTomada,df.format(fechaTomada));

	}

}
