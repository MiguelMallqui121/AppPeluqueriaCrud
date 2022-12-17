package controlador;

import java.awt.Color;
import javax.swing.ImageIcon;
import vista.InterServicio;

public class ValidarServicios {
    public String nomServicio(){
        String nomServicio=InterServicio.txtNombreServicio.getText().toUpperCase().trim();
        return nomServicio;
    }
    public String costoServicio(){
        String costoServicio=InterServicio.txtCostoServicio.getText();
        return costoServicio;
    }
    public String duracionServicio(){
        String duracionServicio=InterServicio.txtDuraccionServicio.getText();
        return duracionServicio;
    }
    
    public void limpiarDatosServicio(){
        ImageIcon icon=new ImageIcon("");
        InterServicio.txtCostoServicio.setText("");
        InterServicio.txtDuraccionServicio.setText("");
        InterServicio.txtNombreServicio.setText("");
        
        InterServicio.lbMensajeNomServicio.setText("");
        InterServicio.lbMensajeCostoServicio.setText("");
        InterServicio.lbMensajeDuracionServicio.setText("");
        
        InterServicio.lbIcon1.setIcon(icon);
        InterServicio.lbIcon2.setIcon(icon);
        InterServicio.lbIcon3.setIcon(icon);
    }
    
    public void limpiarMouseClick(){
        ImageIcon icon=new ImageIcon("");
        InterServicio.lbMensajeNomServicio.setText("");
        InterServicio.lbMensajeCostoServicio.setText("");
        InterServicio.lbMensajeDuracionServicio.setText("");
        
        InterServicio.lbIcon1.setIcon(icon);
        InterServicio.lbIcon2.setIcon(icon);
        InterServicio.lbIcon3.setIcon(icon);
    }
    
     public String cadena(){
        String cad="";
        ImageIcon iconClose=new ImageIcon("src/main/java/vista/img-close.png");
        ImageIcon iconTrue=new ImageIcon("src/main/java/vista/img-check.png");
        if(!nomServicio().matches("[A-Za-z ñÑ áéíóúÁÉÍÓÚ]+")){
            InterServicio.lbMensajeNomServicio.setText("Solo letras");
            InterServicio.lbMensajeNomServicio.setForeground(new Color(199, 52, 52 ));
            InterServicio.lbIcon1.setIcon(iconClose);
            cad+="m";
        }else{
            InterServicio.lbMensajeNomServicio.setForeground(new Color(52, 199, 89 ));
            InterServicio.lbMensajeNomServicio.setText("Dato correcto");
            InterServicio.lbIcon1.setIcon(iconTrue);
            cad+="";
        }
        if(!costoServicio().matches("^([0-9]{1,3}\\.[0-9]{1})$")){
            InterServicio.lbMensajeCostoServicio.setText("Solo formato costo");
            InterServicio.lbMensajeCostoServicio.setForeground(new Color(199, 52, 52 ));
            InterServicio.lbIcon3.setIcon(iconClose);
            cad+="m";
        }else{
            InterServicio.lbMensajeCostoServicio.setForeground(new Color(52, 199, 89 ));
            InterServicio.lbMensajeCostoServicio.setText("Dato correcto");
            InterServicio.lbIcon3.setIcon(iconTrue);
            cad+="";
        }
        if(!duracionServicio().matches("^(0[0-2]):[0-5][0-5]:[0][0]$")){
            InterServicio.lbMensajeDuracionServicio.setText("En formato hora, minuto y segundo");
            InterServicio.lbMensajeDuracionServicio.setForeground(new Color(199, 52, 52 ));
            InterServicio.lbIcon2.setIcon(iconClose);
            cad+="m";
        }else{
            InterServicio.lbMensajeDuracionServicio.setForeground(new Color(52, 199, 89 ));
            InterServicio.lbMensajeDuracionServicio.setText("Dato correcto");
            InterServicio.lbIcon2.setIcon(iconTrue);
            cad+="";
        }
        return cad;
     }
}
