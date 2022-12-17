package controlador;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import vista.InterCliente;

public class ValidarCliente {

    public String nomCliente(){
        String nombreCliente=InterCliente.txtNombreCliente.getText().toUpperCase().trim();
        return nombreCliente;
    }
    public String apellidoCliente(){
        String apellidoCliente=InterCliente.txtApellidoCliente.getText().toUpperCase().trim();
        return apellidoCliente;
    }
    public String direccionCliente(){
        String direccionCliente=InterCliente.txtDireccionCliente.getText().toUpperCase().trim();
        return direccionCliente;
    }
    public String celularCliente(){
        String celularCliente=InterCliente.txtCelularCliente.getText();
        return celularCliente;
    }
    public String correoCliente(){
        String correoCliente=InterCliente.txtCorreoCliente.getText().trim();
        return correoCliente;
    }
    public int cbDistritoCliente(){
        int cbDistrito=InterCliente.cbDistritoCliente.getSelectedIndex();
        return cbDistrito;
    }
    public String nomDistritoCliente(){
        String nomDistrito=InterCliente.cbDistritoCliente.getSelectedItem().toString().trim();
        return nomDistrito;
    }
    
    public void limpiarDatosCliente(){
        ImageIcon icon=new ImageIcon("");
        InterCliente.txtNombreCliente.setText("");
        InterCliente.txtApellidoCliente.setText("");
        InterCliente.txtCelularCliente.setText("");
        InterCliente.txtCorreoCliente.setText("");
        InterCliente.txtDireccionCliente.setText("");
        InterCliente.cbDistritoCliente.setSelectedItem("Elegir");
        
        InterCliente.lbMensajeNomCliente.setText("");
        InterCliente.lbMensajeApeCliente.setText("");
        InterCliente.lbMensajeCelCliente.setText("");
        InterCliente.lbMensajeCorreoCliente.setText("");
        InterCliente.lbMensajeDirCliente.setText("");
        
        InterCliente.lbIcon1.setIcon(icon);
        InterCliente.lbIcon2.setIcon(icon);
        InterCliente.lbIcon3.setIcon(icon);
        InterCliente.lbIcon4.setIcon(icon);
        InterCliente.lbIcon5.setIcon(icon);
    }
    
    public void limpiarMouserClick(){
        ImageIcon icon=new ImageIcon("");
        InterCliente.lbMensajeNomCliente.setText("");
        InterCliente.lbMensajeApeCliente.setText("");
        InterCliente.lbMensajeCelCliente.setText("");
        InterCliente.lbMensajeCorreoCliente.setText("");
        InterCliente.lbMensajeDirCliente.setText("");
        
        InterCliente.lbIcon1.setIcon(icon);
        InterCliente.lbIcon2.setIcon(icon);
        InterCliente.lbIcon3.setIcon(icon);
        InterCliente.lbIcon4.setIcon(icon);
        InterCliente.lbIcon5.setIcon(icon);
    }
    
    public String cadena(){
        String cad="";
        ImageIcon iconClose=new ImageIcon("src/main/java/vista/img-close.png");
        ImageIcon iconTrue=new ImageIcon("src/main/java/vista/img-check.png");
        if(!nomCliente().matches("[A-Za-z ñÑ áéíóúÁÉÍÓÚ]+")){
            InterCliente.lbMensajeNomCliente.setText("Solo letras");
            InterCliente.lbMensajeNomCliente.setForeground(new Color(199, 52, 52 ));
            InterCliente.lbIcon1.setIcon(iconClose);
            cad+="m";
        }else{
            InterCliente.lbMensajeNomCliente.setForeground(new Color(52, 199, 89 ));
            InterCliente.lbMensajeNomCliente.setText("Dato correcto");
            InterCliente.lbIcon1.setIcon(iconTrue);
            cad+="";
        }
        if(!apellidoCliente().matches("[A-Za-z ñÑ áéíóúÁÉÍÓÚ]+")){
            InterCliente.lbMensajeApeCliente.setText("Solo letras");
            InterCliente.lbMensajeApeCliente.setForeground(new Color(199, 52, 52 ));
            InterCliente.lbIcon3.setIcon(iconClose);
            cad+="m";
        }else{
            InterCliente.lbMensajeApeCliente.setForeground(new Color(52, 199, 89 ));
            InterCliente.lbMensajeApeCliente.setText("Dato correcto");
            InterCliente.lbIcon3.setIcon(iconTrue);
            cad+="";
        }
        if(!direccionCliente().matches("[a-z A-Z 0-9 . -]+$")){
            InterCliente.lbMensajeDirCliente.setText("Solo formato dirección");
            InterCliente.lbMensajeDirCliente.setForeground(new Color(199, 52, 52 ));
            InterCliente.lbIcon4.setIcon(iconClose);
            cad+="m";
        }else{
            InterCliente.lbMensajeDirCliente.setForeground(new Color(52, 199, 89 ));
            InterCliente.lbMensajeDirCliente.setText("Dato correcto");
            InterCliente.lbIcon4.setIcon(iconTrue);
            cad+="";
        }
        if(!celularCliente().matches("[9]+\\d{8}$")){
            InterCliente.lbMensajeCelCliente.setForeground(new Color(199, 52, 52 ));
            InterCliente.lbMensajeCelCliente.setText("Solo formato celular");
            InterCliente.lbIcon2.setIcon(iconClose);
            cad+="m";
        }else{
            InterCliente.lbMensajeCelCliente.setForeground(new Color(52, 199, 89 ));
            InterCliente.lbMensajeCelCliente.setText("Dato correcto");
            InterCliente.lbIcon2.setIcon(iconTrue);
            cad+="";
        }
        if(!correoCliente().matches("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+")){
            InterCliente.lbMensajeCorreoCliente.setForeground(new Color(199, 52, 52 ));
            InterCliente.lbMensajeCorreoCliente.setText("Solo formato correo");
            InterCliente.lbIcon5.setIcon(iconClose);
            cad+="m";
        }else{
            InterCliente.lbMensajeCorreoCliente.setForeground(new Color(52, 199, 89 ));
            InterCliente.lbMensajeCorreoCliente.setText("Dato correcto");
            InterCliente.lbIcon5.setIcon(iconTrue);
            cad+="";
        }
        if(cbDistritoCliente()==0){
            JOptionPane.showMessageDialog(null, "Selecionar el distrito");
            cad+="m";
        }else{
            cad+="";
        }
        return cad;
    }
    
}
