package Ejercicio3;

import java.util.List;

public class ParametroParser {

    public static Long aLong(String numero, String nombre, List<String> errores) {
        try {
            return Long.valueOf(numero);
        } catch (NumberFormatException e) {
            errores.add("No se puede convertir a Long el ATRIBUTO " + nombre);
            return null;
        }
    }

    public static Double aDouble(String numero, String nombre, List<String> errores) {
        try {
            return Double.valueOf(numero);
        } catch (NumberFormatException e) {
            errores.add("No se puede convertir a Double el ATRIBUTO " + nombre);
            return null;
        }
    }

    public static int aInt(String numero, String nombre, List<String> errores) {
        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            errores.add("No se puede convertir a Int el Atributo " + nombre);
            return 0;
        }
    }

}
/*
public class ParametroParser {
    // Versión OBLIGATORIA: si viene null o vacío, ya es un error
    public static Double aDoubleObligatorio(String valor, String campo, List<String> errores) {
        if (valor == null || valor.isBlank()) {
            errores.add("El campo '" + campo + "' es obligatorio");
            return null;
        }
        try {
            return Double.valueOf(valor);
        } catch (NumberFormatException e) {
            errores.add("El campo '" + campo + "' debe ser un decimal válido");
            return null;
        }
    }

    // Versión OPCIONAL: si viene null, está bien, simplemente no se agrega error
    public static Double aDoubleOpcional(String valor, String campo, List<String> errores) {
        if (valor == null || valor.isBlank()) {
            return null; // no es error, es opcional
        }
        try {
            return Double.valueOf(valor);
        } catch (NumberFormatException e) {
            errores.add("El campo '" + campo + "' debe ser un decimal válido");
            return null;
        }
    }
}
 */

/*
conversion WRAPPER VS PRIMITIVOS
// Con Wrapper (Long, Double, Integer...)
Long.valueOf("123")      // devuelve Long
Double.valueOf("12.5")   // devuelve Double

// Con Primitivo (long, double, int...)
Long.parseLong("123")    // devuelve long
Double.parseDouble("12.5") // devuelve double
*/
