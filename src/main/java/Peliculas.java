public class Pelicula {
    private String idPelicula;
    private String titulo;
    private String genero;
    private String director;
    private int stock;
    private int vecesArrendada;

    public Pelicula(String idPelicula, String titulo, String genero, String director, 
                   int stock, String clasificacion) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.director = director;
        this.stock = stock;
        this.vecesArrendada = 0;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getVecesArrendada() {
        return vecesArrendada;
    }

    public void setVecesArrendada(int vecesArrendada) {
        this.vecesArrendada = vecesArrendada;
    }


    public boolean arrendar() {
        if (stock > 0) {
            stock--;
            vecesArrendada++;
            return true;
        }
        return false;
    }

    public void devolver() {
        stock++;
    }
}
