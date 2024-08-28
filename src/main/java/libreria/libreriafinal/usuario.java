package libreria.libreriafinal;

public class usuario {
    //cargamos los atributos
    private String nombre;
    private String apellido;
    private String clave;
    private int documento;
    private boolean estadodecuenta;
    private String rol;

    //iniciamos el constructor recibiendo los atributos del objeto usuario
    public usuario(String nombre, String apellido, int documento, String clave, boolean estadodecuenta, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.documento = documento;  // Por defecto, el documento es 0
        this.estadodecuenta = false; //iniciamos en false, que no esta iniciada la sesion
        this.rol = rol; //iniciamos en false, que no esta iniciada la sesion
    }

    //metodos para obtener datos y modificarlos

    //se crea un meotodo para obtener nombre
    public String getNombre() {
        return nombre;
    }

    //se crea un metodo para obtener la clave
    public String getClave() {
        return clave;
    }

    //se crea un metodo para obtener el apellido
    public String getApellido() {
        return apellido;
    }

    //se crea un metodo para obtener el documento
    public int getDocumento() {
        return documento;
    }

    //se obtiene el rol
    public String getRol(){
        return rol;
    }


    //metodo para modificar el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //se cambia el apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //se cambia la clave
    public void setClave(String clave) {
        this.clave = clave;
    }

    //se cambia el documento
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    //Haciendo utilizacion del metodo override y toString transformamos los datos del objeto en una cadena de texto con el fin de ser mostrada
    //con mayor facilidad en su totalidad cuando se solicite
    //ejemplo case 1 del menu admin mostrar todos los usuarios
    //proporciona una estructura a la hora de mostrar la lista completa

    //cuando llamamos al override estamos remplazando la lista de usuarios y le damos la estructura
    //estamos modificando a la lista usuarios dandole el siguiente aspecto
    @Override
    public String toString() {
        return " Nombre: " + nombre + " Apellido: " + apellido + " Dni: " + documento + " Rol: " + rol;
    }

}
