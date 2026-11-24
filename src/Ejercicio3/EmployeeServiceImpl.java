package Ejercicio3;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<EmployeeResponseDTO> obtenerLista() {
        return repo.findAll().stream().map(MapperEmployee::toDto).toList();
    }

    @Override
    public Optional<EmployeeResponseDTO> buscarEmployeePorId(Long id) {
        return repo.findById(id).map(MapperEmployee::toDto);
    }

    @Override
    public EmployeeResponseDTO crearEmployee(EmployeeRequestDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Dto no puede ser null");
        }

        Employee nuevo = MapperEmployee.toEntity(dto);

        return MapperEmployee.toDto(repo.save(nuevo));
    }

    @Override
    public EmployeeResponseDTO actualizarEmployee(Long id, EmployeeRequestDTO dto) {
        if (id == null || dto == null) {
            throw new IllegalArgumentException("Datos incorrectos");
        }
        Employee existente = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("No existe usuario con ese ID"));
        existente.setUsername(dto.username());
        existente.setPassword(dto.password());
        existente.setEmail(dto.email());
        existente.setSalary(dto.salary());

        return MapperEmployee.toDto(repo.save(existente));
    }

    @Override
    public void eliminarEmployee(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id no puede ser nulo para eliminar");
        }
        repo.deleteById(id);
    }

}
