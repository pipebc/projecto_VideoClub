
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Inicio extends javax.swing.JFrame {

    private VideoClub videoClub;
    
    public Inicio() {
        videoClub = new VideoClub(); // Carga las películas automáticamente
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();

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

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
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
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
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
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID de la película a eliminar:");
        if (id != null && !id.trim().isEmpty()) {
            if (videoClub.eliminarPelicula(id.trim())) {
                JOptionPane.showMessageDialog(this, "Película eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la película.");
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
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
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del cliente a eliminar:");
        if (id != null && !id.trim().isEmpty()) {
            videoClub.eliminarCliente(id.trim());
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        List<Cliente> clientes = videoClub.getClientes();
        StringBuilder sb = new StringBuilder("Clientes:\n");
        for (Cliente c : clientes) {
            sb.append(c.getIdCliente()).append(": ")
              .append(c.getNombre()).append(" ")
              .append(c.getApellido()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
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
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        String idCliente = JOptionPane.showInputDialog(this, "ID del Cliente:");
        Cliente cliente = videoClub.buscarCliente(idCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.");
            return;
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
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        String idArriendo = JOptionPane.showInputDialog(this, "ID del arriendo a eliminar:");
        if (idArriendo != null && !idArriendo.trim().isEmpty()) {
            videoClub.eliminarArriendo(idArriendo.trim());
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
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
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        String idArriendo = JOptionPane.showInputDialog(this, "ID del arriendo a devolver:");
        Arriendo arriendo = videoClub.buscarArriendo(idArriendo);
        if (arriendo != null && !arriendo.isDevuelto()) {
            String fechaDevolucion = JOptionPane.showInputDialog(this, "Fecha de devolución (YYYY-MM-DD):", java.time.LocalDate.now().toString());
            arriendo.marcarDevuelto(fechaDevolucion);
            JOptionPane.showMessageDialog(this, "Arriendo devuelto correctamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Arriendo no encontrado o ya devuelto.");
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
