package utils;

public class Validaciones {
    public static boolean validarDni(String dni) {
        return dni.matches("\\d{8}");
    }

}
