package libreria.libreriafinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Autenticacion {
    private  Scanner scanner;
    private  List<usuario> usuarios;

    public List<usuario> getuUsuarios() {
        // devolucion de la lista de usuarios
        return usuarios;
    }

    public Autenticacion() {
        //creamos una lista de usuarios, se inicializa
        usuarios = new ArrayList<>();
        scanner = new Scanner(System.in);

        //se carga la lista de usuarios precargados
        //podria moverse asuarios

        usuarios.add(new usuario("Francisco", "Gonzalez", 46177410, "1234", false, "admin"));

        usuarios.add(new usuario("Ana", "Martinez", 46258410, "anita123", true, "user"));
        usuarios.add(new usuario("Carlos", "Pérez", 46102347, "carlospz", true, "user"));
        usuarios.add(new usuario("Laura", "Fernandez", 46309876, "laufer", true, "user"));

        usuarios.add(new usuario("Miguel", "Rodriguez", 46451234, "miguelr", false, "admin"));

        usuarios.add(new usuario("Sofía", "Gómez", 46578329, "sofigomez", true, "user"));
        usuarios.add(new usuario("Pedro", "Alvarez", 46600987, "pedrito", true, "user"));
        usuarios.add(new usuario("Lucía", "Lopez", 46711920, "lucialopez", true, "user"));

        usuarios.add(new usuario("Andrés", "Ruiz", 46822345, "andresr", false, "admin"));

        usuarios.add(new usuario("Mariana", "Ramirez", 46933456, "marianar", true, "user"));

    }

    //metodo para mostrar todos los usuarios
    public void MostrarUsuarios() {
        //si la lista de usuarios esta vacia
        if (usuarios.isEmpty()) {
            //se tira error
            System.out.println("No hay libros disponibles.");
        } else {
            //si no, se recorre la lista de usuarios 
            for (usuario usuario : usuarios) {
                //se imprmen los usuarios
                System.out.println(usuario);
            }
        }
    }

    //metodo con el menu de autenticacion
    public void showAuth() {

        int opcion3 = 0;
        while (opcion3 != 2) {
            System.out.println("---- MENÚ PRINCIPAL Autenticacion ----");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Crear Cuenta");
            System.out.println("3. Salir del programa");
            System.out.print("Seleccione una opcion: ");

            //no se esta tomando un valor strng si no int
            opcion3 = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion3) {

                case 1:
                    // iniciar sesion
                    iniciarSesion();
                    break;
                case 2:
                    crearCuenta();
                    // crear cuenta
                    break;
                case 3:
                    // salir del programa
                    System.out.println("Saliendo del programa");
                    System.exit(0); //comando para salir del programa
                    break;

                default:
                    break;
            }

        }

    }

    public boolean eliminarUsuario(int documento) {
        for (usuario usuario : usuarios) {
            if (usuario.getDocumento() == documento) {
                if (usuario.getRol().equalsIgnoreCase("admin")) {
                    System.out.println("No se puede eliminar un usuario con rol de administrador.");
                    return false;
                }
                usuarios.remove(usuario);
                System.out.println("Usuario eliminado correctamente.");
                return true; // Indica que el usuario fue eliminado
            }
        }
        System.out.println("No se encontró el usuario con el documento proporcionado.");
        return false; // Indica que el usuario no fue encontrado
    }
    
    

    public void editarUsuario() {
        System.out.print("Ingrese el documento del usuario a editar: ");
        int documento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
    
        for (usuario usuario : usuarios) {
            if (usuario.getDocumento() == documento) {
                System.out.println("Usuario encontrado: " + usuario);
    
                System.out.print("Ingrese el nuevo nombre (presione Enter para mantener el actual): ");
                String nuevoNombre = scanner.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    usuario.setNombre(nuevoNombre);
                }
    
                System.out.print("Ingrese el nuevo apellido (presione Enter para mantener el actual): ");
                String nuevoApellido = scanner.nextLine();
                if (!nuevoApellido.isEmpty()) {
                    usuario.setApellido(nuevoApellido);
                }
    
                System.out.print("Ingrese la nueva contraseña (presione Enter para mantener la actual): ");
                String nuevaClave = scanner.nextLine();
                if (!nuevaClave.isEmpty()) {
                    usuario.setClave(nuevaClave);
                }
    
                System.out.println("Usuario editado correctamente: " + usuario);
                return;
            }
        }
        System.out.println("No se encontró el usuario con el documento proporcionado.");
    }
    

    public void buscarUsuario() {
        System.out.print("Ingrese el documento del usuario a buscar: ");
        int documento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
    
        for (usuario usuario : usuarios) {
            if (usuario.getDocumento() == documento) {
                System.out.println("Usuario encontrado: " + usuario);
                return;
            }
        }
        System.out.println("No se encontró el usuario con el documento proporcionado.");
    }
    

    public void crearCuenta() {
        System.out.println("Ingrese su nombre");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su apellido");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese su clave");
        String clave = scanner.nextLine();
        System.out.println("Ingrese su documento");
        int documento = scanner.nextInt();
        usuarios.add(new usuario(nombre, apellido, documento, clave, false, "usuario"));
        showAuth();
    }

    public void iniciarSesion() {
        System.out.println("Ingrese su documento (DNI): ");
        int documento = 0;
        boolean isAdmin = false; // Variable para verificar si el usuario es admin

        try {
            documento = Integer.parseInt(scanner.nextLine()); // Convertir el valor ingresado a int
        } catch (NumberFormatException e) {
            System.out.println("Documento inválido. Por favor, ingrese un número válido.");
            return; // Salir de la función si el documento no es válido
        }

        System.out.println("Ingrese su contraseña: ");
        String contraseña = scanner.nextLine();

        boolean usuarioEncontrado = false;
        for (usuario usuario : usuarios) {
            if (documento == usuario.getDocumento() && contraseña.equals(usuario.getClave())) {
                System.out.println(" Bienvenido " + usuario.getRol() + " " + usuario.getNombre());
                usuarioEncontrado = true;
                if (usuario.getRol() == "admin") {
                    isAdmin = usuario.getRol().equals("admin");
                    menu menu = new menu();
                    menu.showMenu(true, usuario.getNombre());
                } else {
                    menu menu = new menu();
                    menu.showMenu(false, usuario.getNombre());
                }
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("Documento o contraseña incorrectos.");
        }
    }

}
