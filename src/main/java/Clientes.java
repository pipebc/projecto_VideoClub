import java.util.ArrayList;
import java.util.List;

public class Clientes{
    private int idCliente;
    private String Nombre;
    private String Direccion;
    private int Numero;
    private List<Arriendos> arriendos;
    
    public Clientes (int idCliente, String Nombre, String Direccion, int Numero){
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Numero = Numero;
        this.arriendos = new ArrayList<>();
    }
    public int getidCliente(){
        return idCliente;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getDireccion(){
        return Direccion;
    }
    public int getNumero(){
        return Numero;
    }
    public List<Arriendos> getArriendos(){
        return arriendos;
    }   
    public void setNombre(String nombre){
        this.Nombre = Nombre;
    }
    public void setDireccion(String Direccion){
        this.Direccion  = Direccion;
    }
    public void setNumero(int Numero){
        this.Numero = Numero;
    }
    
     public void agregarArriendo(Arriendos arriendo) {
        this.arriendos.add(arriendo);
    }
     
    // Sobrecarga 1: Agregar arriendo con datos básicos
    public void agregarArriendo(String pelicula, String fechaArriendo) {
        Arriendos nuevoArriendo = new Arriendos("", pelicula, fechaArriendo, "");
        this.arriendos.add(nuevoArriendo);
    }
    
    // Sobrecarga 2: Agregar arriendo completo
    public void agregarArriendo(String sugerencias, String pelicula, String fechaArriendo, String fechaDevolucion) {
        Arriendos nuevoArriendo = new Arriendos(sugerencias, pelicula, fechaArriendo, fechaDevolucion);
        this.arriendos.add(nuevoArriendo);
    }
}

