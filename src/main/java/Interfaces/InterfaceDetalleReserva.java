package Interfaces;

import java.util.List;
import modelo.DetalleReserva;

public interface InterfaceDetalleReserva {
    public String agregar (DetalleReserva detalle);
    public String eliminar (int cod);
    public String modificar(DetalleReserva detalle);
    public List<DetalleReserva> listar();
    public List<DetalleReserva> filtrarDetalle(int cod);
    public DetalleReserva getOne(int cod);
    public DetalleReserva UltimoDetalleReserva();
}
