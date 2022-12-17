package dao;

import Interfaces.InterfaceCliente;
import java.sql.CallableStatement;
import modelo.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ClienteDao implements InterfaceCliente {

    MySQLConexion cn = new MySQLConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente c;
    List<Cliente> lista;
    CallableStatement cs;

    @Override
    public String agregar(Cliente c) {
        String msj = null;
        try {
            String sql = "{call sp_adicionar_cliente(?,?,?,?,?,?)}";
            con = MySQLConexion.getConexion();
            cs = con.prepareCall(sql);
            cs.setString(1, c.getNombre());
            cs.setString(2, c.getApellido());
            cs.setString(3, c.getCorreo());
            cs.setInt(4, c.getCelular());
            cs.setString(5, c.getDistrito());
            cs.setString(6, c.getDireccion());
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
            String sql = "delete from cliente where id_cliente=" + cod;
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
    public String modificar(Cliente c) {
        String msj = null;
        try {
            con = MySQLConexion.getConexion();
            String sql = "update cliente set id_cliente=?,nombre=?,apellido=?,correo=?,celular=?,distrito=?,direccion=? where id_cliente="+c.getIdCliente();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getIdCliente());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellido());
            ps.setString(4, c.getCorreo());
            ps.setInt(5, c.getCelular());
            ps.setString(6, c.getDistrito());
            ps.setString(7, c.getDireccion());
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
    public List<Cliente> listar() {
        con = MySQLConexion.getConexion();
        String msj = null;
        lista = new ArrayList<>();
        try {
            String sql = "select c.id_cliente, c.nombre, c.apellido, c.correo, c.celular, c.distrito, c.direccion from cliente c";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Cliente();
                c.setIdCliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setCorreo(rs.getString(4));
                c.setCelular(rs.getInt(5));
                c.setDistrito(rs.getString(6));
                c.setDireccion(rs.getString(7));
                lista.add(c);
            }
        } catch (SQLException ex) {
            msj = ex.getMessage();
        }
        return lista;
    }
    
    @Override
    public Cliente getOne(int cod) {
        Cliente c =null; 
        try {
        String sql="select * from cliente where id_cliente="+cod;
          con=MySQLConexion.getConexion();
         ps=con.prepareStatement(sql);
         rs=ps.executeQuery();
         while(rs.next()){
         c= new Cliente();
         c.setIdCliente(rs.getInt(1));
         c.setNombre(rs.getString(2));
         c.setApellido(rs.getString(3));
         c.setCorreo(rs.getString(4));
         c.setCelular(rs.getInt(5));
         c.setDistrito(rs.getString(6));
         c.setDireccion(rs.getString(7));
         }
     } catch (SQLException ex) {
               ex.getMessage();
     }
        return c;
    }
}
