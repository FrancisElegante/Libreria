package libreria.libreriafinal;
import java.util.List;

//metodo de ingreso de libro
public class IngresarLibro {
    //se recibe como parametro el titulo y autor del libro a volver a ingresar
    public void ingresarLibro(List<libro> libros, String titulo, String autor) {
            //con un for recorremos la lista de libros
        for (libro libro : libros) {
            //si el titulo existe en la lista
                    // Verificar si el libro ya existe pero está marcado como no disponible
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isDisponible()) {
                //se setea el libro como disponible
                libro.setDisponible(true);
                //se imprime el reingreso
                System.out.println("El libro ha sido reingresado correctamente.");
                return;
            }
        }

        //Añadido que esta siendo evaluado
        // Si no existe, agregar como nuevo libro
        libros.add(new libro(titulo, autor));
        System.out.println("Libro agregado correctamente.");
    }
}
