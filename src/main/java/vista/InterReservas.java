package vista;
import controlador.ControladorReserv;
import modelo.Empleado;
import modelo.Cliente;
import modelo.Servicio;

public class InterReservas extends javax.swing.JInternalFrame {

    public InterReservas() {
        initComponents();
        controlador.ControladorReserv controladorReserva=new ControladorReserv(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnListar = new javax.swing.JButton();
        btnFinalizarReserva = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaMensaje = new javax.swing.JTextArea();
        cbServicios = new javax.swing.JComboBox<>();
        cbEmpleados = new javax.swing.JComboBox<>();
        txtDuracion = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHoraFin = new javax.swing.JTextField();
        btnCalcularHora = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReserva = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbTipoReserva = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaDetalleReserva = new javax.swing.JTable();
        btnAgregarDetalleSelecionado = new javax.swing.JButton();
        btnActualizarServicos = new javax.swing.JButton();
        btnActualizarEmpleado = new javax.swing.JButton();
        btnActualizarCliente = new javax.swing.JButton();
        btnAgregarDetalle = new javax.swing.JButton();
        btnEliminarReserva = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnListar.setBackground(new java.awt.Color(13, 110, 253));
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setText("Listar");
        btnListar.setPreferredSize(new java.awt.Dimension(79, 38));
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnFinalizarReserva.setBackground(new java.awt.Color(13, 110, 253));
        btnFinalizarReserva.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizarReserva.setText("Finalizar Reserva");
        btnFinalizarReserva.setPreferredSize(new java.awt.Dimension(79, 38));
        btnFinalizarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarReservaActionPerformed(evt);
            }
        });

        txtAreaMensaje.setColumns(20);
        txtAreaMensaje.setRows(5);
        jScrollPane2.setViewportView(txtAreaMensaje);

        cbServicios.setPreferredSize(new java.awt.Dimension(33, 29));

        cbEmpleados.setPreferredSize(new java.awt.Dimension(33, 29));
        cbEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEmpleadosActionPerformed(evt);
            }
        });

        txtDuracion.setEnabled(false);
        txtDuracion.setPreferredSize(new java.awt.Dimension(15, 29));

        txtSubTotal.setEnabled(false);
        txtSubTotal.setPreferredSize(new java.awt.Dimension(15, 29));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(36, 36, 38));
        jLabel8.setText("Total:   S/.");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(36, 39, 49));
        jLabel1.setText("Mantenimiento Reserva");

        txtTotal.setEnabled(false);
        txtTotal.setPreferredSize(new java.awt.Dimension(15, 29));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(36, 36, 38));
        jLabel9.setText("Hora Inicio:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 36, 38));
        jLabel3.setText("Servicio:");

        txtHoraInicio.setPreferredSize(new java.awt.Dimension(15, 29));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 36, 38));
        jLabel4.setText("Empleado:");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(36, 36, 38));
        jLabel10.setText("Hora Fin:");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 36, 38));
        jLabel5.setText("Duración:");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(36, 36, 38));
        jLabel6.setText("Mensaje:");

        txtHoraFin.setEnabled(false);
        txtHoraFin.setPreferredSize(new java.awt.Dimension(15, 29));

        btnCalcularHora.setBackground(new java.awt.Color(13, 110, 253));
        btnCalcularHora.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcularHora.setText("Calcular Hora");
        btnCalcularHora.setPreferredSize(new java.awt.Dimension(79, 38));
        btnCalcularHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularHoraActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(36, 36, 38));
        jLabel7.setText("Subtotal:");

        tablaReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaReserva);

        btnAgregar.setBackground(new java.awt.Color(13, 110, 253));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setPreferredSize(new java.awt.Dimension(79, 38));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(36, 36, 38));
        jLabel2.setText("Fecha Inicio:");

        txtFechaInicio.setDateFormatString("yyyy-MM-dd");

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(36, 36, 38));
        jLabel11.setText("Estado:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "Ocupado" }));
        cbEstado.setPreferredSize(new java.awt.Dimension(106, 29));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(36, 36, 38));
        jLabel12.setText("Tipo:");

        cbTipoReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Local", "Domicilio" }));
        cbTipoReserva.setPreferredSize(new java.awt.Dimension(106, 29));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(36, 36, 38));
        jLabel13.setText("Cliente:");

        cbCliente.setPreferredSize(new java.awt.Dimension(33, 29));

        tablaDetalleReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaDetalleReserva);

        btnAgregarDetalleSelecionado.setBackground(new java.awt.Color(13, 110, 253));
        btnAgregarDetalleSelecionado.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarDetalleSelecionado.setText("<html>\n<p>Agregar Detalle <br>\nSelecionado</p>\n</html>");
        btnAgregarDetalleSelecionado.setEnabled(false);
        btnAgregarDetalleSelecionado.setPreferredSize(new java.awt.Dimension(79, 38));
        btnAgregarDetalleSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDetalleSelecionadoActionPerformed(evt);
            }
        });

        btnActualizarServicos.setBackground(new java.awt.Color(34, 216, 132));
        btnActualizarServicos.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarServicos.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\Integrador1-AppPeluqueria\\AppPeluqueriaCrud\\src\\main\\java\\vista\\img-refresh.png")); // NOI18N
        btnActualizarServicos.setPreferredSize(new java.awt.Dimension(79, 38));
        btnActualizarServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarServicosActionPerformed(evt);
            }
        });

        btnActualizarEmpleado.setBackground(new java.awt.Color(34, 216, 132));
        btnActualizarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarEmpleado.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\Integrador1-AppPeluqueria\\AppPeluqueriaCrud\\src\\main\\java\\vista\\img-refresh.png")); // NOI18N
        btnActualizarEmpleado.setPreferredSize(new java.awt.Dimension(79, 38));
        btnActualizarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEmpleadoActionPerformed(evt);
            }
        });

        btnActualizarCliente.setBackground(new java.awt.Color(34, 216, 132));
        btnActualizarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarCliente.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Documents\\Integrador1-AppPeluqueria\\AppPeluqueriaCrud\\src\\main\\java\\vista\\img-refresh.png")); // NOI18N
        btnActualizarCliente.setPreferredSize(new java.awt.Dimension(79, 38));
        btnActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarClienteActionPerformed(evt);
            }
        });

        btnAgregarDetalle.setBackground(new java.awt.Color(13, 110, 253));
        btnAgregarDetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarDetalle.setText("<html>\n<p>Agregar Ultimo <br>\nDetalle</p>\n</html>");
        btnAgregarDetalle.setEnabled(false);
        btnAgregarDetalle.setPreferredSize(new java.awt.Dimension(79, 38));
        btnAgregarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDetalleActionPerformed(evt);
            }
        });

        btnEliminarReserva.setBackground(new java.awt.Color(220, 53, 69));
        btnEliminarReserva.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarReserva.setText("Eliminar Reserva");
        btnEliminarReserva.setPreferredSize(new java.awt.Dimension(79, 38));
        btnEliminarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(506, 506, 506)
                        .addComponent(jLabel1)
                        .addGap(488, 488, 488))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEliminarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(cbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(18, 18, 18))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel13)
                                                                .addGap(26, 26, 26)))
                                                        .addComponent(cbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnActualizarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnActualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(41, 41, 41)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel5)
                                                        .addGap(50, 50, 50)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel12)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cbTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addComponent(jLabel9))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel10)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnFinalizarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarDetalleSelecionado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregarDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCalcularHora, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbTipoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addComponent(btnActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbServicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnActualizarServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoraInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCalcularHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnActualizarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFinalizarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarDetalleSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnFinalizarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinalizarReservaActionPerformed

    private void cbEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEmpleadosActionPerformed

    }//GEN-LAST:event_cbEmpleadosActionPerformed

    private void btnCalcularHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularHoraActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarDetalleSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDetalleSelecionadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarDetalleSelecionadoActionPerformed

    private void btnActualizarServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarServicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarServicosActionPerformed

    private void btnActualizarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarEmpleadoActionPerformed

    private void btnActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarClienteActionPerformed

    private void btnAgregarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDetalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarDetalleActionPerformed

    private void btnEliminarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarReservaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnActualizarCliente;
    public static javax.swing.JButton btnActualizarEmpleado;
    public static javax.swing.JButton btnActualizarServicos;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnAgregarDetalle;
    public javax.swing.JButton btnAgregarDetalleSelecionado;
    public javax.swing.JButton btnCalcularHora;
    public javax.swing.JButton btnEliminarReserva;
    public javax.swing.JButton btnFinalizarReserva;
    public javax.swing.JButton btnListar;
    public static javax.swing.JComboBox<Cliente> cbCliente;
    public static javax.swing.JComboBox<Empleado> cbEmpleados;
    public static javax.swing.JComboBox<String> cbEstado;
    public static javax.swing.JComboBox<Servicio> cbServicios;
    public static javax.swing.JComboBox<String> cbTipoReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTable tablaDetalleReserva;
    public static javax.swing.JTable tablaReserva;
    public static javax.swing.JTextArea txtAreaMensaje;
    public javax.swing.JTextField txtDuracion;
    public static com.toedter.calendar.JDateChooser txtFechaInicio;
    public javax.swing.JTextField txtHoraFin;
    public javax.swing.JTextField txtHoraInicio;
    public javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
