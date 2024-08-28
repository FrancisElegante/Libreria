package libreria.libreriafinal;

import java.util.List;

//se recibe la lista de libros y titulo a retirar
public class RetirarLibro {
    //se inicia una funcion con un valor booleano
    public boolean retirarLibro(List<libro> libros, String titulo) {
        //se recorre la lista de libros
        for (libro libro : libros) {
            //si el titulo y el libro esta disponible
            
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.isDisponible()) {
                //se cambia el estado del libro a no disponible
                libro.setDisponible(false);
                //se devuelve true a la funcion booleana
                return true;
            }
        }
        return false;
    }
}
