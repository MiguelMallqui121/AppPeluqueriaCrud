package controlador;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Empleado;
import vista.frmLogin;
import static vista.frmLogin.cbCargo;
import static vista.frmLogin.txtPassword;
import static vista.frmLogin.txtUserName;
import vista.frmMenu;
import dao.EmpleadoDao;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class ControladorLogin implements ActionListener{

    private frmLogin vistaLogin;
    EmpleadoDao daoEmpleado=new EmpleadoDao();

    public ControladorLogin(frmLogin vistaLogin) {
        this.vistaLogin=vistaLogin;
        this.vistaLogin.setResizable(false);
        this.vistaLogin.setLocationRelativeTo(null);
        this.vistaLogin.setTitle("Login - Sistema de Reservas para Peluquería");
        this.vistaLogin.btnLogin.addActionListener(this);
        
        //Imagenes para el Login
        ImageIcon img1=new ImageIcon("src/main/java/vista/img-peluq.png");
        ImageIcon img2=new ImageIcon("src/main/java/vista/img-usuario.png");
        ImageIcon img3=new ImageIcon("src/main/java/vista/img-contrasena.png");
        frmLogin.lbImg1.setIcon(img1);
        frmLogin.lbImg2.setIcon(img2);
        frmLogin.lbImg3.setIcon(img3);
        
        //Look and feel Mejora la Apariencia de la aplicación
        FlatLightLaf.setup();
        UIManager.put( "Table.background", Color.WHITE);
        UIManager.put( "Table.selectionForeground", Color.WHITE);
        UIManager.put( "Table.selectionBackground", new Color(236, 176, 40 ));
        UIManager.put( "Table.selectionInactiveForeground",Color.WHITE);
        UIManager.put( "Table.selectionInactiveBackground",new Color(236, 176, 40 ));
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vistaLogin.btnLogin)){
            //Para ver si el valor no esta vacio
        if(!txtUserName.getText().isEmpty() && !txtPassword.getText().isEmpty()){
            Empleado ep=new Empleado();
            //trim elimina los espacios
            ep.setUsername(txtUserName.getText().trim());
            ep.setPassword(txtPassword.getText().trim());
            ep.setCargo(cbCargo.getSelectedIndex());
            if(daoEmpleado.ValidarEmpleado(ep)==1){
                JOptionPane.showMessageDialog(null, "Usuario Correcto");
                frmMenu fm=new frmMenu();
                //Ingresar como
                if(cbCargo.getSelectedIndex()==0){
                    //Empleado
                    fm.jMenu4.setVisible(false);//servicio
                    fm.jMenu3.setVisible(false);//empleado
                    fm.setVisible(true);
                    this.vistaLogin.setVisible(false);
                }else{
                    //Administrador
                    fm.setVisible(true);
                    this.vistaLogin.setVisible(false);
                }               
            }else{
                JOptionPane.showMessageDialog(null, "Usuario Incorrecto");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese sus datos");
        }
        }
    }
    
}
