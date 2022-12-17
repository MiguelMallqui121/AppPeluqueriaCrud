package controlador;

import static controlador.ControladorFormularios.jDesktopPane_menu;
import dao.ClienteDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import vista.InterCliente;
import vista.InterLeyenda;

public class ControladorCliente implements ActionListener, MouseListener {

    ValidarCliente validacionCliente = new ValidarCliente();
    ClienteDao daoCliente = new ClienteDao();
    private InterCliente vistaCliente;
    DefaultTableModel modelo = new DefaultTableModel();
    JTable tabla;
    String id, nom, ap, co, dis, dir;
    int cel;

    public ControladorCliente(InterCliente vistaCliente, JTable tabla) {
        this.vistaCliente = vistaCliente;
        this.tabla = tabla;
        this.vistaCliente.btnAgregar.addActionListener(this);
        this.vistaCliente.btnListar.addActionListener(this);
        this.vistaCliente.btnModificar.addActionListener(this);
        this.vistaCliente.btnEliminar.addActionListener(this);
        this.vistaCliente.btnLeyenda.addActionListener(this);
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
        vistaCliente.tabla.setModel(modelo);
        vistaCliente.tabla.setRowHeight(30);
        vistaCliente.tabla.setRowMargin(5);
    }

    public void LISTAR() {
        modelo.getDataVector().removeAllElements();
        vistaCliente.tabla.updateUI();
        List<Cliente> list = daoCliente.listar();
        for (int i = 0; i < list.size(); i++) {
            Object o[] = {list.get(i).getIdCliente(), list.get(i).getNombre(), list.get(i).getApellido(), list.get(i).getCorreo(), list.get(i).getCelular(), list.get(i).getDistrito(), list.get(i).getDireccion()};
            modelo.addRow(o);
        }
    }

    public void recogerDatosCliente() {
        nom = validacionCliente.nomCliente();
        ap = validacionCliente.apellidoCliente();
        co = validacionCliente.correoCliente();
        cel = Integer.parseInt(validacionCliente.celularCliente());
        dis = validacionCliente.nomDistritoCliente();
        dir = validacionCliente.direccionCliente();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vistaCliente.btnLeyenda)) {
            InterLeyenda interLeyenda = new InterLeyenda();
            if (ControladorFormularios.JInternalFrames_Abiertos(interLeyenda) == false) {
            jDesktopPane_menu.add(interLeyenda);
            interLeyenda.setVisible(true);
            }
        }
        if (e.getSource().equals(vistaCliente.btnAgregar)) {
            if (validacionCliente.cadena().length() == 0) {
                recogerDatosCliente();
                Cliente cliente = new Cliente(nom, ap, co, cel, dis, dir);
                String msg = daoCliente.agregar(cliente);
                if (msg.equals("AGREGADO")) {
                    JOptionPane.showMessageDialog(null, "Se agrego el registro correctamente");
                    LISTAR();
                    validacionCliente.limpiarDatosCliente();
                } else {
                    JOptionPane.showMessageDialog(null, "El correo o celular es: "+msg);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Corregir campos selecionados");
            }
        }
        if (e.getSource().equals(vistaCliente.btnListar)) {
            modelo.getDataVector().removeAllElements();
            vistaCliente.tabla.updateUI();
            List<Cliente> list = daoCliente.listar();
            for (int i = 0; i < list.size(); i++) {
                Object o[] = {list.get(i).getIdCliente(), list.get(i).getNombre(), list.get(i).getApellido(), list.get(i).getCorreo(), list.get(i).getCelular(), list.get(i).getDistrito(), list.get(i).getDireccion()};
                modelo.addRow(o);
            }
        }
        if (e.getSource().equals(vistaCliente.btnEliminar)) {
            int filaEliminar = vistaCliente.tabla.getSelectedRow();
            if (filaEliminar >= 0) {
                int codigo = Integer.parseInt(vistaCliente.tabla.getValueAt(filaEliminar, 0).toString());
                String msg = daoCliente.eliminar(codigo);
                if (msg == null) {
                    JOptionPane.showMessageDialog(null, "Se elimino el registro satifactoriamente");
                    LISTAR();
                    validacionCliente.limpiarDatosCliente();
                } else {
                    JOptionPane.showMessageDialog(null, msg);
                    validacionCliente.limpiarDatosCliente();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione una fila para eliminar.");
                validacionCliente.limpiarDatosCliente();
            }
        }
        if (e.getSource().equals(vistaCliente.btnModificar)) {
            int filaEditar = tabla.getSelectedRow();
            if (filaEditar >= 0) {
                if (validacionCliente.cadena().length() == 0) {
                    Cliente c = new Cliente();
                    c.setApellido(validacionCliente.apellidoCliente());
                    c.setIdCliente(Integer.parseInt(tabla.getValueAt(filaEditar, 0).toString()));
                    c.setNombre(validacionCliente.nomCliente());
                    c.setCorreo(validacionCliente.correoCliente());
                    c.setCelular(Integer.parseInt(validacionCliente.celularCliente()));
                    c.setDireccion(validacionCliente.direccionCliente());
                    c.setDistrito(validacionCliente.nomDistritoCliente());
                    String msj = daoCliente.modificar(c);
                    if (msj==null) {
                        JOptionPane.showMessageDialog(null, "Modificado correctamente");
                        LISTAR();
                        validacionCliente.limpiarDatosCliente();
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
            validacionCliente.limpiarMouserClick();
            InterCliente.txtNombreCliente.setText(tabla.getValueAt(fila, 1).toString());
            InterCliente.txtApellidoCliente.setText(tabla.getValueAt(fila, 2).toString());
            InterCliente.txtCorreoCliente.setText(tabla.getValueAt(fila, 3).toString());
            InterCliente.txtCelularCliente.setText(tabla.getValueAt(fila, 4).toString());
            InterCliente.txtDireccionCliente.setText(tabla.getValueAt(fila, 6).toString());
            InterCliente.cbDistritoCliente.setSelectedItem(tabla.getValueAt(fila, 5).toString());
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
