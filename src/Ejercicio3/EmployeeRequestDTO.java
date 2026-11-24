package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public record EmployeeRequestDTO(String username, String password, String email, Double salary) {

    public List<String> validar() {
        List<String> errores = new ArrayList<>();
        if (username == null || username.isBlank()) {
            errores.add("Ingrese un username valido");
        }

        if (password == null || password.isBlank() || password.length() < 8) {
            errores.add("La contraseña debe tener minimo 8 caracteres");
        }

        if (email == null || email.isBlank() || !email.contains("@")) {
            errores.add("Ingresa un correo valido");
        }

        if (salary != null && salary < 0) {
            errores.add("Ingresa un salario valido");
        }
        return errores;
    }

}

    /*
    public EmployeeRequestDTO {

        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Ingrese un username valido");
        }

        if (password == null || password.isBlank() || password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener minimo 8 caracteres");
        }

        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("Ingresa un correo valido");
        }

        if (salary != null && salary < 0) {
            throw new IllegalArgumentException("Ingresa un salario valido");
        }
    }
     */
 /*
    EmployeeRequestDTO: Se usa para crear/actualizar.

Campos: username, password, email, salary.

Validaciones requeridas dentro del record:

El username no puede ser nulo ni estar vacío.

La password debe tener al menos 8 personajes.

El salary debe ser mayor que 0.
     */