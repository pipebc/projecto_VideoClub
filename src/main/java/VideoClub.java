import java.io.*;
import java.util.*;

public class VideoClub {
    private List<Cliente> clientes;
    private List<Pelicula> peliculas;
    private List<Arriendo> arriendos;
    
    private HashMap<String, Double> multasClientes;
    
    public VideoClub() {
        clientes = new ArrayList<>();
        peliculas = new ArrayList<>();
        arriendos = new ArrayList<>();
        
        multasClientes = new HashMap<String, Double>();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        agregarCliente(new Cliente("CLI-001", "Juan", "Pérez", "+56912345678", "juan@email.com"));
        agregarCliente(new Cliente("CLI-002", "María", "González", "+56987654321", "maria@email.com"));
        agregarCliente(new Cliente("CLI-003", "Carlos", "López", "+56955555555", "carlos@email.com"));

        agregarPelicula(new Pelicula("PEL-001", "El Padrino", "Drama", "Francis Ford Coppola", 5, "R"));
        agregarPelicula(new Pelicula("PEL-002", "Toy Story", "Animación", "John Lasseter", 3, "G"));
        agregarPelicula(new Pelicula("PEL-003", "Matrix", "Ciencia Ficción", "Lana Wachowski", 4, "PG-13"));
        agregarPelicula(new Pelicula("PEL-004", "Forrest Gump", "Drama", "Robert Zemeckis", 2, "PG-13"));
        agregarPelicula(new Pelicula("PEL-005", "Jurassic Park", "Aventura", "Steven Spielberg", 3, "PG-13"));

        Cliente cliente1 = buscarCliente("CLI-001");
        Pelicula pelicula1 = buscarPelicula("PEL-001");
        Pelicula pelicula2 = buscarPelicula("PEL-003");

        if (cliente1 != null && pelicula1 != null) {
            Arriendo arriendo1 = new Arriendo("ARR-001", cliente1, pelicula1, "2024-05-01");
            pelicula1.arrendar();
            agregarArriendo(arriendo1);
            cliente1.agregarArriendo(arriendo1); 
        }

        if (cliente1 != null && pelicula2 != null) {
            Arriendo arriendo2 = new Arriendo("ARR-002", cliente1, pelicula2, "2024-05-05");
            pelicula2.arrendar();
            agregarArriendo(arriendo2);
            cliente1.agregarArriendo(arriendo2); 
        }
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void agregarArriendo(Arriendo arriendo) {
        arriendos.add(arriendo);
    }

    public List<Cliente> getClientes() {
        return Collections.unmodifiableList(clientes);
    }

    public List<Pelicula> getPeliculas() {
        return Collections.unmodifiableList(peliculas);
    }

    public List<Arriendo> getArriendos() {
        return Collections.unmodifiableList(arriendos);
    }

    public Cliente buscarCliente(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public Pelicula buscarPelicula(String idPelicula) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getIdPelicula().equals(idPelicula)) {
                return pelicula;
            }
        }
        return null;
    }
    
    public Pelicula buscarPelicula(String titulo, boolean porTitulo) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null;
    }
    
    public List<Pelicula> buscarPeliculas(String genero, int limite) {
        List<Pelicula> resultado = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(pelicula);
                if (resultado.size() >= limite) break;
            }
        }
        return resultado;
    }

    public boolean eliminarCliente(String idCliente) {
        Cliente c = buscarCliente(idCliente);
        if (c == null) {
            System.out.println("Cliente no encontrado");
            return false;
        }
        
        if (!c.getArriendos().isEmpty()) {
            System.out.println("No se puede eliminar: el cliente tiene arriendos asociados");
            return false;
        }
        boolean ok = clientes.remove(c);
        if (ok) {
            multasClientes.remove(idCliente);
            System.out.println("Cliente eliminado: " + idCliente);
        }
        return ok;
    }

    public boolean eliminarPelicula(String idPelicula) {
        Pelicula p = buscarPelicula(idPelicula);
        if (p == null) {
            System.out.println("Película no encontrada");
            return false;
        }
        
        for (Arriendo a : arriendos) {
            if (a.getPelicula() != null && idPelicula.equals(a.getPelicula().getIdPelicula()) && !a.isDevuelto()) {
                System.out.println("No se puede eliminar: hay arriendos no devueltos de esta película");
                return false;
            }
        }
        boolean ok = peliculas.remove(p);
        if (ok) System.out.println("Película eliminada: " + idPelicula);
        return ok;
    }

    public boolean eliminarArriendo(String idArriendo) {
        Arriendo target = null;
        for (Arriendo a : arriendos) {
            if (a.getIdArriendo().equals(idArriendo)) {
                target = a;
                break;
            }
        }
        if (target == null) {
            System.out.println("Arriendo no encontrado");
            return false;
        }
        
        if (!target.isDevuelto() && target.getPelicula() != null) {
            target.getPelicula().devolver();
        }
        
        if (target.getCliente() != null) {
            target.getCliente().eliminarArriendoPorId(idArriendo);
        }
        boolean ok = arriendos.remove(target);
        if (ok) System.out.println("Arriendo eliminado: " + idArriendo);
        return ok;
    }
    
    
    public static void main(String[] args) throws IOException {
        VideoClub videoClub = new VideoClub();
        System.out.println("Datos iniciales cargados correctamente!");
        System.out.println("Clientes: " + videoClub.clientes.size());
        System.out.println("Películas: " + videoClub.peliculas.size());
        System.out.println("Arriendos: " + videoClub.arriendos.size());
    }
}
