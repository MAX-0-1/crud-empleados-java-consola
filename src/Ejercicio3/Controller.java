package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private final EmployeeService service;

    public Controller(EmployeeService service) {
        this.service = service;
    }

    public List<EmployeeResponseDTO> listarUsuarios() {
        return service.obtenerLista();
    }

    public EmployeeResponseDTO crearUsuario(String username, String password, String email, String salary) {
        List<String> errores = new ArrayList<>();
        Double salaryvalido = ParametroParser.aDouble(salary, "Salary", errores);
        if (!errores.isEmpty()) {
            throw new ExcepcionesAcumuladas(errores, "Parsear");
        }

        EmployeeRequestDTO dto = new EmployeeRequestDTO(username, password, email, salaryvalido);
        errores.addAll(dto.validar());

        if (!errores.isEmpty()) {
            throw new ExcepcionesAcumuladas(errores, "DTO");
        }
        return service.crearEmployee(dto);
    }

    public EmployeeResponseDTO actualizarCompletoUsuario(String id, String username, String password, String email, String salary) {
        List<String> errores = new ArrayList<>();
        Long idValido = ParametroParser.aLong(id, "Id", errores);
        Double salaryValido = ParametroParser.aDouble(salary, "salario", errores);

        if (!errores.isEmpty()) {
            throw new ExcepcionesAcumuladas(errores, "PARSEO");
        }

        EmployeeRequestDTO dto = new EmployeeRequestDTO(username, password, email, salaryValido);
        errores.addAll(dto.validar());
        if (!errores.isEmpty()) {
            throw new ExcepcionesAcumuladas(errores, "DTO");
        }
        return service.actualizarEmployee(idValido, dto);
    }

    public void EliminarUsuario(String id) {
        List<String> errores = new ArrayList<>();
        Long idvalido = ParametroParser.aLong(id, "id", errores);
        if (!errores.isEmpty()) {
            throw new ExcepcionesAcumuladas(errores, "PARSEO");
        }

        service.eliminarEmployee(idvalido);
    }

}
