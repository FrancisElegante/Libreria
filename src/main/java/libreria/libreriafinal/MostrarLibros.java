package libreria.libreriafinal;
import java.util.List;

//se recibe la lista de libros
public class MostrarLibros {
    public void mostrarLibros(List<libro> libros) {
        //si la lista esta vacia se avisa
        if (libros.isEmpty()) {
            System.out.println("No hay libros disponibles.");
            //si no se recorre la lista y se imprimen los libros
        } else {
            for (libro libro : libros) {
                System.out.println(libro);
            }
        }
    }
}
