import java.io.*;
import java.util.*;

public class Sistema {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        VideoClub videoClub = new VideoClub();
        
        Cliente seleccionado = null;
        
        int opcion = 0;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Agregar nueva Película");
            System.out.println("3. Mostrar Arriendos");
            System.out.println("4. Agregar arriendo a clientes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            System.out.println("");
            switch(opcion){
                
                case 1:
                    Cliente nuevoCliente = crearCliente();
                    
                case 2:
                    //Pelicula nuevaPelicula = agregarPelicula();
                
                case 3:
                    //Arriendo mostrarArriendo = listarArriendo():
                
                case 4:
                    //Arriendo agregarArriendo = agregarArriendoCliente)();
                
                case 0:
                    System.out.println("Finalizado");
                    
                default:
                    System.out.println("Opcion no valida");  
            }
        }while(opcion != 0);
        
    }
    
    private static Cliente crearCliente() {
        System.out.print("ID del cliente: ");
        String id = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Tipo de membresía (regular/premium): ");
        String tipoMembresia = scanner.nextLine();
        return new Cliente(id, nombre, apellido, telefono, email, tipoMembresia);
    }
    
}
