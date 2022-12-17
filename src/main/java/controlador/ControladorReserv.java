package controlador;

import dao.ClienteDao;
import dao.DetalleReservaDao;
import dao.EmpleadoDao;
import dao.ReservaDao;
import dao.ServicioDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Servicio;
import modelo.Reserva;
import modelo.DetalleReserva;
import vista.InterReservas;

public class ControladorReserv implements ActionListener, MouseListener, ItemListener {

    private InterReservas vistaReservas;
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
//    JTable tabla;
    ReservaDao daoReserva = new ReservaDao();
    ClienteDao daoCliente = new ClienteDao();
    EmpleadoDao daoEmpleado = new EmpleadoDao();
    ServicioDao daoServicio = new ServicioDao();
    DetalleReservaDao daoDetalle = new DetalleReservaDao();
    String fechaInicio, estado, tipoReserva;
    String nomServicio, nomEmpleado, mensaje, duracion, horaInicio, horaFin;
    double costo, total;
    int cbServicio, cbEstado;
    Cliente cliente;
    Empleado empleado;
    Servicio servicio;
    Reserva reserva;
    Reserva reserva0;
    Reserva reservaUltima;

    public ControladorReserv(InterReservas vistaReservas) {
        this.vistaReservas = vistaReservas;
        this.vistaReservas.btnListar.addActionListener(this);
        this.vistaReservas.btnCalcularHora.addActionListener(this);
        this.vistaReservas.btnFinalizarReserva.addActionListener(this);
        this.vistaReservas.btnAgregar.addActionListener(this);
        this.vistaReservas.btnAgregarDetalle.addActionListener(this);
        this.vistaReservas.btnAgregarDetalleSelecionado.addActionListener(this);
        this.vistaReservas.btnActualizarServicos.addActionListener(this);
        this.vistaReservas.btnActualizarEmpleado.addActionListener(this);
        this.vistaReservas.btnActualizarCliente.addActionListener(this);
        this.vistaReservas.btnEliminarReserva.addActionListener(this);
        this.vistaReservas.tablaReserva.addMouseListener(this);
//        this.vistaReservas.tablaDetalleReserva.addMouseListener(this);
        this.vistaReservas.cbServicios.addItemListener(this);
        ImageIcon img1=new ImageIcon("src/main/java/vista/img-refresh.png");
        this.vistaReservas.btnActualizarCliente.setIcon(img1);
        this.vistaReservas.btnActualizarEmpleado.setIcon(img1);
        this.vistaReservas.btnActualizarServicos.setIcon(img1);
        iniciarTablaReserva();
        iniciarTablaDetalle();
        listadoClientes();
        listadoEmpleados();
        listadoServicios();
        obtenerDatosServicio();
    }

    public void obtenerDatosServicio() {
        int contador = 0;
        cbServicio = vistaReservas.cbServicios.getSelectedIndex();
        for (Servicio x : daoServicio.listar()) {
            if (cbServicio == contador) {
                vistaReservas.txtDuracion.setText(x.getDuracion());
                vistaReservas.txtSubTotal.setText(x.getCosto() + "");
            }
            contador++;
        }
    }

    public void iniciarTablaReserva() {
        modelo.addColumn("IdReserva");
        modelo.addColumn("Fecha");
        modelo.addColumn("Estado");
        modelo.addColumn("Tipo Reserva");
        modelo.addColumn("Cliente");
        vistaReservas.tablaReserva.setModel(modelo);
        vistaReservas.tablaReserva.setRowHeight(30);
        vistaReservas.tablaReserva.setRowMargin(5);

    }

    public void iniciarTablaDetalle() {
        modelo2.addColumn("ID Detalle");
        modelo2.addColumn("Hora incio");
        modelo2.addColumn("Hora Fin");
        modelo2.addColumn("Mensaje");
        modelo2.addColumn("duración");
        modelo2.addColumn("Subtotal");
        modelo2.addColumn("Servicio");
        modelo2.addColumn("Empleado");
        modelo2.addColumn("Reserva");
        vistaReservas.tablaDetalleReserva.setModel(modelo2);
        vistaReservas.tablaDetalleReserva.setRowHeight(30);
        vistaReservas.tablaDetalleReserva.setRowMargin(5);
    }

    public void recogerDatosReserva() {
        try {
            fechaInicio = sdf.format(vistaReservas.txtFechaInicio.getDate()) + "";
            cbEstado = vistaReservas.cbEstado.getSelectedIndex();
            estado = vistaReservas.cbEstado.getItemAt(vistaReservas.cbEstado.getSelectedIndex());
            cliente = vistaReservas.cbCliente.getItemAt(vistaReservas.cbCliente.getSelectedIndex());
            tipoReserva = vistaReservas.cbTipoReserva.getItemAt(vistaReservas.cbTipoReserva.getSelectedIndex());
        } catch (Exception ex) {
        }
    }

    public void recogerDatosDetalle() {
        cliente = vistaReservas.cbCliente.getItemAt(vistaReservas.cbCliente.getSelectedIndex());
        empleado = vistaReservas.cbEmpleados.getItemAt(vistaReservas.cbEmpleados.getSelectedIndex());
        servicio = vistaReservas.cbServicios.getItemAt(vistaReservas.cbServicios.getSelectedIndex());
        duracion = vistaReservas.txtDuracion.getText();
        costo = Double.parseDouble(vistaReservas.txtSubTotal.getText());
        mensaje = vistaReservas.txtAreaMensaje.getText();
        horaInicio = vistaReservas.txtHoraInicio.getText();
        horaFin = vistaReservas.txtHoraFin.getText();
    }

    public String validarHoraInicio() {
        String cadena = "";
        String horaInicio = vistaReservas.txtHoraInicio.getText();
        if (!horaInicio.matches("^[0-2][1-9]:[0-5][0-5]:[0][0]$")) {
            cadena += "m";
            JOptionPane.showMessageDialog(null, "La hora Comienza con [0-2] el siguiente digito es [1-9], minutos acepta desde 0 a 5 en ambos digitos y segundos deben ir 00");
        } else {
            cadena += "";
        }
        return cadena;
    }

    public void calcularHoraFin() {
        try {
            String sCadena = vistaReservas.txtDuracion.getText();
            String cadenaInicio = vistaReservas.txtHoraInicio.getText();
            String horaInicio = cadenaInicio.substring(0, 2);
            String minInicio = cadenaInicio.substring(3, 5);
            int hIn = Integer.parseInt(horaInicio);
            int mFn = Integer.parseInt(minInicio);
            String hora = sCadena.substring(0, 2);
            String min = sCadena.substring(3, 5);
            int sumHora = Integer.parseInt(hora);
            int sumMin = Integer.parseInt(min);
            DateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.set(2022, 10 - 1, 11, hIn, mFn, 00);
            //Desplegamos la fecha
            Date newtempDate = cal.getTime();
            //Le cambiamos la hora y minutos
            cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + sumMin);
            cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + sumHora);
            cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) + 0);
            String newTempDate = sdf1.format(cal.getTime());
            vistaReservas.txtHoraFin.setText(newTempDate);
        } catch (Exception ex) {

        }
    }

    public void listadoEmpleados() {
        vistaReservas.cbEmpleados.removeAllItems();
        for (Empleado x : daoEmpleado.listar()) {
            vistaReservas.cbEmpleados.addItem(new Empleado(x.getCodE(), x.getNombre(), x.getApellido(), x.getCorreo(), x.getCelular(), x.getDistrito(), x.getDireccion(), x.getUsername(), x.getPassword(), x.getCargo()));
        }
    }

    public void listadoClientes() {
        vistaReservas.cbCliente.removeAllItems();
        for (Cliente x : daoCliente.listar()) {
            vistaReservas.cbCliente.addItem(new Cliente(x.getIdCliente(), x.getNombre(), x.getApellido(), x.getCorreo(), x.getCelular(), x.getDistrito(), x.getDireccion()));
        }
    }

    public void listadoServicios() {
        vistaReservas.cbServicios.removeAllItems();
        for (Servicio x : daoServicio.listar()) {
            vistaReservas.cbServicios.addItem(new Servicio(x.getId(), x.getNombre(), x.getDuracion(), x.getCosto()));
        }
    }

    public void LISTAR() {
        modelo.getDataVector().removeAllElements();
        vistaReservas.tablaReserva.updateUI();
        List<Reserva> list = daoReserva.listar();
        for (int i = 0; i < list.size(); i++) {
            Object o[] = {list.get(i).getIdReserva(), list.get(i).getFechaInicio(), list.get(i).getEstado(), list.get(i).getTipo(), list.get(i).getCliente()};
            modelo.addRow(o);
        }
    }

    public void listadoDetalles(int cod) {
        modelo2.getDataVector().removeAllElements();
        vistaReservas.tablaDetalleReserva.updateUI();
        double sum = 0;
        List<DetalleReserva> list = daoDetalle.filtrarDetalle(cod);
        for (int i = 0; i < list.size(); i++) {
            Object o[] = {list.get(i).getId(), list.get(i).getHoraInicio(), list.get(i).getHoraFin(), list.get(i).getMensaje(), list.get(i).getDuracion(), list.get(i).getSubtotal(), list.get(i).getServicio(), list.get(i).getEmpleado(), list.get(i).getReserva().getIdReserva()};
            sum += list.get(i).getSubtotal();
            modelo2.addRow(o);
        }
        InterReservas.txtTotal.setText(sum + "");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vistaReservas.btnEliminarReserva)) {
            int filaEliminar = vistaReservas.tablaReserva.getSelectedRow();
            if (filaEliminar != -1) {
                int codigo = Integer.parseInt(vistaReservas.tablaReserva.getValueAt(filaEliminar, 0).toString());
                daoReserva.eliminar(codigo);
                JOptionPane.showMessageDialog(null, "Se elimino correctamente");
                LISTAR();
                modelo2.getDataVector().removeAllElements();
                vistaReservas.tablaDetalleReserva.updateUI();
            } else {
                JOptionPane.showMessageDialog(null, "Selecionar fila");
            }
        }
        if (e.getSource().equals(vistaReservas.btnActualizarCliente)) {
            listadoClientes();
        }
        if (e.getSource().equals(vistaReservas.btnActualizarServicos)) {
            listadoServicios();
        }
        if (e.getSource().equals(vistaReservas.btnActualizarEmpleado)) {
            listadoEmpleados();
        }
        if (e.getSource().equals(vistaReservas.btnListar)) {
            LISTAR();
        }
        if (e.getSource().equals(vistaReservas.btnCalcularHora)) {
            if (validarHoraInicio().length() == 0) {
                calcularHoraFin();
                vistaReservas.btnAgregarDetalleSelecionado.setEnabled(true);
                vistaReservas.btnAgregarDetalle.setEnabled(true);
            }
        }
        if (e.getSource().equals(vistaReservas.btnAgregar)) {
            recogerDatosReserva();
            if (fechaInicio == null) {
                JOptionPane.showMessageDialog(null, "Complete la fecha y estado debe estar en Ocupado");
            } else {
                reserva0 = new Reserva(fechaInicio, cbEstado, tipoReserva, cliente);
                int msg = daoReserva.agregar(reserva0);
                if (msg == 0) {
                    JOptionPane.showMessageDialog(null, "Se registro la reserva correctamente");
                    LISTAR();
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha y tipo de reserva ya esta ingresado");
                }
            }
        }
        if (e.getSource().equals(vistaReservas.btnAgregarDetalleSelecionado)) {
            try{
            int filaBuscar = vistaReservas.tablaReserva.getSelectedRow();
            if (filaBuscar != -1) {
                int codigo = Integer.parseInt(vistaReservas.tablaReserva.getValueAt(filaBuscar, 0).toString());
                DetalleReserva detalle = new DetalleReserva();
                recogerDatosDetalle();
                reserva = new Reserva();
                reserva.setIdReserva(Integer.parseInt(vistaReservas.tablaReserva.getValueAt(filaBuscar, 0).toString()));
                detalle.setHoraInicio(horaInicio);
                detalle.setHoraFin(horaFin);
                detalle.setDuracion(duracion);
                detalle.setMensaje(mensaje);
                detalle.setSubtotal(costo);
                detalle.setReserva(reserva);
                detalle.setServicio(servicio);
                detalle.setEmpleado(empleado);
                String msj = daoDetalle.agregar(detalle);
                if (msj == null) {
                    JOptionPane.showMessageDialog(null, "Agregado correctamente");
                    listadoDetalles(codigo);
                    vistaReservas.btnAgregarDetalleSelecionado.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Problemas a la hora de agregar:" + msj);
                    vistaReservas.btnAgregarDetalleSelecionado.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecione una fila de la tabla reserva");
            }
            }catch(Exception ex){
                
            }
        }
        if (e.getSource().equals(vistaReservas.btnAgregarDetalle)) {
            vistaReservas.btnAgregarDetalle.setEnabled(false);
            DetalleReserva detalle = new DetalleReserva();
            EmpleadoDao csd = new EmpleadoDao();
            ServicioDao sr = new ServicioDao();
            recogerDatosDetalle();
            reservaUltima = daoReserva.ultimaReserva();
            detalle.setHoraInicio(horaInicio);
            detalle.setHoraFin(horaFin);
            detalle.setDuracion(duracion);
            detalle.setMensaje(mensaje);
            detalle.setSubtotal(costo);
            detalle.setReserva(reservaUltima);
            detalle.setServicio(servicio);
            detalle.setEmpleado(empleado);
            String msj = daoDetalle.agregar(detalle);
            DetalleReserva detalleUltimoRegistro = daoDetalle.UltimoDetalleReserva();
            if (msj == null) {
                JOptionPane.showMessageDialog(null, "Agregado correctamente");
                System.out.println(reserva0);
            } else {
                JOptionPane.showMessageDialog(null, "Problemas a la hora de agregar:" + msj);
            }
            Object objeto[] = {detalleUltimoRegistro.getId(), detalle.getHoraInicio(), detalle.getHoraFin(), detalle.getMensaje(), detalle.getDuracion(),
                detalle.getSubtotal(), detalle.getServicio(), detalle.getEmpleado(), detalle.getReserva()};
            modelo2.addRow(objeto);
        }
        if (e.getSource().equals(vistaReservas.btnFinalizarReserva)) {
            try {
                List<DetalleReserva> detalles = new ArrayList();
                double sum = 0;
                //cuenta los detalles insertados
                for (int i = 0; i < modelo2.getRowCount(); i++) {
                    int codigo = Integer.parseInt(vistaReservas.tablaDetalleReserva.getValueAt(i, 0).toString());
                    DetalleReserva detalle5 = daoDetalle.getOne(codigo);
                    sum += detalle5.getSubtotal();
                    reservaUltima.addDetalle(detalle5);
                }
                InterReservas.txtTotal.setText(sum + "");
                System.out.println(reservaUltima);
            } catch (Exception ex) {

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int filaBuscar = vistaReservas.tablaReserva.getSelectedRow();
        try {
            if (filaBuscar != -1) {
                int codigo = Integer.parseInt(vistaReservas.tablaReserva.getValueAt(filaBuscar, 0).toString());
                listadoDetalles(codigo);
            }
        } catch (Exception ex) {

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

    @Override
    public void itemStateChanged(ItemEvent e) {
        vistaReservas.cbServicios.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                //tu código
                cbServicio = vistaReservas.cbServicios.getSelectedIndex();
                obtenerDatosServicio();
            }
        });
    }

}
