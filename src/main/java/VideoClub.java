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
        cargarPeliculasDesdeArchivo("src/100peliculas.txt");
    }

    private void cargarPeliculasDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 5) {
                    String id = datos[0].trim();
                    String titulo = datos[1].trim();
                    String genero = datos[2].trim();
                    String director = datos[3].trim();
                    int stock = Integer.parseInt(datos[4].trim());

                    Pelicula pelicula = new Pelicula(id, titulo, genero, director, stock, "PG-13");
                    peliculas.add(pelicula);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    private void guardarPeliculasEnArchivo(String rutaArchivo) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
        for (Pelicula pelicula : peliculas) {
            String linea = pelicula.getIdPelicula() + ";" +
                           pelicula.getTitulo() + ";" +
                           pelicula.getGenero() + ";" +
                           pelicula.getDirector() + ";" +
                           pelicula.getStock();
            bw.write(linea);
            bw.newLine();
        }
        System.out.println("Archivo actualizado correctamente!");
    } catch (IOException e) {
        System.out.println("Error al guardar en archivo: " + e.getMessage());
        }
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        guardarPeliculasEnArchivo("src/100peliculas.txt");
        
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

    public void eliminarPelicula(String idPelicula) {
        Pelicula encontrada = null;
        for (Pelicula p : peliculas) {
            if (p.getIdPelicula().equalsIgnoreCase(idPelicula)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            peliculas.remove(encontrada);
            guardarPeliculasEnArchivo("src/100peliculas.txt");
            System.out.println("Película eliminada correctamente!");
        }   else  {
            System.out.println("No se encontró una película con ese ID.");
        }
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
