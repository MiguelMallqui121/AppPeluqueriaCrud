package vista;

import controlador.ControladorFormularios;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class frmMenu extends javax.swing.JFrame {
    
    public frmMenu() {
        initComponents();
        controlador.ControladorFormularios controladorFormulario=new ControladorFormularios(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_Reserva = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem_Nuevo_Cliente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem_Nuevo_Empleado = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem_Nuevo_Servicio = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem_Cerrar_Session = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\Integrador1-AppPeluqueria\\AppPeluqueriaCrud\\src\\main\\java\\vista\\img-reserva.png")); // NOI18N
        jMenu1.setText("Reservas");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_Reserva.setText("Reserva");
        jMenuItem_Reserva.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_Reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ReservaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_Reserva);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\Prueba\\AppPeluqueria\\src\\main\\java\\vista\\img-clasificacion.png")); // NOI18N
        jMenu2.setText("Cliente");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_Nuevo_Cliente.setText("Nuevo Cliente");
        jMenuItem_Nuevo_Cliente.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_Nuevo_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Nuevo_ClienteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_Nuevo_Cliente);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\Prueba\\AppPeluqueria\\src\\main\\java\\vista\\img-peluquero.png")); // NOI18N
        jMenu3.setText("Empleado");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_Nuevo_Empleado.setText("Nuevo Empleado");
        jMenuItem_Nuevo_Empleado.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_Nuevo_Empleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Nuevo_EmpleadoActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem_Nuevo_Empleado);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\Prueba\\AppPeluqueria\\src\\main\\java\\vista\\img-estante.png")); // NOI18N
        jMenu4.setText("Servicio");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem_Nuevo_Servicio.setText("Nuevo Servicio");
        jMenuItem_Nuevo_Servicio.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_Nuevo_Servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Nuevo_ServicioActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem_Nuevo_Servicio);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\Prueba\\AppPeluqueria\\src\\main\\java\\vista\\img-cerrar-sesion.png")); // NOI18N
        jMenu5.setText("Cerrar Sessión");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jMenuItem_Cerrar_Session.setText("Cerrar Sessión");
        jMenuItem_Cerrar_Session.setPreferredSize(new java.awt.Dimension(180, 30));
        jMenuItem_Cerrar_Session.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_Cerrar_SessionActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem_Cerrar_Session);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_Nuevo_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Nuevo_ClienteActionPerformed

    }//GEN-LAST:event_jMenuItem_Nuevo_ClienteActionPerformed

    private void jMenuItem_Nuevo_EmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Nuevo_EmpleadoActionPerformed
        
    }//GEN-LAST:event_jMenuItem_Nuevo_EmpleadoActionPerformed

    private void jMenuItem_Nuevo_ServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Nuevo_ServicioActionPerformed
        
    }//GEN-LAST:event_jMenuItem_Nuevo_ServicioActionPerformed

    private void jMenuItem_Cerrar_SessionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_Cerrar_SessionActionPerformed

    }//GEN-LAST:event_jMenuItem_Cerrar_SessionActionPerformed

    private void jMenuItem_ReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ReservaActionPerformed

    }//GEN-LAST:event_jMenuItem_ReservaActionPerformed

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
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu jMenu1;
    public static javax.swing.JMenu jMenu2;
    public static javax.swing.JMenu jMenu3;
    public static javax.swing.JMenu jMenu4;
    public static javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem_Cerrar_Session;
    public javax.swing.JMenuItem jMenuItem_Nuevo_Cliente;
    public javax.swing.JMenuItem jMenuItem_Nuevo_Empleado;
    public javax.swing.JMenuItem jMenuItem_Nuevo_Servicio;
    public javax.swing.JMenuItem jMenuItem_Reserva;
    // End of variables declaration//GEN-END:variables
}
