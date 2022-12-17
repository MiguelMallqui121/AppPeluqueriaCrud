package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vista.InterCliente;
import vista.InterEmpleado;

public class ValidarEmpleado{

    public String nomEmpleado(){
        String nombreEmpleado=InterEmpleado.txtNombreEmpleado.getText().toUpperCase().trim();
        return nombreEmpleado;
    }
    public String apellidoEmpleado(){
        String apellidoEmpleado=InterEmpleado.txtApellidoEmpleado.getText().toUpperCase().trim();
        return apellidoEmpleado;
    }
    public String direccionEmpleado(){
        String direccionEmpleado=InterEmpleado.txtDireccionEmpleado.getText().toUpperCase().trim();
        return direccionEmpleado;
    }
    public String celularEmpleado(){
        String celularEmpleado=InterEmpleado.txtCelularEmpleado.getText();
        return celularEmpleado;
    }
    public String correoEmpleado(){
        String correoEmpleado=InterEmpleado.txtCorreoEmpleado.getText().trim();
        return correoEmpleado;
    }
    public String usernameEmpleado(){
        String usernameEmpleado=InterEmpleado.txtUsuarioEmpleado.getText().trim();
        return usernameEmpleado;
    }
    public String passwordEmpleado(){
        String passwordEmpleado=InterEmpleado.txtPasswordEmpleado.getText().trim();
        return passwordEmpleado;
    }
    
    public int cbDistrito(){
        int cbDistrito=InterEmpleado.cbDistritoEmpleado.getSelectedIndex();
        return cbDistrito;
    }
    public String nomDistritoEmpleado(){
        String nomDistrito=InterEmpleado.cbDistritoEmpleado.getSelectedItem().toString().trim();
        return nomDistrito;
    }
    public int cbCargoEmpleado(){
        int cbCargoEmpleado=InterEmpleado.cbCargoEmpleado.getSelectedIndex();
        return cbCargoEmpleado;
    }
    public String nomCargoEmpleado(){
        String nomCargoEmpleado=InterEmpleado.cbCargoEmpleado.getSelectedItem().toString();
        return nomCargoEmpleado;
    }
    
    public void limpiarDatosEmpleado(){
        ImageIcon icon=new ImageIcon("");
        InterEmpleado.txtNombreEmpleado.setText("");
        InterEmpleado.txtApellidoEmpleado.setText("");
        InterEmpleado.txtCelularEmpleado.setText("");
        InterEmpleado.txtCorreoEmpleado.setText("");
        InterEmpleado.txtDireccionEmpleado.setText("");
        InterEmpleado.cbDistritoEmpleado.setSelectedItem("Elegir");
        InterEmpleado.txtUsuarioEmpleado.setText("");
        InterEmpleado.txtPasswordEmpleado.setText("");
        
        InterEmpleado.lbMensajeNomEmpleado.setText("");
        InterEmpleado.lbMensajeApeEmpleado.setText("");
        InterEmpleado.lbMensajeCelEmpleado.setText("");
        InterEmpleado.lbMensajeCorreoEmpleado.setText("");
        InterEmpleado.lbMensajeDirEmpleado.setText("");
        InterEmpleado.lbMensajeDistritoEmpleado.setText("");
        InterEmpleado.lbMensajeUsuarioEmpleado.setText("");
        InterEmpleado.lbMensajePasswordEmpleado.setText("");
        
        InterEmpleado.lbIcon1.setIcon(icon);
        InterEmpleado.lbIcon2.setIcon(icon);
        InterEmpleado.lbIcon3.setIcon(icon);
        InterEmpleado.lbIcon4.setIcon(icon);
        InterEmpleado.lbIcon5.setIcon(icon);
        InterEmpleado.lbIcon6.setIcon(icon);
        InterEmpleado.lbIcon7.setIcon(icon);
    }
    
    public void limpiarMouseClick(){
        ImageIcon icon=new ImageIcon("");
        InterEmpleado.lbMensajeNomEmpleado.setText("");
        InterEmpleado.lbMensajeApeEmpleado.setText("");
        InterEmpleado.lbMensajeCelEmpleado.setText("");
        InterEmpleado.lbMensajeCorreoEmpleado.setText("");
        InterEmpleado.lbMensajeDirEmpleado.setText("");
        InterEmpleado.lbMensajeDistritoEmpleado.setText("");
        InterEmpleado.lbMensajeUsuarioEmpleado.setText("");
        InterEmpleado.lbMensajePasswordEmpleado.setText("");
        
        InterEmpleado.lbIcon1.setIcon(icon);
        InterEmpleado.lbIcon2.setIcon(icon);
        InterEmpleado.lbIcon3.setIcon(icon);
        InterEmpleado.lbIcon4.setIcon(icon);
        InterEmpleado.lbIcon5.setIcon(icon);
        InterEmpleado.lbIcon6.setIcon(icon);
        InterEmpleado.lbIcon7.setIcon(icon);
    }
    
    public String cadena(){
        String cad="";
        ImageIcon iconClose=new ImageIcon("src/main/java/vista/img-close.png");
        ImageIcon iconTrue=new ImageIcon("src/main/java/vista/img-check.png");
        if(!nomEmpleado().matches("[A-Za-z ñÑ áéíóúÁÉÍÓÚ]+")){
            InterEmpleado.lbMensajeNomEmpleado.setText("Solo se admiten letras");
            InterEmpleado.lbMensajeNomEmpleado.setForeground(new Color(199, 52, 52 ));
            InterEmpleado.lbIcon1.setIcon(iconClose);
            cad+="m";
        }else{
            InterEmpleado.lbMensajeNomEmpleado.setForeground(new Color(52, 199, 89 ));
            InterEmpleado.lbMensajeNomEmpleado.setText("Dato correcto");
            InterEmpleado.lbIcon1.setIcon(iconTrue);
            cad+="";
        }
        if(!apellidoEmpleado().matches("[A-Za-z ñÑ áéíóúÁÉÍÓÚ]+")){
            InterEmpleado.lbMensajeApeEmpleado.setText("Solo letras");
            InterEmpleado.lbMensajeApeEmpleado.setForeground(new Color(199, 52, 52 ));
            InterEmpleado.lbIcon3.setIcon(iconClose);
            cad+="m";
        }else{
            InterEmpleado.lbMensajeApeEmpleado.setForeground(new Color(52, 199, 89 ));
            InterEmpleado.lbMensajeApeEmpleado.setText("Dato correcto");
            InterEmpleado.lbIcon3.setIcon(iconTrue);
            cad+="";
        }
        if(!direccionEmpleado().matches("[a-z A-Z 0-9 . - ,]+$")){
            InterEmpleado.lbMensajeDirEmpleado.setText("Solo formato dirección");
            InterEmpleado.lbMensajeDirEmpleado.setForeground(new Color(199, 52, 52 ));
            InterEmpleado.lbIcon4.setIcon(iconClose);
            cad+="m";
        }else{
            InterEmpleado.lbMensajeDirEmpleado.setForeground(new Color(52, 199, 89 ));
            InterEmpleado.lbMensajeDirEmpleado.setText("Dato correcto");
            InterEmpleado.lbIcon4.setIcon(iconTrue);
            cad+="";
        }
        if(!celularEmpleado().matches("[9]+\\d{8}$")){
            InterEmpleado.lbMensajeCelEmpleado.setForeground(new Color(199, 52, 52 ));
            InterEmpleado.lbMensajeCelEmpleado.setText("Solo formato celular");
            InterEmpleado.lbIcon2.setIcon(iconClose);
            cad+="m";
        }else{
            InterEmpleado.lbMensajeCelEmpleado.setForeground(new Color(52, 199, 89 ));
            InterEmpleado.lbMensajeCelEmpleado.setText("Dato correcto");
            InterEmpleado.lbIcon2.setIcon(iconTrue);
            cad+="";
        }
        if(!correoEmpleado().matches("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+")){
            InterEmpleado.lbMensajeCorreoEmpleado.setForeground(new Color(199, 52, 52 ));
            InterEmpleado.lbMensajeCorreoEmpleado.setText("Solo formato correo");
            InterEmpleado.lbIcon5.setIcon(iconClose);
            cad+="m";
        }else{
            InterEmpleado.lbMensajeCorreoEmpleado.setForeground(new Color(52, 199, 89 ));
            InterEmpleado.lbMensajeCorreoEmpleado.setText("Dato correcto");
            InterEmpleado.lbIcon5.setIcon(iconTrue);
            cad+="";
        }
        if(!usernameEmpleado().matches("[a-zA-Z0-9]+")){
            InterEmpleado.lbMensajeUsuarioEmpleado.setForeground(new Color(199, 52, 52 ));
            InterEmpleado.lbMensajeUsuarioEmpleado.setText("Solo formato usuario");
            InterEmpleado.lbIcon6.setIcon(iconClose);
            cad+="m";
        }else{
            InterEmpleado.lbMensajeUsuarioEmpleado.setForeground(new Color(52, 199, 89 ));
            InterEmpleado.lbMensajeUsuarioEmpleado.setText("Dato correcto");
            InterEmpleado.lbIcon6.setIcon(iconTrue);
            cad+="";
        }
        
        String PASSWORD_SPECIAL_CHARS = "@#$%^`<>&+=\"!ºª·#~%&'¿¡€,:;*/+-.=_\\[\\]\\(\\)\\|\\_\\?\\\\";
        int PASSWORD_MIN_SIZE = 8;
        String PASSWORD_REGEXP = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[" + PASSWORD_SPECIAL_CHARS + "])(?=\\S+$).{"+PASSWORD_MIN_SIZE+",}$";

        if(!passwordEmpleado().matches(PASSWORD_REGEXP)){
            InterEmpleado.lbMensajePasswordEmpleado.setForeground(new Color(199, 52, 52 ));
            InterEmpleado.lbMensajePasswordEmpleado.setText("Solo formato password");
            InterEmpleado.lbIcon7.setIcon(iconClose);
            cad+="m";
        }else{
            InterEmpleado.lbMensajePasswordEmpleado.setForeground(new Color(52, 199, 89 ));
            InterEmpleado.lbMensajePasswordEmpleado.setText("Dato correcto");
            InterEmpleado.lbIcon7.setIcon(iconTrue);
            cad+="";
        }
        
        if(cbDistrito()==0){
            InterEmpleado.lbMensajeDistritoEmpleado.setForeground(new Color(199, 52, 52 ));
            InterEmpleado.lbMensajeDistritoEmpleado.setText("Selecione distrito");
            cad+="m";
        }else{
            InterEmpleado.lbMensajeDistritoEmpleado.setForeground(new Color(52, 199, 89 ));
            InterEmpleado.lbMensajeDistritoEmpleado.setText("Dato correcto");
            cad+="";
        }
        return cad;
    }
    
}
