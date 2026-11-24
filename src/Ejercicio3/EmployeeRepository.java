package Ejercicio3;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    Employee save(Employee entity);

    void deleteById(Long id);
    
    boolean existById(Long id);
}
