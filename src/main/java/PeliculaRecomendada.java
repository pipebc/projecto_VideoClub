
import java.util.List;

public class PeliculaRecomendada extends Pelicula {
    private boolean recomendadaPorSistema;
    private Boolean gustoRecomendacion; 
    private int vecesRecomendada;
    private int vecesGustada;
    private double tasaExito;
    private List<String> clientesQueGustaron;
    private List<String> clientesQueNoGustaron;

    public PeliculaRecomendada(String idPelicula, String titulo, String genero, 
                              String director, int stock, String clasificacion) {
        super(idPelicula, titulo, genero, director, stock);
        this.recomendadaPorSistema = false;
        this.gustoRecomendacion = null;
        this.vecesRecomendada = 0;
        this.vecesGustada = 0;
        this.tasaExito = 0.0;
        this.clientesQueGustaron = new java.util.ArrayList<>();
        this.clientesQueNoGustaron = new java.util.ArrayList<>();
    }

    public void registrarRecomendacion() {
        this.recomendadaPorSistema = true;
        this.vecesRecomendada++;
        System.out.println("Película recomendada: " + getTitulo() + " | Total recomendaciones: " + vecesRecomendada);
    }

    public void registrarFeedback(String idCliente, boolean leGusto) {
        if (gustoRecomendacion != null) {
            System.out.println("Error: Esta película ya recibió feedback");
            return;
        }
        
        this.gustoRecomendacion = leGusto;
        
        if (leGusto) {
            vecesGustada++;
            clientesQueGustaron.add(idCliente);
            System.out.println("✓ Feedback positivo de cliente: " + idCliente);
        } else {
            clientesQueNoGustaron.add(idCliente);
            System.out.println("✗ Feedback negativo de cliente: " + idCliente);
        }
        
        actualizarTasaExito();
    }

    public void registrarFeedbackMultiple(boolean leGusto) {
        this.gustoRecomendacion = leGusto;
        if (leGusto) {
            vecesGustada++;
        }
        actualizarTasaExito();
        System.out.println("Feedback registrado: " + (leGusto ? "GUSTÓ" : "NO GUSTÓ"));
    }

    private void actualizarTasaExito() {
        if (vecesRecomendada > 0) {
            this.tasaExito = ((double) vecesGustada / vecesRecomendada) * 100.0;
        }
    }

    public double getPuntuacionRecomendacion() {
        double puntuacion = 0.0;
        
        if (recomendadaPorSistema) {
            puntuacion += 30.0;
            
            puntuacion += (tasaExito * 0.7);
            
            if (getStock() > 0) {
                puntuacion += 10.0;
            }
            
            puntuacion += Math.min(getVecesArrendada() * 0.5, 20.0);
        }
        
        return Math.min(puntuacion, 100.0);
    }

    public String getNivelRecomendacion() {
        double puntuacion = getPuntuacionRecomendacion();
        
        if (puntuacion >= 80) return "EXCELENTE";
        if (puntuacion >= 60) return "MUY BUENA";
        if (puntuacion >= 40) return "BUENA";
        if (puntuacion >= 20) return "REGULAR";
        return "BAJA";
    }

    public String toString() {
        return super.toString() + 
               "\n--- DATOS RECOMENDACIÓN ---" +
               "\nRecomendada por sistema: " + (recomendadaPorSistema ? "Sí" : "No") +
               "\nVeces recomendada: " + vecesRecomendada +
               "\nVeces gustada: " + vecesGustada +
               "\nTasa de éxito: " + String.format("%.1f", tasaExito) + "%" +
               "\nPuntuación: " + String.format("%.1f", getPuntuacionRecomendacion()) +
               "\nNivel: " + getNivelRecomendacion() +
               "\nFeedback: " + (gustoRecomendacion == null ? "Sin feedback" : 
                                (gustoRecomendacion ? "Positivo" : "Negativo"));
    }

    public boolean arrendar() {
        boolean resultado = super.arrendar();
        if (resultado && recomendadaPorSistema) {
            System.out.println("¡Película recomendada arrendada con éxito!");
        }
        return resultado;
    }


    public boolean isRecomendadaPorSistema() {
        return recomendadaPorSistema;
    }

    public void setRecomendadaPorSistema(boolean recomendadaPorSistema) {
        this.recomendadaPorSistema = recomendadaPorSistema;
    }

    public Boolean getGustoRecomendacion() {
        return gustoRecomendacion;
    }

    public void setGustoRecomendacion(Boolean gustoRecomendacion) {
        this.gustoRecomendacion = gustoRecomendacion;
        if (gustoRecomendacion != null) {
            if (gustoRecomendacion) {
                vecesGustada++;
            }
            actualizarTasaExito();
        }
    }

    public int getVecesRecomendada() {
        return vecesRecomendada;
    }

    public void setVecesRecomendada(int vecesRecomendada) {
        this.vecesRecomendada = vecesRecomendada;
        actualizarTasaExito();
    }

    public int getVecesGustada() {
        return vecesGustada;
    }

    public double getTasaExito() {
        return tasaExito;
    }

    public List<String> getClientesQueGustaron() {
        return new java.util.ArrayList<>(clientesQueGustaron);
    }

    public List<String> getClientesQueNoGustaron() {
        return new java.util.ArrayList<>(clientesQueNoGustaron);
    }
}