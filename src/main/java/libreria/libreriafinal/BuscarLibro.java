package libreria.libreriafinal;

//importamos las listas de java
import java.util.List;

//creamos la clase para buscar libros
public class BuscarLibro {
    // creamos el metodo de busqueda en la lista
    public void buscarLibro(List<libro> libros, String busqueda) {
        //creamos una bandera
        boolean encontrado = false;
        // creamos un bucle para recorrer la lista de libros
        for (libro libro : libros) {
            //comparamos el titulo del libro con la busqueda
                //ignoramos mayusculas y minisculas en la busqueda
                    //utilizamos un comparador || para ofrecer busqueda por autor(amigable con el usuario, agregado de valor)
            if (libro.getTitulo().equalsIgnoreCase(busqueda) || libro.getAutor().equalsIgnoreCase(busqueda)) {
                //si se encuentra el libro, mostramos los datos del libro
                System.out.println(libro);
                //mostramos la bandera
                encontrado = true;
            }
        }
        //si no se encuentra tiramos error
        if (!encontrado) {
            //
            System.out.println("No se encontraron libros con esa búsqueda.");
        }
    }
}