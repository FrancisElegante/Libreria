/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreriafinal;

import java.util.Scanner;

/**
 *
 * @author Asus
 */

//Creamos una clase menu donde estaran nuestros menus y la conexion con crudlibreria mediante invocacion de metodos

public class menu {
    // importamos el package scanner para interactuar con el usuario
    private static Scanner scanner = new Scanner(System.in);

    // inicializamos la clase crudlibreria en menu para utilizar sus metodos
    private static crudlibreria biblioteca = new crudlibreria();
    private static Autenticacion auth = new Autenticacion();
    // crudlibreria como la clase, y new como instancia. Luego biblioteca como
    // nombre local de la clase

    public menu() {
        scanner = new Scanner(System.in);
    }

    //Pasamos como parametro un valor boleano y el nombre del usuario
    //Con el boleano definimos que se podra ver del menu

    public void showMenu(boolean isAdmin, String usuario) {
        int option = 0; // declaramos una variable tipo int para almacenar el ingreso del usuario
        while (option != 6) { // 6 será la opción para salir del programa
            // asegurarse que sea igual al numero de opciones o finalizara

            //Imprimimos las opciones
            System.out.println("---- MENÚ PRINCIPAL ----");
            System.out.println("1. Retirar libro");
            System.out.println("2. Buscar libro");
            System.out.println("3. Ver todos los libros");
            System.out.println("4. Reingresar libro");

            //si admin es true podra ver panel admin, si no, no podra.

            if (isAdmin) {
                System.out.println("5. Panel Admin");
            }

            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            //Guardamos el valor ingresado por el usuario 
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiamos el buffer para evitar problemas con el bucle y el switch

            // utilizamos switch como bucle para que el usuario realice varias acciones
            switch (option) {
                // Generamos los cases y designamos sus clases
                case 1 -> {
                    retirarLibro();
                    break;
                }
                case 2 -> {
                    buscarLibro();
                    break;
                }
                case 3 -> {
                    verTodosLosLibros();
                    break;
                }
                case 4 -> {
                    agregarLibro();
                    break;
                }
                case 5 -> {
                    //si es admin al seleccionar el case 5 se mostrara un mensaje de bienvenido
                    //tambien podra acceder al panel de admin
                    if (isAdmin) {
                        System.out.println("Bienvenido " + usuario);
                        panelAdmin();
                    }
                }
                case 6 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }


    //Funcion para invocar el metodo ingresar libro
    private void agregarLibro() {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        //le enviamos al metodo el titulo y autor que se agregara
        biblioteca.ingresarLibro(titulo, autor);
    }

    //Funcion para invocar el metodo retirar libro
    private static void retirarLibro() {
        System.out.print("Ingrese el título del libro a retirar: ");
        String titulo = scanner.nextLine();
        //pasamos como parametro el titulo que sera retirado
        biblioteca.retirarLibro(titulo);
    }

    //funcion para invocar metodo buscarlibro
    private static void buscarLibro() {
        System.out.print("Ingrese el título o autor del libro a buscar: ");
        String busqueda = scanner.nextLine();
        //pasamos como parametro la busqueda del usuario, que sera el titulo o autor
        biblioteca.buscarLibro(busqueda);
    }

    //funcion para invocar metodo de ver todos los libros
    private void verTodosLosLibros() {
        System.out.println("Cargando todos los libros...");
        //invocamos el metodo mostrar libro
        biblioteca.mostrarLibros();
    }

    //funcion para invocar metodo de editar libro
    private static void editarLibro() {
        System.out.print("Ingrese el título del libro a editar: ");
        String titulo = scanner.nextLine();
        //si no se encuentra el libro se envia error, si no se sigue
        if (!biblioteca.editarLibro(titulo)) {
            System.out.println("No se encontró el libro.");
        }
    }

    //funcion para invocar el metodo eliminar libro
    private static void eliminarLibro() {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String titulo = scanner.nextLine();
        //pasamos como parametro el titulo que se desea eliminar
        //si no se encuentra se da error
        if (!biblioteca.eliminarLibro(titulo)) {
            System.out.println("No se encontró el libro.");
        }
    }

    private static void eliminarUsuario() {
        System.out.print("Ingrese el documento del usuario a eliminar: ");
        int documento = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        
        // Llama al método eliminarUsuario de la clase Autenticacion
        if (!auth.eliminarUsuario(documento)) {
            System.out.println("No se encontró el usuario.");
        }
    }
    
    private static void buscarUsuario() {
        auth.buscarUsuario();
    }

    private static void editarUsuario() {
        auth.editarUsuario();
    }
    

    //segundo menu visible por el admin
    //se trabaja con autenticacion y crudlibreria
    public static void panelAdmin() {
        int option2 = 0;

        while (option2 != 8) {
            System.out.println("---- MENÚ PRINCIPAL ADMIN ----");
            System.out.println("1. Ver todos los usuarios");
            System.out.println("2. Buscar usuarios");
            System.out.println("3. Editar usuarios");
            System.out.println("4. Eliminar usuarios");
            System.out.println("5. Agregar un nuevo libro");
            System.out.println("6. Editar un libro");
            System.out.println("7. Eliminar un libro");
            System.out.println("8. Salir al menú normal");
            System.out.print("Seleccione una opción: ");

            option2 = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option2) {
                case 1:
                    System.out.println("Cargando todos los usuarios...");
                    auth.MostrarUsuarios();
                    break;
                case 2:
                    System.out.println("Cargando busqueda de usuarios...");
                    buscarUsuario();
                    break;
                case 3:
                    System.out.println("Cargando edicion de usuarios");
                    editarUsuario();
                    break;
                case 4:
                    System.out.println("Cargando anulacion de usuarios...");
                    eliminarUsuario();
                    break;
                case 5:
                    System.out.println("Añadir Libro");
                    new menu().agregarLibro(); // Llamar a la función agregarlibro
                    break;
                case 6:
                    System.out.println("Editar Libro");
                    new menu().editarLibro(); // Llamar a la función editarLibro
                    break;
                case 7:
                    System.out.println("Eliminar Libro");
                    new menu().eliminarLibro(); // Llamar a la función eliminarLibro
                    break;
                case 8:
                    System.out.println("Saliendo al menú normal...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

}