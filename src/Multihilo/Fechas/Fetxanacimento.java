package Multihilo.Fechas;

import java.time.LocalDate;

//Realiza un m�todo que reciba una fecha de nacimiento y devuelva la edad.

public class Fetxanacimento {

	public int tuEdad(LocalDate born) {
		LocalDate hoy = LocalDate.now();
		int anyhoy = hoy.getYear();
		int anyborn = born.getYear();
		
		int edad = anyhoy - anyborn;
		
		if(hoy.getMonth() != born.getMonth() && hoy.getDayOfMonth() != born.getDayOfMonth()) {
			edad = edad - 1;
		}
		
		return edad;
	}
	
	public static void main(String[] args) {
		Fetxanacimento l = new Fetxanacimento();
		LocalDate nacimiento = LocalDate.of(1985, 7, 12); // a�o, mes, d�a
		System.out.println(l.tuEdad(nacimiento));
	}

}
