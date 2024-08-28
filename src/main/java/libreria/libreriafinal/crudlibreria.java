/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreriafinal;

/**
 *
 * @author Asus
 */

//imports de liberias!

//importamos listas de arreglos
//importamos listas
//importamos scanner para registrar inputs de teclado
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class crudlibreria {
    private final Scanner scanner;

    // creamos una lista de objetos tipo libro
    private final List<libro> libros;

    // iniciamos como atributo la clase retirarlibro
    private RetirarLibro retirarLibro;

    // iniciamos como atributo la clase buscarlibro
    private BuscarLibro buscarLibro;

    // iniciamos como atributo la clase mostrarlibros
    private MostrarLibros mostrarLibros;

    // iniciamos como atributo la clase ingresar libro
    private IngresarLibro ingresarLibro;

    // obtenemos la lista de libros con el metodo get libros en la interfaz de
    // libros
    // Ahora se puede acceder a los libros fuera de crudlibreria donde esta definido
    // se retorna la lista como libros
    public List<libro> getLibros() {
        // devolucion de la lista de libros almacenada en libros
        return libros;
    }

    // inicializamos el constructor
    // constructor, funcion que se inicializa de forma automatica al correr el
    // codigo
    public crudlibreria() {
        // iniciamos lista de java
        // iniciamos scanner
        libros = new ArrayList<>();
        scanner = new Scanner(System.in);

        // inicializacion de clases a utilizar, luego las invocaremos
        // al tener los mismos nombres se presta a confusion, podrian ser distintos

        // creamos una instancia de retirarlibro
        retirarLibro = new RetirarLibro();

        // creamos una instancia de buscar libro
        buscarLibro = new BuscarLibro();

        // creamos una instancia de mostrar libro
        mostrarLibros = new MostrarLibros();

        // creamos una instancia de ingresar libro
        ingresarLibro = new IngresarLibro();

        // Libros precargados, se agregan apenas se inice el codigo, por eso van en el
        // constructor
        // se deberian cargar en la interfaz de libro y no en el crud
        libros.add(new libro("El Quijote", "Miguel de Cervantes"));
        libros.add(new libro("Cien Años de Soledad", "Gabriel García Márquez"));
        libros.add(new libro("1984", "George Orwell"));
        libros.add(new libro("La Odisea", "Homero"));
        libros.add(new libro("Orgullo y Prejuicio", "Jane Austen"));
        libros.add(new libro("Matar a un ruiseñor", "Harper Lee"));
        libros.add(new libro("Crimen y Castigo", "Fiódor Dostoyevski"));
        libros.add(new libro("El Gran Gatsby", "F. Scott Fitzgerald"));
        libros.add(new libro("Don Juan Tenorio", "José Zorrilla"));
        libros.add(new libro("La Metamorfosis", "Franz Kafka"));
        libros.add(new libro("El Principito", "Antoine de Saint-Exupéry"));
        libros.add(new libro("Ulises", "James Joyce"));
        libros.add(new libro("El Guardián entre el Centeno", "J.D. Salinger"));
        libros.add(new libro("En Busca del Tiempo Perdido", "Marcel Proust"));
        libros.add(new libro("Los Miserables", "Victor Hugo"));
        libros.add(new libro("La Divina Comedia", "Dante Alighieri"));
        libros.add(new libro("Guerra y Paz", "León Tolstói"));
        libros.add(new libro("Cumbres Borrascosas", "Emily Brontë"));
        libros.add(new libro("Fahrenheit 451", "Ray Bradbury"));
        libros.add(new libro("El Nombre de la Rosa", "Umberto Eco"));
    }

    // creamos una funcion que llamara a la clase con el metodo retirarlibro
    // se pasa como parametro lo ingresado por el usuario almacenado en una variable
    // titulo, proveniente de menu
    public void retirarLibro(String titulo) {
        // llamando a la clase y instancia que creamos
        // si existe un libro con el titulo se procede con el metodo y se retira
        // se procede con el metodo
        // retirarLibro hace mencion a la clase y la segunda a la funcion
        // pasamos la lista de libros y lo ingresado por el usuario
        if (retirarLibro.retirarLibro(libros, titulo)) {
            System.out.println("Libro retirado correctamente.");
            // si no se da error
        } else {
            System.out.println("No se encontró el libro o ya está retirado.");
        }
    }

    // creamos una funcion que llamara a la clase con el metodo buscarlibro
    public void buscarLibro(String busqueda) {
        // se procede con el metodo
        // se envia la lista de libros, y la busqueda del usuario
        buscarLibro.buscarLibro(libros, busqueda);
    }

    // creamos una funcion que llamara a la clase con el metodo mostrarlibros
    public void mostrarLibros() {
        // se procede con el metodo
        // se envia la lista de libros
        mostrarLibros.mostrarLibros(libros);
    }

    // creamos una funcion que llamara a la clase con el metodo ingresarlibro
    // recibe como parametro el titulo y autor
    public void ingresarLibro(String titulo, String autor) {
        // se procede con el metodo
        // se envia la lista de libros, el titulo y autor
        ingresarLibro.ingresarLibro(libros, titulo, autor);
    }

    // creamos una funcion que llamara a la clase con el metodo editarlibro
    // se pasa el parametro titulo
    public boolean editarLibro(String titulo) {
        // se inicia un bucle que recorra la lista de libros
        for (libro libro : libros) {
            // mientras se recorre se compara con el titulo a buscar
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                // si se encuentra se procede
                System.out.println("Libro encontrado: " + libro);
                // se ofrece cambiar o mantener el actual
                System.out.print("Ingrese el nuevo título (o presione Enter para mantener el actual): ");
                // se crea una variable local para almacenar el titulo nuevo
                String nuevoTitulo = scanner.nextLine();
                // si el nuevo titulo esta vacio se queda el anterior, si no se actualiza
                if (!nuevoTitulo.isEmpty()) {
                    libro.setTitulo(nuevoTitulo);
                }

                // mismo procedimiento para autor
                System.out.print("Ingrese el nuevo autor (o presione Enter para mantener el actual): ");
                String nuevoAutor = scanner.nextLine();
                if (!nuevoAutor.isEmpty()) {
                    libro.setAutor(nuevoAutor);
                }

                System.out.println("Libro editado correctamente: " + libro);
                // se certifica que el libro se edito
                return true;
            }
        }
        return false; // Si no se encuentra el libro
    }

    // creamos una funcion que llamara a la clase con el metodo editarlibro
    public boolean eliminarLibro(String titulo) {
        for (libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libros.remove(libro);
                System.out.println("Libro eliminado correctamente.");
                return true;
            }
        }
        System.out.println("No se encontró el libro a eliminar.");
        return false;
    }

}
