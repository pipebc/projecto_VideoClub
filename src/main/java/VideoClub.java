import java.io.*;
import java.time.LocalDate;
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
        cargarPeliculasDesdeArchivo("100peliculas.txt");
        cargarClientesDesdeArchivo("30clientes.txt");
        asignarArriendosIniciales();
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
                    Pelicula pelicula = new PeliculaRecomendada(id, titulo, genero, director, stock, "");
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

    private void cargarClientesDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length >= 5) {
                    DeudaCliente cliente = new DeudaCliente(
                        datos[0].trim(),
                        datos[1].trim(),
                        datos[2].trim(),
                        datos[3].trim(),
                        datos[4].trim()
                    );
                    clientes.add(cliente);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo de clientes: " + e.getMessage());
        }
    }



    private void guardarClientesEnArchivo(String rutaArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Cliente c : clientes) {
                String linea = c.getIdCliente() + ";" +
                               c.getNombre() + ";" +
                               c.getApellido() + ";" +
                               c.getTelefono() + ";" +
                               c.getEmail() + ";" +
                               "premium"; 
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Archivo de clientes actualizado correctamente!");
        } catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }
    
    private void asignarArriendosIniciales() {
        if (clientes.size() < 10 || peliculas.size() < 10) return;

        for (int i = 0; i < 10; i++) { 
            Cliente cliente = clientes.get(i);

            for (int j = 0; j < 10; j++) { 
                Pelicula pelicula = peliculas.get(j % peliculas.size());
                if (!pelicula.arrendar()) continue; 

                String idArriendo = "ARR-" + cliente.getIdCliente() + "-" + pelicula.getIdPelicula();
                String fechaArriendo = LocalDate.now().minusDays(j).toString();

                Arriendo arriendo = new Arriendo(idArriendo, cliente, pelicula, fechaArriendo);
                arriendos.add(arriendo);
                cliente.agregarArriendo(arriendo);
            }
        }

        System.out.println("Arriendos iniciales asignados automáticamente a 10 clientes.");
    }


    public boolean agregarCliente(Cliente cliente) {
        if (!(cliente instanceof DeudaCliente)) {
            cliente = new DeudaCliente(
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getEmail()
            );
        }
        if (buscarCliente(cliente.getIdCliente()) != null) {
            return false;
        }
        clientes.add(cliente);
        guardarClientesEnArchivo("30clientes.txt");
        return true;
    }

    public boolean agregarPelicula(Pelicula pelicula) {
        for (Pelicula p : peliculas) {
            if (p.getIdPelicula().equalsIgnoreCase(pelicula.getIdPelicula()) ||
                p.getTitulo().equalsIgnoreCase(pelicula.getTitulo())) {
                return false;
            }
        }
        Pelicula nueva;
        if (pelicula instanceof PeliculaRecomendada) {
            nueva = pelicula;
        } else {
            nueva = new PeliculaRecomendada(
                pelicula.getIdPelicula(),
                pelicula.getTitulo(),
                pelicula.getGenero(),
                pelicula.getDirector(),
                pelicula.getStock(),
                ""
            );
        }
        peliculas.add(pelicula);
        guardarPeliculasEnArchivo("100peliculas.txt");
        return true;
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
            guardarClientesEnArchivo("30clientes.txt");
            System.out.println("Cliente eliminado: " + idCliente);
        }
        return ok;
    }

    public boolean eliminarPelicula(String idPelicula) {
        Pelicula encontrada = null;
        for (Pelicula p : peliculas) {
            if (p.getIdPelicula().equalsIgnoreCase(idPelicula)) {
                encontrada = p;
                break;
            }
        }
        if (encontrada != null) {
            peliculas.remove(encontrada);
            guardarPeliculasEnArchivo("100peliculas.txt");
            System.out.println("Película eliminada correctamente!");
            return true;
        } else {
            System.out.println("No se encontró una película con ese ID.");
            return false;
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
    
    
    public void modificarArriendo(String idArriendo, String nuevaFechaDevolucion, boolean devuelto, int calificacion) {
        Arriendo encontrado = null;
        for (Arriendo a : arriendos) {
            if (a.getIdArriendo().equalsIgnoreCase(idArriendo)) {
                encontrado = a;
                break;
            }
        }

        if (encontrado != null) {
            if (nuevaFechaDevolucion != null && !nuevaFechaDevolucion.isEmpty()) {
                encontrado.setFechaDevolucion(nuevaFechaDevolucion);
            }
            encontrado.setDevuelto(devuelto);
            encontrado.setCalificacion(calificacion);

            System.out.println("Arriendo modificado correctamente!");
        } else {
            System.out.println("No se encontró un arriendo con el ID ingresado.");
        }
    }
    
    public Arriendo buscarArriendo(String idArriendo) {
        for (Arriendo a : arriendos) {
            if (a.getIdArriendo().equalsIgnoreCase(idArriendo)) {
                return a;
            }
        }
        return null;
    }
    
    public List<String> listarClientesConDeuda() {
        List<String> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente instanceof DeudaCliente) {
                DeudaCliente dc = (DeudaCliente) cliente;
                if (dc.getMontoTotalMulta() > 0) {
                    resultado.add(dc.getIdCliente() + " - " + dc.getNombre() + " " + dc.getApellido() +
                              " | Deuda: $" + dc.getMontoTotalMulta());
                }
            }
        }
        return resultado;
    }
    
    public List<String> listarClientesEnListaNegra() {
        List<String> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente instanceof DeudaCliente) {
                DeudaCliente dc = (DeudaCliente) cliente;
                if (dc.isBloqueadoPorMulta()) {
                    resultado.add(dc.getIdCliente() + " - " + dc.getNombre() + " " + dc.getApellido() +
                                  " | Deuda: $" + dc.getMontoTotalMulta());
                }
            }
        }
        return resultado;
    }
    
    
    
    public String generarReporteCompleto() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== REPORTE GENERAL DEL VIDEOCLUB ===\n\n");

        sb.append("Clientes registrados: ").append(clientes.size()).append("\n");
        sb.append("Películas registradas: ").append(peliculas.size()).append("\n");
        sb.append("Arriendos totales: ").append(arriendos.size()).append("\n\n");

        sb.append("---- LISTA DE CLIENTES ----\n");
        for (Cliente c : clientes) {
            sb.append(c.getIdCliente()).append(" - ")
              .append(c.getNombre()).append(" ").append(c.getApellido())
              .append(" | Email: ").append(c.getEmail()).append("\n");
        }
        sb.append("\n");


        sb.append("---- LISTA DE PELÍCULAS ----\n");
        for (Pelicula p : peliculas) {
            sb.append(p.getIdPelicula()).append(" - ").append(p.getTitulo())
              .append(" | Género: ").append(p.getGenero())
              .append(" | Stock: ").append(p.getStock()).append("\n");
        }
        sb.append("\n");

        sb.append("---- ARRIENDOS ACTIVOS ----\n");
        for (Arriendo a : arriendos) {
            if (!a.isDevuelto()) {
                sb.append(a.getIdArriendo()).append(" | Cliente: ")
                  .append(a.getCliente().getNombre()).append(" ").append(a.getCliente().getApellido())
                  .append(" | Película: ").append(a.getPelicula().getTitulo())
                  .append(" | Fecha arriendo: ").append(a.getFechaArriendo()).append("\n");
            }
        }
        sb.append("\n");

    
        sb.append("---- CLIENTES CON DEUDA ----\n");
        for (Cliente cliente : clientes) {
            if (cliente instanceof DeudaCliente) {
                DeudaCliente dc = (DeudaCliente) cliente;
                if (dc.getMontoTotalMulta() > 0) {
                    sb.append(dc.getIdCliente()).append(" - ").append(dc.getNombre()).append(" ").append(dc.getApellido())
                      .append(" | Deuda: $").append(dc.getMontoTotalMulta()).append("\n");
                }
            }
        }
        sb.append("\n");

    
        sb.append("---- CLIENTES EN LISTA NEGRA ----\n");
        for (Cliente cliente : clientes) {
            if (cliente instanceof DeudaCliente) {
                DeudaCliente dc = (DeudaCliente) cliente;
                if (dc.isBloqueadoPorMulta()) {
                    sb.append(dc.getIdCliente()).append(" - ").append(dc.getNombre()).append(" ").append(dc.getApellido())
                      .append(" | Deuda: $").append(dc.getMontoTotalMulta()).append("\n");
                }
            }
        }
        sb.append("\n");

        sb.append("=== FIN DEL REPORTE ===");
        return sb.toString();
    }
    
    public void mostrarEstadoHarryPotter() {
        int arrendadas = 0;
        int disponibles = 0;

        for (Pelicula pelicula : peliculas) {
            if (pelicula.getTitulo().toLowerCase().contains("harry potter")) {
                arrendadas += pelicula.getVecesArrendada();
                disponibles += pelicula.getStock();
            }
        }

        System.out.println("=== Estado de películas de Harry Potter ===");
        System.out.println("Cantidad arrendada: " + arrendadas);
        System.out.println("Cantidad disponible: " + disponibles);
    }
    
    public String pagarDeudaCliente(String idCliente, double monto) {
        Cliente c = buscarCliente(idCliente);
        if (c == null) {
            return "Cliente no encontrado.";
        }
        if (!(c instanceof DeudaCliente)) {
            return "El cliente no tiene sistema de multas (no es DeudaCliente).";
        }
        DeudaCliente dc = (DeudaCliente) c;
        double deuda = dc.getMontoTotalMulta();
        if (deuda <= 0) {
            return "El cliente no tiene deudas pendientes.";
        }
        if (monto <= 0) {
            dc.pagarMultaCompleta();
            return "Deuda saldada completamente.";
        } else {
            if (monto > deuda) {
                dc.pagarMulta(deuda);
                return "Pago realizado. Deuda saldada completamente.";
            } else {
                dc.pagarMulta(monto);
                return "Pago realizado. Multa restante: $" + dc.getMontoTotalMulta();
            }
        }
    }
    
    public boolean agregarMultaCliente(String idCliente, double monto, String motivo) {
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado: " + idCliente);
            return false;
        }

        if (!(cliente instanceof DeudaCliente)) {
            System.out.println("El cliente no es de tipo DeudaCliente: " + idCliente);
            return false;
        }

        DeudaCliente deudaCliente = (DeudaCliente) cliente;

        if (monto <= 0) {
            System.out.println("El monto de la multa debe ser mayor a 0");
            return false;
        }

        deudaCliente.agregarMulta(monto);

        double multaActual = multasClientes.getOrDefault(idCliente, 0.0);
        multasClientes.put(idCliente, multaActual + monto);

        System.out.println("Multa agregada exitosamente:");
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Monto: $" + monto);
        System.out.println("Motivo: " + motivo);
        System.out.println("Deuda total: $" + deudaCliente.getMontoTotalMulta());

        return true;
    }       
    
    public static void main(String[] args) throws IOException {
        VideoClub videoClub = new VideoClub();
        System.out.println("Datos iniciales cargados correctamente!");
        System.out.println("Clientes: " + videoClub.clientes.size());
        System.out.println("Películas: " + videoClub.peliculas.size());
        System.out.println("Arriendos: " + videoClub.arriendos.size());
    }
}
