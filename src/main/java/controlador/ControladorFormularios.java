package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import vista.InterCliente;
import vista.InterEmpleado;
import vista.InterReservas;
import vista.InterServicio;
import vista.frmLogin;
import vista.frmMenu;

public class ControladorFormularios implements ActionListener {

    private frmMenu formularioMenu;
    public static JDesktopPane jDesktopPane_menu;

    public ControladorFormularios(frmMenu formularioMenu) {
        this.formularioMenu = formularioMenu;
        formularioMenu.setSize(new Dimension(1200, 700));
        formularioMenu.setExtendedState(formularioMenu.MAXIMIZED_BOTH);
        formularioMenu.setLocationRelativeTo(null);
        formularioMenu.setLayout(null);
        jDesktopPane_menu = new JDesktopPane();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.jDesktopPane_menu.setBounds(0, 0, ancho, (alto - 110));
        formularioMenu.add(jDesktopPane_menu);

        //Imagenes para el menu
        ImageIcon img1=new ImageIcon("src/main/java/vista/img-reserva.png");
        ImageIcon img2=new ImageIcon("src/main/java/vista/img-clasificacion.png");
        ImageIcon img3=new ImageIcon("src/main/java/vista/img-peluquero.png");
        ImageIcon img4=new ImageIcon("src/main/java/vista/img-estante.png");
        ImageIcon img5=new ImageIcon("src/main/java/vista/img-cerrar-sesion.png");
        frmMenu.jMenu1.setIcon(img1);
        frmMenu.jMenu2.setIcon(img2);
        frmMenu.jMenu3.setIcon(img3);
        frmMenu.jMenu4.setIcon(img4);
        frmMenu.jMenu5.setIcon(img5);
        
        this.formularioMenu.jMenuItem_Nuevo_Cliente.addActionListener(this);
        this.formularioMenu.jMenuItem_Cerrar_Session.addActionListener(this);
        this.formularioMenu.jMenuItem_Nuevo_Empleado.addActionListener(this);
        this.formularioMenu.jMenuItem_Nuevo_Servicio.addActionListener(this);
        this.formularioMenu.jMenuItem_Reserva.addActionListener(this);
    }

    public static boolean JInternalFrames_Abiertos(JInternalFrame jif) {
        JInternalFrame[] jif_Activos = jDesktopPane_menu.getAllFrames();
        //Este arreglo almacena todos los JInternalFrames que esten abierto en el jDesktopPane.
        for (int i = 0; i < jif_Activos.length; i++) {
            //Validamos con un if si nuestro arreglo en la posición i es igual al JInternalFrame que esta activo en el jDesktopPane, si es igual devolverá true.
            if (jif.getClass().isInstance(jif_Activos[i])) {
//                JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.", "Información", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "La ventana que esta intentando abrir ya esta abierta.");
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(formularioMenu.jMenuItem_Nuevo_Cliente)) {
            InterCliente interCliente = new InterCliente();
            if (JInternalFrames_Abiertos(interCliente) == false) {
                jDesktopPane_menu.add(interCliente);
                interCliente.setVisible(true);
            }
        }
        if (e.getSource().equals(formularioMenu.jMenuItem_Cerrar_Session)) {
            frmLogin formularioLogin = new frmLogin();
            formularioLogin.setVisible(true);
            formularioMenu.setVisible(false);
        }
        if (e.getSource().equals(formularioMenu.jMenuItem_Nuevo_Empleado)) {
            InterEmpleado intereEmpleado = new InterEmpleado();
            if (JInternalFrames_Abiertos(intereEmpleado) == false) {
                jDesktopPane_menu.add(intereEmpleado);
                intereEmpleado.setVisible(true);
            }
        }
        if (e.getSource().equals(formularioMenu.jMenuItem_Nuevo_Servicio)) {
            InterServicio intereServicio = new InterServicio();
            if (JInternalFrames_Abiertos(intereServicio) == false) {
                jDesktopPane_menu.add(intereServicio);
                intereServicio.setVisible(true);
            }
        }
        if (e.getSource().equals(formularioMenu.jMenuItem_Reserva)) {
            InterReservas intereReservas = new InterReservas();
            if (JInternalFrames_Abiertos(intereReservas) == false) {
                jDesktopPane_menu.add(intereReservas);
                intereReservas.setVisible(true);
            }
        }
    }

}
