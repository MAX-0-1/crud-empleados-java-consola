package Ejercicio3;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeResponseDTO> obtenerLista();

    Optional<EmployeeResponseDTO> buscarEmployeePorId(Long id);

    EmployeeResponseDTO crearEmployee(EmployeeRequestDTO dto);

    EmployeeResponseDTO actualizarEmployee(Long id, EmployeeRequestDTO dto);

    void eliminarEmployee(Long id);
}
