import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Sistema {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            VideoClub videoClub = new VideoClub();
            System.out.println("=== SISTEMA VIDEO CLUB INICIADO ===");
            System.out.println("Datos iniciales cargados:");
            System.out.println("- " + videoClub.getClientes().size() + " clientes");
            System.out.println("- " + videoClub.getPeliculas().size() + " películas");
            System.out.println("- " + videoClub.getArriendos().size() + " arriendos iniciales");

            ejecutarMenuPrincipal(videoClub);
        } catch (Exception e) {
            System.out.println("Error al iniciar el sistema: " + e.getMessage());
        }
    }

    private static void ejecutarMenuPrincipal(VideoClub videoClub) throws IOException {
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        do {
            System.out.println("\n=== SISTEMA VIDEO CLUB ===");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Películas");
            System.out.println("3. Gestión de Arriendos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(lector.readLine());
            switch (opcion) {
                case 1:
                    menuClientes(videoClub, lector);
                    break;
                case 2:
                    menuPeliculas(videoClub, lector);
                    break;
                case 3:
                    menuArriendos(videoClub, lector);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);
    }
    
    private static void insertarArriendoCliente(VideoClub videoClub) {
        System.out.println("\n-- Agregar arriendo a cliente --");

        System.out.print("Ingrese ID del cliente: ");
        String idCliente = scanner.nextLine().trim();
        Cliente cliente = videoClub.buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        System.out.print("Ingrese ID de la película: ");
        String idPelicula = scanner.nextLine().trim();
        Pelicula pelicula = videoClub.buscarPelicula(idPelicula);
        if (pelicula == null) {
            System.out.println("Película no encontrada");
            return;
        }

        if (!pelicula.arrendar()) {
            System.out.println("Sin stock disponible para esta película");
            return;
        }

        String idArriendo = "ARR-" + System.currentTimeMillis();
        String fechaArriendo = LocalDate.now().toString();
        Arriendo arriendo = new Arriendo(idArriendo, cliente, pelicula, fechaArriendo);

        videoClub.agregarArriendo(arriendo);
        cliente.agregarArriendo(arriendo);

        System.out.println("Arriendo agregado con éxito: " + idArriendo +
                " | Cliente: " + cliente.getIdCliente() +
                " | Película: " + pelicula.getTitulo() +
                " | Fecha: " + fechaArriendo);
    }

    private static void listarArriendosDeCliente(VideoClub videoClub) {
        System.out.println("\n-- Listado de arriendos de un cliente --");
        System.out.print("Ingrese ID del cliente: ");
        String idCliente = scanner.nextLine().trim();
        Cliente cliente = videoClub.buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado");
            return;
        }

        List<Arriendo> lista = cliente.getArriendosActivos();
        if (lista.isEmpty()) {
            System.out.println("El cliente no tiene arriendos registrados");
            return;
        }

        System.out.println("\nArriendos del cliente " + cliente.getIdCliente() + ":");
        for (Arriendo a : lista) {
            Pelicula p = a.getPelicula();
            System.out.println("- " + a.getIdArriendo() +
                    " | Película: " + (p != null ? p.getTitulo() : "(desconocida)") +
                    " | Fecha arriendo: " + a.getFechaArriendo() +
                    " | Fecha devolucion: " + a.getFechaDevolucion());
        }
    }

    private static int leerEntero() {
        String entrada = scanner.nextLine();
        try {
            return Integer.parseInt(entrada.trim());
        } catch (NumberFormatException e) {
            return -1; 
        }
    }

 
    private static void menuClientes(VideoClub vc, BufferedReader lector) throws IOException {
        int op;
        do {
            System.out.println("\nClientes");
            System.out.println("1) Agregar");
            System.out.println("2) Eliminar");
            System.out.println("3) Mostrar");
            System.out.println("4) Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(lector.readLine());
            switch (op) {
                case 1: {
                    System.out.print("ID: "); String id = lector.readLine();
                    System.out.print("Nombre: "); String nombre = lector.readLine();
                    System.out.print("Apellido: "); String apellido = lector.readLine();
                    System.out.print("Teléfono: "); String tel = lector.readLine();
                    System.out.print("Email: "); String email = lector.readLine();
                    vc.agregarCliente(new Cliente(id, nombre, apellido, tel, email));
                    System.out.println("Cliente agregado");
                    break;
                }

                case 2: {
                    System.out.print("ID a eliminar: "); String id = lector.readLine();
                    vc.eliminarCliente(id);
                    break;
                }
                case 3: {
                    System.out.println("\nListado de clientes (" + vc.getClientes().size() + "):");
                    for (Cliente c : vc.getClientes()) {
                        System.out.println("- " + c.getIdCliente() + ": " + c.getNombre() + " " + c.getApellido());
                    }
                    break;
                }
                case 4: break;
                default: System.out.println("Opción no válida");
            }
        } while (op != 4);
    }

    private static void menuPeliculas(VideoClub vc, BufferedReader lector) throws IOException {
        int op;
        do {
            System.out.println("\nPelículas");
            System.out.println("1) Agregar");
            System.out.println("2) Eliminar");
            System.out.println("3) Mostrar");
            System.out.println("4) Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(lector.readLine());
            switch (op) {
                case 1: {
                    System.out.print("ID: "); String id = lector.readLine();
                    System.out.print("Título: "); String titulo = lector.readLine();
                    System.out.print("Género: "); String genero = lector.readLine();
                    System.out.print("Director: "); String director = lector.readLine();
                    System.out.print("Stock: "); int stock = Integer.parseInt(lector.readLine());
                    System.out.print("Clasificación: "); String clasif = lector.readLine();
                    vc.agregarPelicula(new Pelicula(id, titulo, genero, director, stock));
                    System.out.println("Película agregada");
                    break;
                }
                case 2: {
                    System.out.print("ID a eliminar: "); String id = lector.readLine();
                    vc.eliminarPelicula(id);
                    break;
                }
                case 3: {
                    System.out.println("\nListado de películas (" + vc.getPeliculas().size() + "):");
                    for (Pelicula p : vc.getPeliculas()) {
                        System.out.println("- " + p.getIdPelicula() + ": " + p.getTitulo() +
                                " | Género: " + p.getGenero() + " | Stock: " + p.getStock());
                    }
                    break;
                }
                case 4: break;
                default: System.out.println("Opción no válida");
            }
        } while (op != 4);
    }

    private static void menuArriendos(VideoClub vc, BufferedReader lector) throws IOException {
        int op;
        do {
            System.out.println("\n[Arriendos]");
            System.out.println("1) Agregar arriendo a cliente");
            System.out.println("2) Eliminar arriendo");
            System.out.println("3) Mostrar arriendos de un cliente");
            System.out.println("4) Devolver arriendo");
            System.out.println("5) Modificar arriendo");
            System.out.println("6) Volver");
            System.out.print("Opción: ");
            op = Integer.parseInt(lector.readLine());
            switch (op) {
                case 1: insertarArriendoCliente(vc); break;
                case 2: {
                    System.out.print("ID de arriendo a eliminar: "); String idA = lector.readLine();
                    vc.eliminarArriendo(idA);
                    break;
                }
                case 3: listarArriendosDeCliente(vc); break;
                case 4: {
                    System.out.print("falta "); 
                    break;
                }
                case 5:
                    System.out.print("Ingrese ID del arriendo a modificar: ");
                    String idArriendo = scanner.nextLine();
                    System.out.print("Ingrese nueva fecha de devolución (o Enter para dejar igual): ");
                    String nuevaFecha = scanner.nextLine();
                    System.out.print("¿Está devuelto? (true/false): ");
                    boolean devuelto = Boolean.parseBoolean(scanner.nextLine());
                    System.out.print("Ingrese calificación (0-5): ");
                    int calificacion = Integer.parseInt(scanner.nextLine());
                    vc.modificarArriendo(idArriendo, nuevaFecha, devuelto, calificacion);
                    break;

                case 6: break;
                default: System.out.println("Opción no válida");
            }
        } while (op != 6);
    }
}
