package Ejercicio3;

import java.util.ArrayList;
import java.util.List;

public class db_Employee {

    private static db_Employee instancia;
    private final List<Employee> listaEmpleados;
    private long ID = 1;

    private db_Employee() {
        listaEmpleados = new ArrayList<>();
    }

    public long incrementId() {
        return ID++;
    }

    public static db_Employee getInstancia() {
        if (instancia == null) {
            instancia = new db_Employee();
        }
        return instancia;
    }

    public List<Employee> getLista() {
        return listaEmpleados;
    }

}
