package Ejercicio3;

import java.util.List;

public class ExcepcionesAcumuladas extends AppExcepciones {

    private final List<String> errores;

    public ExcepcionesAcumuladas(List<String> errores, String nombreCapa) {
        super("Tienes " + errores.size() + " errores de validacion en la capa " + nombreCapa);
        this.errores = errores;
    }

    public List<String> getErrores() {
        return errores;
    }
}
