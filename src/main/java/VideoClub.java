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

    public void agregarMulta(String idCliente, double monto) {
        if (multasClientes.containsKey(idCliente)) {
            // Si ya tiene multa, sumar al monto existente
            double multaActual = multasClientes.get(idCliente);
            multasClientes.put(idCliente, multaActual + monto);
        } else {
            // Si no tiene multa, crear nueva entrada
            multasClientes.put(idCliente, monto);
        }
        System.out.println("Multa de $" + monto + " agregada al cliente " + idCliente);
    }
    
    public double consultarMulta(String idCliente) {
        return multasClientes.getOrDefault(idCliente, 0.0);
    }
    
    public void pagarMulta(String idCliente, double monto) {
        if (multasClientes.containsKey(idCliente)) {
            double multaActual = multasClientes.get(idCliente);
            if (monto >= multaActual) {
                multasClientes.remove(idCliente);
                System.out.println("Multa pagada completamente. Gracias!");
            } else {
                multasClientes.put(idCliente, multaActual - monto);
                System.out.println("Se abonaron $" + monto + ". Saldo pendiente: $" + (multaActual - monto));
            }
        } else {
            System.out.println("El cliente no tiene multas pendientes");
        }
    }
    
    public void mostrarTodasMultas() {
        System.out.println("\n=== MULTAS PENDIENTES ===");
        if (multasClientes.isEmpty()) {
            System.out.println("No hay multas pendientes");
        } else {
            for (Map.Entry<String, Double> entry : multasClientes.entrySet()) {
                System.out.println("Cliente: " + entry.getKey() + " - Multa: $" + entry.getValue());
            }
        }
    }
    
    public boolean puedeArrendar(String idCliente) {
        double multa = consultarMulta(idCliente);
        if (multa > 0) {
            System.out.println("Cliente tiene multa pendiente de $" + multa);
            return false;
        }
        
        Cliente cliente = buscarCliente(idCliente);
        if(cliente != null && cliente.isActivo()) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        VideoClub videoClub = new VideoClub();
        System.out.println("Datos iniciales cargados correctamente!");
        System.out.println("Clientes: " + videoClub.clientes.size());
        System.out.println("Películas: " + videoClub.peliculas.size());
        System.out.println("Arriendos: " + videoClub.arriendos.size());
    }
}

