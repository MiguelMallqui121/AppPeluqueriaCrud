package modelo;

import java.util.List;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private int celular;
    private String distrito;
    private String direccion; 
    private List<Reserva> reserva;

    public Cliente() {
    }
    
    public Cliente(String nombre, String apellido, String correo, int celular, String distrito, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.distrito = distrito;
        this.direccion = direccion;
    }

    public Cliente(int idCliente, String nombre, String apellido, String correo, int celular, String distrito, String direccion) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.distrito = distrito;
        this.direccion = direccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
    }

    @Override
        public String toString() {
        return nombre;
    }

    
    
    
    
}
