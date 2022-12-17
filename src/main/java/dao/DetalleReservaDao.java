package dao;

import Interfaces.InterfaceDetalleReserva;
import modelo.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import modelo.Reserva;
import modelo.Servicio;
import modelo.DetalleReserva;

public class DetalleReservaDao implements InterfaceDetalleReserva {

    MySQLConexion cn = new MySQLConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DetalleReserva d;
    List<DetalleReserva> lista;
    Servicio servicio;
    Reserva reserva;
    Empleado empleado;
    EmpleadoDao DAOEmpleado = new EmpleadoDao();
    ReservaDao DAOReserva = new ReservaDao();
    ServicioDao DAOServicio = new ServicioDao();

    @Override
    public String agregar(DetalleReserva detalle) {

        String msj = null;
        try {
            String sql = "insert into detalle_reserva_servicio (hora_inicio,hora_fin,mensaje,duracion,subtotal,id_servicio,id_empleado,id_reserva) values (?,?,?,?,?,?,?,?)";
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, detalle.getHoraInicio());
            ps.setString(2, detalle.getHoraFin());
            ps.setString(3, detalle.getMensaje());
            ps.setString(4, detalle.getDuracion());
            ps.setDouble(5, detalle.getSubtotal());
            ps.setInt(6, detalle.getServicio().getId());
            ps.setInt(7, detalle.getEmpleado().getCodE());
            ps.setInt(8, detalle.getReserva().getIdReserva());
            int n = ps.executeUpdate();
            if (n == 0) {
                msj = "0 Filas afectadas";
            }
        } catch (SQLException ex) {
            msj = ex.getMessage();
        }
        return msj;
    }

    @Override
    public String eliminar(int cod) {
        String msj = null;
        try {
            String sql = "delete from detalle_reserva_servicio where id=" + cod;
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            int n = ps.executeUpdate();
            if (n == 0) {
                msj = "0 Filas afectadas";
            }
        } catch (SQLException ex) {
            msj = ex.getMessage();
        }
        return msj;
    }

    @Override
    public String modificar(DetalleReserva detalle) {
        String msj = null;
        try {
            String sql = "update detalle_reserva_servicio set id=?,hora_inicio=?,hora_fin=?,mensaje=?,duracion=?,subtotal=?,id_servicio=?,id_empleado=?,id_reserva=? where id=" + detalle.getId();
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, detalle.getId());
            ps.setString(2, detalle.getHoraInicio());
            ps.setString(3, detalle.getHoraFin());
            ps.setString(4, detalle.getMensaje());
            ps.setString(5, detalle.getDuracion());
            ps.setDouble(6, detalle.getSubtotal());
            ps.setInt(7, detalle.getServicio().getId());
            ps.setInt(8, detalle.getEmpleado().getCodE());
            ps.setInt(9, detalle.getReserva().getIdReserva());
            int n = ps.executeUpdate();
            if (n == 0) {
                msj = "0 Filas afectadas";
            }
        } catch (SQLException ex) {
            msj = ex.getMessage();
        }
        return msj;
    }

    @Override
    public List<DetalleReserva> listar() {
        con = MySQLConexion.getConexion();
        String msj = null;
        lista = new ArrayList<>();
        try {
            String sql = "SELECT * from detalle_reserva_servicio";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new DetalleReserva();
                d.setId(rs.getInt(1));
                d.setHoraInicio(rs.getString(2));
                d.setHoraFin(rs.getString(3));
                d.setMensaje(rs.getString(4));
                d.setDuracion(rs.getString(5));
                d.setSubtotal(rs.getDouble(6));
                servicio = DAOServicio.getOne(rs.getInt(7));
                d.setServicio(servicio);
                empleado = DAOEmpleado.getOne(rs.getInt(8));
                d.setEmpleado(empleado);
                reserva = DAOReserva.getOne(rs.getInt(9));
                d.setReserva(reserva);
                lista.add(d);
            }
        } catch (SQLException ex) {
            msj = ex.getMessage();
        }
        return lista;
    }
    
    @Override
    public List<DetalleReserva> filtrarDetalle(int cod) {
        con = MySQLConexion.getConexion();
        String msj = null;
        lista = new ArrayList<>();
        try {
            String sql = "select * from detalle_reserva_servicio dr\n" +
            "where dr.id_reserva="+cod;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new DetalleReserva();
                d.setId(rs.getInt(1));
                d.setHoraInicio(rs.getString(2));
                d.setHoraFin(rs.getString(3));
                d.setMensaje(rs.getString(4));
                d.setDuracion(rs.getString(5));
                d.setSubtotal(rs.getDouble(6));
                servicio = DAOServicio.getOne(rs.getInt(7));
                d.setServicio(servicio);
                empleado = DAOEmpleado.getOne(rs.getInt(8));
                d.setEmpleado(empleado);
                reserva = DAOReserva.getOne(rs.getInt(9));
                d.setReserva(reserva);
                lista.add(d);
            }
        } catch (SQLException ex) {
            msj = ex.getMessage();
        }
        return lista;
    }

    @Override
    public DetalleReserva getOne(int cod) {
        d = null;
        try {
            String sql = "select * from detalle_reserva_servicio where id=" + cod;
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d=new DetalleReserva();
                d.setId(rs.getInt(1));
                d.setHoraInicio(rs.getString(2));
                d.setHoraFin(rs.getString(3));
                d.setMensaje(rs.getString(4));
                d.setDuracion(rs.getString(5));
                d.setSubtotal(rs.getDouble(6));
                servicio = DAOServicio.getOne(rs.getInt(7));
                d.setServicio(servicio);
                empleado = DAOEmpleado.getOne(rs.getInt(8));
                d.setEmpleado(empleado);
                reserva = DAOReserva.getOne(rs.getInt(9));
                d.setReserva(reserva);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return d;
    }

    @Override
    public DetalleReserva UltimoDetalleReserva() {
        DetalleReserva d = null;
        try {
            String sql = "SELECT * FROM detalle_reserva_servicio WHERE id=(SELECT max(id) FROM detalle_reserva_servicio)";
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new DetalleReserva();
                d.setId(rs.getInt(1));
                d.setHoraInicio(rs.getString(2));
                d.setHoraFin(rs.getString(3));
                d.setMensaje(rs.getString(4));
                d.setDuracion(rs.getString(5));
                d.setSubtotal(rs.getDouble(6));
                servicio = DAOServicio.getOne(rs.getInt(7));
                d.setServicio(servicio);
                empleado = DAOEmpleado.getOne(rs.getInt(8));
                d.setEmpleado(empleado);
                reserva = DAOReserva.getOne(rs.getInt(9));
                d.setReserva(reserva);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return d;
    }
}
