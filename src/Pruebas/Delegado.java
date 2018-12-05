package Pruebas;

public class Delegado {

    public static void main(String[] args) {
        String[] miGente = new String[11];
        miGente[0] = "Rick";
        miGente[1] = "Lolo";
        miGente[2] = "Pablo";
        miGente[3] = "María";
        miGente[4] = "Ismael";
        miGente[5] = "Yeray";
        miGente[6] = "Alex_gafitas";
        miGente[7] = "Alex_noGafitas";
        miGente[8] = "Rubén";
        miGente[9] = "Lily";
        miGente[10] = "Nicolás";
        //System.out.printf("Nuevo delegado de 2ºDAM curso 2018/19 es %s", elegirDelegado(miGente));
        String x = "******************************************************************************";
        System.out.println(x.length());
    }

    private static String elegirDelegado(String[] alumno) {
        int random = (int) (Math.random() * 10);
        return alumno[random];
    }

}
