package Ejercicio3;

public class AppExcepciones extends RuntimeException {

    public AppExcepciones(String mensaje) {
        super(mensaje != null ? mensaje : "Error desconocido");
    }
}