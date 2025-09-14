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

    public boolean agregarCliente(Cliente cliente) {
        if (buscarCliente(cliente.getIdCliente()) == null) {
            return clientes.add(cliente);
        }
        return false;
    }

    public boolean agregarPelicula(Pelicula pelicula) {
        if (buscarPelicula(pelicula.getIdPelicula()) == null) {
            boolean res = peliculas.add(pelicula);
            guardarPeliculasEnArchivo("src/100peliculas.txt");
            return res;
        }
        return false;
    }

    public boolean agregarArriendo(Arriendo arriendo) {
        if (buscarArriendo(arriendo.getIdArriendo()) == null) {
            arriendos.add(arriendo);
            arriendo.getCliente().agregarArriendo(arriendo);
            return true;
        }
        return false;
    }

    public Cliente buscarCliente(String idCliente) {
        for (Cliente c : clientes) {
            if (c.getIdCliente().equals(idCliente)) {
                return c;
            }
        }
        return null;
    }

    public Pelicula buscarPelicula(String titulo) {
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

    public Arriendo buscarArriendo(String idArriendo) {
        for (Arriendo a : arriendos) {
            if (a.getIdArriendo().equals(idArriendo)) {
                return a;
            }
        }
        return null;
    }

    public boolean eliminarCliente(String idCliente) {
        Cliente c = buscarCliente(idCliente);
        if (c == null) {
            System.out.println("Cliente no encontrado");
            return false;
        }
        if (!c.getArriendosActivos().isEmpty()) {
            System.out.println("No se puede eliminar: el cliente tiene arriendos activos");
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
        boolean ok = peliculas.remove(p);
        if (ok) {
            guardarPeliculasEnArchivo("src/100peliculas.txt");
            System.out.println("Película eliminada correctamente!");
        }
        return ok;
    }

    public boolean eliminarArriendo(String idArriendo) {
        Arriendo a = buscarArriendo(idArriendo);
        if (a == null) {
            System.out.println("Arriendo no encontrado");
            return false;
        }
        if (!a.isDevuelto() && a.getPelicula() != null) {
            a.getPelicula().devolver();
        }
        if (a.getCliente() != null) {
            a.getCliente().eliminarArriendoPorId(idArriendo);
        }
        boolean ok = arriendos.remove(a);
        if (ok) System.out.println("Arriendo eliminado: " + idArriendo);
        return ok;
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
                    Pelicula pelicula = new Pelicula(id, titulo, genero, director, stock);
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

    public List<Cliente> getClientes() { 
        return Collections.unmodifiableList(clientes); 
    }
    public List<Pelicula> getPeliculas() { 
        return Collections.unmodifiableList(peliculas); 
    }
    public List<Arriendo> getArriendos() { 
        return Collections.unmodifiableList(arriendos); 
    }
}
