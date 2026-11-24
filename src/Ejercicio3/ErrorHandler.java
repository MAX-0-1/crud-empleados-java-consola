package Ejercicio3;

public class ErrorHandler {

    public static void mostrarError(Exception e) {
        if (e instanceof AppExcepciones appEx) {
            mostrarError(appEx);
        } else {
            System.out.println("Error inesperado: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }

    public static void mostrarError(AppExcepciones e) {
        if (e instanceof ExcepcionesAcumuladas excepcionesAcumuladas) {
            System.out.println(e.getMessage());
            excepcionesAcumuladas.getErrores().forEach(err -> System.out.println("- " + err));
        } else if (e instanceof RecursoNoEncontrado) {
            System.out.println("Error en repository: " + e.getMessage());
        } else {
            System.out.println("Error General " + e.getMessage());
        }
    }
}
