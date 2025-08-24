public class Peliculas{
    private int idPelicula;
    private String Titulo;
    private String Genero;
    private int Stock;
    
    public Peliculas (int idPelicula, String Titulo, String Genero, int Stock){
        this.idPelicula = idPelicula;
        this.Titulo = Titulo;
        this.Genero = Genero;
        this.Stock = Stock;
    }
    
    public int getidPelicula(){
        return idPelicula;
    }
    public String getTitulo(){
        return Titulo;
    }
    public String getGenero(){
        return Genero;
    }
    public int getStock(){
        return Stock;
    }
    public void dismunuirStock(){
        if (Stock > 0){
            Stock--;
        }
    }
    public void aumentarStock(){
        if (Stock < 0){
            Stock++;
        }
    }
}

