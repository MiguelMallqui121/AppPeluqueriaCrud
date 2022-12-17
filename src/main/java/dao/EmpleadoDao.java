package dao;

import Interfaces.InterfaceEmpleado;
import java.sql.CallableStatement;
import modelo.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Empleado;

public class EmpleadoDao implements InterfaceEmpleado {

    MySQLConexion cn = new MySQLConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empleado e;
    List<Empleado> lista;
    CallableStatement cs;

    @Override
    public String agregar(Empleado e) {
        String msj = null;
        try {
            String sql = "{call sp_adicionar_empleado(?,?,?,?,?,?,?,?,?)}";
            con = MySQLConexion.getConexion();
            cs = con.prepareCall(sql);
            cs.setString(1, e.getNombre());
            cs.setString(2, e.getApellido());
            cs.setString(3, e.getCorreo());
            cs.setInt(4, e.getCelular());
            cs.setString(5, e.getDistrito());
            cs.setString(6, e.getDireccion());
            cs.setString(7, e.getUsername());
            cs.setString(8, e.getPassword());
            cs.setInt(9, e.getCargo());
            rs = cs.executeQuery();
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
            String sql = "delete from empleado where id_empleado=" + cod;
            con = cn.getConexion();
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
    public String modificar(Empleado e) {
        String msj = null;
        try {
            String sql = "update empleado set id_empleado=?,nombre=?,apellido=?,correo=?,celular=?,distrito=?,direccion=?,username=?,password=?,cargo=? where id_empleado="+e.getCodE();
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, e.getCodE());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getApellido());
            ps.setString(4, e.getCorreo());
            ps.setInt(5, e.getCelular());
            ps.setString(6, e.getDistrito());
            ps.setString(7, e.getDireccion());
            ps.setString(8, e.getUsername());
            ps.setString(9, e.getPassword());
            ps.setInt(10, e.getCargo());
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
    public List<Empleado> listar() {
        con = MySQLConexion.getConexion();
        lista = new ArrayList();
        try {
            String sql = "select * from empleado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                e=new Empleado();
                e.setCodE(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApellido(rs.getString(3));
                e.setCorreo(rs.getString(4));
                e.setCelular(rs.getInt(5));
                e.setDistrito(rs.getString(6));
                e.setDireccion(rs.getString(7));
                e.setUsername(rs.getString(8));
                e.setPassword(rs.getString(9));
                e.setCargo(rs.getInt(10));
                lista.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public Empleado getOne(int cod) {
        e = null;
        try {
            String sql = "select * from empleado where id_empleado=" + cod;
            con = MySQLConexion.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                e = new Empleado();
                e.setCodE(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApellido(rs.getString(3));
                e.setCorreo(rs.getString(4));
                e.setCelular(rs.getInt(5));
                e.setDistrito(rs.getString(6));
                e.setDireccion(rs.getString(7));
                e.setUsername(rs.getString(8));
                e.setPassword(rs.getString(9));
                e.setCargo(rs.getInt(10));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return e;
    }

    @Override
    public int ValidarEmpleado(Empleado e) {
        int respuesta = 0;
        try {
            con = MySQLConexion.getConexion();
            String sql = "SELECT COUNT(e.id_empleado) as Cantidad\n"
                    + "FROM empleado e\n"
                    + "WHERE e.username=BINARY ? and e.password=BINARY ? and e.cargo=BINARY ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, e.getUsername());
            ps.setString(2, e.getPassword());
            ps.setInt(3, e.getCargo());
            rs = ps.executeQuery();
            while (rs.next()) {
                respuesta = rs.getInt("Cantidad");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al inciar Sessión");
        }
        return respuesta;
    }

}
