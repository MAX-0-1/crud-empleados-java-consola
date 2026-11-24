package Ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        db_Employee db = db_Employee.getInstancia();
        EmployeeRepository repo = new EmployeeRepositoryImpl(db);
        EmployeeService service = new EmployeeServiceImpl(repo);
        Controller controller = new Controller(service);

        Scanner teclado = new Scanner(System.in);

        String mensaje = """
                        ************************
                        1. LISTAR USUARIOS
                        2. CREAR USUARIO
                        3. ACTUALIZAR USUARIO
                        4. ELIMINAR USUARIO
                        5. SALIR
                        ************************
                        """;
        int opcion = 0;
        List<String> errores = new ArrayList();
        do {
            while (true) {
                System.out.println(mensaje);
                String numero = teclado.nextLine();
                try {
                    opcion = ParametroParser.aInt(numero, "Opcion", errores);
                    System.out.println("Opcion correcta Elegida " + opcion);
                    break;
                } catch (Exception e) {
                    ErrorHandler.mostrarError(e);
                }
            }

            switch (opcion) {
                case 1 -> {
                    if (controller.listarUsuarios().isEmpty()) {
                        System.out.println("No hay Usuarios Registrados");
                    } else {
                        for (EmployeeResponseDTO listarUsuario : controller.listarUsuarios()) {
                            System.out.println(listarUsuario + "\n");
                        }
                    }
                }
                case 2 -> {
                    boolean exito = false;
                    while (!exito) {
                        System.out.print("Ingrese un nombre: ");
                        String nombre = teclado.nextLine();
                        System.out.print("Ingrese un password: ");
                        String password = teclado.nextLine();
                        System.out.print("Ingrese un email valido con @: ");
                        String email = teclado.nextLine();
                        System.out.print("Ingrese un salario valido: ");
                        String salario = teclado.nextLine();
                        try {
                            EmployeeResponseDTO user = controller.crearUsuario(nombre, password, email, salario);
                            String userNuevo = """
                                         %nUSUARIO CREADO
                                         ID: %d
                                         USUARIO: %s
                                         EMAIL: %s
                                         """.formatted(user.id(), user.username(), user.email());
                            System.out.println(userNuevo);
                            exito = true;
                        } catch (Exception e) {
                            ErrorHandler.mostrarError(e);
                            exito = !(e instanceof ExcepcionesAcumuladas);
                        }

                    }
                }
                case 3 -> {
                    boolean exito = false;
                    while (!exito) {
                        System.out.print("Ingrese el ID del usuario a actualizar: ");
                        String id = teclado.nextLine();
                        System.out.print("Ingrese nuevo nombre: ");
                        String username = teclado.nextLine();
                        System.out.print("Ingrese nuevo password: ");
                        String password = teclado.nextLine();
                        System.out.print("Ingrese nuevo email: ");
                        String email = teclado.nextLine();
                        System.out.print("Ingrese nuevo salario: ");
                        String salario = teclado.nextLine();
                        try {
                            EmployeeResponseDTO actualizado = controller.actualizarCompletoUsuario(id, username, password, email, salario);
                            //RESPONSEDTO Long id, String username, String email
                            String datosActualizados = """
                                                      NUEVOS DATOS ACTUALIZADOS DEL USER CON ID %d:
                                                      USUARIO: %s
                                                      EMAIL: %S
                                                      """.formatted(actualizado.id(), actualizado.username(), actualizado.email());
                            System.out.println(datosActualizados);
                            exito = true;
                        } catch (Exception e) {
                            ErrorHandler.mostrarError(e);
                            exito = !(e instanceof ExcepcionesAcumuladas);
                        }
                    }

                }
                case 4 -> {
                    boolean exito = false;
                    while (!exito) {
                        System.out.print("Ingrese ID del USUARIO a eliminar: ");
                        String idEliminar = teclado.nextLine();
                        try {
                            controller.EliminarUsuario(idEliminar);
                            System.out.println("Eliminacion Exitosa");
                            exito = true;
                        } catch (Exception e) {
                            ErrorHandler.mostrarError(e);
                            exito = !(e instanceof ExcepcionesAcumuladas);
                        }
                    }
                }
                case 5 -> {
                    System.out.println("adios");
                }
                default -> {
                    System.out.println("no existe la opcion " + opcion);
                }
            }

        } while (opcion != 5);
    }
}
