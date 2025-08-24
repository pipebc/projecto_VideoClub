public class Cliente {
    // Atributos privados (SIA1.3)
    private String idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private boolean activo;
    private Arriendo[] arriendos; 
    private int numArriendos;
    
    public Cliente(String idCliente, String nombre, String apellido, String telefono, 
                  String email, String tipoMembresia) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.activo = true;
        this.arriendos = new Arriendo[100]; 
        this.numArriendos = 0;
    }
    

    public Arriendo[] getArriendosActivos() {
        Arriendo[] activos = new Arriendo[numArriendos];
        for (int i = 0; i < numArriendos; i++) {
            activos[i] = arriendos[i];
        }
        return activos;
    }
    
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Arriendo[] getArriendos() {
        return arriendos;
    }

    public void setArriendos(Arriendo[] arriendos) {
        this.arriendos = arriendos;
    }
    
    public int getNumArriendos() {
        return numArriendos;
    }

    public boolean agregarArriendo(Arriendo arriendo) {
        if (numArriendos < arriendos.length) {
            arriendos[numArriendos] = arriendo;
            numArriendos++;
            return true;
        }
        return false;
    }
    
    public void actualizarContacto(String nuevoTelefono) {
        this.telefono = nuevoTelefono;
        System.out.println("Teléfono actualizado: " + nuevoTelefono);
    }
    
    public void actualizarContacto(String nuevoTelefono, String nuevoEmail) {
        this.telefono = nuevoTelefono;
        this.email = nuevoEmail;
        System.out.println("Contactos actualizados: " + nuevoTelefono + ", " + nuevoEmail);
    }
    
}


