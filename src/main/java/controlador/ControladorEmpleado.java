package controlador;

import static controlador.ControladorFormularios.jDesktopPane_menu;
import dao.EmpleadoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Empleado;
import vista.InterCliente;
import vista.InterEmpleado;
import vista.InterLeyenda;

public class ControladorEmpleado implements ActionListener, MouseListener{

    ValidarEmpleado validarEmpleado=new ValidarEmpleado();
    EmpleadoDao daoEmpleado=new EmpleadoDao();
    private InterEmpleado vistaEmpleado;
    DefaultTableModel modelo = new DefaultTableModel();
    JTable tabla;
    String id, nom, ap, co, dis, dir,user, password,nomCargo;
    int cel,cargo;
    
    public ControladorEmpleado(InterEmpleado vistaEmpleado,JTable tabla) {
        this.vistaEmpleado=vistaEmpleado;
        this.tabla = tabla;
        this.vistaEmpleado.btnAgregar.addActionListener(this);
        this.vistaEmpleado.btnModificar.addActionListener(this);
        this.vistaEmpleado.btnListar.addActionListener(this);
        this.vistaEmpleado.btnEliminar.addActionListener(this);
        this.vistaEmpleado.btnLeyenda.addActionListener(this);
        tabla.addMouseListener(this);
        iniciar();
    }
    
    public void iniciar() {
        modelo.addColumn("IdCliente");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Correo");
        modelo.addColumn("Celular");
        modelo.addColumn("Distrito");
        modelo.addColumn("Dirección");
        modelo.addColumn("Usuario");
        modelo.addColumn("Password");
        modelo.addColumn("Cargo");
        vistaEmpleado.tablaEmpleado.setModel(modelo);
        vistaEmpleado.tablaEmpleado.setRowHeight(30);
        vistaEmpleado.tablaEmpleado.setRowMargin(5);
    }
    
    public void LISTAR() {
        modelo.getDataVector().removeAllElements();
        vistaEmpleado.tablaEmpleado.updateUI();
        List<Empleado> list = daoEmpleado.listar();
        for (int i = 0; i < list.size(); i++) {
            Object o[] = {list.get(i).getCodE(), list.get(i).getNombre(), list.get(i).getApellido(), list.get(i).getCorreo(), list.get(i).getCelular(), list.get(i).getDistrito(), list.get(i).getDireccion(), list.get(i).getUsername(),list.get(i).getPassword(),list.get(i).getCargo()};
            modelo.addRow(o);
        }
    }
    
    public void recogerDatosCliente() {
        nom = validarEmpleado.nomEmpleado();
        ap = validarEmpleado.apellidoEmpleado();
        co = validarEmpleado.correoEmpleado();
        cel = Integer.parseInt(validarEmpleado.celularEmpleado());
        dis = validarEmpleado.nomDistritoEmpleado();
        dir = validarEmpleado.direccionEmpleado();
        user = validarEmpleado.usernameEmpleado();
        password = validarEmpleado.passwordEmpleado();
        nomCargo = validarEmpleado.nomCargoEmpleado();
        cargo=validarEmpleado.cbCargoEmpleado();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vistaEmpleado.btnLeyenda)) {
            InterLeyenda interLeyenda = new InterLeyenda();
            if (ControladorFormularios.JInternalFrames_Abiertos(interLeyenda) == false) {
            jDesktopPane_menu.add(interLeyenda);
            interLeyenda.setVisible(true);
            }
        }
        if (e.getSource().equals(vistaEmpleado.btnAgregar)) {
            if (validarEmpleado.cadena().length() == 0) {
                recogerDatosCliente();
                Empleado empleado=new Empleado(nom, ap, co, cel, dis, dir, user, password, cargo);
                String msg = daoEmpleado.agregar(empleado);
                if (msg.equals("AGREGADO")) {
                    JOptionPane.showMessageDialog(null, "Se agrego el registro correctamente");
                    LISTAR();
                    validarEmpleado.limpiarDatosEmpleado();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario: "+msg);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Corregir campos selecionados");
            }
        }
       
        if (e.getSource().equals(vistaEmpleado.btnListar)) {
            LISTAR();
        }
        
        if (e.getSource().equals(vistaEmpleado.btnEliminar)) {
            int filaEliminar = vistaEmpleado.tablaEmpleado.getSelectedRow();
            if (filaEliminar >= 0) {
                int codigo = Integer.parseInt(vistaEmpleado.tablaEmpleado.getValueAt(filaEliminar, 0).toString());
                String msg = daoEmpleado.eliminar(codigo);
                if (msg == null) {
                    JOptionPane.showMessageDialog(null, "Se elimino el registro satifactoriamente");
                    LISTAR();
                    validarEmpleado.limpiarDatosEmpleado();
                } else {
                    JOptionPane.showMessageDialog(null, msg);
                    validarEmpleado.limpiarDatosEmpleado();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione una fila para eliminar.");
                validarEmpleado.limpiarDatosEmpleado();
            }
        }
        
        if (e.getSource().equals(vistaEmpleado.btnModificar)) {
            int filaEditar = tabla.getSelectedRow();
            if (filaEditar >= 0) {
                if (validarEmpleado.cadena().length() == 0) {
                    Empleado ep=new Empleado();
                    ep.setApellido(validarEmpleado.apellidoEmpleado());
                    ep.setCodE(Integer.parseInt(tabla.getValueAt(filaEditar, 0).toString()));
                    ep.setNombre(validarEmpleado.nomEmpleado());
                    ep.setCorreo(validarEmpleado.correoEmpleado());
                    ep.setCelular(Integer.parseInt(validarEmpleado.celularEmpleado()));
                    ep.setDireccion(validarEmpleado.direccionEmpleado());
                    ep.setDistrito(validarEmpleado.nomDistritoEmpleado());
                    ep.setUsername(validarEmpleado.usernameEmpleado());
                    ep.setPassword(validarEmpleado.passwordEmpleado());
                    ep.setCargo(validarEmpleado.cbCargoEmpleado());
                    String msj = daoEmpleado.modificar(ep);
                    if (msj==null) {
                        JOptionPane.showMessageDialog(null, "Modificado correctamente");
                        LISTAR();
                        validarEmpleado.limpiarDatosEmpleado();
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
       try{
        if (fila != -1) {
            validarEmpleado.limpiarMouseClick();
            InterEmpleado.txtNombreEmpleado.setText(tabla.getValueAt(fila, 1).toString());
            InterEmpleado.txtApellidoEmpleado.setText(tabla.getValueAt(fila, 2).toString());
            InterEmpleado.txtCorreoEmpleado.setText(tabla.getValueAt(fila, 3).toString());
            InterEmpleado.txtCelularEmpleado.setText(tabla.getValueAt(fila, 4).toString());
            InterEmpleado.txtDireccionEmpleado.setText(tabla.getValueAt(fila, 6).toString());
            InterEmpleado.cbDistritoEmpleado.setSelectedItem(tabla.getValueAt(fila, 5).toString());
            InterEmpleado.txtUsuarioEmpleado.setText(tabla.getValueAt(fila, 7).toString());
            InterEmpleado.txtPasswordEmpleado.setText(tabla.getValueAt(fila, 8).toString());
            int cargo=Integer.parseInt(tabla.getValueAt(fila, 9).toString());
            String nomCarg;
            if(cargo==0){
                nomCarg="Empleado";
            }else{
                nomCarg="Administrador";
            }
            InterEmpleado.cbCargoEmpleado.setSelectedItem(nomCarg);
        }
       }catch(Exception ex){
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
