package Ejercicio3;

public class MapperEmployee {

    public static Employee toEntity(EmployeeRequestDTO dto) {
        Employee entidad = new Employee();
        entidad.setUsername(dto.username());
        entidad.setPassword(dto.password());
        entidad.setEmail(dto.email());
        entidad.setSalary(dto.salary());
        return entidad;
    }

    public static EmployeeResponseDTO toDto(Employee entity) {
        return new EmployeeResponseDTO(entity.getId(), entity.getUsername(), entity.getEmail());
    }
}
