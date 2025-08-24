public class Arriendos{
    private String sugerencias;
    private String Pelicula;
    private String FechaArriendo;
    private String FechaDevolucion;
    private String TEST;
    private String TESTTTTT;
   
    public Arriendos (String sugerencias, String Pelicula, String FechaArriendo, String FechaDevolucion){
        this.sugerencias = sugerencias;
        this.Pelicula = Pelicula;
        this.FechaArriendo = FechaArriendo;
        this.FechaDevolucion = FechaDevolucion;
    }
    public String getsugerencias(){
        return sugerencias;
    }
    public String getPelicula(){
        return Pelicula;
    }
    public String getFechaArriendo(){
        return FechaArriendo;
    }
    public String getFechaDevolucion(){
        return FechaDevolucion;
    }          
}