package Ejercicio3;

import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final db_Employee db;

    public EmployeeRepositoryImpl(db_Employee db) {
        this.db = db;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        if (id == null) {
            throw new NullPointerException("Id a buscar no puede ser nulo");
        }
        return db.getLista().stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public List<Employee> findAll() {
        return List.copyOf(db.getLista());
    }

    @Override
    public Employee save(Employee entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entidad no puede ser nulo");
        }
        if (entity.getId() == null) {
            entity.setId(db.incrementId());
            db.getLista().add(entity);
            return entity;
        }
        for (int i = 0; i < db.getLista().size(); i++) {
            if (db.getLista().get(i).getId().equals(entity.getId())) {
                db.getLista().set(i, entity);
                return entity;
            }
        }
        throw new IllegalArgumentException("Entidad con ID no valido");
    }

    @Override
    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id a eliminar no puede ser nulo");
        }

        if (!existById(id)) {
            throw new RecursoNoEncontrado("Id a eliminar no existe");
        }

        db.getLista().removeIf(user -> user.getId().equals(id));
    }

    @Override
    public boolean existById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID para verificar existencia no puede ser nulo");
        }
        boolean valor = false;
        for (int i = 0; i < db.getLista().size(); i++) {
            if (db.getLista().get(i).getId().equals(id)) {
                valor = true;
                return valor;
            }
        }
        return valor;
    }

}
