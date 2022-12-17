package controlador;

import static controlador.ControladorFormularios.jDesktopPane_menu;
import dao.ServicioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.InterServicio;
import modelo.Servicio;
import vista.InterLeyenda;

public class ControladorServicios implements ActionListener,MouseListener{

    ValidarServicios validarServicios=new ValidarServicios();
    ServicioDao daoServicio=new ServicioDao();
    private InterServicio vistaServicio;
    DefaultTableModel modelo=new DefaultTableModel();
    JTable tabla;
    String idServicio,nom,dur;
    double cost;

    public ControladorServicios(InterServicio formularioServicio,JTable tabla) {
    this.vistaServicio=formularioServicio;
    this.tabla=tabla;
    this.vistaServicio.btnAgregar.addActionListener(this);
    this.vistaServicio.btnEliminar.addActionListener(this);
    this.vistaServicio.btnModificar.addActionListener(this);
    this.vistaServicio.btnListar.addActionListener(this);
    this.vistaServicio.btnLeyenda.addActionListener(this);
    tabla.addMouseListener(this);
        iniciar();
    }
    
    public void iniciar() {
        modelo.addColumn("IdServicio");
        modelo.addColumn("Nombre");
        modelo.addColumn("Duracion");
        modelo.addColumn("Costo");
        vistaServicio.tablaServicio.setModel(modelo);
        vistaServicio.tablaServicio.setRowHeight(30);
        vistaServicio.tablaServicio.setRowMargin(5);
    }
    
    public void LISTAR() {
        modelo.getDataVector().removeAllElements();
        vistaServicio.tablaServicio.updateUI();
        List<Servicio> list = daoServicio.listar();
        for (int i = 0; i < list.size(); i++) {
            Object o[] = {list.get(i).getId(), list.get(i).getNombre(), list.get(i).getDuracion(), list.get(i).getCosto()};
            modelo.addRow(o);
        }
    }
    
    public void recogerDatosServicios() {
        nom=validarServicios.nomServicio();
        dur=validarServicios.duracionServicio();
        cost=Double.parseDouble(validarServicios.costoServicio());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vistaServicio.btnLeyenda)){
            InterLeyenda interLeyenda = new InterLeyenda();
            if (ControladorFormularios.JInternalFrames_Abiertos(interLeyenda) == false) {
            jDesktopPane_menu.add(interLeyenda);
            interLeyenda.setVisible(true);
            }
        }
        if(e.getSource().equals(vistaServicio.btnAgregar)){
            if (validarServicios.cadena().length() == 0) {
                recogerDatosServicios();
                Servicio servicio=new Servicio(nom, dur, cost);
                String msg = daoServicio.agregar(servicio);
                if (msg.equals("AGREGADO")) {
                    JOptionPane.showMessageDialog(null, "Se agrego el registro correctamente");
                    LISTAR();
                    validarServicios.limpiarDatosServicio();
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de registro: "+msg);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Corregir campos selecionados");
            }
        }
        
        if (e.getSource().equals(vistaServicio.btnListar)) {
             LISTAR();
        }
        
        if (e.getSource().equals(vistaServicio.btnEliminar)) {
            int filaEliminar = vistaServicio.tablaServicio.getSelectedRow();
            if (filaEliminar >= 0) {
                int codigo = Integer.parseInt(vistaServicio.tablaServicio.getValueAt(filaEliminar, 0).toString());
                String msg = daoServicio.eliminar(codigo);
                if (msg == null) {
                    JOptionPane.showMessageDialog(null, "Se elimino el registro satifactoriamente");
                    LISTAR();
                    validarServicios.limpiarDatosServicio();
                } else {
                    JOptionPane.showMessageDialog(null, msg);
                    validarServicios.limpiarDatosServicio();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione una fila para eliminar.");
                validarServicios.limpiarDatosServicio();
            }
        }
        
        if (e.getSource().equals(vistaServicio.btnModificar)) {
            int filaEditar = tabla.getSelectedRow();
            if (filaEditar >= 0) {
                if (validarServicios.cadena().length() == 0) {
                    Servicio s = new Servicio();
                    s.setNombre(validarServicios.nomServicio());
                    s.setId(Integer.parseInt(tabla.getValueAt(filaEditar, 0).toString()));
                    s.setCosto(Double.parseDouble(validarServicios.costoServicio()));
                    s.setDuracion(validarServicios.duracionServicio());
                    String msj = daoServicio.modificar(s);
                    if (msj==null) {
                        JOptionPane.showMessageDialog(null, "Modificado correctamente");
                        LISTAR();
                        validarServicios.limpiarDatosServicio();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se modifico: "+msj);
                        LISTAR();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Corregir campos selecionados");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione una fila para Modificar");
                LISTAR();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = tabla.getSelectedRow();
        if (fila != -1) {
            validarServicios.limpiarMouseClick();
            InterServicio.txtNombreServicio.setText(tabla.getValueAt(fila, 1).toString());
            InterServicio.txtDuraccionServicio.setText(tabla.getValueAt(fila, 2).toString());
            InterServicio.txtCostoServicio.setText(tabla.getValueAt(fila, 3).toString());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
