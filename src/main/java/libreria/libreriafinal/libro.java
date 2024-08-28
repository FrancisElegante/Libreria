/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.libreriafinal;

/**
 *
 * @author Asus
 */

// Creamos una interfaz para trabajar con el objeto libro
// Interfaz = modelo de un objeto con atributos a respetar
// Tambien crearemos metodos para utilizar fuera de la clase libro para
// obtenerlos y modificarlos

public class libro {
    // Definimos los atributos que tendra libro(sus caracteristicas)
    private String titulo;
    private String autor;
    private boolean disponible;

    // llamamos al constructor para que los atributos se inicialicen con el
    public libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true; // Por defecto, el libro está disponible
    }

    // Creamos metodos get para obtener informacion cuando se precise
    public String getTitulo() {
        return titulo;
    }

    // Creamos metodos set para modificar informacion cuando se precise
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Creamos metodos get para obtener informacion cuando se precise
    public String getAutor() {
        return autor;
    }

    // Creamos metodos set para modificar informacion cuando se precise
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Creamos metodos get para obtener informacion cuando se precise
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Haciendo utilizacion del metodo override y toString transformamos los datos
    // del objeto en una cadena de texto con el fin de ser mostrada
    // con mayor facilidad en su totalidad cuando se solicite
    // ejemplo case 4 del menu mostrar todos los libros
    // proporciona una estructura a la hora de mostrar la lista completa

    // cuando llamamos al override estamos remplazando la lista de libros y le
    // damos la estructura
    // estamos modificando a la lista usuarios dandole el siguiente aspecto
    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Disponible: " + (disponible ? "Sí" : "No");
    }
}
