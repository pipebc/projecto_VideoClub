import java.util.*;

public class Cliente {
    private String idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private boolean activo;
    private List<Arriendo> arriendos;

    public Cliente(String idCliente, String nombre, String apellido, String telefono, String email) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.activo = true;
        this.arriendos = new ArrayList<>();
    }

    
    public boolean agregarArriendo(Arriendo arriendo) {
        return arriendos.add(arriendo);
    }

    public Arriendo buscarArriendoPorId(String idArriendo) {
        for (Arriendo a : arriendos) {
            if (a.getIdArriendo().equals(idArriendo)) {
                return a;
            }
        }
        return null;
    }

    public boolean eliminarArriendoPorId(String idArriendo) {
        Iterator<Arriendo> it = arriendos.iterator();
        while (it.hasNext()) {
            Arriendo a = it.next();
            if (a.getIdArriendo().equals(idArriendo)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public List<Arriendo> getArriendosActivos() {
        List<Arriendo> activos = new ArrayList<>();
        for (Arriendo a : arriendos) {
            if (!a.isDevuelto()) {
                activos.add(a);
            }
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
    public List<Arriendo> getArriendos() { 
        return arriendos; 
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
