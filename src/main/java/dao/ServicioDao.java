package dao;

import Interfaces.InterfaceServicio;
import java.sql.CallableStatement;
import modelo.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Servicio;

public class ServicioDao implements InterfaceServicio {

    MySQLConexion cn = new MySQLConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Servicio s;
    List<Servicio> lista;
    CallableStatement cs;

    @Override
    public String agregar(Servicio s) {
        String msj = null;
        try {
            String sql = "{call sp_adicionar_servicio(?,?,?)}";
            con = MySQLConexion.getConexion();
            cs = con.prepareCall(sql);
            cs.setString(1, s.getNombre());
            cs.setString(2, s.getDuracion());
            cs.setDouble(3, s.getCosto());
            rs= cs.executeQuery();
            if (rs.next()) {
                msj = rs.getString(1);
            }
        } catch (SQLException ex) {
            msj=ex.getMessage();
        }
        return msj;
    }

    @Override
    public String eliminar(int cod) {
        String msj = null;
        try {
            String sql = "delete from servicio where id_servicio=" + cod;
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
    public String modificar(Servicio s) {
        String msj = null;
        try {
            String sql = "update servicio set id_servicio=?,nombre=?,duracion=?,costo=? where id_servicio="+s.getId();
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getNombre());
            ps.setString(3, s.getDuracion());
            ps.setDouble(4, s.getCosto());
            int n=ps.executeUpdate();
            if (n==0) {
                msj="0 Filas afectadas";
            }
        } catch (SQLException ex) {
            msj=ex.getMessage();
        }
        return msj;
    }

    @Override
    public List<Servicio> listar() {
        con = MySQLConexion.getConexion();
        String msj = null;
        lista = new ArrayList<>();
        try {
            String sql = "select * from servicio s";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new Servicio();
                s.setId(rs.getInt(1));
                s.setNombre(rs.getString(2));
                s.setDuracion(rs.getString(3));
                s.setCosto(rs.getDouble(4));
                lista.add(s);
            }
        } catch (SQLException ex) {
            msj = ex.getMessage();
        }
        return lista;
    }

    @Override
    public Servicio getOne(int cod) {
        s = null;
        try {
            String sql = "select * from servicio where id_servicio=" + cod;
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new Servicio();
                s.setId(rs.getInt(1));
                s.setNombre(rs.getString(2));
                s.setDuracion(rs.getString(3));
                s.setCosto(rs.getDouble(4));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return s;
    }
}
