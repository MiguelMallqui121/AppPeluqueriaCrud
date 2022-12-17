package dao;

import Interfaces.InterfaceReserva;
import java.sql.CallableStatement;
import modelo.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.Reserva;

public class ReservaDao implements InterfaceReserva {

    MySQLConexion cn = new MySQLConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Reserva r;
    List<Reserva> lista;
    CallableStatement cs;

    @Override
    public int agregar(Reserva r) {
        int msj = 0;
        con = MySQLConexion.getConexion();
        try {
            String sql = "{call sp_adicionar_reserva(?,?,?,?)}";
            cs = con.prepareCall(sql);
            cs.setString(1, r.getFechaInicio());
            cs.setInt(2, r.getEstado());
            cs.setString(3, r.getTipo());
            cs.setInt(4, r.getCliente().getIdCliente());
            rs = cs.executeQuery();
            if (rs.next()) {
                msj = rs.getInt(1);
            }
        } catch (SQLException ex) {
        }
        return msj;
    }

    @Override
    public String eliminar(int cod) {
        String msj = null;
        try {
            String sql = "delete from reserva where id_reserva=" + cod;
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
    public String modificar(Reserva r) {
        String msj = null;
        try {
            String sql = "update reserva set id_reserva=?,fecha_inicio=?,estado=?,tipo_reserva=?,id_cliente=? where id_reserva=" + r.getIdReserva();
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, r.getIdReserva());
            ps.setString(2, r.getFechaInicio());
            ps.setInt(3, r.getEstado());
            ps.setString(4, r.getTipo());
            ps.setInt(5, r.getCliente().getIdCliente());
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
    public List<Reserva> listar() {
        con = MySQLConexion.getConexion();
        String msj = null;
        lista = new ArrayList<>();
        try {
            String sql = "SELECT * from reserva";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = new Reserva();
                r.setIdReserva(rs.getInt(1));
                r.setFechaInicio(rs.getString(2));
                r.setEstado(rs.getInt(3));
                r.setTipo(rs.getString(4));
                ClienteDao cliDAO = new ClienteDao();
                Cliente cliente = cliDAO.getOne(rs.getInt(5));
                r.setCliente(cliente);
                lista.add(r);
            }
        } catch (SQLException ex) {
            msj = ex.getMessage();
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Reserva> ordenarPorFecha() {
        con = MySQLConexion.getConexion();
        String msj = null;
        lista = new ArrayList<>();
        try {
            String sql = "select * from reserva r\n"
                    + "order by (r.fecha_inicio);";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = new Reserva();
                r.setIdReserva(rs.getInt(1));
                r.setFechaInicio(rs.getString(2));
                r.setEstado(rs.getInt(3));
                r.setTipo(rs.getString(4));
                ClienteDao cliDAO = new ClienteDao();
                Cliente cliente = cliDAO.getOne(rs.getInt(5));
                r.setCliente(cliente);
                lista.add(r);
            }
        } catch (SQLException ex) {
            msj = ex.getMessage();
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Reserva getOne(int cod) {
        r = null;
        try {
            String sql = "select * from reserva where id_reserva=" + cod;
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = new Reserva();
                r.setIdReserva(rs.getInt(1));
                r.setFechaInicio(rs.getString(2));
                r.setEstado(rs.getInt(3));
                r.setTipo(rs.getString(4));
                ClienteDao cliDAO = new ClienteDao();
                Cliente cliente = cliDAO.getOne(rs.getInt(5));
                r.setCliente(cliente);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return r;
    }

    @Override
    public Reserva ultimaReserva() {
        r = null;
        try {
            String sql = "SELECT * FROM reserva WHERE id_reserva=(SELECT max(id_reserva) FROM reserva)";
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = new Reserva();
                r.setIdReserva(rs.getInt(1));
                r.setFechaInicio(rs.getString(2));
                r.setEstado(rs.getInt(3));
                r.setTipo(rs.getString(4));
                ClienteDao cliDAO = new ClienteDao();
                Cliente cliente = cliDAO.getOne(rs.getInt(5));
                r.setCliente(cliente);
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return r;
    }
}
