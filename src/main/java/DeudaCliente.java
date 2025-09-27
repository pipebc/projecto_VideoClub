public class DeudaCliente extends Cliente {
    private double montoTotalMulta;
    private boolean multaAlta;
    private boolean bloqueadoPorMulta;
    private static final double LIMITE_MULTA_ALTA = 5000.0;

    public DeudaCliente(String idCliente, String nombre, String apellido, 
                         String telefono, String email) {
        super(idCliente, nombre, apellido, telefono, email);
        this.montoTotalMulta = 0.0;
        this.multaAlta = false;
        this.bloqueadoPorMulta = false;
    }

    public DeudaCliente(String idCliente, String nombre, String apellido, 
                         String telefono, String email,
                         double montoTotalMulta, boolean multaAlta, boolean bloqueadoPorMulta) {
        super(idCliente, nombre, apellido, telefono, email);
        this.montoTotalMulta = montoTotalMulta;
        this.multaAlta = multaAlta;
        this.bloqueadoPorMulta = bloqueadoPorMulta;
    }

  
    public boolean puedeArrendar() {
        if (bloqueadoPorMulta && montoTotalMulta > 0) {
            System.out.println("CLIENTE BLOQUEADO - Multa pendiente: $" + montoTotalMulta);
            return false;
        }
        if (!super.isActivo()) {
            System.out.println("CLIENTE INACTIVO - No puede realizar arriendos");
            return false;
        }
        return true;
    }

    public void agregarMulta(double monto) {
        if (monto < 0) {
            System.out.println("Error: El monto de la multa no puede ser negativo");
            return;
        }
        this.montoTotalMulta += monto;
        actualizarEstadoMulta();
        System.out.println("Multa agregada: $" + monto + " | Total multa: $" + montoTotalMulta);
    }

    public void pagarMulta(double monto) {
        if (monto < 0) {
            System.out.println("Error: El monto de pago no puede ser negativo");
            return;
        }
        
        if (monto > montoTotalMulta) {
            System.out.println("Monto excede la deuda. Se devuelven: $" + (monto - montoTotalMulta));
            this.montoTotalMulta = 0.0;
        } else {
            this.montoTotalMulta -= monto;
        }
        
        actualizarEstadoMulta();
        System.out.println("Pago realizado. Saldo multa restante: $" + montoTotalMulta);
        
        if (montoTotalMulta == 0 && bloqueadoPorMulta) {
            System.out.println("CLIENTE DESBLOQUEADO - Todas las multas han sido pagadas");
        }
    }

    public void pagarMultaCompleta() {
        System.out.println("Pago completo de multa: $" + montoTotalMulta);
        this.montoTotalMulta = 0.0;
        actualizarEstadoMulta();
        System.out.println("CLIENTE DESBLOQUEADO - Multas pagadas completamente");
    }

    private void actualizarEstadoMulta() {
        this.multaAlta = (montoTotalMulta > LIMITE_MULTA_ALTA);
        this.bloqueadoPorMulta = multaAlta;
    }

    public String getEstadoMulta() {
        if (montoTotalMulta == 0) {
            return "SIN MULTA";
        } else if (multaAlta) {
            return "MULTA ALTA - BLOQUEADO";
        } else {
            return "MULTA PENDIENTE";
        }
    }

  
    public String toString() {
        return super.toString() + 
               "\nTipo: Premium" +
               "\nMonto Total Multa: $" + montoTotalMulta +
               "\nEstado Multa: " + getEstadoMulta() +
               "\nBloqueado: " + (bloqueadoPorMulta ? "SÃ­" : "No");
    }


    public double getMontoTotalMulta() {
        return montoTotalMulta;
    }

    public void setMontoTotalMulta(double montoTotalMulta) {
        this.montoTotalMulta = montoTotalMulta;
        actualizarEstadoMulta();
    }

    public boolean isMultaAlta() {
        return multaAlta;
    }

    public boolean isBloqueadoPorMulta() {
        return bloqueadoPorMulta;
    }

    public void setBloqueadoPorMulta(boolean bloqueadoPorMulta) {
        this.bloqueadoPorMulta = bloqueadoPorMulta;
    }

    public static double getLimiteMultaAlta() {
        return LIMITE_MULTA_ALTA;
    }
}
