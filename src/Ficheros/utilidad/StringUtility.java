package Ficheros.utilidad;

public class StringUtility {
    private StringUtility() {
    }

    public static String repeat(int n, String string) {
        StringBuilder builder = new StringBuilder(string);
        for (int i = 0; i < n; i++) {
            builder.append(string);
        }
        return builder.toString();
    }
}
