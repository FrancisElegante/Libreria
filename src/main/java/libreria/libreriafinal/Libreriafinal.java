/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package libreria.libreriafinal;

import java.util.List;

/**
 *
 * @author Asus
 */
public class Libreriafinal {

    public static void main(String[] args) {



        //se iniciar mostrando el menu de autenticacion, no el principal
        //se inicializa el constructor de autenticacion como principal 
        Autenticacion autenticacion = new Autenticacion();
        //dentro de autenticacion invocamos el metodo showAuth
        autenticacion.showAuth();
    }

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
