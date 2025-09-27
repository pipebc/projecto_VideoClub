import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Inicio extends javax.swing.JFrame {

    private VideoClub videoClub;
    
    public Inicio() {
        videoClub = new VideoClub();
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Peliculas");

        jMenuItem1.setText("Agregar Pelicula ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Mostrar Peliculas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Eliminar Pelicula");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");

        jMenuItem4.setText("Registrar Cliente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Eliminar Cliente");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Lista de Clientes");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("Informacion de Cliente");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Recomendaciones");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem20.setText("Registrar recomendacion");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem20);

        jMenuItem21.setText("Registrar feedback de cliente");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem21);

        jMenuItem22.setText("Ver detalles recomendacion");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem22);

        jMenuBar1.add(jMenu6);

        jMenu3.setText("Arriendos");

        jMenuItem8.setText("Agregar Arriendo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Eliminar Arriendo");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setText("Lista de Arriendo de Cliente");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setText("Devolver Arriendo");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Deudas");

        jMenuItem12.setText("Lista de deudas");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem14.setText("Pagar Multa");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem17.setText("Agregar deuda");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem17);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Otros");

        jMenuItem15.setText("reporte");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem15);

        jMenuItem16.setText("Funcion sia2.5");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem16);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField genreField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField stockField = new JTextField();
        Object[] message = {
            "ID:", idField,
            "Título:", titleField,
            "Género:", genreField,
            "Director:", directorField,
            "Stock:", stockField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Agregar Película", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String id = idField.getText().trim();
                String title = titleField.getText().trim();
                String genre = genreField.getText().trim();
                String director = directorField.getText().trim();
                int stock = Integer.parseInt(stockField.getText().trim());
                Pelicula p = new Pelicula(id, title, genre, director, stock);
                if (videoClub.agregarPelicula(p)) {
                    JOptionPane.showMessageDialog(this, "Película agregada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Ya existe una película con ese ID o Título.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al agregar película: " + e.getMessage());
            }
        }
    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        List<Pelicula> peliculas = videoClub.getPeliculas();
        StringBuilder sb = new StringBuilder("Películas:\n");
        for (Pelicula p : peliculas) {
            sb.append(p.getIdPelicula()).append(" - ")
              .append(p.getTitulo()).append(" | ")
              .append(p.getGenero()).append(" | ")
              .append(p.getDirector()).append(" | Stock: ")
              .append(p.getStock()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }                                          

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID de la película a eliminar:");
        if (id != null && !id.trim().isEmpty()) {
            if (videoClub.eliminarPelicula(id.trim())) {
                JOptionPane.showMessageDialog(this, "Película eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la película.");
            }
        }
    }                                          

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        JTextField idField = new JTextField();
        JTextField nombreField = new JTextField();
        JTextField apellidoField = new JTextField();
        JTextField telField = new JTextField();
        JTextField emailField = new JTextField();
        Object[] message = {
            "ID:", idField,
            "Nombre:", nombreField,
            "Apellido:", apellidoField,
            "Teléfono:", telField,
            "Email:", emailField
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Registrar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String id = idField.getText().trim();
                String nombre = nombreField.getText().trim();
                String apellido = apellidoField.getText().trim();
                String tel = telField.getText().trim();
                String email = emailField.getText().trim();
                Cliente c = new Cliente(id, nombre, apellido, tel, email);
                if (videoClub.agregarCliente(c)) {
                    JOptionPane.showMessageDialog(this, "Cliente registrado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Ya existe un cliente con ese ID.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al registrar cliente: " + e.getMessage());
            }
        }
    }                                          

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente a eliminar:");
        if (id != null && !id.trim().isEmpty()) {
            videoClub.eliminarCliente(id.trim());
        }
    }                                          

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        List<Cliente> clientes = videoClub.getClientes();
        StringBuilder sb = new StringBuilder("Clientes:\n");
        for (Cliente c : clientes) {
            sb.append(c.getIdCliente()).append(": ")
              .append(c.getNombre()).append(" ")
              .append(c.getApellido()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }                                          

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente:");
        Cliente c = videoClub.buscarCliente(id);
        if (c != null) {
            JOptionPane.showMessageDialog(this, "ID: " + c.getIdCliente()
                + "\nNombre: " + c.getNombre()
                + "\nApellido: " + c.getApellido()
                + "\nTeléfono: " + c.getTelefono()
                + "\nEmail: " + c.getEmail());
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
        }
    }                                          

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String idCliente = JOptionPane.showInputDialog(this, "ID del Cliente:");
        Cliente cliente = videoClub.buscarCliente(idCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            return;
        }

        if (cliente instanceof DeudaCliente) {
            if (!((DeudaCliente)cliente).puedeArrendar()) {
                JOptionPane.showMessageDialog(this, "El cliente no puede arrendar por deuda o bloqueo.");
                return;
            }
        }

        
        String idPelicula = JOptionPane.showInputDialog(this, "ID de la Película:");
        Pelicula pelicula = videoClub.buscarPelicula(idPelicula);
        if (pelicula == null) {
            JOptionPane.showMessageDialog(this, "Película no encontrada.");
            return;
        }

        if (!pelicula.arrendar()) {
            JOptionPane.showMessageDialog(this, "Sin stock disponible para esta película.");
            return;
        }

        String idArriendo = "ARR-" + System.currentTimeMillis();
        String fechaArriendo = java.time.LocalDate.now().toString();
        Arriendo arriendo = new Arriendo(idArriendo, cliente, pelicula, fechaArriendo);

        videoClub.agregarArriendo(arriendo);
        cliente.agregarArriendo(arriendo);

        JOptionPane.showMessageDialog(this, "Arriendo agregado con éxito: " + idArriendo +
                "\nCliente: " + cliente.getIdCliente() +
                "\nPelícula: " + pelicula.getTitulo() +
                "\nFecha: " + fechaArriendo);
    }                                          

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String idArriendo = JOptionPane.showInputDialog(this, "ID del arriendo a eliminar:");
        if (idArriendo != null && !idArriendo.trim().isEmpty()) {
            videoClub.eliminarArriendo(idArriendo.trim());
        }
    }                                          

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String idCliente = JOptionPane.showInputDialog(this, "ID del Cliente:");
        Cliente cliente = videoClub.buscarCliente(idCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            return;
        }

        List<Arriendo> lista = cliente.getArriendosActivos();
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El cliente no tiene arriendos registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Arriendo a : lista) {
            Pelicula p = a.getPelicula();
            sb.append("- ").append(a.getIdArriendo())
                .append(" | Película: ").append(p != null ? p.getTitulo() : "(desconocida)")
                .append(" | Fecha arriendo: ").append(a.getFechaArriendo())
                .append(" | Fecha devolución: ").append(a.getFechaDevolucion())
                .append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }                                           

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String idArriendo = JOptionPane.showInputDialog(this, "ID del arriendo a devolver:");
        Arriendo arriendo = videoClub.buscarArriendo(idArriendo);
        if (arriendo != null && !arriendo.isDevuelto()) {
            String fechaDevolucion = JOptionPane.showInputDialog(this, "Fecha de devolución (YYYY-MM-DD):", java.time.LocalDate.now().toString());
            arriendo.marcarDevuelto(fechaDevolucion);
            JOptionPane.showMessageDialog(this, "Arriendo devuelto correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Arriendo no encontrado o ya devuelto.");
        }
    }                                           

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        List<String> deudores = videoClub.listarClientesConDeuda();
        if (deudores.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay clientes con deuda.");
        } else {
            StringBuilder sb = new StringBuilder("Clientes con deuda:\n");
            for (String s : deudores) sb.append(s).append("\n");
            JOptionPane.showMessageDialog(this, sb.toString());
        }
    }                                           

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente:");
        if (id == null || id.trim().isEmpty()) return;
        Cliente c = videoClub.buscarCliente(id);
        if (c == null || !(c instanceof DeudaCliente)) {
            String msg = videoClub.pagarDeudaCliente(id, 1);
            JOptionPane.showMessageDialog(this, msg);
            return;
        }
        DeudaCliente dc = (DeudaCliente) c;
        double deuda = dc.getMontoTotalMulta();
        if (deuda <= 0) {
            JOptionPane.showMessageDialog(this, "El cliente no tiene deudas pendientes.");
            return;
        }
        String[] opciones = {"Pagar parcial", "Pagar todo", "Cancelar"};
        int respuesta = JOptionPane.showOptionDialog(this,
                "La deuda actual del cliente es: $" + deuda + "\n¿Desea pagar un monto parcial o toda la deuda?",
                "Pago de Deuda",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);
        if (respuesta == 0) { 
            String montoStr = JOptionPane.showInputDialog(this, "Ingrese el monto a pagar:");
            if (montoStr == null) return;
            try {
                double monto = Double.parseDouble(montoStr);
                if (monto <= 0) throw new NumberFormatException();
                String msg = videoClub.pagarDeudaCliente(id, monto);
                JOptionPane.showMessageDialog(this, msg);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Monto inválido.");
            }
        } else if (respuesta == 1) {
            String msg = videoClub.pagarDeudaCliente(id, 0);
            JOptionPane.showMessageDialog(this, msg);
        }
    }                                           

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String reporte = videoClub.generarReporteCompleto();
        JOptionPane.showMessageDialog(this, reporte);
    }                                           

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        int arrendadas = 0;
        int disponibles = 0;
        for (Pelicula pelicula : videoClub.getPeliculas()) {
            if (pelicula.getTitulo().toLowerCase().contains("harry potter")) {
                arrendadas += pelicula.getVecesArrendada();
                disponibles += pelicula.getStock();
            }
        }
        String mensaje = "=== Estado de películas de Harry Potter ===\n"
                       + "Cantidad arrendada: " + arrendadas + "\n"
                       + "Cantidad disponible: " + disponibles;
        JOptionPane.showMessageDialog(this, mensaje, "Estado Harry Potter", JOptionPane.INFORMATION_MESSAGE);
    }                                           

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID de la película recomendada:");
        Pelicula p = videoClub.buscarPelicula(id);
        if (!(p instanceof PeliculaRecomendada)) {
            JOptionPane.showMessageDialog(this, "La película no es del tipo recomendada.");
            return;
        }
        PeliculaRecomendada pr = (PeliculaRecomendada) p;
        pr.registrarRecomendacion();
        JOptionPane.showMessageDialog(this, "¡Recomendación registrada!\nVeces recomendada: " + pr.getVecesRecomendada());
    }                                           

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String idPelicula = JOptionPane.showInputDialog(this, "Ingrese el ID de la película recomendada:");
        Pelicula p = videoClub.buscarPelicula(idPelicula);
        if (!(p instanceof PeliculaRecomendada)) {
            JOptionPane.showMessageDialog(this, "La película no es del tipo recomendada.");
            return;
        }
        PeliculaRecomendada pr = (PeliculaRecomendada) p;
        String idCliente = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente que da feedback:");
        String[] opciones = {"Sí, le gustó", "No le gustó"};
        int res = JOptionPane.showOptionDialog(this, "¿Le gustó la recomendación al cliente?", "Feedback",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        if (res == 0) {
            pr.registrarFeedback(idCliente, true);
            JOptionPane.showMessageDialog(this, "¡Feedback positivo registrado!");
        } else if (res == 1) {
            pr.registrarFeedback(idCliente, false);
            JOptionPane.showMessageDialog(this, "Feedback negativo registrado.");
        }
    }                                           

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID de la película recomendada:");
        Pelicula p = videoClub.buscarPelicula(id);
        if (!(p instanceof PeliculaRecomendada)) {
            JOptionPane.showMessageDialog(this, "La película no es del tipo recomendada.");
            return;
        }
        PeliculaRecomendada pr = (PeliculaRecomendada) p;
        JOptionPane.showMessageDialog(this, pr.toString());
    }                                           

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente:");
        if (id == null || id.trim().isEmpty()) return;

        String montoStr = JOptionPane.showInputDialog(this, "Ingrese el monto de la multa:");
        if (montoStr == null) return;

        double monto;
        try {
            monto = Double.parseDouble(montoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Monto inválido.");
            return;
        }

        String motivo = JOptionPane.showInputDialog(this, "Ingrese el motivo de la multa:");
        if (motivo == null || motivo.trim().isEmpty()) return;

        boolean exito = videoClub.agregarMultaCliente(id.trim(), monto, motivo);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Multa agregada correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo agregar la multa.");
        }
    }                                           

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration                   
}
