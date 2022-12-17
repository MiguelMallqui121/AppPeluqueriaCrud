package modelo;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private int idReserva;
    private String fechaInicio;
    private int estado;
    private String tipo;
    private Cliente cliente;
    private List<DetalleReserva> detalles = new ArrayList<>();

    public Reserva() {
    }

    public Reserva(String fechaInicio, int estado, String tipo, Cliente cliente) {
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public Reserva(int idReserva, String fechaInicio, int estado, String tipo, Cliente cliente) {
        this.idReserva = idReserva;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleReserva> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleReserva> detalles) {
        this.detalles = detalles;
    }

    public void addDetalle(DetalleReserva detallesReserva) {
        this.detalles.add(detallesReserva);
    }

    @Override
    public String toString() {
        return String.valueOf(idReserva);
    }

    
}
