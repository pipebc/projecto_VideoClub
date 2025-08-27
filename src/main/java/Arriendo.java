public class Arriendo {
    private String idArriendo;
    private Cliente cliente;
    private Pelicula pelicula;
    private String fechaArriendo;
    private String fechaDevolucion;
    private boolean devuelto;
    private int calificacion; 

    public Arriendo(String idArriendo, Cliente cliente, Pelicula pelicula, String fechaArriendo) {
        this.idArriendo = idArriendo;
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.fechaArriendo = fechaArriendo;
        this.devuelto = false;
        this.calificacion = 0;
    }

    public String getIdArriendo() {
        return idArriendo;
    }

    public void setIdArriendo(String idArriendo) {
        this.idArriendo = idArriendo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(String fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
